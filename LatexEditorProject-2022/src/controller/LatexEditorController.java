package controller;

import java.util.HashMap;
import java.util.Map;
import controller.commands.Command;
import controller.commands.CommandFactory;
import model.VersionsManager;

public class LatexEditorController{
	private HashMap<String, Command> commands;
	private VersionsManager versionsManager;
	private String [] stringNames = new String [] {"addLatex", "changeVersionsStrategy","create","disableVersionsManagement","edit","enableVersionsManagement","load","rollbackToPreviousVersion","save"};
	
	public LatexEditorController(VersionsManager versionsManager) {
		this.versionsManager = versionsManager;
		CommandFactory commandFactory = new CommandFactory(versionsManager);
		commands = new HashMap<String, Command>(); 
		Map<Integer, String> commandNames = new HashMap<>();
		
		for(int k=0; k<stringNames.length; k++) {
			commandNames.put(k, stringNames[k]);
			commands.put(stringNames[k], commandFactory.createCommand(stringNames[k]));
		}
	} 
	
	public void enact(String command) {
		commands.get(command).execute();
	}
	
	public VersionsManager getVersionsManager() {
		return versionsManager;
	}
}
