package com.cf.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 课程
 * 
 * @author yy
 * @email 849876282@qq.com
 * @date 2019-10-20 12:12:49
 */
public class EduCourseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//课程ID
	private String id;
	//课程讲师ID
	private String teacherId;
	//课程专业ID
	private String subjectId;
	//课程专业父级ID
	private String subjectParentId;
	//课程标题
	private String title;
	//课程销售价格，设置为0则可免费观看
	private BigDecimal price;
	//总课时
	private Integer lessonNum;
	//课程封面图片路径
	private String cover;
	//销售数量
	private Long buyCount;
	//浏览数量
	private Long viewCount;
	//乐观锁
	private Long version;
	//课程状态 Draft未发布  Normal已发布
	private String status;
	//创建时间
	private Date gmtCreate;
	//更新时间
	private Date gmtModified;

	/**
	 * 设置：课程ID
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：课程ID
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：课程讲师ID
	 */
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	/**
	 * 获取：课程讲师ID
	 */
	public String getTeacherId() {
		return teacherId;
	}
	/**
	 * 设置：课程专业ID
	 */
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	/**
	 * 获取：课程专业ID
	 */
	public String getSubjectId() {
		return subjectId;
	}
	/**
	 * 设置：课程专业父级ID
	 */
	public void setSubjectParentId(String subjectParentId) {
		this.subjectParentId = subjectParentId;
	}
	/**
	 * 获取：课程专业父级ID
	 */
	public String getSubjectParentId() {
		return subjectParentId;
	}
	/**
	 * 设置：课程标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：课程标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：课程销售价格，设置为0则可免费观看
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：课程销售价格，设置为0则可免费观看
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：总课时
	 */
	public void setLessonNum(Integer lessonNum) {
		this.lessonNum = lessonNum;
	}
	/**
	 * 获取：总课时
	 */
	public Integer getLessonNum() {
		return lessonNum;
	}
	/**
	 * 设置：课程封面图片路径
	 */
	public void setCover(String cover) {
		this.cover = cover;
	}
	/**
	 * 获取：课程封面图片路径
	 */
	public String getCover() {
		return cover;
	}
	/**
	 * 设置：销售数量
	 */
	public void setBuyCount(Long buyCount) {
		this.buyCount = buyCount;
	}
	/**
	 * 获取：销售数量
	 */
	public Long getBuyCount() {
		return buyCount;
	}
	/**
	 * 设置：浏览数量
	 */
	public void setViewCount(Long viewCount) {
		this.viewCount = viewCount;
	}
	/**
	 * 获取：浏览数量
	 */
	public Long getViewCount() {
		return viewCount;
	}
	/**
	 * 设置：乐观锁
	 */
	public void setVersion(Long version) {
		this.version = version;
	}
	/**
	 * 获取：乐观锁
	 */
	public Long getVersion() {
		return version;
	}
	/**
	 * 设置：课程状态 Draft未发布  Normal已发布
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：课程状态 Draft未发布  Normal已发布
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：创建时间
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}
	/**
	 * 设置：更新时间
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getGmtModified() {
		return gmtModified;
	}
}
