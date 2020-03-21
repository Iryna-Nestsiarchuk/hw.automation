package core.parser.dom;

import core.parser.model.Email;
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
        List<Email> emails = new ArrayList<Email>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            emails.add(getEmail(nodeList.item(i)));
        }
        return emails;
    }

    private static Email getEmail(Node node) {
        Email email = new Email();
        Element element = (Element) node;
        email.setId(Integer.parseInt(element.getAttribute("id")));
        email.setSubject(getTagValue("Subject", element));
        email.setReceiver(getTagValue("Receiver", element));
        email.setText(getTagValue("Text", element));
        return email;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }

}
