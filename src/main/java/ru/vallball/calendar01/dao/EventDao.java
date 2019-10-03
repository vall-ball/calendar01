package ru.vallball.calendar01.dao;

import java.time.LocalDate;
import java.util.List;

import ru.vallball.calendar01.model.Event;


public interface EventDao {
	void save(Event event);
	List<Event> list();
	void delete(Long id);
	void update(Event event);
	Event findById(Long id);
		
}
