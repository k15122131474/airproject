package com.sfa.service.impl;

import com.sfa.dao.TPersonMapper;
import com.sfa.model.TPerson;
import com.sfa.service.TPersonService;
import com.sfa.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/08/30.
 */
@Service
@Transactional
public class TPersonServiceImpl extends AbstractService<TPerson> implements TPersonService {
    @Resource
    private TPersonMapper tPersonMapper;

}
