package aplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import entitis.LogEntry;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter file full path:");
		String path = sc.next();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path)) ) {
				
			Set <LogEntry> logs =  new HashSet<>(); 
			String lineLog =  br.readLine();
			while(lineLog != null) {
				String[] fields = lineLog.split(" ");
				String userName = fields[0];
				Date moment = Date.from(Instant.parse(fields[1]));
				
				logs.add(new LogEntry(userName, moment));
				lineLog = br.readLine(); 
			}
			System.out.println("Total users: "+logs.size());
		}
		catch(IOException e){
			System.out.print("Error: "+ e);
		}
		
		sc.close();

	}

}
