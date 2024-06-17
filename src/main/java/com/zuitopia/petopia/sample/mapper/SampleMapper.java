package com.zuitopia.petopia.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zuitopia.petopia.dto.SampleVO;

@Mapper
public interface SampleMapper {
	public List<SampleVO> getList();
}
