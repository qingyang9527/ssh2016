package dao;

import vo.User;

public interface IUserDAO {

	public User validateUser(String username, String password);

	public boolean exitUser(String username);

	public void saveUser(User user);

}
