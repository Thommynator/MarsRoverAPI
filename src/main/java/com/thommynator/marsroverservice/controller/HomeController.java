package com.thommynator.marsroverservice.controller;

import com.thommynator.marsroverservice.model.Camera;
import com.thommynator.marsroverservice.model.FormData;
import com.thommynator.marsroverservice.model.PhotoApiResponse;
import com.thommynator.marsroverservice.service.MarsRoverApiService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@Log4j2
public class HomeController {

    @Autowired
    private MarsRoverApiService roverService;

    @GetMapping("/")
    public String homeView(@ModelAttribute FormData formData, ModelMap model) {

        if (formData.getAvailableCameras() == null || formData.getAvailableCameras().isEmpty()) {
            formData = createDefaultFormData(formData);
        }

        PhotoApiResponse roverData = roverService.getEmptyData(formData);
        model.put("roverData", roverData);
        model.put("formData", formData);
        return "index";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
        log.error("Request: " + req.getRequestURL() + " raised " + ex);

        ModelAndView mav = new ModelAndView();
        mav.addObject("exceptionMessage", ex.getMessage());
        mav.setViewName("error");

        return mav;
    }

    private FormData createDefaultFormData(FormData formData) {
        //formData.setRover(StringUtils.isEmpty(formData.getRover()) ? "spirit" : formData.getRover());
        formData.setSol(formData.getSol() == null ? 1 : formData.getSol());

        List<Camera> cameras = new ArrayList<>();
        cameras.add(new Camera("FHAZ", "Front Hazard Avoidance Camera"));
        cameras.add(new Camera("RHAZ", "Rear Hazard Avoidance Camera"));
        cameras.add(new Camera("MAST", "Mast Camera"));
        cameras.add(new Camera("CHEMCAM", "Chemistry and Camera Complex"));
        cameras.add(new Camera("MAHLI", "Mars Hand Lens Imager"));
        cameras.add(new Camera("MARDI", "Mars Descent Imager"));
        cameras.add(new Camera("NAVCAM", "Navigation Camera"));
        cameras.add(new Camera("PANCAM", "Panoramic Camera"));
        cameras.add(new Camera("MINITES", "Miniature Thermal Emission Spectrometer "));
        formData.setAvailableCameras(cameras);

        formData.setSelectedCameras(List.of(
                new Camera("RHAZ", "Rear Hazard Avoidance Camera"),
                new Camera("MARDI", "Mars Descent Imager")));

        return formData;
    }

}
