package com.cf.service;

import com.cf.entity.EduCourseEntity;

import java.util.List;
import java.util.Map;

/**
 * 课程
 * 
 * @author yy
 * @email 849876282@qq.com
 * @date 2019-10-20 12:12:49
 */
public interface EduCourseService {
	
	EduCourseEntity queryObject(String id);
	
	List<EduCourseEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(EduCourseEntity eduCourse);
	
	void update(EduCourseEntity eduCourse);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
