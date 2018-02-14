package pl.coderslab.model;

import java.sql.Date;

public class Customer {

	private int id;
	private String firstname;
	private String surname;
	private Date birthday;

	public Customer() {
	}

	public Customer(String firstname, String surname, Date birthday) {
		setFirstname(firstname);
		setSurname(surname);
		setBirthday(birthday);
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", surname=" + surname + ", birthday=" + birthday
				+ "]";
	}
}
