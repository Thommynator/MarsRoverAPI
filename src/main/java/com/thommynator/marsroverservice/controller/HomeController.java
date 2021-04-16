package com.thommynator.marsroverservice.controller;

import com.thommynator.marsroverservice.model.PhotoApiResponse;
import com.thommynator.marsroverservice.service.MarsRoverApiService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Controller
@Log4j2
public class HomeController {

    @Autowired
    private MarsRoverApiService roverService;

    @GetMapping("/")
    public String homeView(ModelMap model,
                           @RequestParam(required = false, name = "selected-rover") String selectedRover,
                           @RequestParam(required = false, name = "sol") Integer sol) {
        selectedRover = StringUtils.isEmpty(selectedRover) ? "spirit" : selectedRover;
        sol = sol == null ? 1 : sol;

        model.put("selectedRover", selectedRover);
        model.put("selectedSol", sol);

        PhotoApiResponse roverData = roverService.getRoverData(selectedRover, sol);
        model.put("roverData", roverData);
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
