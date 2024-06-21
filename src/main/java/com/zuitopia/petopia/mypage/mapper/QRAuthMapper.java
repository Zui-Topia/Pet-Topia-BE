package com.zuitopia.petopia.mypage.mapper;

import com.zuitopia.petopia.dto.ReservationQRVO;
import com.zuitopia.petopia.dto.ReservationVO;
import java.util.Date;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QRAuthMapper {
    public int createQR(int reservationId);

    public int updateReservationAuthComplete(int reservationId);

    public ReservationQRVO getQRByQrId(int qrId);
    public ReservationQRVO getQRByReservationId(int reservationId);

    public ReservationVO getReservationByQrId(int qrId);

}
