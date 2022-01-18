package com.hbl.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbl.eduservice.entity.EduSubject;
import com.hbl.eduservice.entity.excel.SubjectData;
import com.hbl.eduservice.listener.SubjectExcelListener;
import com.hbl.eduservice.mapper.EduSubjectMapper;
import com.hbl.eduservice.service.EduSubjectService;
import com.hbl.servicebase.exceptionHandler.HblException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author hbl
 * @since 2022-01-18
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

	//添加课程分类
	@Override
	public void saveSubject(MultipartFile file, EduSubjectService eduSubjectService) {
		try {
			//文件输入流
			InputStream is = file.getInputStream();

			//调用方法进行读取
			EasyExcel.read(is, SubjectData.class, new SubjectExcelListener(eduSubjectService))
					.sheet().doRead();

		} catch (Exception e) {
			e.printStackTrace();
			throw new HblException(20002, "添加课程分类失败11");
		}
	}
}

