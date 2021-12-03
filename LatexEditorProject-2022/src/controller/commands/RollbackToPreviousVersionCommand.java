package controller.commands;

import model.VersionsManager;

public class RollbackToPreviousVersionCommand extends CommandTemplate {
	
	
	public RollbackToPreviousVersionCommand(VersionsManager versionsManager) {
		super(versionsManager);
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		versionsManager.rollback();
	}

}
