package entitis;

public class OutsourcedEmployee extends Employee {//aqui estamos utilizando a herança
	private Double additionalCharge;

	public OutsourcedEmployee() {
		super();
	}
	public OutsourcedEmployee(String name, Integer hours, Double valuePeerHour, Double additionalCharge) {
		super(name, hours, valuePeerHour);
		this.additionalCharge = additionalCharge;
	}
	public Double getAdditionalCharge() {
		return additionalCharge;
	}
	public void setAdditionalCharge(Double additionalCharge) {
		this.additionalCharge = additionalCharge;
	}
	
	@Override
	public Double payment() {
		return super.payment() + additionalCharge*1.1;
	}
	
	
}
