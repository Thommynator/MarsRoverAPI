package com.thommynator.marsroverservice.service;

import com.thommynator.marsroverservice.model.PhotoApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MarsRoverApiService {

    public PhotoApiResponse getRoverData() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY";
        ResponseEntity<PhotoApiResponse> response = restTemplate.getForEntity(url, PhotoApiResponse.class);
        return response.getBody();
    }
}
