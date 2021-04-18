package com.thommynator.marsroverservice.model;

import lombok.Data;

/**
 * Representation of the form data from the web page.
 */
@Data
public class FormData {

    private String rover;
    private Integer sol;
    private Boolean fhaz;
    private Boolean rhaz;
    private Boolean mast;
    private Boolean chemcam;
    private Boolean mahli;
    private Boolean mardi;
    private Boolean navcam;
    private Boolean pancam;
    private Boolean minites;

}
