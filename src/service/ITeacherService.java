package service;

import java.util.List;

import util.PageBean;
import vo.Teacher;

public interface ITeacherService {

	public void addTeacher(Teacher t);

	public Teacher findTeacherById(String tid);

	public PageBean queryForPage(int pageSize, int page);

	public void updateTeacher(Teacher t);

	public void deleteTeacher(Teacher t);

	public Teacher validateUser(String username, String password);

}
