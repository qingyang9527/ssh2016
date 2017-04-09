package dao;

import java.util.List;

import vo.Course;

public interface ICourseDAO {

	public List<Course> queryForPage(final String hql, final int offset,
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
	public Course findCourseById(int cnum);

	// ����ѧ��
	public void addCourse(Course c);

	// ����ѧ����Ϣ
	public void updateCourse(Course c);

	// ɾ��ѧ��
	public void deleteCourse(Course c);

}
