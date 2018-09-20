package com.sfa.service.impl;

import com.sfa.dao.TCompanyMapper;
import com.sfa.model.TCompany;
import com.sfa.service.TCompanyService;
import com.sfa.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/09/20.
 */
@Service
@Transactional
public class TCompanyServiceImpl extends AbstractService<TCompany> implements TCompanyService {
    @Resource
    private TCompanyMapper tCompanyMapper;

}
