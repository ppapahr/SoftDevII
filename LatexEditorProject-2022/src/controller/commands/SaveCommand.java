package controller.commands;

import model.VersionsManager;

public class SaveCommand extends CommandTemplate {
	
	public SaveCommand(VersionsManager versionsManager) {
		super(versionsManager);
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		versionsManager.getCurrentDocument().save(versionsManager.getFilename());
	}

}
