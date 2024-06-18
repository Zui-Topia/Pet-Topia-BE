package com.zuitopia.petopia.sample;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.zuitopia.petopia.dto.SampleVO;
import com.zuitopia.petopia.sample.mapper.SampleMapper;

import lombok.extern.log4j.Log4j;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:**/*-context.xml")
@Log4j
public class SampleMapperTests {
	@Autowired
	private SampleMapper sampleMapper;
	
	@Test
	public void testGet() {
		try {
			List<SampleVO> list = sampleMapper.getList();
			
			assertEquals(2, list.size());
		}
		catch (Exception e) {
			log.info("message : " + e.getMessage());
			log.info(e.getStackTrace());
		}
	}
	
}
