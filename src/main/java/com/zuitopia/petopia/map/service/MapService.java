package com.zuitopia.petopia.map.service;

import com.zuitopia.petopia.dto.MapVO;
import com.zuitopia.petopia.dto.PlaceVO;

import java.util.List;
/**
 * 지도 관련 서비스 interface
 * @apiNote 지점/ 층/ 상점 에 대한 정보, 마커의 정보 등의 기능을 제공
 *
 * @author 김도연
 * @since 2024.06.19
 *
 * <pre>
 *    수정일           수정자                      수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.19        김도연                      최초 생성
 * </pre>
 */
public interface MapService {

    /**
     * 지점에 대한 층 정보를 가져오는 메소드
     * @param branchId
     * @return getListFloorMapId 지점에 대한 층 정보 리턴
     */
    List<MapVO> getListFloorMapId(int branchId);

    /**
     * 지점/ 층에 대한 지도 정보를 가져오는 메소드
     * @param placeVo
     * @return List<PlaceVO> 지점/ 층에 대한 지도 정보 리턴
     */
    List<PlaceVO> getMapInfo(PlaceVO placeVo);

    /**
     * 지점에 대한 검색 상점 정보를 가져오는 메소드
     * @param branchId
     * @return List<PlaceVO> 지점에 대한 검색 상점 정보 리턴
     */
    List<PlaceVO> getSearchInfo(int branchId);
}
