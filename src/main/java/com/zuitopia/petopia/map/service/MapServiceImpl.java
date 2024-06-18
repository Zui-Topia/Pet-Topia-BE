package com.zuitopia.petopia.map.service;

import com.zuitopia.petopia.dto.MapVO;
import com.zuitopia.petopia.dto.PlaceVO;
import com.zuitopia.petopia.map.mapper.MapMapper;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Log
@Service
@AllArgsConstructor
public class MapServiceImpl implements MapService{

    private final MapMapper mapper;

    @Override
    public List<MapVO> getListFloorMapId(int branchId) {
        return mapper.getListFloorMapId(branchId);
    }

    @Override
    public MapVO getMapImg(int mapId) {
        return mapper.getMapImg(mapId);
    }
}
