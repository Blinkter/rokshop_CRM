package pl.coderslab.model;

import java.sql.Date;

public class Order {

	private int id;
	private Date accepted;
	private Date planned_begin;
	private Date begin;
	private int order_employee_id;
	private String problem_description;
	private String repair_description;
	private String status;
	private int order_vehicle_id;
	private double repair_cost_for_customer;
	private double parts_cost;
	private double hours_amount;

	public Order() {
	}

	public Order(Date accepted, Date lanned_begin, Date begin, int order_employee_id, String problem_description,
			String repair_description, String status, int order_vehicle_id, double repair_cost_for_customer,
			double parts_cost, int hours_amount) {
		super();
		setAccepted(accepted);
		setPlanned_begin(planned_begin);
		setBegin(begin);
		setOrder_employee_id(order_employee_id);
		setProblem_description(problem_description);
		setRepair_description(repair_description);
		setStatus(status);
		setOrder_vehicle_id(order_vehicle_id);
		setRepair_cost_for_customer(repair_cost_for_customer);
		setParts_cost(parts_cost);
		setHours_amount(hours_amount);
	}

	public Date getAccepted() {
		return accepted;
	}

	public void setAccepted(Date accepted) {
		this.accepted = accepted;
	}

	public Date getPlanned_begin() {
		return planned_begin;
	}

	public void setPlanned_begin(Date planned_begin) {
		this.planned_begin = planned_begin;
	}

	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public int getOrder_employee_id() {
		return order_employee_id;
	}

	public void setOrder_employee_id(int order_employee_id) {
		this.order_employee_id = order_employee_id;
	}

	public String getProblem_description() {
		return problem_description;
	}

	public void setProblem_description(String problem_description) {
		this.problem_description = problem_description;
	}

	public String getRepair_description() {
		return repair_description;
	}

	public void setRepair_description(String repair_description) {
		this.repair_description = repair_description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getOrder_vehicle_id() {
		return order_vehicle_id;
	}

	public void setOrder_vehicle_id(int order_vehicle_id) {
		this.order_vehicle_id = order_vehicle_id;
	}

	public double getRepair_cost_for_customer() {
		return repair_cost_for_customer;
	}

	public void setRepair_cost_for_customer(double repair_cost_for_customer) {
		this.repair_cost_for_customer = repair_cost_for_customer;
	}

	public double getParts_cost() {
		return parts_cost;
	}

	public void setParts_cost(double parts_cost) {
		this.parts_cost = parts_cost;
	}

	public double getHours_amount() {
		return hours_amount;
	}

	public void setHours_amount(double hours_amount) {
		this.hours_amount = hours_amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", accepted=" + accepted + ", planned_begin=" + planned_begin + ", begin=" + begin
				+ ", order_employee_id=" + order_employee_id + ", problem_description=" + problem_description
				+ ", repair_description=" + repair_description + ", status=" + status + ", order_vehicle_id="
				+ order_vehicle_id + ", repair_cost_for_customer=" + repair_cost_for_customer + ", parts_cost="
				+ parts_cost + ", hours_amount=" + hours_amount + "]";
	}

}
