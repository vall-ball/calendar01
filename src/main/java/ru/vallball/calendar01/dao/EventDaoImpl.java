package ru.vallball.calendar01.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.vallball.calendar01.model.Event;

@Repository
public class EventDaoImpl implements EventDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Event event) {
		sessionFactory.getCurrentSession().saveOrUpdate(event);
		
	}

	@Override
	public List<Event> list() {
		TypedQuery<Event> query = sessionFactory.getCurrentSession().createQuery("from Event event");
	    return query.getResultList();
	}

	@Override
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Event event = (Event) session.get(Event.class, id); 
		session.delete(event);
		
	}

	@Override
	public void update(Event event) {
		sessionFactory.getCurrentSession().update(event);
		
	}

	@Override
	public Event findById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Event event = (Event) session.get(Event.class, id);
		return event;
	}


}

