package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import vo.Student;
import vo.User;

import dao.BaseDAO;
import dao.IStudentDAO;

public class StudentDAO extends HibernateDaoSupport implements IStudentDAO {

	// 查询所有学生信息
	@SuppressWarnings("unchecked")
	/*
	 * public List<Student> findAllStudent() { Transaction ts = null;
	 * List<Student> list = null; String hql = ""; try { hql = "from Student";
	 * Session session = getSession(); ts = session.beginTransaction(); Query
	 * query = session.createQuery(hql); list = query.list(); ts.commit();
	 * return list; } catch (Exception e) { e.printStackTrace(); return list; }
	 * finally { if (ts != null) { ts = null; } }
	 * 
	 * }
	 */
	// 根据学生ID查询学生
	public Student findStudentById(int sid) {
		Student student = null;
		student = (Student) this.getHibernateTemplate().get(Student.class, sid);
		return student;
	}

	public Student findStudentByStudentId(String studentId) {
		String sql = "from Student s where s.studentId=?";
		Session session = getSession();
		Query q = session.createQuery(sql);
		q.setParameter(0, studentId);
		List<Student> stuList = q.list();
		if (stuList.size() > 0) {
			Student student = stuList.get(0);
			return student;
		} else {
			return null;
		}

	}

	// 添加学生
	public void addStudent(Student s) {
		this.getHibernateTemplate().save(s);
	}

	// 更新学生信息
	public void updateStudent(Student s) {
		this.getHibernateTemplate().update(s);
	}

	// 删除学生信息
	public void deleteStudent(Student s) {
		this.getHibernateTemplate().delete(s);
	}

	// 分页查询学生
	public List<Student> queryForPage(String hql, int offset, int length) {
		Session session = this.getSession();
		Query q = session.createQuery(hql);
		q.setFirstResult(offset);
		q.setMaxResults(length);
		List<Student> list = q.list();
		System.out.println(list.size());
		session.close();
		return list;
	}

	// 获取分页查询总的记录数
	public int getAllRowCount(String hql) {
		return this.getHibernateTemplate().find(hql).size();
	}

	public Student validateStu(String studentId, String spwd) {
		Session session = getSession();
		String hql = "from Student s where s.studentId=? and s.spwd=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, studentId);
		query.setParameter(1, spwd);
		List stuList = query.list();
		if (stuList.size() > 0) {
			Student student = (Student) stuList.get(0);
			return student;
		}
		session.close();
		return null;
	}
}
