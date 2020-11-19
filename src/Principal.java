import java.util.ArrayList;
import java.util.Scanner;

import com.itextpdf.text.Document;

public class Principal {
	
	public static void main (String []args) {
		
		Scanner input = new Scanner(System.in);
		
		ArrayList<Atestado> listaAtestado = new ArrayList<Atestado>();
		
			System.out.println("\nNome Paciente: ");
			String nomPac = input.nextLine();
			input.nextLine();
			
			System.out.println("\nData: ");
			String data = input.nextLine();
			input.nextLine();
			
			System.out.println("\nNome M�dico: ");
			String nomMed = input.nextLine();
			input.hasNextLine();
			
			int op = 0;
			
			do {
			
			System.out.println("\nSelecione o tipo de Atestado: ");
			System.out.println("-----------------------------------------");
			System.out.println("-- 1 - Aus�ncia do Trabalho -------------");
			System.out.println("-- 2 - Aus�ncia de Atividade ------------");
			System.out.println("-- 3 - Comparecimento -------------------");
			System.out.println("-- 4 - Acompanhante ---------------------");
			System.out.println("-- 5 - Cancelar -------------------------");
			System.out.println("-- Op��o: ");
			
			op = input.nextInt();
			
			switch(op) {
			
				case 1: 
					
					System.out.println("\nDeseja fazer pesquisa CID 10? \n 's' para sim 'n' para n�o" );
					String tipo = input.next();
					input.nextLine();
					if (tipo.equals("s")) {
						System.out.println("\nDoen�a:");
						String cod = input.next();
						PesquisaCID obj = new PesquisaCID();
						obj.pesquisa(cod);
					}
					System.out.println("\nDigite o CID: ");
					String cid = input.nextLine();
					input.nextLine();
					
					System.out.println("\nDigite o periodo: ");
					String periodo = input.nextLine();
					input.nextLine();
					
					System.out.println("Deseja gerar o PDF? Digite 1 para sim e 2 para n�o");
					int opc = 0;

					opc = input.nextInt();
					input.nextLine();
					
					if(opc == 1) {
						
						GeraPDF objPDF = new GeraPDF();
						objPDF.Gera(nomPac, data, nomMed, cid, periodo);
					}
					
					AusenciaTrabalho objAusenciaTrab = new AusenciaTrabalho(nomPac,data, nomMed, cid, periodo);
					listaAtestado.add(objAusenciaTrab);
					
					break;
				
				case 2: System.out.println("\nDeseja fazer pesquisa CID 10? \n 's' para sim 'n' para n�o" );
					String tipo1 = input.next();
					if (tipo1.equals("s")) {
						System.out.println("\nDoen�a:");
						String cod = input.next();
						PesquisaCID obj = new PesquisaCID();
						obj.pesquisa(cod);
					}
					
					System.out.println("\nDigite o CID: ");
					String cid1 = input.nextLine();
					
					
					System.out.println("\nDigite o periodo: ");
					String periodo1 = input.nextLine();
					input.nextLine();
					AusenciaAtividade objAusencia = new AusenciaAtividade(nomPac,data,nomMed,periodo1,cid1);
					listaAtestado.add(objAusencia);		
					break;
					
				case 3:
					System.out.println("\nDigite o periodo: ");
					String periodo2 = input.nextLine();
					input.nextLine();
					Comparecimento objComparecimento = new Comparecimento(nomPac,data,nomMed,periodo2,"CID - 10 - Z00");
					listaAtestado.add(objComparecimento);
					break;
					
				case 4: 
					System.out.println("\nDigite o periodo: ");
					String periodo3 = input.nextLine();
					input.nextLine();
					Acompanhante objAcompanhante = new Acompanhante(nomPac,data,nomMed,periodo3,"CID - 10 - Z00");
					listaAtestado.add(objAcompanhante);
					break;
					
				case 5:
					System.out.println("Saindo...");
					break;
					
				case 6:
					System.out.println("Gerando pdf...");
					String perioodo = "20 dias";
					Document doc = new Document();
					
				default: 
					System.out.println("Op��o Inv�lida! Tente Novamente.");
			}
			
			
			} while(op != 6);
			
			for(int i = 0; i < listaAtestado.size(); i++) {
				
				Atestado objAtestado = listaAtestado.get(i);
				System.out.println(objAtestado.toString() + "\n");
				System.out.println(objAtestado.cabecalho());
				
			}
			input.close();
	}
}
