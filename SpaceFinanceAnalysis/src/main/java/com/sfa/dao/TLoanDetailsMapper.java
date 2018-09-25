package com.sfa.dao;

import java.util.List;

import com.sfa.core.Mapper;
import com.sfa.model.LoanResult;
import com.sfa.model.TLoanDetails;

public interface TLoanDetailsMapper extends Mapper<TLoanDetails> {

	List<LoanResult> selectLoanOut(Integer tLoanoutComid);
	List<LoanResult> selectLoanIn(Integer tLoaninComid);
}