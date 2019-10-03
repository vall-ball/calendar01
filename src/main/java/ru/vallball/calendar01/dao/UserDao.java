package ru.vallball.calendar01.dao;

import java.util.List;

import ru.vallball.calendar01.model.User;


public interface UserDao {
	 void save(User user);
	 List<User> list();
	 void delete(String username);
	 void update(User user);
	 User findUserByUsername(String username);
}

