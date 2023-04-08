package com.minis.web;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XmlScanComponentHelper {

    public static List<String> getNodeValue(URL xmlPath) {
        ArrayList<String> packages = new ArrayList<>();
        SAXReader saxReader = new SAXReader();
        Document document = null;
        try{
            document = saxReader.read(xmlPath);
        }catch (Exception e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        Iterator iterator = root.elementIterator();
        while(iterator.hasNext()) {
            Element element = (Element)iterator.next();
            packages.add(element.attributeValue("base-package"));
        }
        return packages;
    }
}
