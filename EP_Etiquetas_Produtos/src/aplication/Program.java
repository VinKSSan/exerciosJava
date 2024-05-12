package aplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entitis.ImportedProduct;
import entitis.Product;
import entitis.UsedProduct;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		List <Product> products = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i = 1; i<=n; i++) {
			System.out.println("Product #"+i+" data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if(ch=='i') {
				System.out.print("Customs fee:");
				double customFee = sc.nextDouble();
				Product product = new ImportedProduct(name, price, customFee);
				products.add(product);
			} else if(ch=='u'){
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(sc.next(), 
						DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				Product product = new UsedProduct(name, price , date);
				products.add(product);
			}else {
				Product product = new Product(name, price);
				products.add(product);
			}
		}
		
		System.out.println("PRICE TAGS");
		
		for(Product product : products) {
		    System.out.println(product.priceTag());
		}
		
		
		sc.close();
	}

}
