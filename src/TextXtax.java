import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class TextXtax {

	public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
		
		String dni="", titular="", moneda="", saldo="", fechacreacion="";
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(new File("cuentas.xml")));
		while (reader.hasNext()) {
		    XMLEvent nextEvent = reader.nextEvent();
		    if (nextEvent.isStartElement()) {
		        StartElement startElement = nextEvent.asStartElement();
		        switch (startElement.getName().getLocalPart()) {
	            case "titular":
	                nextEvent = reader.nextEvent();
	                System.out.println((nextEvent.asCharacters().getData()));
	                Attribute dni2 = startElement.getAttributeByName(new QName("dni"));
	                if (dni2 != null) {
	                System.out.println((dni2.getValue()));
	                }
	                break;
	            case "saldoactual":
	                nextEvent = reader.nextEvent();
	                System.out.println((nextEvent.asCharacters().getData()));
	                Attribute moneda2 = startElement.getAttributeByName(new QName("moneda"));
	                if (moneda2 != null) {
	                System.out.println((moneda2.getValue()));
	                }
	                break;
	            case "fechacreacion":
	                nextEvent = reader.nextEvent();
	                System.out.println((nextEvent.asCharacters().getData()));
	                break;
	         
	    }
		    if (nextEvent.isEndElement()) {
		        EndElement endElement = nextEvent.asEndElement();
		        if (endElement.getName().getLocalPart().equals("listado")) {
		            System.out.println("fin");
		        }
	}
		    }
}
}
}