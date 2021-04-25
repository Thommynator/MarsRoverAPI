package com.thommynator.marsroverservice.service;

import com.thommynator.marsroverservice.model.Camera;
import com.thommynator.marsroverservice.model.FormData;
import com.thommynator.marsroverservice.model.Photo;
import com.thommynator.marsroverservice.model.PhotoApiResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
public class MarsRoverApiService {

    @Value("${auth.api_key}")
    private String apiKey;

    @Autowired
    private CameraService cameraService;

    public PhotoApiResponse getRoverData(FormData formData) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            PhotoApiResponse response = new PhotoApiResponse();
            createUrls(formData)
                    .forEach(url -> {
                        List<Photo> photos = Optional.ofNullable(restTemplate.getForEntity(url, PhotoApiResponse.class).getBody())
                                .orElse(new PhotoApiResponse()).getPhotos();
                        photos.forEach(photo -> photo.setImgSrc(photo.getImgSrc().replace("http://", "https://")));
                        response.addPhotos(photos);
                    });
            return response;
        } catch (Exception e) {
            log.error("HTTP Request failed", e);
            throw e;
        }
    }

    public PhotoApiResponse getEmptyData(FormData formData) {
        return new PhotoApiResponse();
    }

    private String createUrl(String rover, Integer sol, Camera camera, String apiKey) {
        return "https://api.nasa.gov/mars-photos/api/v1/rovers/" + rover + "/photos"
                + "?sol=" + sol
                + "&camera=" + camera.getName()
                + "&api_key=" + apiKey;
    }

    private List<String> createUrls(FormData formData) {
        return formData.getSelectedCameras().stream()
                .map(camera -> createUrl(formData.getRover(), formData.getSol(), camera, this.apiKey))
                .collect(Collectors.toList());
    }


}
