package controller;

import java.util.*;

import controller.commands.AddLatexCommand;
import controller.commands.ChangeVersionsStrategyCommand;
import controller.commands.Command;
import controller.commands.CommandFactory;
import controller.commands.CreateCommand;
import controller.commands.DisableVersionsManagementCommand;
import controller.commands.EditCommand;
import controller.commands.EnableVersionsManagementCommand;
import controller.commands.LoadCommand;
import controller.commands.RollbackToPreviousVersionCommand;
import controller.commands.SaveCommand;
import model.VersionsManager;

public class LatexEditorController{
	private HashMap<String, Command> commands;
	
	public LatexEditorController(VersionsManager versionsManager) {
		CommandFactory commandFactory = new CommandFactory(versionsManager);
		commands = new HashMap<String, Command>(); 
		Map<Integer, String> commandNames = new HashMap<>();
		commandNames.put(1, "addLatex");
		commandNames.put(2, "changeVersionsStrategy");
		commandNames.put(3, "create");
		commandNames.put(4, "disableVersionsManagement");
		commandNames.put(5, "edit");
		commandNames.put(6, "enableVersionsManagement");
		commandNames.put(7, "load");
		commandNames.put(8, "rollbackToPreviousVersion");
		commandNames.put(9, "save");

		for (String name : 	commandNames.values())
			commands.put(name, commandFactory.createCommand(name));
		//System.out.println(commands);
	} 
	
	public void enact(String command) {
		commands.get(command).execute();
	}
}
