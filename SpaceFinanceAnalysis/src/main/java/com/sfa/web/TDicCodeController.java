package com.sfa.web;
import com.sfa.core.Result;
import com.sfa.core.ResultGenerator;
import com.sfa.model.TDicCode;
import com.sfa.service.TDicCodeService;
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
* Created by CodeGenerator on 2018/09/17.
*/
@RestController
@RequestMapping("/t/dic/code")
public class TDicCodeController {
    @Resource
    private TDicCodeService tDicCodeService;

    @PostMapping("/add")
    public Result add(@RequestBody TDicCode tDicCode) {
        tDicCodeService.save(tDicCode);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam("id") Integer id) {
  
        tDicCodeService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(TDicCode tDicCode) {
        tDicCodeService.update(tDicCode);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        TDicCode tDicCode = tDicCodeService.findById(id);
        return ResultGenerator.genSuccessResult(tDicCode);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<TDicCode> list = tDicCodeService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
