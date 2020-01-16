import java.io.CharArrayWriter;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Midefault extends DefaultHandler {


	StringBuffer titular, saldoactual, fechacreacion;
	boolean bt, bs, bf;
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("comienzo del documento");
		
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("final");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch(qName) {
		case "titular":
		     bt = true;
		 
		     System.out.println(attributes.getValue("dni"));
		        titular = new StringBuffer();
		        break;
		case "saldoactual":
		 bs=true;
	
		 System.out.println(attributes.getValue("moneda"));
		 saldoactual = new StringBuffer();
		 break;
		case "fechacreacion":
			 bf=true;
			
			 fechacreacion = new StringBuffer();
			 break;
		}

	
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch(qName) {
		case "titular":
		     bt = false;
		    
		        break;
		case "saldoactual":
		 bs=false;

		 break;
		case "fechacreacion":
			 bf=false;
	
			 break;
		}
		if (titular!=null) {
			System.out.println(titular);
			titular=null;
		}
		 
	
		 
		if (saldoactual!=null) {
			System.out.println(saldoactual);
			 saldoactual=null;
		}
		
		
		 if (fechacreacion!=null) {
			 System.out.println(fechacreacion);
			 fechacreacion=null;
		 }
		
	
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (bt) {
			titular.append(ch, start, length);
		} else if (bs) {
			saldoactual.append(ch, start, length);
		}else if (bf) {
			fechacreacion.append(ch, start, length);
		}
	}

}
