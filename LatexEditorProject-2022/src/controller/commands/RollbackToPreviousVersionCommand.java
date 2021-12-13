package controller.commands;

import javax.swing.JOptionPane;

import model.Document;
import model.VersionsManager;

public class RollbackToPreviousVersionCommand extends CommandTemplate {
	
	
	public RollbackToPreviousVersionCommand(VersionsManager versionsManager) {
		super(versionsManager);
	}


	@Override
	public void execute() {
		if(versionsManager.isEnabled() == false) {
			JOptionPane.showMessageDialog(null, "Strategy is not enabled", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			Document doc = versionsManager.getStrategy().getVersion();
			if(doc == null) {
				JOptionPane.showMessageDialog(null, "No version available", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				versionsManager.getStrategy().removeVersion();
				versionsManager.setCurrentDocument(doc);
			}
		}
	}

}
