package services;

import java.time.LocalDate;

import etities.Contract;
import etities.Installment;

public class ContractService {
	
	private OlinePaymentService olinePaymentService;
	
	
	
	public ContractService(OlinePaymentService olinePaymentService) {
		this.olinePaymentService = olinePaymentService;
	}



	public void processContract(Contract contract, Integer months) {
		double basicQuota = contract.getTotalValue()/months;
		 
		for(int i=1;i<=months;i++) {
			LocalDate duDate = contract.getDate().plusMonths(i);
			double interest = olinePaymentService.interest(basicQuota, i);
			double fee =  olinePaymentService.paymentFee(basicQuota + interest);
			double tdQuot = basicQuota+fee+interest;
			
			contract.getInstalments().add(new Installment(duDate, tdQuot));
			
			
		}
	}
}	
