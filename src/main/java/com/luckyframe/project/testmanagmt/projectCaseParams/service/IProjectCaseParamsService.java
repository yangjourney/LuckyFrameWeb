package com.luckyframe.project.testmanagmt.projectCaseParams.service;

import java.util.List;

import com.luckyframe.project.testmanagmt.projectCaseParams.domain.ProjectCaseParams;

/**
 * 用例公共参数 服务层
 * 
 * @author luckyframe
 * @date 2019-03-21
 */
public interface IProjectCaseParamsService 
{
	/**
     * 查询用例公共参数信息
     * 
     * @param paramsId 用例公共参数ID
     * @return 用例公共参数信息
     */
	ProjectCaseParams selectProjectCaseParamsById(Integer paramsId);
	
	/**
     * 查询用例公共参数列表
     * 
     * @param projectCaseParams 用例公共参数信息
     * @return 用例公共参数集合
     */
	List<ProjectCaseParams> selectProjectCaseParamsList(ProjectCaseParams projectCaseParams);
	
	/**
	 * 根据项目ID查询所有项目中以及当前项目下的公共参数
	 * @param projectId 项目ID
	 * @author Seagull
	 * @date 2019年6月18日
	 */
	List<ProjectCaseParams> selectProjectCaseParamsListByProjectId(Integer projectId);
	
	/**
     * 新增用例公共参数
     * 
     * @param projectCaseParams 用例公共参数信息
     * @return 结果
     */
	int insertProjectCaseParams(ProjectCaseParams projectCaseParams);
	
	/**
     * 修改用例公共参数
     * 
     * @param projectCaseParams 用例公共参数信息
     * @return 结果
     */
	int updateProjectCaseParams(ProjectCaseParams projectCaseParams);
		
	/**
     * 删除用例公共参数信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deleteProjectCaseParamsByIds(String ids);
	
    /**
     * 校验用例参数名称是否唯一
     * @param projectCaseParams 公共参数对象
     * @author Seagull
     * @date 2019年3月22日
     */
    String checkProjectCaseParamsNameUnique(ProjectCaseParams projectCaseParams);
}
