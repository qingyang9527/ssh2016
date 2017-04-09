package dao;

import java.util.List;

import vo.Student;

public interface IStudentDAO {
	public List<Student> queryForPage(final String hql, final int offset,
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
	public Student findStudentById(int sid);

	public Student findStudentByStudentId(String studentId);

	// 增加学生
	public void addStudent(Student s);

	// 更新学生信息
	public void updateStudent(Student s);

	// 删除学生
	public void deleteStudent(Student s);

	public Student validateStu(String studentId, String spwd);

}
