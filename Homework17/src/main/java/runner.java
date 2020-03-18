import dom.DomParser;
import model.Email;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import sax.EmailHandler;
import stax.StaxParser;

import javax.xml.parsers.*;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class runner {
    private static final String EMAILS_XML = "emails.xml";

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, XMLStreamException {
        System.out.println(" ========================= SAX parser ==============================");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        EmailHandler countryHandler = new EmailHandler();
        saxParser.parse(new File(EMAILS_XML), countryHandler);
        List<Email> emails = countryHandler.getEmails();
        emails.forEach(email -> System.out.println(email));

        System.out.println(" ============================== STAX parser =========================");
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(EMAILS_XML));
        emails = new StaxParser().parse(xmlEventReader);
        emails.forEach(email -> System.out.println(email));

        System.out.println(" ============================== DOM parser =========================");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(EMAILS_XML);
        emails = new DomParser().parse(document);
        emails.forEach(email -> System.out.println(email));
    }
}
