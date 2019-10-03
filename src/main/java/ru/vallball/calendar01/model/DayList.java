package ru.vallball.calendar01.model;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Singleton;

import ru.vallball.calendar01.service.EventService;
import ru.vallball.calendar01.service.UserService;

@Singleton
public class DayList {
	
	EventService eventService;
	UserService userService;
	
	private Year year;
	
	public DayList(EventService eventService, UserService userService) {
		this.eventService = eventService;
		this.userService = userService;
		this.year = Year.now();
	}
	
	/*public DayList(){ 
		this.year = Year.now();
		}*/

public Year getYear() {
	return year;
}

//ѕолучить мес€ц по номеру
	public Month getMonthName(int i) {
		return year.atMonth(i).getMonth();
	}

//список мес€цев
	public List<Month> listMonths() {
		List<Month> list = new ArrayList<>();
		for (int i=1;i<=12;i++) {
			list.add(this.getMonthName(i));
		}
		return list;
	}

//	ѕолучить количество недель в мес€це
	public int getWeeks(YearMonth yearMonth) {
		int daysOfMonths = yearMonth.lengthOfMonth();
		int day = yearMonth.atDay(1).getDayOfWeek().getValue()-1;
		if (((double)(day+daysOfMonths)/7) == 4) return 4;
		else if ((day+daysOfMonths)/7 < 5) return 5;
		else return 6;			
	}
	
	//ѕолучить список всех дней в мес€це
			public List<LocalDate> createList(YearMonth yearMonth) {
				List<LocalDate> list = new ArrayList<>();
				for (int i = 1; i <= yearMonth.lengthOfMonth(); i++) {
						list.add(yearMonth.atDay(i));
					}
				return list;
			}
			
	//ѕолучить все событи€ в мес€це
	public List<Event> listEvents(List<LocalDate> list) {
		List<Event> listEvents = new ArrayList<>();
		
		return listEvents;
	}
	
	public List<Week> listWeeks(Month month,User user){
		YearMonth yearMonth= this.year.atMonth(month.getValue());
		List<Week> listWeek = new ArrayList<>();
		int weeks = getWeeks(yearMonth); //количество недель в мес€це
		int beg = yearMonth.atDay(1).getDayOfWeek().getValue(); //номер дн€ в неделе, с которого начинаетс€ мес€ц
		List<LocalDate> list = createList(yearMonth); //список всех дней в мес€це
		Week firstWeek = new Week();
		Iterator<LocalDate> iterator = list.iterator();
		LocalDate date;
		switch (beg) {
		case 1:	firstWeek.setMon(eventService.findByDateAndUser(date = iterator.next(),user));
				firstWeek.setMonDate(date);
				iterator.remove();
		case 2:	firstWeek.setTue(eventService.findByDateAndUser(date = iterator.next(),user));
				firstWeek.setTueDate(date);
				iterator.remove();
		case 3:	firstWeek.setWed(eventService.findByDateAndUser(date = iterator.next(),user));
				firstWeek.setWedDate(date);
				iterator.remove();
		case 4:	firstWeek.setThu(eventService.findByDateAndUser(date =iterator.next(),user));
				firstWeek.setThuDate(date);
				iterator.remove();
		case 5:	firstWeek.setFri(eventService.findByDateAndUser(date =iterator.next(),user));
				firstWeek.setFriDate(date);
				iterator.remove();
		case 6:	firstWeek.setSat(eventService.findByDateAndUser(date =iterator.next(),user));
				firstWeek.setSatDate(date);
				iterator.remove();
		case 7:	firstWeek.setSun(eventService.findByDateAndUser(date =iterator.next(),user));
				firstWeek.setSunDate(date);
				iterator.remove();
			}
		listWeek.add(firstWeek);
		
		for (int i=2;i<weeks;i++) {
			Week week = new Week();
				week.setMon(eventService.findByDateAndUser(date =iterator.next(), user));
				week.setMonDate(date);
				iterator.remove();
				week.setTue(eventService.findByDateAndUser(date =iterator.next(), user));
				week.setTueDate(date);
				iterator.remove();
				week.setWed(eventService.findByDateAndUser(date =iterator.next(), user));
				week.setWedDate(date);
				iterator.remove();
				week.setThu(eventService.findByDateAndUser(date =iterator.next(), user));
				week.setThuDate(date);
				iterator.remove();
				week.setFri(eventService.findByDateAndUser(date =iterator.next(), user));
				week.setFriDate(date);
				iterator.remove();
				week.setSat(eventService.findByDateAndUser(date =iterator.next(), user));
				week.setSatDate(date);
				iterator.remove();
				week.setSun(eventService.findByDateAndUser(date =iterator.next(), user));
				week.setSunDate(date);
				iterator.remove();		
				listWeek.add(week);
		}
		
		int size = list.size();
		Week lastWeek = new Week();
		
		switch (size) {
		case 7:	lastWeek.setMon(eventService.findByDateAndUser(date =iterator.next(), user));
				lastWeek.setMonDate(date);	
				iterator.remove();
				lastWeek.setTue(eventService.findByDateAndUser(date =iterator.next(), user));
				lastWeek.setTueDate(date);
				iterator.remove();
				lastWeek.setWed(eventService.findByDateAndUser(date =iterator.next(), user));
				lastWeek.setWedDate(date);
				iterator.remove();
				lastWeek.setThu(eventService.findByDateAndUser(date =iterator.next(), user));
				lastWeek.setThuDate(date);
				iterator.remove();
				lastWeek.setFri(eventService.findByDateAndUser(date =iterator.next(), user));
				lastWeek.setFriDate(date);
				iterator.remove();
				lastWeek.setSat(eventService.findByDateAndUser(date =iterator.next(), user));
				lastWeek.setSatDate(date);
				iterator.remove();
				lastWeek.setSun(eventService.findByDateAndUser(date =iterator.next(), user));
				lastWeek.setSunDate(date);
				iterator.remove();
				break;
		
		case 6:	lastWeek.setMon(eventService.findByDateAndUser(date =iterator.next(), user));
		lastWeek.setMonDate(date);
		iterator.remove();
		lastWeek.setTue(eventService.findByDateAndUser(date =iterator.next(), user));
		lastWeek.setTueDate(date);
		iterator.remove();
		lastWeek.setWed(eventService.findByDateAndUser(date =iterator.next(), user));
		lastWeek.setWedDate(date);
		iterator.remove();
		lastWeek.setThu(eventService.findByDateAndUser(date =iterator.next(), user));
		lastWeek.setThuDate(date);
		iterator.remove();
		lastWeek.setFri(eventService.findByDateAndUser(date =iterator.next(), user));
		lastWeek.setFriDate(date);
		iterator.remove();
		lastWeek.setSat(eventService.findByDateAndUser(date =iterator.next(), user));
		lastWeek.setSatDate(date);
		iterator.remove();
			break;
		
		case 5:	lastWeek.setMon(eventService.findByDateAndUser(date =iterator.next(), user));
		lastWeek.setMonDate(date);
		iterator.remove();
		lastWeek.setTue(eventService.findByDateAndUser(date =iterator.next(), user));
		lastWeek.setTueDate(date);
		iterator.remove();
		lastWeek.setWed(eventService.findByDateAndUser(date =iterator.next(), user));
		lastWeek.setWedDate(date);
		iterator.remove();
		lastWeek.setThu(eventService.findByDateAndUser(date =iterator.next(), user));
		lastWeek.setThuDate(date);
		iterator.remove();
		lastWeek.setFri(eventService.findByDateAndUser(date =iterator.next(), user));
		lastWeek.setFriDate(date);
		iterator.remove();
		break;
		
		case 4:	lastWeek.setMon(eventService.findByDateAndUser(date =iterator.next(), user));
		lastWeek.setMonDate(date);
		iterator.remove();
		lastWeek.setTue(eventService.findByDateAndUser(date =iterator.next(), user));
		lastWeek.setTueDate(date);
		iterator.remove();
		lastWeek.setWed(eventService.findByDateAndUser(date =iterator.next(), user));
		lastWeek.setWedDate(date);
		iterator.remove();
		lastWeek.setThu(eventService.findByDateAndUser(date =iterator.next(), user));
		lastWeek.setThuDate(date);
		iterator.remove();
		break;
		
		case 3:	lastWeek.setMon(eventService.findByDateAndUser(date =iterator.next(), user));
		lastWeek.setMonDate(date);
		iterator.remove();
		lastWeek.setTue(eventService.findByDateAndUser(date =iterator.next(), user));
		lastWeek.setTueDate(date);
		iterator.remove();
		lastWeek.setWed(eventService.findByDateAndUser(date =iterator.next(), user));
		lastWeek.setWedDate(date);
		iterator.remove();
		break;
		
		case 2:	lastWeek.setMon(eventService.findByDateAndUser(date =iterator.next(), user));
		lastWeek.setMonDate(date);
		iterator.remove();
		lastWeek.setTue(eventService.findByDateAndUser(date =iterator.next(), user));
		lastWeek.setTueDate(date);
		iterator.remove();
		break;
		
		case 1:	lastWeek.setMon(eventService.findByDateAndUser(date =iterator.next(), user));
		lastWeek.setMonDate(date);
		iterator.remove();
		break;
				}
		listWeek.add(lastWeek);
		/*for (Week week : listWeek) {
			System.out.println(week);
		}*/
		return listWeek;

	}
	
	//создание повтор€ющихс€ событий
	public void createRepeatedItem(Event event) {
		
	}
	
}
