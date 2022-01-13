package com.hbl.eduservice.controller;


import com.hbl.eduservice.entity.EduTeacher;
import com.hbl.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@CrossOrigin //解决跨域问题
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {
	@Autowired
	private EduTeacherService eduTeacherService;

	//查询讲师表所有数据
	@GetMapping("/findAll")
	public List<EduTeacher> list(){
		return eduTeacherService.list(null);
	}
	//逻辑删除讲师
	@DeleteMapping("/deleteTeacherById/{id}")
	public boolean deleteTeacherById(@PathVariable String id){
		return eduTeacherService.removeById(id);
	}


}

