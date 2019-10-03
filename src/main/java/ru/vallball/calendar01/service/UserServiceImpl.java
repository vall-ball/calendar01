package ru.vallball.calendar01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vallball.calendar01.dao.UserDao;
import ru.vallball.calendar01.model.User;


@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findUserByUsername(username);
		if (user != null) return user;
		throw new UsernameNotFoundException("Пользователь " + username + " не найден");
	}

	@Override
	public void save(User user) {
		userDao.save(user);
		
	}

	@Override
	public List<User> list() {
		return userDao.list();
	}

	@Override
	public void delete(String username) {
		userDao.delete(username);
		
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		
	}

	@Override
	public User userByName(String name) {
		return userDao.findUserByUsername(name);
	}

}

