import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeraPDF{
		
		public void Gera(String nomPac, String data, String nomMed, String cid, String periodo) {
		
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
			
			
			Paragraph dados = new Paragraph();
			
			dados.add("\n\n\n\n\n\n\n\n\n            Atesto para os devidos fins, a pedido que o(a) Sr(a). " + nomPac
										+ " inscrito(a) no CPF sob o nº (), paciente sob meus cuidados, foi atentido(a) no dia " + data + 
												" apresentando quadro referente ao CID " + cid + " e necessitando de " + periodo + " dias de repouso.");
			
			dados.setAlignment(Element.ALIGN_JUSTIFIED);
			
			Paragraph rodape = new Paragraph();
			
			rodape.add("\n\n\n\n\n\n\n\n\n\n\n\n\n            Médico: " + nomMed + "\n\n            CRM 123456");
			
			doc.add(dados);
			doc.add(rodape);
			
			doc.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		}
}

