package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.IStudentDAO;
import dao.impl.StudentDAO;

import service.IStudentService;
import vo.Student;

import util.PageBean;

public class StudentService implements IStudentService {
	private IStudentDAO studentDAO;

	public Student findStudentById(int sid) {
		return studentDAO.findStudentById(sid);
	}

	public Student findStudentByStudentId(String studentId) {
		return studentDAO.findStudentByStudentId(studentId);
	}

	public void addStudent(Student s) {
		this.studentDAO.addStudent(s);
	}

	public void updateStudent(Student s) {
		this.studentDAO.updateStudent(s);
	}

	public void deleteStudent(Student s) {
		this.studentDAO.deleteStudent(s);
	}

	public IStudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(IStudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	/**
	 * ��ҳ��ѯ
	 * 
	 * @param pageSize
	 *            ÿҳ��ʾ���ټ�¼
	 * @param currentPage
	 *            ��ǰҳ
	 * @return ��װ�˷�ҳ��Ϣ��bean
	 */
	public PageBean queryForPage(int pageSize, int page) {
		final String hql = "from Student s order by s.sid"; // ��ѯ���
		int allRow = studentDAO.getAllRowCount(hql); // �ܼ�¼��
		int totalPage = PageBean.countTatalPage(pageSize, allRow); // ��ҳ��
		final int offset = PageBean.countOffset(pageSize, page); // ��ǰҳ��ʼ��¼
		final int length = pageSize; // ÿҳ��¼��
		final int currentPage = PageBean.countCurrentPage(page); // ��ǰҳ
		List list = studentDAO.queryForPage(hql, offset, length); //
		// �ѷ�ҳ��Ϣ���浽Bean����
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}

	public Student validateStu(String studentId, String spwd) {
		return studentDAO.validateStu(studentId, spwd);

	}
}
