package com.sfa.dao;

import java.util.List;

import com.sfa.core.Mapper;
import com.sfa.model.LoanResult;
import com.sfa.model.TLoanDetails;

public interface TLoanDetailsMapper extends Mapper<TLoanDetails> {

	List<LoanResult> selectLoanOut(String tLoanoutComid);
	List<LoanResult> selectLoanIn(String tLoaninComid);
	int selectCompany(String outcompany);
	String selectCompanyById(String userId);
	int updataStatus(int tLoanId);
}