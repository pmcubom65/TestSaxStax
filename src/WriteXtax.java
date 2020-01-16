import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;

public class WriteXtax {

	public static void main(String[] args) throws XMLStreamException {
		XMLOutputFactory factory  = XMLOutputFactory.newInstance();
		
		XMLStreamWriter writer = factory.createXMLStreamWriter(System.out);
		
		writer.writeStartDocument();
	     writer.writeStartElement("listado");
	     writer.writeStartElement("cuenta");
	     writer.writeStartElement("titular");
	     
	     writer.writeAttribute("dni", "v1225");
	     writer.writeCharacters("manolo");
	     writer.writeEndElement();
	     writer.writeEndElement();
	     writer.writeEndElement();
	     writer.writeEndDocument();

	     writer.flush();
	     writer.close();

	}

}
