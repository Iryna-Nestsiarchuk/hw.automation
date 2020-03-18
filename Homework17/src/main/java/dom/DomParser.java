package dom;
import model.Email;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DomParser {
    public List<Email> parse(Document document) throws FileNotFoundException, XMLStreamException {
        NodeList nodeList = document.getElementsByTagName("Email");
        List<Email> countries = new ArrayList<Email>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            countries.add(getEmail(nodeList.item(i)));
        }
        return countries;
    }

    private static Email getEmail(Node node) {
        Email country = new Email();
        Element element = (Element) node;
        country.setId(Integer.parseInt(element.getAttribute("id")));
        country.setSubject(getTagValue("Subject", element));
        country.setReceiver(getTagValue("Receiver", element));
        country.setText(getTagValue("Text", element));
        return country;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}
