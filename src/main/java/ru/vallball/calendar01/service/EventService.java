package ru.vallball.calendar01.service;

import java.time.LocalDate;
import java.util.List;

import ru.vallball.calendar01.model.Event;
import ru.vallball.calendar01.model.User;

public interface EventService {
	void save(Event event);
	List<Event> list();
	void delete(Long id);
	void update(Event event);
	Event findById(Long id);
	List<Event> findByDateAndUser(LocalDate date, User user);
	List<Event> findByNameOrDesc(String str, User user);
	void createRepeatedItem(Event event,int[] povtor);
}
