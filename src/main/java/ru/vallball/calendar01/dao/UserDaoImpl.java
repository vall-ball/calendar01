package ru.vallball.calendar01.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.vallball.calendar01.model.User;


@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(User user) {
		sessionFactory.getCurrentSession().save(user);
		
	}

	@Override
	public List<User> list() {
		TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User user order by user.role");
	    return query.getResultList();
	}

	@Override
	public void delete(String username) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, username); 
		session.delete(user);
		
	}

	@Override
	public void update(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
		
	}

	@Override
	public User findUserByUsername(String username) {
		return sessionFactory.getCurrentSession().get(User.class, username);
	}

}

