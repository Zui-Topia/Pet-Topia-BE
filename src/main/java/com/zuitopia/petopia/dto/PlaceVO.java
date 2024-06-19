package com.zuitopia.petopia.dto;

import lombok.Data;

@Data
public class PlaceVO {
    private int placeId;
    private int mapId;
    private int categoryId;
    private String placeName;
    private int placePositionX;
    private int placePositionY;
    private int petZone;
    private String placeInfo;
}
