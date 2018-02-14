package pl.coderslab.model;

public class Empolyee {

	private int id;
	private String first_name;
	private String surname;
	private String address;
	private int phone_number;
	private String note;
	private Double hour_rate;

	public Empolyee(String first_name, String surname, String address, int phone_number, String note,
			Double hour_rate) {
		setFirst_name(first_name);
		setSurname(surname);
		setAddress(address);
		setPhone_number(phone_number);
		setNote(note);
		setHour_rate(hour_rate);
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
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

	@Override
	public String toString() {
		return "Empolyee [id=" + id + ", first_name=" + first_name + ", surname=" + surname + ", address=" + address
				+ ", phone_number=" + phone_number + ", note=" + note + ", hour_rate=" + hour_rate + "]";
	}

}
