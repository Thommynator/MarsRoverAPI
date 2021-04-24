package com.thommynator.marsroverservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Representation of the form data from the web page.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormData {

    private String rover;
    private Integer sol;
    private List<Camera> allCameras;
    private List<Camera> availableCamerasOnRover;
    private List<Camera> selectedCameras;
}
