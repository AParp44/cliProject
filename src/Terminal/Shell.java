package Terminal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import CFG.CFG;
import CFG.Grammars;
import io.XmlRead;
import commandLine.Command;
import commandLine.CommandFactory;

public class Shell {

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		// TODO Auto-generated method stub
		ArrayList<CFG> list = new ArrayList<CFG>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome");;
		System.out.println("Input open <file> down below!");
        while(true){
        	System.out.print(">");
            String userInput = scanner.nextLine();
            String[] splitedInput = userInput.split("[ ]");
            String commandName = splitedInput[0];
            String[] commandArgs = new String[splitedInput.length-1];
            System.arraycopy(splitedInput,1,commandArgs,0,commandArgs.length);
            Command command =CommandFactory.getCommand(commandName);
            if(command!=null) {
                command.execute(commandArgs);
            }
            else {
                System.out.println("Bad command. Try again or use help.");
            }
       
        }
	}

}
