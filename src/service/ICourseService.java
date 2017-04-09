package service;

import util.PageBean;
import vo.Course;

public interface ICourseService {
	public PageBean queryForPage(int pageSize, int page);

	public Course findCourseById(int cnum);

	public void addCourse(Course c);

	public void updateCourse(Course c);

	public void deleteCourse(Course c);
}
