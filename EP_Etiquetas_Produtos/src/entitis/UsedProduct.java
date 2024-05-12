package entitis;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product{
	private LocalDate ManufactureDate;
	
	public UsedProduct() {
		super();
	}
	
	public UsedProduct(String name, Double price, LocalDate manufactureDate) {
		super(name, price);
		ManufactureDate = manufactureDate;
	}
	
	public LocalDate getManufactureDate() {
		return ManufactureDate;
	}

	public void setManufactureDate(LocalDate manufactureDate) {
		ManufactureDate = manufactureDate;
	}

	@Override
	public String priceTag() {
		return super.priceTag()
				+ "(used - "  
				+"(Manufacture date: " 
				+ ManufactureDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				+ ")";
	}
}
