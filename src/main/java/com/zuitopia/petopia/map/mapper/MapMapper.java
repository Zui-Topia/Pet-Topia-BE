package com.zuitopia.petopia.map.mapper;

import com.zuitopia.petopia.dto.MapVO;
import com.zuitopia.petopia.dto.PlaceVO;

import java.util.List;

public interface MapMapper {
    public List<MapVO> getListFloorMapId(int branch_id); // 상점 아이디로 MapVO(층, 지도 아이디)가져오기
    public MapVO getMapImg(int map_id);// map 아이디로 map 이미지 가져오기
}
