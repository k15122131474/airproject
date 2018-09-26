package com.sfa.web;

import com.sfa.core.Result;
import com.sfa.core.ResultGenerator;
import com.sfa.model.LoanResult;
import com.sfa.model.TLoanDetails;
import com.sfa.service.TLoanDetailsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2018/09/25.
 */
@RestController
@RequestMapping("/t/loan/details")
public class TLoanDetailsController {
	@Resource
	private TLoanDetailsService tLoanDetailsService;

	@PostMapping("/add")
	public Result add(TLoanDetails tLoanDetails) {	
		tLoanDetailsService.save(tLoanDetails);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		tLoanDetailsService.deleteById(id);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/update")
	public Result update(TLoanDetails tLoanDetails) {
		tLoanDetailsService.update(tLoanDetails);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam Integer id) {
		TLoanDetails tLoanDetails = tLoanDetailsService.findById(id);
		return ResultGenerator.genSuccessResult(tLoanDetails);
	}

	@PostMapping("/list")
	public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
		PageHelper.startPage(page, size);
		List<TLoanDetails> list = tLoanDetailsService.findAll();
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

	@PostMapping("/loanout")
	public Result loanout(@RequestParam String tLoanoutComid) {
		if (tLoanoutComid == null) {
			return ResultGenerator.genFailResult("查询失败");
		} else {
			List<LoanResult> rs = tLoanDetailsService.selectloanout(tLoanoutComid);
			return ResultGenerator.genSuccessResult(rs);
		}
	}
	@PostMapping("/loanin")
	public Result loanin(@RequestParam String tLoaninComid) {
		if (tLoaninComid == null) {
			return ResultGenerator.genFailResult("查询失败");
		} else {
			List<LoanResult> rs = tLoanDetailsService.selectloanin(tLoaninComid);
			return ResultGenerator.genSuccessResult(rs);
		}
	}

}
