package service;

import java.util.List;

import util.PageBean;
import vo.Student;

public interface IStudentService {

	/*
	 * 分页查询学生信息
	 */
	public PageBean queryForPage(int pageSize, int page);

	/*
	 * 通过学生学号来查询学生信息
	 */
	public Student findStudentById(int sid);

	/**
	 * 增加学生
	 * 
	 * @param s
	 */
	public void addStudent(Student s);

	/**
	 * 更新学生信息
	 * 
	 * @param s
	 */
	public void updateStudent(Student s);

	/**
	 * 删除学生
	 * 
	 * @param s
	 */
	public void deleteStudent(Student s);

	public Student validateStu(String studentId, String spwd);

	public Student findStudentByStudentId(String studentId);

}
