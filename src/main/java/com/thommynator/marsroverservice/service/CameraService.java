package com.thommynator.marsroverservice.service;

import com.thommynator.marsroverservice.model.Camera;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CameraService {

    private static Map<String, Camera> cameras = new HashMap<>();
    private static Map<String, List<Camera>> camerasPerRover = new HashMap<>();

    public CameraService() {
        cameras.put("FHAZ", new Camera("FHAZ", "Front Hazard Avoidance Camera"));
        cameras.put("RHAZ", new Camera("RHAZ", "Rear Hazard Avoidance Camera"));
        cameras.put("MAST", new Camera("MAST", "Mast Camera"));
        cameras.put("CHEMCAM", new Camera("CHEMCAM", "Chemistry and Camera Complex"));
        cameras.put("MAHLI", new Camera("MAHLI", "Mars Hand Lens Imager"));
        cameras.put("MARDI", new Camera("MARDI", "Mars Descent Imager"));
        cameras.put("NAVCAM", new Camera("NAVCAM", "Navigation Camera"));
        cameras.put("PANCAM", new Camera("PANCAM", "Panoramic Camera"));
        cameras.put("MINITES", new Camera("MINITES", "Miniature Thermal Emission Spectrometer "));

        camerasPerRover.put("curiosity", Stream.of("FHAZ", "RHAZ", "MAST", "CHEMCAM", "MAHLI", "MARDI", "NAVCAM")
                .map(camera -> cameras.get(camera)).collect(Collectors.toList()));
        camerasPerRover.put("opportunity", Stream.of("FHAZ", "RHAZ", "NAVCAM", "PANCAM", "MINITES")
                .map(camera -> cameras.get(camera)).collect(Collectors.toList()));
        camerasPerRover.put("spirit", Stream.of("FHAZ", "RHAZ", "NAVCAM", "PANCAM", "MINITES")
                .map(camera -> cameras.get(camera)).collect(Collectors.toList()));
    }

    public List<Camera> getAvailableCamerasOfRover(String rover) {
        return camerasPerRover.get(rover);
    }

    public Camera getCameraByName(String name) {
        return cameras.get(name);
    }
}
