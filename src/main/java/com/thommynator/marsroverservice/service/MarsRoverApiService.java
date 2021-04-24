package com.thommynator.marsroverservice.service;

import com.thommynator.marsroverservice.model.FormData;
import com.thommynator.marsroverservice.model.PhotoApiResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Log4j2
public class MarsRoverApiService {

    @Value("${auth.api_key}")
    private String apiKey;

    @Autowired
    private CameraService cameraService;

//    public PhotoApiResponse getRoverData(FormData formData) {
//        try {
//            RestTemplate restTemplate = new RestTemplate();
//            String url = "https://api.nasa.gov/mars-photos/api/v1/rovers/" + formData.getRover() + "/photos?sol=" + formData.getSol() + "&api_key=" + apiKey;
//            ResponseEntity<PhotoApiResponse> response = restTemplate.getForEntity(url, PhotoApiResponse.class);
//            return response.getBody();
//        } catch (Exception e) {
//            log.error("HTTP Request failed", e);
//            throw e;
//        }
//    }

    public PhotoApiResponse getEmptyData(FormData formData) {
        return new PhotoApiResponse();
    }

    private String createUrl(String rover, Integer sol, String camera, String apiKey) {
        return "https://api.nasa.gov/mars-photos/api/v1/rovers/" + rover + "/photos"
                + "?sol=" + sol
                + "&camera=" + camera
                + "&api_key=" + apiKey;
    }

//    private String createUrls(FormData formData) {
//
//    }
}
