package aplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entitis.Product;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc =  new Scanner(System.in);
		
		System.out.println("enter path: ");
		String path = sc.nextLine();
		
		List<Product> pList = new ArrayList<>();
		
		
		try( BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			while(line!= null) {
				String[] fields = line.split(",");
				pList.add(new Product(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();
			}
			double avg = pList.stream()
					.map(p->p.getPrice())
					.reduce(0.0,(x,y)->x+y/pList.size());
			System.out.println("Average price:"+String.format("%.2f", avg));
			
			Comparator<String> comp = (s1,s2)->s1.toUpperCase().compareTo(s2.toUpperCase()); 
			
			List<String> namesP = pList.stream()
					.filter(p->p.getPrice()<avg)
					.map(p->p.getName())
					.sorted(comp.reversed())
					.collect(Collectors.toList());
			
			namesP.forEach(System.out::println);
			
			
					
			
		}catch( IOException e) {
			System.out.println("Error: "+e);
		}
		
		sc.close();

	}

}
