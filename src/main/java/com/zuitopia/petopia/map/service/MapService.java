package com.zuitopia.petopia.map.service;

import com.zuitopia.petopia.dto.MapVO;
import com.zuitopia.petopia.dto.PlaceVO;

import java.util.List;

public interface MapService {
    List<MapVO> getListFloorMapId(int branchId);
    MapVO getMapImg(int mapId);
}
