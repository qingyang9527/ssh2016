package service.impl;

import java.util.List;

import dao.ITeacherDAO;

import service.ITeacherService;
import util.PageBean;
import vo.Teacher;

public class TeacherService implements ITeacherService {
	private ITeacherDAO teacherDAO;

	public ITeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public void setTeacherDAO(ITeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	public void addTeacher(Teacher t) {
		this.teacherDAO.addTeacher(t);
	}

	public Teacher findTeacherById(String tid) {
		return teacherDAO.findTeacherById(tid);
	}

	public PageBean queryForPage(int pageSize, int page) {
		final String hql = "from Teacher order by tid"; // ��ѯ���
		int allRow = teacherDAO.getAllRowCount(hql); // �ܼ�¼��
		int totalPage = PageBean.countTatalPage(pageSize, allRow); // ��ҳ��
		final int offset = PageBean.countOffset(pageSize, page); // ��ǰҳ��ʼ��¼
		final int length = pageSize; // ÿҳ��¼��
		final int currentPage = PageBean.countCurrentPage(page); // ��ǰҳ
		List tlist = teacherDAO.queryForPage(hql, offset, length); //
		// �ѷ�ҳ��Ϣ���浽Bean����
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setTlist(tlist);
		pageBean.init();
		return pageBean;
	}

	public void updateTeacher(Teacher t) {
		this.teacherDAO.updateTeacher(t);

	}

	public void deleteTeacher(Teacher t) {
		this.teacherDAO.deleteTeacher(t);

	}

	public Teacher validateUser(String username, String password) {
		return teacherDAO.validateUser(username, password);
	}

}
