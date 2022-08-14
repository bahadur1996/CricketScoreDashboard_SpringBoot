package com.backendcode.assignment.util;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.ByteArrayInputStream;

public class XmlUtil {
    public static boolean isXML(String xml)
    {
        try
        {
            XMLReader parser = XMLReaderFactory.createXMLReader();
            parser.setContentHandler(new DefaultHandler());
            InputSource source = new InputSource(new ByteArrayInputStream(xml.getBytes()));
            parser.parse(source);
            return true;
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
