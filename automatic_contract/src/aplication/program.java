package aplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import etities.Contract;
import etities.Installment;
import services.ContractService;
import services.PaypalService;

public class program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		
		System.out.println("Entre os dados do contrato: ");
		System.out.println("Numero: ");
		int number = sc.nextInt();
		
		System.out.println("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt);
		
		System.out.println("Valor do contrato: ");
		double totalValue = sc.nextDouble();

		Contract contract = new Contract(number , date, totalValue );
		
		System.out.println("Entre com o numero de parcelas: ");
		int n = sc.nextInt();
		
		ContractService contractService = new ContractService(new PaypalService());
		
		contractService.processContract(contract, n);
		
		System.out.println("parcelas: ");
		
		for(Installment installment: contract.getInstalments()) {
			System.out.println(installment);
		}
		
		
		
		
		
		
		
		
		sc.close();
	}

}
