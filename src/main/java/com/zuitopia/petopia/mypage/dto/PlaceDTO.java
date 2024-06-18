package com.zuitopia.petopia.mypage.dto;

import lombok.Data;

@Data
public class PlaceDTO {
    private Long placeId;
    private Long branchId;
    private Long mapId;
    private String placeInfo;
    private String placeName;
    private String branchName;
}
