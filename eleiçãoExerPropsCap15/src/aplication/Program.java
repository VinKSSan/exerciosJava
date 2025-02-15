package aplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> votePerCandidate= new HashMap<>();
		
		System.out.println("input to file path: ");
		String path =sc.next();
		sc.close();
		try( BufferedReader br = new BufferedReader(new FileReader(path)) ){
			String line = br.readLine();
			while(line!=null) {
				String[] candidates = line.split(",");
				String candName = candidates[0];
				Integer votes = Integer.parseInt(candidates[1]);
				if(votePerCandidate.containsKey(candName)){
					Integer votSum = votes+ votePerCandidate.get(candName);
					votePerCandidate.put(candName, votSum);
				}else {
					votePerCandidate.put(candName, votes);
				}
				line = br.readLine();
			}
			for(String candName: votePerCandidate.keySet()){
				System.out.println(candName+" , "+votePerCandidate.get(candName));
			}
			
		} catch(IOException e){
			System.out.println("error: "+e);
		}
	}

}
