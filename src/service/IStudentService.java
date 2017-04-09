package service;

import java.util.List;

import util.PageBean;
import vo.Student;

public interface IStudentService {

	/*
	 * ��ҳ��ѯѧ����Ϣ
	 */
	public PageBean queryForPage(int pageSize, int page);

	/*
	 * ͨ��ѧ��ѧ������ѯѧ����Ϣ
	 */
	public Student findStudentById(int sid);

	/**
	 * ����ѧ��
	 * 
	 * @param s
	 */
	public void addStudent(Student s);

	/**
	 * ����ѧ����Ϣ
	 * 
	 * @param s
	 */
	public void updateStudent(Student s);

	/**
	 * ɾ��ѧ��
	 * 
	 * @param s
	 */
	public void deleteStudent(Student s);

	public Student validateStu(String studentId, String spwd);

	public Student findStudentByStudentId(String studentId);

}
