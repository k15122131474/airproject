package com.sfa.service.impl;

import com.sfa.dao.TPersonMapper;
import com.sfa.model.TPerson;
import com.sfa.model.TSysUser;
import com.sfa.model.UserInfo;
import com.sfa.service.TPersonService;
import com.sfa.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/08/30.
 */
@Service
@Transactional
public class TPersonServiceImpl extends AbstractService<TPerson> implements TPersonService {
    @Resource
    private TPersonMapper tPersonMapper;

	@Override
	public boolean hasUser(String username) {
		if(tPersonMapper.selectByUsername(username)>0) {
			return true;
			}
		return false;
	}

	@Override
	public List<UserInfo> findAllPersion() {
		
		return null;
	}

	@Override
	public boolean addAccount(TSysUser ts, TPerson tp) {
		int flageu=tPersonMapper.insertUser(ts);
		int flagep=tPersonMapper.insertPerson(tp);
		if(flageu==flagep&&flageu>0) {
			return true;
		}
		return false;
	}

	@Override
	public UserInfo findPersonById(String tPersonId) {
		UserInfo uinfo=tPersonMapper.findPersonById(tPersonId);
		return uinfo;
	}

	@Override
	public boolean updataPersonInfo(TPerson tp) {
		int flag=tPersonMapper.updataPerson(tp);
		if(flag==1) {
			return true;
		}else {
		return false;
		}
	}

	@Override
	public boolean updataUserInfo(TSysUser tu) {
		int flag=tPersonMapper.updataUser(tu);

		if(flag==1) {
			return true;
		}else {
		return false;
		}
	}

	@Override
	public int deleteUserInfo(TPerson tperson) {
		int delflagp=tPersonMapper.deletePersonById(tperson.gettPresonId());
		int delflagu=tPersonMapper.deleteUserById(tperson.gettUserId());
		if(delflagp==1&&delflagu==1) {
			return 1;
		}
		else 
			return 0;
	}

	@Override
	public List<UserInfo> findPersonByName(String tCname) {
		List<UserInfo> uinfo=tPersonMapper.findPersonByName(tCname);
		return uinfo;
	}

	@Override
	public UserInfo findPersonByUserId(String tUserId) {
		UserInfo uinfo=tPersonMapper.findPersonByUserId(tUserId);
		return uinfo;
	}

}
