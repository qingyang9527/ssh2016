package action;

import java.util.List;

import org.hibernate.mapping.Map;

import service.ICourseService;
import util.PageBean;
import vo.Course;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CourseAction extends ActionSupport implements ModelDriven<Course> {

	private Course course = new Course();
	private PageBean pageBean;
	private int page = 1;
	private List<Course> courseList;
	private ICourseService courseService;

	/**
	 * ¿Î³ÌACTION
	 */
	private static final long serialVersionUID = 1L;

	public String findCoursePage() {
		this.pageBean = courseService.queryForPage(5, page);
		this.courseList = this.pageBean.getcList();
		return "findCourse_success";
	}

	public String addCourse() {
		this.courseService.addCourse(course);
		return "addCourse_success";
	}

	public String editCourse() {
		this.courseService.findCourseById(course.getCnum());
		return "editCourse_success";
	}

	public String updateCourse() {
		this.courseService.updateCourse(course);
		return "updateCourse_success";
	}

	public String deleteCourse() {
		this.courseService.deleteCourse(course);
		return "deleteCourse_success";
	}

	public Course getModel() {
		return course;
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

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public ICourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
	}

}
