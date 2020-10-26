import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeraPDF{
	
		private String nomPac;
		private String data;
		private String nomMed;
		private String cid;
		private Document doc;


		public GeraPDF() {
			
		}
		
		public GeraPDF (String nomPac, String data, String nomMed, String periodo, String cid) {
	    	setNomPac(nomPac);
			setData(data);
			setNomMed(nomMed);
			setCid(cid);
			setDoc(doc);
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
		public String getCid() {
			return cid;
		}
		public void setCid(String cid) {
			this.cid = cid;
		}
	    public Document getDoc() {
			return doc;
		}

		public void setDoc(Document doc) {
			this.doc = doc;
		}
		
		public void Gera(String nomPac, String data, String nomMed, String periodo, String cid) {
		
		try {
			
			Document doc = new Document();
			
			PdfWriter.getInstance(doc, new FileOutputStream(nomPac+".pdf"));
			
			doc.open();
			Paragraph paragraph = new Paragraph();
			Font f = new Font(FontFamily.TIMES_ROMAN,28);
			
			Image img = Image.getInstance("photo.jpg");
			img.setAlignment(Element.ALIGN_LEFT);
			img.setAbsolutePosition(0,741);
			img.scaleToFit(100,100);
			doc.add(img);
			paragraph.add("ATESTADO MÉDICO");
			paragraph.setAlignment(Element.ALIGN_CENTER);
			doc.add(paragraph);
			doc.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		}
}

