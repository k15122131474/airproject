package com.sfa.service;
import com.sfa.model.LoanResult;
import com.sfa.model.TLoanDetails;

import java.util.List;

import com.sfa.core.Service;


/**
 * Created by CodeGenerator on 2018/09/25.
 */
public interface TLoanDetailsService extends Service<TLoanDetails> {

	List<LoanResult> selectloanout(String tLoanoutComid);
	List<LoanResult> selectloanin(String tLoaninComid);

}
