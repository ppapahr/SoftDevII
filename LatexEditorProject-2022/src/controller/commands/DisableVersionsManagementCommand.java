package controller.commands;

import model.VersionsManager;

public class DisableVersionsManagementCommand extends CommandTemplate {
	
	public DisableVersionsManagementCommand(VersionsManager versionsManager) {
		super(versionsManager);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		versionsManager.disable();
	}

}
