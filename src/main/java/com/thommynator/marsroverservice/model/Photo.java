package com.thommynator.marsroverservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Photo {
    private int id;

    private int sol;

    private Camera camera;

    @JsonProperty("img_src")
    private String imgSrc;

    @JsonProperty("earth_date")
    private Date earthDate;

    private Rover rover;
}