package ru.vallball.calendar01.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.vallball.calendar01.model.DayList;
import ru.vallball.calendar01.model.Event;
import ru.vallball.calendar01.model.User;
import ru.vallball.calendar01.model.Week;
import ru.vallball.calendar01.service.EventService;
import ru.vallball.calendar01.service.UserService;




@Controller
@RequestMapping(value = { "/"})
public class HomeController {
	
	@Autowired
	EventService eventService;
	
	@Autowired
	UserService userService;
	
	@ModelAttribute("dayList")
	public DayList dayList() {
		return new DayList(eventService,userService);
	}

	@ModelAttribute("user")
	public User getUser(HttpServletRequest request) {
		return userService.userByName(request.getRemoteUser());
	}
	
	@ModelAttribute("event")
	public Event event() {
		return new Event();
	}
	
	@ModelAttribute("listTime")
	public List<LocalTime> listTime() {
		List<LocalTime> list = new ArrayList<>();
		for (int i=0;i<24;i++) {
			list.add(LocalTime.of(i, 0));
		}
		return list;
		
	}
	
	@GetMapping("/")
	public String index(HttpServletRequest request) {
		return "index";
	}
	
	@GetMapping("/addEvent/{id}")
	public String addEvent(@PathVariable("id") String date, HttpServletRequest req) {
		LocalDate d = LocalDate.parse(date);
		req.getSession().setAttribute("date", d);
		return "addEvent";
	}
	
	@PostMapping("/addEvent")
    public String create(@ModelAttribute("event") Event event,HttpServletRequest req,@RequestParam("time") String time,
    		@RequestParam(required=false,name="a") int[] povtors){
		event.setUser(userService.userByName(req.getRemoteUser()));
		event.setDate((LocalDate)req.getSession().getAttribute("date"));
		LocalTime t = LocalTime.parse(time);
		event.setTime(t);
		eventService.save(event);
		if (povtors != null) eventService.createRepeatedItem(event, povtors);
		return "redirect:/";
    }
	
	@GetMapping("/delete/{id}")
	public String deleteEvent(@PathVariable("id") Long id) {
		eventService.delete(id);
		return "redirect:/";
	}
	
	@GetMapping("/update/{id}")
	public String updateForm(@PathVariable("id") Long id, HttpServletRequest request, ModelMap model) {
		Event event = eventService.findById(id);
		request.getSession().setAttribute("eventForChange", event); 
		model.addAttribute("eventForChange", event);
		return "updateEvent";
	}
	
	@PostMapping("/updateEvent")
	public String update(@RequestParam("name") String name,@RequestParam("description") String description,
			@RequestParam("time") String time, HttpServletRequest request) {
		Event event = (Event)request.getSession().getAttribute("eventForChange"); 
		event.setName(name);
		event.setDescription(description);
		LocalTime t = LocalTime.parse(time);
		event.setTime(t);
		eventService.update(event);
		return "redirect:/";
	}
	
	@GetMapping("/search")
	public String search() {
		return "search";
	}
	
	@PostMapping("/search")
	public String searchEvent(@RequestParam("str") String str,ModelMap model,HttpServletRequest request) {
		List<Event> events = eventService.findByNameOrDesc(str, userService.userByName(request.getRemoteUser()));
		model.addAttribute("events", events);
		model.addAttribute("key", str);
		//request.getSession().setAttribute("events", events);
		//request.getSession().setAttribute("key", str);
		return "searchResult";
	}
	
}
