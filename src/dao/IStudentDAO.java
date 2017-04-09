package dao;

import java.util.List;

import vo.Student;

public interface IStudentDAO {
	public List<Student> queryForPage(final String hql, final int offset,
			final int length);

	/**
	 * ��ѯ���еļ�¼��
	 * 
	 * @param hql
	 *            ��ѯ����
	 * @return �ܼ�¼��
	 */

	// ��ȡ��ҳ��ѯ�ܵļ�¼��
	public int getAllRowCount(String hql);

	// ѧ�Ų�ѯѧ����Ϣ
	public Student findStudentById(int sid);

	public Student findStudentByStudentId(String studentId);

	// ����ѧ��
	public void addStudent(Student s);

	// ����ѧ����Ϣ
	public void updateStudent(Student s);

	// ɾ��ѧ��
	public void deleteStudent(Student s);

	public Student validateStu(String studentId, String spwd);

}
