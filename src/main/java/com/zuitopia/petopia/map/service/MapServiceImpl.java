package com.zuitopia.petopia.map.service;

import com.zuitopia.petopia.dto.MapVO;
import com.zuitopia.petopia.dto.PlaceVO;
import com.zuitopia.petopia.map.mapper.MapMapper;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 지도 관련 서비스 구현체
 * @author 김도연
 * @since 2024.06.19
 *
 * <pre>
 *    수정일          수정자                      수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.19       김도연                      최초 생성
 * </pre>
 */
@Log
@Service
@AllArgsConstructor
public class MapServiceImpl implements MapService{
    private final MapMapper mapMapper;

    /**
     * @param branchId
     * @return List<MapVO> 지점에 대한 층 정보 리턴
     */
    @Override
    public List<MapVO> getListFloorMapId(int branchId) {
        return mapMapper.getListFloorMapId(branchId);
    }

    /**
     * @param place
     * @return List<PlaceVO> 지점/ 층에 대한 지도 정보 리턴
     */
    @Override
    public List<PlaceVO> getMapInfo(PlaceVO place) {
        return mapMapper.getMapInfo(place);
    }

    /**
     * @param branchId
     * @return List<PlaceVO> 지점에 대한 검색 상점 정보 리턴
     */
    @Override
    public List<PlaceVO> getSearchInfo(int branchId) {
        return mapMapper.getSearchInfo(branchId);
    }
}
