package com.zuitopia.petopia.mypage.dto;

import lombok.Data;

@Data
public class PlaceDTO {
    private int placeId;
    private int branchId;
    private int mapId;
    private String placeInfo;
    private String placeName;
    private String branchName;
}
