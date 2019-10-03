package ru.vallball.calendar01.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "events")
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	LocalDate date;
	
	@NotNull
	LocalTime time;
	
	@NotNull
	@Transient
	ZonedDateTime zone = ZonedDateTime.now();
	
	@NotNull
	String name;
	
	String description;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="users")
	User user;

	public Event() {
		}
	
	
	
	public Event(@NotNull LocalDate date, @NotNull LocalTime time, @NotNull String name,
			String description, @NotNull User user) {
		super();
		this.date = date;
		this.time = time;
		this.zone = ZonedDateTime.now();;
		this.name = name;
		this.description = description;
		this.user = user;
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return this.getTime().toString()+" "+name+" "+description;
	}

}