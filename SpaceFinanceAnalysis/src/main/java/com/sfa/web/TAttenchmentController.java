package com.sfa.web;
import com.sfa.core.Result;
import com.sfa.core.ResultGenerator;
import com.sfa.model.TAttenchment;
import com.sfa.service.TAttenchmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/09/18.
*/
@RestController
@RequestMapping("/t/attenchment")
public class TAttenchmentController {
    @Resource
    private TAttenchmentService tAttenchmentService;

    @PostMapping("/add")
    public Result add(TAttenchment tAttenchment) {
        tAttenchmentService.save(tAttenchment);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        tAttenchmentService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(TAttenchment tAttenchment) {
        tAttenchmentService.update(tAttenchment);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        TAttenchment tAttenchment = tAttenchmentService.findById(id);
        return ResultGenerator.genSuccessResult(tAttenchment);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<TAttenchment> list = tAttenchmentService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
