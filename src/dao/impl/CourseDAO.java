package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import vo.Course;
import dao.ICourseDAO;

public class CourseDAO extends HibernateDaoSupport implements ICourseDAO {

	public List<Course> queryForPage(String hql, int offset, int length) {
		Session session = this.getSession();
		Query q = session.createQuery(hql);
		q.setFirstResult(offset);
		q.setMaxResults(length);
		List<Course> list = q.list();
		System.out.println(list.size());
		session.close();
		return list;
	}

	public int getAllRowCount(String hql) {
		return this.getHibernateTemplate().find(hql).size();
	}

	public Course findCourseById(int cnum) {
		Course course = null;
		course = (Course) this.getHibernateTemplate().get(Course.class, cnum);
		return course;
	}

	public void addCourse(Course c) {
		this.getHibernateTemplate().save(c);

	}

	public void updateCourse(Course c) {
		this.getHibernateTemplate().update(c);

	}

	public void deleteCourse(Course c) {
		this.getHibernateTemplate().delete(c);

	}

}
