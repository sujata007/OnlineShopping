package src.com.java.splitwise.service;

import src.com.java.splitwise.model.User;

public interface UserService {

	public void addUser(User user);

	public User getUser(String userName);
}
