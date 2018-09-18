package com.sfa.service.impl;

import com.sfa.dao.TAttenchmentMapper;
import com.sfa.model.TAttenchment;
import com.sfa.service.TAttenchmentService;
import com.sfa.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/09/18.
 */
@Service
@Transactional
public class TAttenchmentServiceImpl extends AbstractService<TAttenchment> implements TAttenchmentService {
    @Resource
    private TAttenchmentMapper tAttenchmentMapper;

}
