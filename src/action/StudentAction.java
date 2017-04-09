package action;

import java.util.List;

import service.IStudentService;
import service.impl.StudentService;
import util.PageBean;
import vo.Student;
import vo.User;

import com.opensymphony.xwork2.ModelDriven;

public class StudentAction extends SuperAction implements ModelDriven<Student> {
	private Student student = new Student();
	private IStudentService studentService;
	private PageBean pageBean;
	private int page = 1;
	private List<Student> studentlist;

	private static final long serialVersionUID = 1L;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<Student> getStudentlist() {
		return studentlist;
	}

	public void setStudentlist(List<Student> studentlist) {
		this.studentlist = studentlist;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public Student getModel() {
		return student;
	}

	public IStudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	/*
	 * public String findStudent() { List<Student> list =
	 * studentService.findAllStudent(); if (list != null && list.size() > 0) {
	 * session.setAttribute("student_list", list); } return
	 * "Studetn_find_success";
	 * 
	 * }
	 */

	// 通过学生学号查询

	public String findStudentPage() {
		this.pageBean = studentService.queryForPage(5, page);// 获取封装了分页信息和数据的pageBean
		this.studentlist = this.pageBean.getList(); // 获取数据
		return "findStudentPage_success";
	}

	// 增加学生信息的action方法
	public String addStudent() {
		this.studentService.addStudent(student);
		return "addStudent_success";
	}

	// 编辑学生信息的action方法
	public String editStudent() {
		this.student = studentService.findStudentById(student.getSid());
		return "editStudent_success";
	}

	public String editStudentByStudentId() {
		this.student = studentService.findStudentByStudentId(student
				.getStudentId());
		return "editStudentByStudentId_success";
	}

	// 更新学生信息的action方法
	public String updateStudent() {
		this.studentService.updateStudent(student);
		return "updateStudent_success";
	}

	// 删除学生信息的action方法
	public String deleteStudent() {
		this.studentService.deleteStudent(student);
		return "deleteStudent_success";
	}

}
