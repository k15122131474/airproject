package com.sfa.core;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * 定制版MyBatis Mapper插件接口，如需其他接口参考官方文档自行添加。
 *
 *	什么是通用Mapper
	通用Mapper就是为了解决单表增删改查，基于Mybatis的插件。开发人员不需要编写SQL，
	不需要在DAO中增加方法，只要写好实体类，就能支持相应的增删改查方法。
 * @author David
 */
public interface Mapper<T>
        extends
        BaseMapper<T>,
        ConditionMapper<T>,
        IdsMapper<T>,
        InsertListMapper<T> {
}
