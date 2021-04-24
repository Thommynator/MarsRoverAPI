package com.thommynator.marsroverservice.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PhotoApiResponse {

    List<Photo> photos = new ArrayList<>();

    public void addPhotos(List<Photo> photosToAdd) {
        this.photos.addAll(photosToAdd);
    }
}
