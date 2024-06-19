package com.zuitopia.petopia.user.dto;

import com.zuitopia.petopia.dto.PetVO;
import com.zuitopia.petopia.dto.UserVO;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserReactDTO {
    private UserVO userVO;
    private PetVO petVO;
}
