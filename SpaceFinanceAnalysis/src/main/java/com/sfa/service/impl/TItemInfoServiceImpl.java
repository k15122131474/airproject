package com.sfa.service.impl;

import com.sfa.dao.TItemInfoMapper;
import com.sfa.model.TItemInfo;
import com.sfa.service.TItemInfoService;
import com.sfa.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/08/28.
 */
@Service
@Transactional
public class TItemInfoServiceImpl extends AbstractService<TItemInfo> implements TItemInfoService {
    @Resource
    private TItemInfoMapper tItemInfoMapper;

}
