package controller.commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.Document;
import model.VersionsManager;

public class LoadCommand extends CommandTemplate {
	
	public LoadCommand(VersionsManager versionsManager) {
		super(versionsManager);
	}

	public VersionsManager getVersionsManager() {
		return versionsManager;
	}

	public void setVersionsManager(VersionsManager versionsManager) {
		this.versionsManager = versionsManager;
	}

	@Override
	public void execute() {
		String fileContents = "";
		try {
			Scanner scanner = new Scanner(new FileInputStream(versionsManager.getFilename()));
			while(scanner.hasNextLine()) {
				fileContents = fileContents + scanner.nextLine() + "\n";
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		versionsManager.setCurrentDocument(new Document()); 
		versionsManager.getCurrentDocument().setContents(fileContents);

		versionsManager.setType("emptyTemplate");
		
		fileContents = fileContents.trim();
		if(fileContents.startsWith("\\documentclass[11pt,twocolumn,a4paper]{article}")) {
			versionsManager.setType("articleTemplate");
		}
		else if(fileContents.startsWith("\\documentclass[11pt,a4paper]{book}")) {
			versionsManager.setType("bookTemplate");
		}
		else if(fileContents.startsWith("\\documentclass[11pt,a4paper]{report}")) {
			versionsManager.setType("reportTemplate");
		}
		else if(fileContents.startsWith("\\documentclass{letter}")) {
			versionsManager.setType("letterTemplate");
		}
	}

}
