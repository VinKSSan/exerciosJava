package etities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {
	private LocalDate duDate;
	private Double amount;
	
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
	
	public Installment() {
	}

	public Installment(LocalDate duDate, Double amount) {
		super();
		this.duDate = duDate;
		this.amount = amount;
	}

	public LocalDate getDuDate() {
		return duDate;
	}

	public void setDuDate(LocalDate duDate) {
		this.duDate = duDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return duDate.format(fmt) + "-" + String.format(" %.2f ", amount);
	}
	
	
}
