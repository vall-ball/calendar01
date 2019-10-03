package ru.vallball.calendar01.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vallball.calendar01.dao.EventDao;
import ru.vallball.calendar01.model.Event;
import ru.vallball.calendar01.model.User;

@Service
@Transactional
public class EventServiceImpl implements EventService{
	
	@Autowired
	EventDao eventDao;
	
	
	@Override
	public void save(Event event) {
		eventDao.save(event);
		
	}

	@Override
	public List<Event> list() {
		return eventDao.list();
	}

	@Override
	public void delete(Long id) {
		eventDao.delete(id);
		
	}

	@Override
	public void update(Event event) {
		eventDao.save(event);
		
	}

	@Override
	public Event findById(Long id) {
		return eventDao.findById(id);
	}

	@Override
	public List<Event> findByDateAndUser(LocalDate date, User user) {
		List<Event> list = eventDao.list();
		List<Event> listByEvent = new ArrayList<>();
		boolean control = false;
		for (Event e : list) {
			if (e.getDate().equals(date) && e.getUser().getUsername().equals(user.getUsername())) { listByEvent.add(e);
			control = true;
			}
		}
		if (!control) {
			return new ArrayList<Event>();
			
		}
		return listByEvent;
	}

	@Override
	public List<Event> findByNameOrDesc(String str, User user) {
		List<Event> list = eventDao.list();
		List<Event> listByStr = new ArrayList<>();
		for (Event e : list) {
			if ((e.getName().toLowerCase().contains(str.toLowerCase()) ||
				e.getDescription().toLowerCase().contains(str.toLowerCase()))
				&& e.getUser().getUsername().equals(user.getUsername()))
			{
				listByStr.add(e);
			}
			}
		return listByStr;
	}

	@Override
	public void createRepeatedItem(Event event, int[] povtor) {
		for (int i : povtor) {
			if (i == 1) {
				int t = event.getDate().getMonthValue();
				while (t <= 12) {
					LocalDate date = event.getDate().plusMonths(t);
					Event e = new Event(date,event.getTime(),event.getName(),event.getDescription(),event.getUser());
					save(e);
					t++;
					
				}
			}
		}
		
	}
	
	
	

}

