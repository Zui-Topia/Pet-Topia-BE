package com.zuitopia.petopia.map.controller;

import com.zuitopia.petopia.dto.MapVO;
import com.zuitopia.petopia.dto.PlaceVO;
import com.zuitopia.petopia.map.service.MapService;
import com.zuitopia.petopia.util.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 지도 관련 요청을 처리하는 Controller 클래스 개발
 * 지도, 지점 정보 등의 기능을 제공합니다.
 *
 * @version 1.0
 * @since 2024.06.19
 *
 * <pre>
 *    수정일          수정자                       수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.19        김도연                      최초 생성
 * </pre>
 */
@Controller
@Log
@RequestMapping("/map")
@AllArgsConstructor
public class MapController {

    private final MapService service;
    /**
     * 지점/ 층에 대한  API
     *
     * @return ResponseEntity<BaseResponse> 지점/ 층에 대한 응답
     *
     */
    @ResponseBody
    @GetMapping("/branch/{branchId}/floors")
    public ResponseEntity<BaseResponse> getListFloorMapId(@PathVariable("branchId") int branchId) {
        List<MapVO> floors = service.getListFloorMapId(branchId);
        return ResponseEntity
                .ok()
                .body(BaseResponse.builder()
                        .success(true)
                        .data(floors)
                        .build());
    }

    /**
     * 지점안 상점에 대한 API
     *
     * @return ResponseEntity<BaseResponse> 지점 안 층 지도 정보에 대한 응답
     *
     */
    @ResponseBody
    @GetMapping("/{mapId}/places")
    public ResponseEntity<BaseResponse> getMapImg(@PathVariable int mapId) {
        PlaceVO placeVO = new PlaceVO();
        placeVO.setMapId(mapId);
        List<PlaceVO> places = service.getMapInfo(placeVO);
        return ResponseEntity
                .ok()
                .body(BaseResponse.builder()
                        .success(true)
                        .data(places)
                        .build());
    }
    /**
     * 지점/층의 상점 검색 기능 정보에 대한 API
     *
     * @return ResponseEntity<BaseResponse> 지점/층의 상점 정보에 대한 응답
     *
     */
    @ResponseBody
    @GetMapping("/branch/{branchId}/places")
    public ResponseEntity<BaseResponse> getSearchInfo(@PathVariable("branchId") int branchId) {
        List<PlaceVO> places = service.getSearchInfo(branchId);
        return ResponseEntity
                .ok()
                .body(BaseResponse.builder()
                        .success(true)
                        .data(places)
                        .build());
    }

}
