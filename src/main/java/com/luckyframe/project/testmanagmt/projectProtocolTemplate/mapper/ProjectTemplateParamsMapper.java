package com.luckyframe.project.testmanagmt.projectProtocolTemplate.mapper;

import java.util.List;

import com.luckyframe.project.testmanagmt.projectProtocolTemplate.domain.ProjectTemplateParams;
import org.springframework.stereotype.Component;

/**
 * 模板参数管理 数据层
 * 
 * @author luckyframe
 * @date 2019-03-05
 */
@Component
public interface ProjectTemplateParamsMapper 
{
	/**
     * 查询模板参数管理信息
     * 
     * @param paramsId 模板参数管理ID
     * @return 模板参数管理信息
     */
	ProjectTemplateParams selectProjectTemplateParamsById(Integer paramsId);
	
	/**
     * 查询模板参数管理列表
     * 
     * @param projectTemplateParams 模板参数管理信息
     * @return 模板参数管理集合
     */
	List<ProjectTemplateParams> selectProjectTemplateParamsList(ProjectTemplateParams projectTemplateParams);
	
	/**
     * 新增模板参数管理
     * 
     * @param projectTemplateParams 模板参数管理信息
     * @return 结果
     */
	int insertProjectTemplateParams(ProjectTemplateParams projectTemplateParams);
	
	/**
     * 修改模板参数管理
     * 
     * @param projectTemplateParams 模板参数管理信息
     * @return 结果
     */
	int updateProjectTemplateParams(ProjectTemplateParams projectTemplateParams);
	
	/**
	 * 根据模板ID删除关联的所有参数
	 * @param templateId 模板ID
	 * @author Seagull
	 * @date 2019年3月6日
	 */
	int deleteProjectTemplateParamsByTemplateId(Integer templateId);
	
	/**
     * 批量删除模板参数管理
     * 
     * @param paramsIds 需要删除的数据ID
     * @return 结果
     */
	int deleteProjectTemplateParamsByIds(String[] paramsIds);
	
}