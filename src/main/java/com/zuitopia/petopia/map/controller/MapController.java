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

@Controller
@Log
@RequestMapping("/map")
@AllArgsConstructor
public class MapController {

    private final MapService service;

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
}
