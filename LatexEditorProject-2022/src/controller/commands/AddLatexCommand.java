
package controller.commands;

import java.util.HashMap;
import model.VersionsManager;

public class AddLatexCommand extends CommandTemplate  {	
	private HashMap<String,String> commandTypes = new HashMap<String,String>();
	private String [] commandNames = new String [] {"chapter","section","subsection","subsubsection","enumerate","itemize","table","figure"};
    private String [] commandContents = new String [] { "\n\\chapter{...}"+"\n","\n\\section{...}"+"\n","\n\\subsection{...}"+"\n","\n\\subsubsection{...}"+"\n",
    		"\\begin{enumerate}\n"+"\\item ...\n"+"\\item ...\n"+"\\end{enumerate}\n",
    		"\\begin{itemize}\n"+"\\item ...\n"+"\\item ...\n"+"\\end{itemize}\n",
    		"\\begin{table}\n"+"\\caption{....}\\label{...}\n"+"\\begin{tabular}{|c|c|c|}\n"+"\\hline\n"+"... &...&...\\\\\n"+"... &...&...\\\\\n"+"... &...&...\\\\\n"+"\\hline\n"+"\\end{tabular}\n"+"\\end{table}\n",
    		"\\begin{figure}\n"+"\\includegraphics[width=...,height=...]{...}\n"+"\\caption{....}\\label{...}\n"+"\\end{figure}\n"};
    
	public AddLatexCommand(VersionsManager versionsManager) {
		super(versionsManager);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		versionsManager.saveContents();
	}
	
public String editContents(String type,String before, String after) {
		String contents;
		
		for(int i=0; i<commandNames.length; i++) {
			commandTypes.put(commandNames[i],commandContents[i]);
		}
		
		contents = before + commandTypes.get(type) + after;
		
		return contents;
	}
}