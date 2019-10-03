package ru.vallball.calendar01.config;

import org.springframework.beans.factory.annotation.Autowired;

import ru.vallball.calendar01.model.DayList;
import ru.vallball.calendar01.model.User;
import ru.vallball.calendar01.service.UserService;

public class Test {
	@Autowired
	UserService userService;

	public static void main(String[] args) {
		//DayList dayList = new DayList();
		//System.out.println(dayList.createList());
		User user = new User();
		user.setUsername("bob");
	//	System.out.println("ƒни и недели в мес€це: "+dayList.listWeeks(dayList.getYear().atMonth(7).getMonth(),user));
		//System.out.println(" оличество недель в мес€це = " + dayList.getWeeks(dayList.getYear().atMonth(1)));
		//System.out.println("список мес€цев: "+dayList.listMonths());
		/*List<LocalTime> list = new ArrayList<>();
		for (int i=0;i<24;i++) {
			list.add(LocalTime.of(i, 0));
		}
		System.out.println(list);*/
		
	}
	

}

