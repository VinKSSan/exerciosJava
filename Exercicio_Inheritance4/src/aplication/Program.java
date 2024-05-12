package aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entitis.Employee;
import entitis.OutsourcedEmployee;

public class Program {
	public static void main(String[]args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> employers = new ArrayList<>();
		
		System.out.print("Enter the number of employees: ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n;i++) {
			System.out.println("Employee #"+i+" data:");
			System.out.print("Outsourced (y/n)?");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			
			if(ch == 'y') {// neste momento nós utilizamos o recurso de polimorfismo
				System.out.println("Additional charge: ");
				double additionalCharge = sc.nextDouble();
				Employee emp = new OutsourcedEmployee(name,hours, valuePerHour, additionalCharge);
				employers.add(emp);
			} else {
				Employee emp = new Employee(name,hours, valuePerHour);
				employers.add(emp);
			}
		}
		
		System.out.println("PAYMENTS: ");
		
		for(Employee emp : employers ) {
			System.out.println(emp.getName() + "- $" + String.format("%.2f", emp.payment()));
		}
		
		sc.close();
	}
}
