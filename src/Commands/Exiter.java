package Commands;

import CFG.Grammars;
import commandLine.Command;

public class Exiter implements Command {
    @Override
    public void execute(String[] args) {
    	if(!(Grammars.getGrammarInstance() == null)) {
        if(args.length!=0){
            System.out.println("No need for parameters");
        }
        System.out.println("Exitting the program...");
        System.exit(0);
    	}
    	else {
    		System.out.println("Open file first!");
    		}
    }
    
}
