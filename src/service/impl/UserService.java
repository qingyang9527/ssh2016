package service.impl;

import dao.IUserDAO;
import dao.impl.UserDAO;
import service.IUserService;
import vo.User;

public class UserService implements IUserService {
	private IUserDAO userDAO;

	public User validateUser(String username, String password) {
		return userDAO.validateUser(username, password);
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public boolean exitUser(String username) {
		return userDAO.exitUser(username);
	}

	public void saveUser(User user) {
		this.userDAO.saveUser(user);

	}

}
