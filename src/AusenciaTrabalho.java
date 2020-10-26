
public class AusenciaTrabalho extends Atestado{

	private String periodo;
	
	public AusenciaTrabalho(String nomPac, String data, String nomMed, String cid, String periodo) {
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
		return "\nTipo: Aus�ncia do Trabalho.\n Per�odo: " + periodo; 
	}
	
	public String toString() {
		return super.toString();
	}
	
}
