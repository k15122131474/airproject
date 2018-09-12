package com.sfa.dao;

import com.sfa.core.Mapper;
import com.sfa.model.TTestInfo;

public interface TTestInfoMapper extends Mapper<TTestInfo> {
	
	public TTestInfo getTestInfoById(Integer id);
}