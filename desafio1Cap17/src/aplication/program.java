package aplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entitis.Sales;
import exception.OpcaoInvalida;
import operations.SallerOperation;
public class program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc =  new Scanner(System.in);
		
		//instaciando as operações
		SallerOperation operation = (s,o)->{
			if(o==1) {//buscar vendedor
				System.out.println("enter seller: ");
				String nameSaller = sc.next();
				boolean accy = s.stream()
						.map(ss->ss.getSaller())
						.collect(Collectors.toList())
						.contains(nameSaller);
				if(accy) {
					System.out.println("---SOBRE O VENDEDOR: "+nameSaller+" ;---");
					s.stream()
						.filter(ss->ss.getSaller().equals(nameSaller))
						.forEach(System.out::println);
						
				}else {System.out.println("vendedor não encontrado");}
				
			}else if(o==2) {//total vendido pelo vendedor v, nos  meses m's

				System.out.println("enter seller: ");
				String nameSaller = sc.next();
				boolean accy = s.stream()
						.map(ss->ss.getSaller())
						.collect(Collectors.toList())
						.contains(nameSaller);
				if(accy) {
					System.out.println("enter month(separated to ','): ");
					sc.nextLine();
					String strM = sc.nextLine();
					String[] strV = strM.split(",");
					
					Integer[] mesV = new Integer[strV.length];
					double mtd = 0;
					String mNE= "";
					for(int i=0;i<strV.length;i++) {
						mesV[i] = Integer.parseInt(strV[i]);
					}
					for(int mes:mesV) {
						boolean accm = s.stream()
								.map(ss->ss.getMonth())
								.collect(Collectors.toList())
								.contains(mes);
						if(accm) {
							mtd += s.stream()
								.filter(ss->ss.getMonth().equals(mes))
								.filter(ss->ss.getSaller().equals(nameSaller))
								.mapToDouble(ss->ss.getTotal())
								.sum();
						}else {
							mNE+= String.format("%n",mes);
						}
					}
					System.out.println("Valor total vendido pelo vendedor "
							+nameSaller
							+", nos meses "
							+strM+" = "
							+mtd
					);
					System.out.println("vendedores não encontrados: "+mNE);
						
				}else {System.out.println("vendedor não encontrado");}
				
			}else {//n primeiras vendas de maior preço medio do ano y
			
				System.out.print("vendas: ");
				int quantas_vendas=sc.nextInt();
				System.out.println("ano: ");
				int de_qual_ano = sc.nextInt();
				boolean accy = s.stream()
							.map(ss->ss.getYear())
							.collect(Collectors.toList())
							.contains(de_qual_ano);
				if(accy) {
					System.out.println(quantas_vendas+" primeiras vendas de "+de_qual_ano +" de maior preço médio: ");
					s.stream()
					.filter(ss->ss.getYear().equals(de_qual_ano))
					.sorted((s1,s2)->s2.averagePrice(s2.getTotal(),s2.getItems()).compareTo(s1.averagePrice(s1.getTotal(),s1.getItems())))
					.limit(quantas_vendas)
					.forEach(ss->System.out.println(ss.toString()));
				}else {System.out.println("ano não encontrado"+accy);}
				
			//	s.stream().map(sales->sales.getSeller()).forEach(sss->System.out.println("3 "+sss));
			}
		};
			
		boolean continuar;
		
		System.out.print("continuar, para digitar o caminho do arquivo csv:(digite s para continuar) ");
		Character sn = sc.next().charAt(0);
		sc.nextLine();
		System.out.print("enter path to read file: ");
		String path = sc.nextLine();
		if(sn=='s') {
			continuar = true;
			while(continuar) {
				
				List<Sales> sList = new ArrayList<>();
				
				try( BufferedReader br = new BufferedReader(new FileReader(path))){
						System.out.println("qual operação você gostaria de executar? ");
						System.out.println("1.Buscar vendedor, 2.total vendido pelo vendedor v nos m meses, 3.maiores vendas do ano Y,");
						
						
						try {
							
							Integer opt = sc.nextInt();
							sc.nextLine();
							
							String line = br.readLine();
							while(line!=null) {
								String[] linev = line.split(",");
								sList.add(new Sales(Integer.parseInt(linev[0]),Integer.parseInt(linev[1]), linev[2],Integer.parseInt(linev[3]), Double.parseDouble(linev[4]), opt));
								line = br.readLine();
							}
							operation.operation(sList, opt);
							
						}catch(InputMismatchException ime) {
								System.out.println("erro, digite apenas numeros iteiros. "+ime.getMessage());
						}
						catch(OpcaoInvalida o) {
							System.out.println("opcão invalida, "+o.getMessage());
						}
						
				}catch( IOException e) {
					System.out.println("Error: "+e.getMessage());
				}
				System.out.println("digitar novo caminho?(s para sim): ");
				Character np = sc.next().charAt(0);
				sc.nextLine();
				if(np=='s') {
					System.out.print("enter path to read file: ");
					path = sc.nextLine();
				}
				System.out.println("continuar?(s/n): ");
				continuar = sn == sc.next().charAt(0);
			}
		}
		
		
		sc.close();
	}

}
