package com.thommynator.marsroverservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Camera {
    private String name;
    @JsonProperty("full_name")
    private String fullName;
}