package action;

import java.util.List;

import service.impl.TeacherService;
import util.PageBean;
import vo.Teacher;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TeacherAction extends ActionSupport implements
		ModelDriven<Teacher> {
	private Teacher teacher = new Teacher();
	private TeacherService teacherService;
	private PageBean pageBean;
	private int page = 1;
	private List<Teacher> tlist;

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<Teacher> getTlist() {
		return tlist;
	}

	public void setTlist(List<Teacher> tlist) {
		this.tlist = tlist;
	}

	public Teacher getModel() {
		return teacher;
	}

	public String addTeacher() {
		teacherService.addTeacher(teacher);
		return "addTeacher_success";

	}

	public String findTeacherPage() {
		this.pageBean = teacherService.queryForPage(5, page);// 获取封装了分页信息和数据的pageBean
		this.tlist = this.pageBean.getTlist(); // 获取数据
		return "findTeacherPage_success";
	}

	public String editTeacher() {
		this.teacher = teacherService.findTeacherById(teacher.getTid());
		return "editTeacher_success";
	}

	public String updateTeacher() {
		teacherService.updateTeacher(teacher);
		return "updateTeacher_success";
	}

	public String deleteTeacher() {
		teacherService.deleteTeacher(teacher);
		return "deleteTeacher_success";
	}

}
