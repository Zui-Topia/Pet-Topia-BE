package com.zuitopia.petopia.dto;

import lombok.Data;

/**
 * 장소 정보를 담는 VO 클래스
 * @author 김도연
 * @since 2024.06.18
 *
 * <pre>
 * 수정일             수정자                      수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.18       김도연                      최초 생성
 * </pre>
 */
@Data
public class PlaceVO {
    private int placeId;        // 장소 ID
    private int mapId;          // 지도 ID
    private int categoryId;     // 카테고리 ID
    private String placeName;   // 장소명
    private int placePositionX; // 아이콘 위치 x 좌표
    private int placePositionY; // 아이콘 위치 y 좌표
    private int petZone;        // 펫 동반 여부
    private String placeInfo;   // 장소 상세 위치 정보
}
