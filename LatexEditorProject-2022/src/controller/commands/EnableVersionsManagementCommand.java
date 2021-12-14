package controller.commands;

import model.VersionsManager;
import model.strategies.StableVersionsStrategy;
import model.strategies.VolatileVersionsStrategy;

public class EnableVersionsManagementCommand extends CommandTemplate {
	
	public EnableVersionsManagementCommand(VersionsManager versionsManager) {
		super(versionsManager);
	}


	@Override
	public void execute() {
		versionsManager.enable();
	}

}
