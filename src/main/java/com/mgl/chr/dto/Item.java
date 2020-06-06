package com.mgl.chr.dto;

import lombok.Data;

@Data
public class Item {

    private Address address;

    private String id;

    private String localityType;

    private MapView mapView;

    private Position position;

    private String resultType;

    private Scoring scoring;

    private String title;

}
