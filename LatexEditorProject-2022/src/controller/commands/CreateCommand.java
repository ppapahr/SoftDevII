package controller.commands;

import model.Document;
import model.DocumentManager;
import model.VersionsManager;

public class CreateCommand extends CommandTemplate {
	private DocumentManager documentManager;
	
	public CreateCommand(DocumentManager documentManager, VersionsManager versionsManager) {
		super(versionsManager);
		this.documentManager = documentManager;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		String type = versionsManager.getType();
		Document document = documentManager.createDocument(type);
		versionsManager.setCurrentVersion(document);
	}

}
