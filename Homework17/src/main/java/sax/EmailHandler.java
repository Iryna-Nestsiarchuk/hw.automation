package sax;

import model.Email;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class EmailHandler extends DefaultHandler {
    private List<Email> emails;
    private Email email;
    boolean isSubject = false;
    boolean isReceiver = false;
    boolean isText = false;

    public List<Email> getEmails() {
        return emails;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        if (qName.equalsIgnoreCase("Email")) {
            String id = attributes.getValue("id");
            email = new Email();
            email.setId(Integer.parseInt(id));
            if (emails == null) {
                emails = new ArrayList<Email>();
            }
        } else if (qName.equalsIgnoreCase("Subject")) {
            isSubject = true;
        } else if (qName.equalsIgnoreCase("Receiver")) {
            isReceiver = true;
        } else if (qName.equalsIgnoreCase("Text")) {
            isText = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("Email")) {
            emails.add(email);
        }
    }

    @Override
    public void characters(char characters[], int start, int length) {

        if (isSubject) {
            email.setSubject(new String(characters, start, length));
            isSubject = false;
        } else if (isReceiver) {
            email.setReceiver(new String(characters, start, length));
            isReceiver = false;
        } else if (isText) {
            email.setText(new String(characters, start, length));
            isText = false;
        }
    }
}
