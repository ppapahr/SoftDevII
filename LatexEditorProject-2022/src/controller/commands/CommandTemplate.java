package controller.commands;

import model.VersionsManager;

public abstract class CommandTemplate implements Command{
	protected VersionsManager versionsManager;
	
	public CommandTemplate(VersionsManager versionsManager) {
		this.versionsManager = versionsManager;
	}
	
	
}
