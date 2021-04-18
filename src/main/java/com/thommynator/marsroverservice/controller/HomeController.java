package com.thommynator.marsroverservice.controller;

import com.thommynator.marsroverservice.model.FormData;
import com.thommynator.marsroverservice.model.PhotoApiResponse;
import com.thommynator.marsroverservice.service.MarsRoverApiService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Controller
@Log4j2
public class HomeController {

    @Autowired
    private MarsRoverApiService roverService;

    @GetMapping("/")
    public String homeView(ModelMap model, FormData formData) {
        formData.setRover(StringUtils.isEmpty(formData.getRover()) ? "spirit" : formData.getRover());
        formData.setSol(formData.getSol() == null ? 1 : formData.getSol());

        PhotoApiResponse roverData = roverService.getEmptyData(formData.getRover(), formData.getSol());
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

}
