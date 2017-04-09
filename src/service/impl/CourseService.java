package service.impl;

import java.util.List;

import dao.ICourseDAO;
import dao.impl.CourseDAO;

import service.ICourseService;
import util.PageBean;
import vo.Course;

public class CourseService implements ICourseService {
	private ICourseDAO courseDAO;

	public PageBean queryForPage(int pageSize, int page) {
		final String hql = "from Course c order by c.cnum"; // 查询语句
		int allRow = courseDAO.getAllRowCount(hql); // 总记录数
		int totalPage = PageBean.countTatalPage(pageSize, allRow); // 总页数
		final int offset = PageBean.countOffset(pageSize, page); // 当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = PageBean.countCurrentPage(page); // 当前页
		List list = courseDAO.queryForPage(hql, offset, length); //
		// 把分页信息保存到Bean当中
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setcList(list);
		pageBean.init();
		return pageBean;

	}

	public Course findCourseById(int cnum) {
		return courseDAO.findCourseById(cnum);
	}

	public void addCourse(Course c) {
		this.courseDAO.addCourse(c);

	}

	public void updateCourse(Course c) {
		this.courseDAO.updateCourse(c);

	}

	public void deleteCourse(Course c) {
		this.courseDAO.deleteCourse(c);

	}

	public ICourseDAO getCourseDAO() {
		return courseDAO;
	}

	public void setCourseDAO(ICourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

}
