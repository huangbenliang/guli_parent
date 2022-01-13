package com.hbl.eduservice.controller;


import com.hbl.eduservice.entity.EduTeacher;
import com.hbl.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author hbl
 * @since 2022-01-13
 */
@RestController
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {
	@Autowired
	private EduTeacherService eduTeacherService;

	//查询讲师表所有数据
	@GetMapping("/findAll")
	public List<EduTeacher> list(){
		return eduTeacherService.list(null);
	}

}

