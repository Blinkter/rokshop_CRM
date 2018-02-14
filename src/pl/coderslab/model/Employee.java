package pl.coderslab.model;

public class Employee {

	private int id;
	private String firstname;
	private String surname;
	private String address;
	private int phone_number;
	private String note;
	private Double hour_rate;

	public Employee(String firstname, String surname, String address, int phone_number, String note, Double hour_rate) {
		setFirst_name(firstname);
		setSurname(surname);
		setAddress(address);
		setPhone_number(phone_number);
		setNote(note);
		setHour_rate(hour_rate);
	}

	public Employee() {
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirst_name(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Double getHour_rate() {
		return hour_rate;
	}

	public void setHour_rate(Double hour_rate) {
		this.hour_rate = hour_rate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;

	}

	@Override
	public String toString() {
		return "Empolyee [id=" + id + ", first_name=" + firstname + ", surname=" + surname + ", address=" + address
				+ ", phone_number=" + phone_number + ", note=" + note + ", hour_rate=" + hour_rate + "]";
	}

}
