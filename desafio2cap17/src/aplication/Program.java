package aplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import entitis.Sale;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc =  new Scanner(System.in);
		
		System.out.print("enter path to read file: ");
		String path = sc.nextLine();
		
		List<Sale> sList = new ArrayList<>();
		
		try( BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			
			while(line!=null) {
				String[] linev = line.split(",");
				sList.add(new Sale(Integer.parseInt(linev[0]),Integer.parseInt(linev[1]), linev[2],Integer.parseInt(linev[3]), Double.parseDouble(linev[4])));
				line = br.readLine();
			}
			Set<String> setsal = new TreeSet<>();
			for(Sale sale : sList) {
				setsal.add(sale.getSaller());
			}
			
			System.out.println("Total de vendas por vendedor:");
			for(String saller:setsal) {
				System.out.println(
					saller
					+" - R$ "
					+String.format("%.2f", 
						sList.stream()
							.filter(ss->ss.getSaller().equals(saller))
							.mapToDouble(s->s.getTotal())
							.sum()
						)
				);
			}
			
		}catch( IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
		
		
		sc.close();
	}

}
