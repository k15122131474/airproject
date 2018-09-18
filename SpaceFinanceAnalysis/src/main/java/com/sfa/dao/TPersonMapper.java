package com.sfa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sfa.core.Mapper;
import com.sfa.model.TPerson;
import com.sfa.model.TSysUser;
import com.sfa.model.UserInfo;

public interface TPersonMapper extends Mapper<TPerson> {
	public int selectByUsername(@Param("username")String username);
	public int insertUser(TSysUser tsysuser);
	public int insertPerson(TPerson tperson);
	public UserInfo findPersonById(String tPersonId);
	public int updataPerson(TPerson tperson);
	public int updataUser(TSysUser tu);
	public int deletePersonById(String tPersonId);
	public int deleteUserById(String tUserId);
	public List<UserInfo> findPersonByName(String tCname);
}