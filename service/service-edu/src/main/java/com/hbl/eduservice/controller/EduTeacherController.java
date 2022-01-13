package com.hbl.eduservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbl.commonutils.R;
import com.hbl.eduservice.entity.EduTeacher;
import com.hbl.eduservice.entity.vo.TeacherQuery;
import com.hbl.eduservice.service.EduTeacherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
//@Api(description = "讲师管理")
public class EduTeacherController {
	@Autowired
	private EduTeacherService eduTeacherService;

	//查询讲师表所有数据
	@GetMapping("/findAll")
	@ApiOperation("所有讲师列表")
	public R list() {
		List<EduTeacher> list = eduTeacherService.list(null);
		return R.ok().data("items", list);
	}

	//逻辑删除讲师
	@ApiOperation(value = "根据ID删除讲师")
	@DeleteMapping("/deleteTeacherById/{id}")
	public R deleteTeacherById(@ApiParam(name = "id", value = "讲师Id", required = true) @PathVariable String id) {
		boolean flag = eduTeacherService.removeById(id);
		if (flag) {
			return R.ok();
		} else {
			return R.error();
		}
	}

	@ApiOperation("分页讲师列表")
	@GetMapping("/pageList/{page}/{limit}")
	public R pageList(@ApiParam(name = "page", value = "当前页码", required = true) @PathVariable Long page,
	                  @ApiParam(name = "limit", value = "每页记录数", required = true) @PathVariable Long limit) {
		Page<EduTeacher> pageParam=new Page<>(page,limit);
		eduTeacherService.page(pageParam, null);
		List<EduTeacher> records = pageParam.getRecords();
		long total = pageParam.getTotal();
		return R.ok().data("total",total).data("rows",records);
	}

	@ApiOperation("多条件查询讲师带分页")
	@PostMapping("/pageTeacherCondition/{page}/{limit}")
	public R pageTeacherCondition(@ApiParam(name = "page",value = "当前页码",required = true)@PathVariable Long page,
	                              @ApiParam(name = "limit",value = "每页记录数",required = false,defaultValue = "5")@PathVariable Long limit,
	                              @RequestBody(required = false)TeacherQuery teacherQuery){
		Page<EduTeacher> pageParam=new Page<>(page, limit);
		eduTeacherService.pageQuery(pageParam, teacherQuery);
		List<EduTeacher> records = pageParam.getRecords();
		long total = pageParam.getTotal();
		return R.ok().data("total",total).data("rows",records);
	}
}

