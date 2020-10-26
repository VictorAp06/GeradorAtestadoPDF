import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; 

public class PesquisaCID {
	
	private String codigo;

	public PesquisaCID() {
		
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public void pesquisa(String codigo) {
		
		String path = "C:\\Projects\\ws-eclipse\\GeradorAtestado\\sus.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			
			while(line != null) {
				
				if(line.toLowerCase().contains(codigo.toLowerCase())==true) {
					System.out.println(line);
					String vetor[] = line.split(" ");
					System.out.println("O CID é :" + vetor[0]);
				}
				line = br.readLine();
			}
			
		} catch (IOException e) {
			
			System.out.println("Error: " + e.getMessage());
		
		}
		
	}

}
