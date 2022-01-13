package com.hbl.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbl.eduservice.entity.EduTeacher;
import com.hbl.eduservice.entity.vo.TeacherQuery;
import com.hbl.eduservice.mapper.EduTeacherMapper;
import com.hbl.eduservice.service.EduTeacherService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author hbl
 * @since 2022-01-13
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

	@Override
	public void pageQuery(Page<EduTeacher> pageParam, TeacherQuery teacherQuery) {
		//构建条件
		QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();

		Optional.ofNullable(teacherQuery).filter(e -> !StringUtils.isEmpty(e.getName())).map(TeacherQuery::getName)
				.ifPresent(name -> wrapper.like("name", name));

		Integer level = teacherQuery.getLevel();
		String begin = teacherQuery.getBegin();
		String end = teacherQuery.getEnd();

		//判断是否传入教师头衔
		if (!StringUtils.isEmpty(level)){
			//构造条件
			wrapper.eq("level",level);
		}
		if (!StringUtils.isEmpty(begin)){
			//构造条件
			wrapper.ge("gmt_create",begin);//ge：大于等于
		}
		if (!StringUtils.isEmpty(begin)){
			//构造条件
			wrapper.le("gmt_modified",end);//le:小于等于
		}

		baseMapper.selectPage(pageParam, wrapper);
	}


}
