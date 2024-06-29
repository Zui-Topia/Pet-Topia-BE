package com.zuitopia.petopia.dto;

import lombok.Data;

/**
 * 지도 정보를 담는 VO 클래스
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
public class MapVO {
    private int mapId;      // 지도 ID
    private int branchId;   // 지점 ID
    private int floor;      // 층 수
    private String mapImg;  // 지도 이미지 파일 경로
    private int categoryId; // 카테고리 아이디
}
