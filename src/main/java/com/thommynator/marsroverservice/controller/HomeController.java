package com.thommynator.marsroverservice.controller;

import com.thommynator.marsroverservice.model.PhotoApiResponse;
import com.thommynator.marsroverservice.service.MarsRoverApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private MarsRoverApiService roverService;

    @GetMapping("/")
    public String homeView(ModelMap model) {
        model.put("name", "Thomas");

        PhotoApiResponse roverData = roverService.getRoverData();
        model.put("roverData", roverData);
        return "index";
    }
}
