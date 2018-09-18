package com.sfa.service;
import com.sfa.model.TPerson;
import com.sfa.model.TSysUser;
import com.sfa.model.UserInfo;

import java.util.List;

import com.sfa.core.Service;


/**
 * Created by CodeGenerator on 2018/08/30.
 */
public interface TPersonService extends Service<TPerson> {
	List<UserInfo> findAllPersion();

	public boolean hasUser(String username);
	
	public boolean addAccount(TSysUser ts,TPerson tp);

	UserInfo findPersonById(String tPersonId);

	boolean updataPersonInfo(TPerson tp);

	boolean updataUserInfo(TSysUser tu);

	int deleteUserInfo(TPerson tperson);

	List<UserInfo> findPersonByName(String tCname);
}
