package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.ITeacherDAO;

import vo.Student;
import vo.Teacher;
import vo.User;

public class TeacherDAO extends HibernateDaoSupport implements ITeacherDAO {

	/**
	 * sql语句查询并获得所有老师记录的记录数
	 */
	public int getAllRowCount(String hql) {
		return this.getHibernateTemplate().find(hql).size();
	}

	/**
	 * 通过Id查询老师
	 * 
	 * @param tid
	 * @return
	 */
	public Teacher findTeacherById(String tid) {
		Teacher teacher = null;
		teacher = (Teacher) this.getHibernateTemplate().get(Teacher.class, tid);
		return teacher;
	}

	/**
	 * 分页查询所有的老师
	 * 
	 * @param hql
	 * @param offset
	 * @param length
	 * @return
	 */
	public List<Teacher> queryForPage(String hql, int offset, int length) {
		Session session = this.getSession();
		Query q = session.createQuery(hql);
		q.setFirstResult(offset);
		q.setMaxResults(length);
		List<Teacher> tlist = q.list();
		System.out.println(tlist.size());
		session.close();
		return tlist;
	}

	/**
	 * 增加老师的dao方法
	 */
	public void addTeacher(Teacher t) {
		this.getHibernateTemplate().save(t);
	}

	/**
	 * 更新老师信息的dao方法
	 */
	public void updateTeacher(Teacher t) {
		this.getHibernateTemplate().update(t);
	}

	/**
	 * 删除老师信息的dao方法
	 */
	public void deleteTeacher(Teacher t) {
		this.getHibernateTemplate().delete(t);
	}

	public Teacher validateUser(String username, String password) {
		String hql = "from Teacher t where t.tid=? and t.tpwd=?";
		Session session = getSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, username);
		query.setParameter(1, password);
		List userList = query.list();
		if (userList.size() != 0) {
			Teacher teacher = (Teacher) userList.get(0);
			return teacher;
		}
		session.close();
		return null;
	}

}
