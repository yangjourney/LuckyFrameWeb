package com.luckyframe.project.tool.build;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.luckyframe.framework.web.controller.BaseController;

/**
 * build 表单构建
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/tool/build")
public class BuildController extends BaseController
{

    @RequiresPermissions("tool:build:view")
    @GetMapping()
    public String build()
    {
        return "tool/build/build";
    }
}
