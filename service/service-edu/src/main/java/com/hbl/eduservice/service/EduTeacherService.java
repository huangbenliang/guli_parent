package com.hbl.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hbl.eduservice.entity.EduTeacher;
import com.hbl.eduservice.entity.vo.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author hbl
 * @since 2022-01-13
 */
public interface EduTeacherService extends IService<EduTeacher> {
	//多条件查询讲师带分页
	void pageQuery(Page<EduTeacher> pageParam, TeacherQuery teacherQuery);

}
