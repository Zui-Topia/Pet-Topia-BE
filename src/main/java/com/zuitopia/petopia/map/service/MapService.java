package com.zuitopia.petopia.map.service;

import com.zuitopia.petopia.dto.MapVO;
import com.zuitopia.petopia.dto.PlaceVO;

import java.util.List;

public interface MapService {
    // 지점의 층정보 가져오기
    List<MapVO> getListFloorMapId(int branchId);
    // 지점/ 층에 대한 지도 정보 가져오기
    List<PlaceVO> getMapInfo(PlaceVO placeVo);
    //검색 기능
    List<PlaceVO> getSearchInfo(int branchId);
}
