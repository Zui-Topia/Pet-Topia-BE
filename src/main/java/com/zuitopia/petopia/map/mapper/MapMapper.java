package com.zuitopia.petopia.map.mapper;

import com.zuitopia.petopia.dto.MapVO;
import com.zuitopia.petopia.dto.PlaceVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MapMapper {
    public List<MapVO> getListFloorMapId(int branchId); // 상점 아이디로 MapVO(층, 지도 아이디)가져오기
    public List<PlaceVO> getMapInfo(PlaceVO placeVO);
    public List<PlaceVO> getSearchInfo(int branchId);
}
