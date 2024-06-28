package com.zuitopia.petopia.map.mapper;

import com.zuitopia.petopia.dto.MapVO;
import com.zuitopia.petopia.dto.PlaceVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * 지도 관련 데이터베이스 작업을 처리하는 매퍼 interface 개발
 * 지점/ 층/ 상점 에 대한 정보, 마커의 정보 등의 기능을 제공합니다.
 *
 * @version 1.0
 * @since 2024.06.19
 *
 * <pre>
 *    수정일          수정자                      수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.19       김도연                      최초 생성
 * </pre>
 */
@Mapper
public interface MapMapper {
    /**
     * 지점에 대한 층 정보를 가져오는 메소드
     *
     * @return getListFloorMapId 지점에 대한 층 정보 리턴
     *
     */
    public List<MapVO> getListFloorMapId(int branchId);
    /**
     * 지점안 상점에 대한 API
     *
     * @return ResponseEntity<BaseResponse> 지점 안 층 지도 정보에 대한 응답
     *
     */
    public List<PlaceVO> getMapInfo(PlaceVO placeVO);
    /**
     * 지점/층의 상점 검색 기능 정보에 대한 API
     *
     * @return ResponseEntity<BaseResponse> 지점/층의 상점 정보에 대한 응답
     *
     */
    public List<PlaceVO> getSearchInfo(int branchId);
}
