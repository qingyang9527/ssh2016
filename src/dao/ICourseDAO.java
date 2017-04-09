package dao;

import java.util.List;

import vo.Course;

public interface ICourseDAO {

	public List<Course> queryForPage(final String hql, final int offset,
			final int length);

	/**
	 * 查询所有的记录数
	 * 
	 * @param hql
	 *            查询条件
	 * @return 总记录数
	 */

	// 获取分页查询总的记录数
	public int getAllRowCount(String hql);

	// 学号查询学生信息
	public Course findCourseById(int cnum);

	// 增加学生
	public void addCourse(Course c);

	// 更新学生信息
	public void updateCourse(Course c);

	// 删除学生
	public void deleteCourse(Course c);

}
