package com.thommynator.marsroverservice.service;

import com.thommynator.marsroverservice.model.PhotoApiResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Log4j2
public class MarsRoverApiService {

    @Value("${auth.api_key}")
    private String apiKey;

    public PhotoApiResponse getRoverData(String roverType, int sol) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://api.nasa.gov/mars-photos/api/v1/rovers/" + roverType + "/photos?sol=" + sol + "&api_key=" + apiKey;
            ResponseEntity<PhotoApiResponse> response = restTemplate.getForEntity(url, PhotoApiResponse.class);
            return response.getBody();
        } catch (Exception e) {
            log.error("HTTP Request failed", e);
            throw e;
        }
    }
}
