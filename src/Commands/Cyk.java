package Commands;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import CFG.*;
import commandLine.Command;

public class Cyk implements Command{

	@Override
	public void execute(String[] args) throws IOException, ParserConfigurationException, SAXException {
		if(!(Grammars.getGrammarInstance() == null))	{
			if(args.length == 2) {
		    CFGHelper.cyk(Grammars.getInstance().getList(), args);
			}
			else {
				 System.out.println("Its cyk <id> <word>");
			}
		}
		else {
			System.out.println("Open file first!");
			}
		}
		
	}
	

