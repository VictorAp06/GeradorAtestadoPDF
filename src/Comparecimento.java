
public class Comparecimento extends Atestado{

	private String periodo;
	
	public Comparecimento(String nomPac, String data, String nomMed, String periodo, String cid) {
		super(nomPac, data, nomMed, cid);
		setPeriodo(periodo);
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	public String cabecalho() {
		return "\nTipo: Comparecimento.\n Período: " + periodo;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
