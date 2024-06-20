package com.zuitopia.petopia.mypage.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MyInfoDTO {
    private MyPageUserDTO myPageUserDTO;
    private MyPagePetDTO myPagePetDTO;
    private MyReservationDTO myReservationDTO;
}
