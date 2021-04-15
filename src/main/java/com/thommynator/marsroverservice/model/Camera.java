package com.thommynator.marsroverservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Camera {
    private long id;

    private String name;

    @JsonProperty("rover_id")
    private String roverId;

    @JsonProperty("full_name")
    private String fullName;
}