package com.sfa.service.impl;

import com.sfa.dao.TLoanDetailsMapper;
import com.sfa.model.TLoanDetails;
import com.sfa.service.TLoanDetailsService;
import com.sfa.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/09/25.
 */
@Service
@Transactional
public class TLoanDetailsServiceImpl extends AbstractService<TLoanDetails> implements TLoanDetailsService {
    @Resource
    private TLoanDetailsMapper tLoanDetailsMapper;

}
