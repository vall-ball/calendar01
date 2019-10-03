package ru.vallball.calendar01.model;

import java.time.LocalDate;
import java.util.List;

public class Week {
	private List<Event> mon;
	private List<Event> tue;
	private List<Event> wed;
	private List<Event> thu;
	private List<Event> fri;
	private List<Event> sat;
	private List<Event> sun;
	private LocalDate monDate;
	private LocalDate tueDate;
	private LocalDate wedDate;
	private LocalDate thuDate;
	private LocalDate friDate;
	private LocalDate satDate;
	private LocalDate sunDate;
	
	
	
	public LocalDate getMonDate() {
		return monDate;
	}
	public void setMonDate(LocalDate monDate) {
		this.monDate = monDate;
	}
	public LocalDate getTueDate() {
		return tueDate;
	}
	public void setTueDate(LocalDate tueDate) {
		this.tueDate = tueDate;
	}
	public LocalDate getWedDate() {
		return wedDate;
	}
	public void setWedDate(LocalDate wedDate) {
		this.wedDate = wedDate;
	}
	public LocalDate getThuDate() {
		return thuDate;
	}
	public void setThuDate(LocalDate thuDate) {
		this.thuDate = thuDate;
	}
	public LocalDate getFriDate() {
		return friDate;
	}
	public void setFriDate(LocalDate friDate) {
		this.friDate = friDate;
	}
	public LocalDate getSatDate() {
		return satDate;
	}
	public void setSatDate(LocalDate satDate) {
		this.satDate = satDate;
	}
	public LocalDate getSunDate() {
		return sunDate;
	}
	public void setSunDate(LocalDate sunDate) {
		this.sunDate = sunDate;
	}
	public List<Event> getMon() {
		return mon;
	}
	public void setMon(List<Event> mon) {
		this.mon = mon;
	}
	public List<Event> getTue() {
		return tue;
	}
	public void setTue(List<Event> tue) {
		this.tue = tue;
	}
	public List<Event> getWed() {
		return wed;
	}
	public void setWed(List<Event> wed) {
		this.wed = wed;
	}
	public List<Event> getThu() {
		return thu;
	}
	public void setThu(List<Event> thu) {
		this.thu = thu;
	}
	public List<Event> getFri() {
		return fri;
	}
	public void setFri(List<Event> fri) {
		this.fri = fri;
	}
	public List<Event> getSat() {
		return sat;
	}
	public void setSat(List<Event> sat) {
		this.sat = sat;
	}
	public List<Event> getSun() {
		return sun;
	}
	public void setSun(List<Event> sun) {
		this.sun = sun;
	}
	
	@Override
	public String toString() {
		String d1;
		if (this.getMonDate() != null) d1 = this.getMonDate().toString();
		else d1 = "";
		String d2;
		if (this.getTueDate() != null) d2 = this.getTueDate().toString();
		else d2 = "";
		String d3;
		if (this.getWedDate() != null) d3 = this.getWedDate().toString();
		else d3 = "";
		String d4;
		if (this.getThuDate() != null) d4 = this.getThuDate().toString();
		else d4 = "";
		String d5;
		if (this.getFriDate() != null) d5 = this.getFriDate().toString();
		else d5 = "";
		String d6;
		if (this.getSatDate() != null) d6 = this.getSatDate().toString();
		else d6 = "";
		String d7;
		if (this.getSunDate() != null) d7 = this.getSunDate().toString();
		else d7 = "";
		return d1+d2+d3+d4+d5+d6+d7;
		
	}
}

