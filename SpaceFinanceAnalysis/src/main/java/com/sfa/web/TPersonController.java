package com.sfa.web;

import com.sfa.core.Result;
import com.sfa.core.ResultGenerator;
import com.sfa.model.TPerson;
import com.sfa.model.TSysUser;
import com.sfa.model.UserInfo;
import com.sfa.service.TPersonService;
import com.sfa.util.UUID;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.mybatis.generator.ant.GeneratorAntTask;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2018/08/30.
 */
@RestController
@RequestMapping("/t/person")
public class TPersonController {
	@Resource
	private TPersonService tPersonService;

	@PostMapping("/add")
	public Result add(TPerson tPerson) {
		tPersonService.save(tPerson);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/addUser")
	public Result addUser(@RequestBody UserInfo userinfo) {
		boolean flage;
		TPerson tp = new TPerson();
		TSysUser tu = new TSysUser();
		String userid = UUID.randomUUID(32);
		tp.settPresonId(UUID.randomUUID(32));
		tp.settUserId(userid);
		tp.settCname(userinfo.gettCname());
		tp.settEmail(userinfo.gettEmail());
		tp.settGender(userinfo.gettGender());
		tp.settMobile(userinfo.gettMobile());

		tu.settUserId(userid);
		tu.settUserName(userinfo.gettUserName());
		tu.settUserPwd(userinfo.getPwd());
		tu.settRole("admin");
		tu.settStatus("-1");
		if (tPersonService.hasUser(userinfo.gettUserName()) == true) {
			return ResultGenerator.genFailResult("已存在账号");
		}
		flage = tPersonService.addAccount(tu, tp);
		return ResultGenerator.genSuccessResult(flage);
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		tPersonService.deleteById(id);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/update")
	public Result update(TPerson tPerson) {
		tPersonService.update(tPerson);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam Integer id) {
		TPerson tPerson = tPersonService.findById(id);
		return ResultGenerator.genSuccessResult(tPerson);
	}

	@PostMapping("/list")
	public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
		PageHelper.startPage(page, size);
		List<TPerson> list = tPersonService.findAll();
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

	@GetMapping("/getAllPerson")
	public Result getAllPerson() {
		List<TPerson> list = tPersonService.findAll();
		return ResultGenerator.genSuccessResult(list);
	}

	@GetMapping("/findInfoById")
	public Result findInfoById(@RequestParam String tPersonId) {
		UserInfo userinfo = tPersonService.findPersonById(tPersonId);
		return ResultGenerator.genSuccessResult(userinfo);
	}
	@GetMapping("/findInfoByUserId")
	public Result findInfoByUserId(@RequestParam String tUserId) {
		UserInfo userinfo = tPersonService.findPersonByUserId(tUserId);
		return ResultGenerator.genSuccessResult(userinfo);
	}

	@PostMapping("/updataforpau")
	public Result updataforpau(@RequestBody UserInfo userinfo) {
		boolean flagep;
		boolean flageu;
		TPerson tp = new TPerson();
		TSysUser tu = new TSysUser();
		if (userinfo == null) {
			return ResultGenerator.genFailResult("no info");
		} else {

			tp.settPresonId(userinfo.getId());
			tp.settUserId(userinfo.gettUserId());
			tp.settCname(userinfo.gettCname());
			tp.settEmail(userinfo.gettEmail());
			tp.settGender(userinfo.gettGender());
			tp.settMobile(userinfo.gettMobile());
			flagep = tPersonService.updataPersonInfo(tp);

			tu.settUserId(userinfo.gettUserId());
			tu.settUserName(userinfo.gettUserName());
			tu.settUserPwd(userinfo.getPwd());
			tu.settRole(userinfo.gettRole());
			tu.settStatus(userinfo.gettStatus());
			flageu = tPersonService.updataUserInfo(tu);
			if (flagep == true && flageu == true) {
				return ResultGenerator.genSuccessResult("updata success!");
			} else {
				return ResultGenerator.genFailResult("出现错误");
			}

		}
	}

	@GetMapping("/deleteById")
	Result deleteById(@RequestParam String tpersonid) {
		if (tpersonid == null) {
			return ResultGenerator.genSuccessResult("删除失败");
		} else {
			UserInfo userinfo = tPersonService.findPersonById(tpersonid);
			if(userinfo==null) {
				return ResultGenerator.genFailResult("删除失败");
			}
			TPerson tp=new TPerson();
			tp.settUserId(userinfo.gettUserId());
			tp.settPresonId(userinfo.getId());
			int flag = tPersonService.deleteUserInfo(tp);
			if (flag > 0) {
				return ResultGenerator.genSuccessResult("删除成功");
			} else {
				return ResultGenerator.genFailResult("删除失败");
			}
		}
	}
	
	@GetMapping("/findInfoByName")
	public Result findInfoByName(@RequestParam String tCname) {
		List<UserInfo> userinfo = tPersonService.findPersonByName(tCname);
		return ResultGenerator.genSuccessResult(userinfo);
	}
}
