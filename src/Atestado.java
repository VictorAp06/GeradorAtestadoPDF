
public abstract class Atestado {

	private String nomPac;
	private String data;
	private String nomMed;
	private String cid;
	

	private static int qtdAtestado=0;
	
	public Atestado(String nomPac, String data, String nomMed,String cid) {
		setNomPac(nomPac);
		setData(data);
		setNomMed(nomMed);
		setCid(cid);
		qtdAtestado++;
	}
	
	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}
	
	public String getNomPac() {
		return nomPac;
	}
	public void setNomPac(String nomPac) {
		this.nomPac = nomPac;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getNomMed() {
		return nomMed;
	}
	public void setNomMed(String nomMed) {
		this.nomMed = nomMed;
	}

	public static int getQtdAtestado() {
		return qtdAtestado;
	}

	public static void setQtdAtestado(int qtdAtestado) {
		Atestado.qtdAtestado = qtdAtestado;
	}
	
	public abstract String cabecalho();
	
	public String toString () {
		return "\nPaciente: " + nomPac + "\nData: " + data + "\nMédico: " + nomMed +  "\nCID: " + cid + "\nNúmero Atestado: " + qtdAtestado;      
	}	
}
