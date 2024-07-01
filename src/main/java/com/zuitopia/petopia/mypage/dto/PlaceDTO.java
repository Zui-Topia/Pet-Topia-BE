package com.zuitopia.petopia.mypage.dto;

import lombok.Data;

/**
 * 마이페이지 나의 예약 정보 클래스
 * @author 최유경
 * @since 2024.06.19
 *
 * <pre>
 * 수정일        		수정자       				    수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.19  	    최유경        		        최초 생성
 * </pre>
 */
@Data
public class PlaceDTO {
    private int placeId;        // 장소 ID
    private int branchId;       // 지점 ID
    private int mapId;          // 지도 ID
    private String placeInfo;   // 장소 위치 정보
    private String placeName;   // 장소명
    private String branchName;  // 지점명
}
