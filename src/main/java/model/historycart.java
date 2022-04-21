package model;

import java.util.Date;

public class historycart {
	
	private int id;
	private int total;
	private String name;
	private Date day;
public historycart(int id, int total, String name,java.sql.Date sqlDate) {
		this.id=id;
		this.total=total;
		this.name=name;
		this.day=new java.util.Date(sqlDate.getTime());
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}

}
