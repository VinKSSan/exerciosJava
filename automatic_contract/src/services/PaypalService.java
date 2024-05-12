package services;

public class PaypalService implements OlinePaymentService{

	@Override
	public Double paymentFee(Double amount) {
		return amount*0.02;
	}

	@Override
	public Double interest(Double amount, int months) {
		return amount*0.01*months;
	}
	
	
}
