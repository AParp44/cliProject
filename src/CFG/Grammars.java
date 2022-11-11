package CFG;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import io.XmlRead;

public class Grammars {
private static Grammars grammarInstance;
private ArrayList<CFG>list = new ArrayList<CFG>();
private String fileName;
private Grammars() {}
public static Grammars getInstance() {
	if(grammarInstance == null ) {
		grammarInstance =  new Grammars();
	}
	return grammarInstance;
}
public ArrayList<CFG> getList() {
	return list;
}
public void setList(ArrayList<CFG> list) {
	this.list = list;
}
public static Grammars getGrammarInstance() {
	return grammarInstance;
	
}
public void close() {
	grammarInstance = null;
}
public  void open(String[] args) throws IOException, ParserConfigurationException, SAXException {
	
	
	if (!args[0].isEmpty()) {
		String fn = args[0];
		setFileName(fn);
		File mn = new File(fn);
		mn.createNewFile();
		if (mn.length() != 0) {
			XmlRead xmlR = new XmlRead();
			list = xmlR.getGrammar(mn);
			Grammars.getInstance().setList(list);
		}
		System.out.println("Successfully opened " + mn.getPath());
		System.out.println("You can now use other commands! If you want to check them out input help below!");
}


}
public String getFileName() {
	return fileName;
}
public void setFileName(String fileName) {
	this.fileName = fileName;
}
}
