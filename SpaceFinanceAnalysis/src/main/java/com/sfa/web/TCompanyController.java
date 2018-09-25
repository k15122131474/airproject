package com.sfa.web;
import com.sfa.core.Result;
import com.sfa.core.ResultGenerator;
import com.sfa.model.TCompany;
import com.sfa.service.TCompanyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/09/20.
*/
@RestController
@RequestMapping("/t/company")
public class TCompanyController {
    @Resource
    private TCompanyService tCompanyService;

    @PostMapping("/add")
    public Result add(@RequestBody TCompany tCompany) {
        tCompanyService.save(tCompany);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        tCompanyService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody TCompany tCompany) {
    	
        tCompanyService.update(tCompany);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        TCompany tCompany = tCompanyService.findById(id);
        return ResultGenerator.genSuccessResult(tCompany);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<TCompany> list = tCompanyService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
