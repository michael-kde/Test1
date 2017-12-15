package com.test1;

import java.util.Date;

/**
 * POJO
 *
 */
public class User {

	private String name;
	private String city;
	private String country;
	private Integer number;
	private Date date;
	

	/**
	 * @param name
	 * @param city
	 * @param country
	 * @param number
	 * @param date
	 */
	public User(String name, String city, String country, int number, Date date) {
		this.name = name;
		this.city = city;
		this.country = country;
		this.number = number;
		this.date = date;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}


	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}


	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}


	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}


	/**
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}


	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}


	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "User [name=" + name + ", city=" + city + ", country=" + country
				+ ", number=" + number + ", date=" + date + "]";
	}
}
