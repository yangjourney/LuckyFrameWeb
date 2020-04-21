package com.luckyframe.project.testexecution.taskCaseLog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.luckyframe.common.utils.StringUtils;
import com.luckyframe.common.utils.poi.ExcelUtil;
import com.luckyframe.framework.aspectj.lang.annotation.Log;
import com.luckyframe.framework.aspectj.lang.enums.BusinessType;
import com.luckyframe.framework.web.controller.BaseController;
import com.luckyframe.framework.web.domain.AjaxResult;
import com.luckyframe.project.testexecution.taskCaseLog.domain.TaskCaseLog;
import com.luckyframe.project.testexecution.taskCaseLog.service.ITaskCaseLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 用例日志明细 信息操作处理
 * 
 * @author luckyframe
 * @date 2019-04-08
 */
@Controller
@RequestMapping("/testexecution/taskCaseLog")
public class TaskCaseLogController extends BaseController
{
	
	@Autowired
	private ITaskCaseLogService taskCaseLogService;
	
/*	@RequiresPermissions("testexecution:taskCaseExecute:view")
	@GetMapping()
	public String taskCaseLog()
	{
	    return "testexecution/taskCaseLog/taskCaseLog";
	}*/
	
	/**
	 * 查询用例日志明细列表
	 */
	@RequiresPermissions("testexecution:taskCaseExecute:list")
	@RequestMapping(value = "/list")
	public void list(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();
		String taskCaseIdStr = request.getParameter("taskCaseId");
		int taskCaseId = 0;
		// 得到客户端传递的查询参数
		if (StringUtils.isNotEmpty(taskCaseIdStr)) {
			taskCaseId = Integer.parseInt(taskCaseIdStr);
		}
				
        List<TaskCaseLog> loglist = taskCaseLogService.selectTaskCaseLogListByTaskCaseId(taskCaseId);
		// 转换成json字符串
		JSONArray recordJson= JSONArray.parseArray(JSON.toJSONString(loglist));
		pw.print(recordJson);
	}
	
	
	/**
	 * 导出用例日志明细列表
	 */
	@RequiresPermissions("testexecution:taskCaseExecute:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TaskCaseLog taskCaseLog)
    {
    	List<TaskCaseLog> list = taskCaseLogService.selectTaskCaseLogList(taskCaseLog);
        ExcelUtil<TaskCaseLog> util = new ExcelUtil<>(TaskCaseLog.class);
        return util.exportExcel(list, "taskCaseLog");
    }
	
/*
	@GetMapping("/add")
	public String add()
	{
	    return "testexecution/taskCaseLog/add";
	}*/
	
	/**
	 * 新增保存用例日志明细
	 */
	@RequiresPermissions("testexecution:taskCaseExecute:add")
	@Log(title = "用例日志明细", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TaskCaseLog taskCaseLog)
	{		
		return toAjax(taskCaseLogService.insertTaskCaseLog(taskCaseLog));
	}

	/*	@GetMapping("/edit/{logId}")
	public String edit(@PathVariable("logId") Integer logId, ModelMap mmap)
	{
		TaskCaseLog taskCaseLog = taskCaseLogService.selectTaskCaseLogById(logId);
		mmap.put("taskCaseLog", taskCaseLog);
	    return "testexecution/taskCaseLog/edit";
	}*/
	
	/**
	 * 修改保存用例日志明细
	 */
	@RequiresPermissions("testexecution:taskCaseExecute:edit")
	@Log(title = "用例日志明细", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TaskCaseLog taskCaseLog)
	{		
		return toAjax(taskCaseLogService.updateTaskCaseLog(taskCaseLog));
	}
	
	/**
	 * 删除用例日志明细
	 */
	@RequiresPermissions("testexecution:taskCaseExecute:remove")
	@Log(title = "用例日志明细", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(taskCaseLogService.deleteTaskCaseLogByIds(ids));
	}
	
}
