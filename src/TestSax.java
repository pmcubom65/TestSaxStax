import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamSource;

import org.xml.sax.SAXException;

public class TestSax {
	
public static void main(String[] args) throws TransformerConfigurationException, ParserConfigurationException, SAXException, IOException {
	SAXParserFactory spf=SAXParserFactory.newInstance();
	SAXParser sp=spf.newSAXParser();
	sp.parse(new File("cuentas.xml"), new Midefault());
	
}
}
