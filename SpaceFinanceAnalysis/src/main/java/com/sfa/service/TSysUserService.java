package com.sfa.service;
import com.sfa.model.TSysUser;
import com.sfa.model.UserInfo;

import java.util.List;

import com.sfa.core.Service;


/**
 * Created by CodeGenerator on 2018/08/30.
 */
public interface TSysUserService extends Service<TSysUser> {
	
	public void saveUser(TSysUser tSysUser);
	public List<TSysUser> selectSysUserByNameAndPwd(TSysUser tSysUser);
	public boolean login(TSysUser tSysUser);
	public UserInfo selectUserInfoId(String id);

}
