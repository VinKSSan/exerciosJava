package entitis;

public class Employee {
	private String name;
	private Integer hours;
	private  Double valuePeerHour;
	
	public Employee() {	
	}

	public Employee(String name, Integer hours, Double valuePeerHour) {
		super();
		this.name = name;
		this.hours = hours;
		this.valuePeerHour = valuePeerHour;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public Double getValuePeerHour() {
		return valuePeerHour;
	}

	public void setValuePeerHour(Double valuePeerHour) {
		this.valuePeerHour = valuePeerHour;
	}
	
	public Double payment() {
		return hours*valuePeerHour;
	}
	
	
	
}
