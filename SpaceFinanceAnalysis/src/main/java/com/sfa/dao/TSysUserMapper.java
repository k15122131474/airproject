package com.sfa.dao;

import java.util.List;

import com.sfa.core.Mapper;
import com.sfa.model.TSysUser;


/**
 * 在初始化时会把获取到的Mapper接口注册到MapperRegistry，注册的时候创建一个Mapper代理工厂，
 * 这个工厂通过JDK的代理创建一个执行对象，创建代理需要的InvocationHandler为MapperProxy
 * @author lenovo
 *
 */
public interface TSysUserMapper extends Mapper<TSysUser> {
	
	 List<TSysUser> selectSysUserByNameAndPwd(TSysUser tSysUser);
}