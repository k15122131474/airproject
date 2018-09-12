package com.sfa.web;
import com.sfa.core.Result;
import com.sfa.core.ResultGenerator;
import com.sfa.model.TSysUser;
import com.sfa.service.TSysUserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.sfa.util.DbUtiles;
import com.sfa.util.RandomUtils;
import com.sfa.util.UUID;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.util.List;

/**
* Created by CodeGenerator on 2018/08/30.
*/
@RestController
@RequestMapping("/t/sys/user")
public class TSysUserController {
    @Resource
    private TSysUserService tSysUserService;

    
    
    @ApiOperation(value = "测试User表增加接口", notes = "User表增加")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tSysUser", value = "用户实体类", required = true, dataType = "TSysUser")
    })
    @PostMapping("/add")
    public Result add(@RequestBody TSysUser tSysUser) {
    	
        tSysUserService.saveUser(tSysUser);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "测试User表登陆接口", notes = "User表查询登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tSysUser", value = "用户实体类", required = true, dataType = "TSysUser")
    })
    @PostMapping("/userLogin")
    public Result userLogin(@RequestBody TSysUser tSysUser,HttpSession session) {
    	
        boolean flag = tSysUserService.login(tSysUser);
        
        if(!flag) {
        	return ResultGenerator.genFailResult("登陆失败！");
        }else {
        	List<TSysUser> list = tSysUserService.selectSysUserByNameAndPwd(tSysUser);
        	TSysUser rs=list.get(0);
        	if(list != null && list.size() > 0) {
        		if(DbUtiles.cheackSession(rs.gettUserId())) {
        			DbUtiles.userLogout(rs.gettUserId());
        			return ResultGenerator.genFailResult("用户已登陆");
        		}
        		session.setAttribute("id", rs.gettUserId());
        		DbUtiles.mapSession.put(rs.gettUserId(), session);
        		return ResultGenerator.genSuccessResult(rs);
        	}else {
        		return ResultGenerator.genFailResult("没有找到用户信息");
        	}
        	
        } 
    }
    
    @GetMapping("/userLogout")
    public Result userLogout(@RequestParam String id,HttpSession session) {
    	if(DbUtiles.cheackSession(id)) {
    		DbUtiles.userLogout(id);
    		return ResultGenerator.genSuccessResult("注销成功");
    	}
    	return ResultGenerator.genFailResult("没有找到登陆用户");
    }
    
    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        tSysUserService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(TSysUser tSysUser) {
        tSysUserService.update(tSysUser);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        TSysUser tSysUser = tSysUserService.findById(id);
        return ResultGenerator.genSuccessResult(tSysUser);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<TSysUser> list = tSysUserService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
