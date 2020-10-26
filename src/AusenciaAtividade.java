
public class AusenciaAtividade extends Atestado{
	
	private String periodo;
	
	public AusenciaAtividade(String nomPac, String data, String nomMed, String periodo, String cid) {
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
		return "\nTipo: Aus�ncia de Atividade.\n Per�odo: " + periodo;
	}
	
	public String toString() {
		return super.toString();
	}
}
