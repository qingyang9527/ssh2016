package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import vo.User;
import dao.BaseDAO;
import dao.IUserDAO;

public class UserDAO extends BaseDAO implements IUserDAO {

	public User validateUser(String username, String password) {
		String hql = "from User u where u.username=? and u.password=?";
		Session session = getSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, username);
		query.setParameter(1, password);
		List userList = query.list();
		if (userList.size() != 0) {
			User user = (User) userList.get(0);
			return user;
		}
		session.close();
		return null;
	}

	public boolean exitUser(String username) {
		Session session = getSession();
		String sql = "from User u where u.username=?";
		Query query = session.createQuery(sql);
		query.setParameter(0, username);
		List users = query.list();
		if (users.size() != 0) {
			User userlist = (User) users.get(0);
			return true;
		}
		session.close();
		return false;
	}

	public void saveUser(User user) {
		Session session = getSession();
		Transaction ts = session.beginTransaction();
		session.save(user);
		ts.commit();
		session.close();
	}
	


}
