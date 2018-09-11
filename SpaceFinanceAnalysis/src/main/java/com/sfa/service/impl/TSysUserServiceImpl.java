package com.sfa.service.impl;

import com.sfa.dao.TSysUserMapper;
import com.sfa.model.TSysUser;
import com.sfa.service.TSysUserService;
import com.sfa.util.RandomUtils;
import com.sfa.util.UUID;
import com.sfa.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/08/30.
 */
@Service
@Transactional
public class TSysUserServiceImpl extends AbstractService<TSysUser> implements TSysUserService {
    @Resource
    private TSysUserMapper tSysUserMapper;

	@Override
	public void saveUser(TSysUser tSysUser) {
		// TODO Auto-generated method stub
		String id = UUID.randomUUID();
    	tSysUser.settUserId(id);
    	String pwd = RandomUtils.encryption(tSysUser.gettUserPwd());
    	tSysUser.settUserPwd(pwd);
		tSysUserMapper.insertSelective(tSysUser);
	}

	@Override
	public List<TSysUser> selectSysUserByNameAndPwd(TSysUser tSysUser) {
		// TODO Auto-generated method stub
		List<TSysUser> tsysUserList = null;
		if(tSysUser != null) {
			/*String pwd = RandomUtils.encryption(tSysUser.gettUserPwd());
	    	tSysUser.settUserPwd(pwd);*/
			tsysUserList = new ArrayList<TSysUser>();
			tsysUserList = tSysUserMapper.selectSysUserByNameAndPwd(tSysUser);
			if(tsysUserList != null && tsysUserList.size() > 0) {
				return tsysUserList;
			}else {
				return null;
			}
		}else {
			return null;
		}
	}

	@Override
	public boolean login(TSysUser tSysUser) {
		// TODO Auto-generated method stub
		boolean flag = false;
		
		List<TSysUser> tsysUserList = null;
		if(tSysUser != null) {
			tsysUserList = new ArrayList<TSysUser>();
			tsysUserList = tSysUserMapper.selectSysUserByNameAndPwd(tSysUser);
			if(tsysUserList != null && tsysUserList.size() > 0) {
				flag = true;
				return flag;
			}else {
				return flag;
			}
		}else {
			return flag;
		}
	}

}
