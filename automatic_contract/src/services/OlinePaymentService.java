package services;

public interface OlinePaymentService {
	
	Double paymentFee(Double amount);
	Double interest(Double amount, int months);
}
