package com.sfa.web;
import com.sfa.core.Result;
import com.sfa.core.ResultGenerator;
import com.sfa.model.TItemInfo;
import com.sfa.service.TItemInfoService;
import com.sfa.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
/**
* Created by CodeGenerator on 2018/08/28.
*/
@RestController
@RequestMapping("/t/item/info")

public class TItemInfoController {
	
    @Resource
    private TItemInfoService tItemInfoService;
    
    /**
     * @ApiOperation不是spring自带的注解是swagger里的,
     * com.wordnik.swagger.annotations.ApiOperation; 
     * @ApiOperation和@ApiParam为添加的API相关注解，个参数说明如下： 
	   @ApiOperation(value = “接口说明”, httpMethod = “接口请求方式”, 
			response = “接口返回参数类型”, notes = “接口发布说明”；其他参数可
     * @param tItemInfo
     * @return
     */
    
    
    @ApiOperation(value = "测试ITEM表接口", notes = "ITEM表增删查改")
    
    /**
     * @ApiImplicitParam：用在@ApiImplicitParams注解中，
     * 也可以单独使用，说明一个请求参数的各个方面，该注解包含的常用选项有：
		paramType：参数所放置的地方，包含query、header、path、body以及form，最常用的是前四个。
		name：参数名；
		dataType：参数类型，可以是基础数据类型，也可以是一个class；
		required：参数是否必须传；
		value：参数的注释，说明参数的意义；
		defaultValue：参数的默认值；
     * @param tItemInfo
     * @return
     */
    @ApiImplicitParams({//@ApiImplicitParams：用来包含API的一组参数注解，可以简单的理解为参数注解的集合声明；
        @ApiImplicitParam(name = "tItemInfo", value = "Item实体类", required = true, dataType = "TItemInfo")
    })
    
    /**
     * - @GetMapping是一个组合注解，是@RequestMapping(method = 
		RequestMethod.GET)的缩写。该注解将HTTP Get 映射到 特定的处理方法上。 
		- 同理PostMapping也是一个组合注解，是@RequestMapping(method = 
		RequestMethod.POST)的缩写。
		特别说明，@RequestMapping如果没有指定请求方式，将接收Get、Post、Head、Options等所有的请求方式。
     * @param tItemInfo
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody TItemInfo tItemInfo) {
    	
    	if (StringUtils.isNullorEmpty(tItemInfo)) {
             return ResultGenerator.genSuccessResult().setMessage("数据不能为空！");
        }
        tItemInfoService.save(tItemInfo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        tItemInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    
    @ApiOperation(value = "测试ITEM表接口", notes = "ITEM表增删查改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tItemInfo", value = "Item实体类", required = true, dataType = "TItemInfo")
    })
    @PostMapping("/update")
    public Result update(@RequestBody TItemInfo tItemInfo) {
        tItemInfoService.update(tItemInfo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        TItemInfo tItemInfo = tItemInfoService.findById(id);
        return ResultGenerator.genSuccessResult(tItemInfo);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<TItemInfo> list = tItemInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
