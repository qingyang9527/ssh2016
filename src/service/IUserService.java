package service;

import vo.User;

public interface IUserService {
	public User validateUser(String username, String password);

	public boolean exitUser(String username);

	public void saveUser(User user);

}
