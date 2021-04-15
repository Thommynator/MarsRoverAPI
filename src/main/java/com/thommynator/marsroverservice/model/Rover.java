package com.thommynator.marsroverservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Rover {
    private long id;

    private String name;

    @JsonProperty("landing_date")
    private Date landingDate;

    @JsonProperty("launch_date")
    private Date launchDate;

    private String status;
}
