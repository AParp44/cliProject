package io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import CFG.CFG;
import CFG.Grammars;

public class IOHelper {
public static void save(ArrayList<CFG> list,String[] arr) {
	String fn = Grammars.getInstance().getFileName();
	XmlWrite xwrite = new XmlWrite();
	xwrite.writeXmlFile(list, fn);
	System.out.println("Successfully saved " + fn);
}
public static void saveas(ArrayList<CFG> list,String[] arr) {
	String fn = arr[0];
	XmlWrite xwrite = new XmlWrite();
	xwrite.writeXmlFile(list, fn);
	System.out.println("Successfuly saved another " + fn);
}
public static void open(ArrayList<CFG>list, String[]arr) throws IOException, ParserConfigurationException, SAXException {
	String fn = arr[0];
	File mn = new File(fn);
	mn.createNewFile();
	if (mn.length() != 0) {
		XmlRead xmlR = new XmlRead();
		list = xmlR.getGrammar(mn);
	}
	System.out.println("Successfully opened " + mn.getPath());
	System.out.println("You can now use other commands! If you want to check them out input help below!");
}
}
