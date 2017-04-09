package dao;

import java.util.List;

import vo.Teacher;

public interface ITeacherDAO {

	public void addTeacher(Teacher t);

	public int getAllRowCount(String hql);

	public Teacher findTeacherById(String tid);

	public List<Teacher> queryForPage(final String hql, final int offset,
			final int length);

	public void updateTeacher(Teacher t);

	public void deleteTeacher(Teacher t);

	public Teacher validateUser(String username, String password);

}
