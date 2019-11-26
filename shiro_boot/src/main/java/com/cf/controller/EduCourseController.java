package com.cf.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cf.entity.EduCourseEntity;
import com.cf.service.EduCourseService;
import com.cf.utils.PageUtils;
import com.cf.utils.Query;
import com.cf.utils.R;


/**
 * 课程
 * 
 * @author yy
 * @email 849876282@qq.com
 * @date 2019-10-20 12:12:49
 */
@RestController
@RequestMapping("educourse")
public class EduCourseController {
	@Autowired
	private EduCourseService eduCourseService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("educourse:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<EduCourseEntity> eduCourseList = eduCourseService.queryList(query);
		int total = eduCourseService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(eduCourseList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("educourse:info")
	public R info(@PathVariable("id") String id){
		EduCourseEntity eduCourse = eduCourseService.queryObject(id);
		
		return R.ok().put("eduCourse", eduCourse);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("educourse:save")
	public R save(@RequestBody EduCourseEntity eduCourse){
		eduCourseService.save(eduCourse);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("educourse:update")
	public R update(@RequestBody EduCourseEntity eduCourse){
		eduCourseService.update(eduCourse);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("educourse:delete")
	public R delete(@RequestBody String[] ids){
		eduCourseService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
