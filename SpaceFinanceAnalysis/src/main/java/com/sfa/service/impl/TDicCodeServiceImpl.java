package com.sfa.service.impl;

import com.sfa.dao.TDicCodeMapper;
import com.sfa.model.TDicCode;
import com.sfa.service.TDicCodeService;
import com.sfa.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/09/17.
 */
@Service
@Transactional
public class TDicCodeServiceImpl extends AbstractService<TDicCode> implements TDicCodeService {
    @Resource
    private TDicCodeMapper tDicCodeMapper;

}
