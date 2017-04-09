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
		final String hql = "from Course c order by c.cnum"; // ��ѯ���
		int allRow = courseDAO.getAllRowCount(hql); // �ܼ�¼��
		int totalPage = PageBean.countTatalPage(pageSize, allRow); // ��ҳ��
		final int offset = PageBean.countOffset(pageSize, page); // ��ǰҳ��ʼ��¼
		final int length = pageSize; // ÿҳ��¼��
		final int currentPage = PageBean.countCurrentPage(page); // ��ǰҳ
		List list = courseDAO.queryForPage(hql, offset, length); //
		// �ѷ�ҳ��Ϣ���浽Bean����
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
