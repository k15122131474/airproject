package com.sfa.web;

import com.sfa.core.Result;
import com.sfa.core.ResultGenerator;
import com.sfa.model.LoanDetailsInfo;
import com.sfa.model.LoanResult;
import com.sfa.model.TLoanDetails;
import com.sfa.service.TLoanDetailsService;
import com.sfa.util.UUID;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
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
	@PostMapping("/details")
	public Result deltails(@RequestBody LoanDetailsInfo info) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		TLoanDetails tld=new TLoanDetails();
		int flagein=tLoanDetailsService.selectCompany(info.getIncompany());
		int flageout=tLoanDetailsService.selectCompany(info.getOutcompany());
		if(flagein==-1||flageout==-1) {
			return ResultGenerator.genFailResult("未找到公司id");
		}
		tld.settLoaninComid(flagein);
		tld.settLoanoutComid(flageout);
		tld.settStatus("进行中");
		tld.settWeiyueNum(info.getWeiyue());
		tld.settLixi(info.getLixi());
		tld.settLoanEndTime(info.getStarttime());
		tld.settLoanStartTime(info.getStarttime());
		tld.settLoanNum(info.getNum());
		try {
			Date starttime=sdf.parse(info.getStarttime());
			Date endtime=sdf.parse(info.getEndtime());
			tld.settChanghuanTotal(String.valueOf(Integer.parseInt(info.getNum())+Float.parseFloat(info.getNum())*Float.parseFloat(info.getLixi())*(endtime.getTime()-starttime.getTime())/(30*24*60*60*1000)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		tLoanDetailsService.save(tld);
		return ResultGenerator.genSuccessResult("贷款成功");
	}
	

}
