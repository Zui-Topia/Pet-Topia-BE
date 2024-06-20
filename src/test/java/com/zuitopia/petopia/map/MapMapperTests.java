package com.zuitopia.petopia.map;

import com.zuitopia.petopia.dto.MapVO;
import com.zuitopia.petopia.dto.PlaceVO;
import com.zuitopia.petopia.map.mapper.MapMapper;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.assertEquals;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:**/*-context.xml")
@Log4j
public class MapMapperTests {
	@Autowired
	private MapMapper mapMapper;

	@Test
	public void testGet() {
		try {
			List<MapVO> list = mapMapper.getListFloorMapId(1);

			assertEquals(12, list.size());
		}
		catch (Exception e) {
			log.info("message : " + e.getMessage());
			log.info(e.getStackTrace());
		}
	}
	@Test
	public void testGet1() {
		try {
			PlaceVO placeVO = new PlaceVO();
			placeVO.setMapId(1);
			List<PlaceVO> list = mapMapper.getMapInfo(placeVO);

			assertEquals(3, list.size());
		}
		catch (Exception e) {
			log.info("message : " + e.getMessage());
			log.info(e.getStackTrace());
		}
	}

}
