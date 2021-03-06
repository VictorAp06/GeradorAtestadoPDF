import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeraPDF{
		
		public void Gera(String nomPac, String data, String nomMed, String cid, String periodo, 
				String RQE, String especialidade, String CRM, int finalidade) {
		
		Date data1 = new Date();
			
		try {
			
			Document doc = new Document();
			
			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
			
			PdfWriter.getInstance(doc, new FileOutputStream(nomPac+".pdf"));
			
			doc.open();
			Paragraph paragraph = new Paragraph();
			Font f = new Font(FontFamily.TIMES_ROMAN,28);
			paragraph.add("\n______________________________________________________________________________");
			paragraph.setAlignment(Element.ALIGN_CENTER);
			doc.add(paragraph);
			
			
			Paragraph dados = new Paragraph();
			
			dados.add("\n       Dr " + nomMed
					+ "\n       CRM " + CRM + "\n       RQE " + RQE + " - " + especialidade );
					 
			
			dados.setAlignment(Element.ALIGN_LEFT);
			
			Paragraph endereco = new Paragraph();
			
			endereco.add("\n Rua Martinesia 113, N. S. Aparecida \n CEP: 38400-606 \n Uberl�ndia - Minas Gerais" + "\n______________________________________________________________________________");
			endereco.setAlignment(Element.ALIGN_RIGHT);
			
			doc.add(dados);
			doc.add(endereco);
			
			Paragraph atestado = new Paragraph();
			
			atestado.add("\n\nAtestado");
			atestado.setAlignment(Element.ALIGN_CENTER);
			doc.add(atestado);
			
			Paragraph principal = new Paragraph();
			
			principal.add("\n\n\n        Nome: " + nomPac + "\n\n        C�digo da Finalidade: ");
			principal.setAlignment(Element.ALIGN_LEFT);
			
			Paragraph finali = new Paragraph();
			
			if(finalidade == 1) {
				
				finali.add(" \n (01) Aus�ncia de Atividade (Escola/ Universidade/ N�o Laboral)" );
				
			} else if(finalidade == 2) {
				
				finali.add(" \n (02) Acompanhante em Consulta)" );
				
			} else if(finalidade == 3) {
				
				finali.add(" \n (03) Comparecimento em Consulta" );
			
			} else if(finalidade == 4) {
				
				finali.add(" \n (04) Aus�ncia do Trabalho" );
				
			}
			
			finali.setAlignment(Element.ALIGN_CENTER);
			
			principal.add("\n\n        Per�odo: " + periodo + "\n\n        CID 10: " + cid);
			
			doc.add(principal);	
				
			doc.add(finali);
			
            Paragraph p4 = new Paragraph("\n        Data: "+formatador.format(data1));
            p4.setAlignment(Element.ALIGN_LEFT);
            p4.setSpacingAfter(10);
            doc.add(p4);
            
            
			Paragraph rodape = new Paragraph();
			
			rodape.add("\n       Dr " + nomMed
					+ "\n       CRM " + CRM + "\n       RQE " + RQE + " - " + especialidade );
			

			rodape.setAlignment(Element.ALIGN_RIGHT);
			
			doc.add(rodape);
			
			
			doc.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		}
}

