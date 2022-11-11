package commandLine;

import CFG.CFG;
import Commands.*;

public abstract class CommandFactory {
    public static Command getCommand(String commandName){
    	
        if(commandName.equalsIgnoreCase("list")){
            return new List();
        }else if(commandName.equalsIgnoreCase("exit")){
            return new Exiter();
        }else if(commandName.equalsIgnoreCase("help")){
            return new Helper();
        }else if(commandName.equalsIgnoreCase("addRule")) {
        	return new AddRule();
        }else if(commandName.equalsIgnoreCase("chomskify")) {
        	return new Chomskify();
        }
        else if(commandName.equalsIgnoreCase("chomsky")) {
        	return new Chomsky();
        }
        else if(commandName.equalsIgnoreCase("close")) {
        	return new Close();
        }
        else if(commandName.equalsIgnoreCase("open")) {
        	return new Open();
        }
        else if(commandName.equalsIgnoreCase("concat")) {
        	return new Concat();
        }
        else if(commandName.equalsIgnoreCase("union")) {
        	return new Union();
        }
        else if(commandName.equalsIgnoreCase("cyk")) {
        	return new Cyk();
        }
        else if(commandName.equalsIgnoreCase("empty")) {
        	return new Empty();
        }
        else if(commandName.equalsIgnoreCase("removeRule")) {
        	return new RemoveRule();
        }
        else if(commandName.equalsIgnoreCase("removeRule")) {
        	return new RemoveRule();
        }
        else if(commandName.equalsIgnoreCase("iter")) {
        	return new Iter();
        }
        else if(commandName.equalsIgnoreCase("print")) {
        	return new Print();
        }
        else if(commandName.equalsIgnoreCase("save")) {
        	return new Save();
        }
        else if(commandName.equalsIgnoreCase("saveAs")) {
        	return new SaveAs();
        }
        else{
            return null;
        }
    
    }
}