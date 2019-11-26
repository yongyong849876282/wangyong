package com.cf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.cf.dao.EduCourseDao;
import com.cf.entity.EduCourseEntity;
import com.cf.service.EduCourseService;



@Service("eduCourseService")
public class EduCourseServiceImpl implements EduCourseService {
	@Autowired
	private EduCourseDao eduCourseDao;
	
	@Override
	public EduCourseEntity queryObject(String id){
		return eduCourseDao.queryObject(id);
	}
	
	@Override
	public List<EduCourseEntity> queryList(Map<String, Object> map){
		return eduCourseDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return eduCourseDao.queryTotal(map);
	}
	
	@Override
	public void save(EduCourseEntity eduCourse){
		eduCourseDao.save(eduCourse);
	}
	
	@Override
	public void update(EduCourseEntity eduCourse){
		eduCourseDao.update(eduCourse);
	}
	
	@Override
	public void delete(String id){
		eduCourseDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		eduCourseDao.deleteBatch(ids);
	}
	
}
