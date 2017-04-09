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
	 * 分页查询
	 * 
	 * @param pageSize
	 *            每页显示多少记录
	 * @param currentPage
	 *            当前页
	 * @return 封装了分页信息的bean
	 */
	public PageBean queryForPage(int pageSize, int page) {
		final String hql = "from Student s order by s.sid"; // 查询语句
		int allRow = studentDAO.getAllRowCount(hql); // 总记录数
		int totalPage = PageBean.countTatalPage(pageSize, allRow); // 总页数
		final int offset = PageBean.countOffset(pageSize, page); // 当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = PageBean.countCurrentPage(page); // 当前页
		List list = studentDAO.queryForPage(hql, offset, length); //
		// 把分页信息保存到Bean当中
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
