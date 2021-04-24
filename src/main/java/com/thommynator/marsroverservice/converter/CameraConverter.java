package com.thommynator.marsroverservice.converter;

import com.thommynator.marsroverservice.model.Camera;
import com.thommynator.marsroverservice.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CameraConverter implements Converter<String, Camera> {

    @Autowired
    private CameraService cameraService;

    @Override
    public Camera convert(String cameraName) {
        return cameraService.getCameraByName(cameraName);
    }

}
