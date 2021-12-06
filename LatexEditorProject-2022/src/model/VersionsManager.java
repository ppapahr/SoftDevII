package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import controller.LatexEditorController;
import model.strategies.StableVersionsStrategy;
import model.strategies.VersionsStrategy;
import model.strategies.VolatileVersionsStrategy;

public class VersionsManager {
	private boolean enabled;
	private VersionsStrategy strategy;
	private Document currentDocument;
	private String type;
	private String text;
	private String filename;
	private LatexEditorController controller;

	
	public VersionsManager(VersionsStrategy versionsStrategy) {
		this.strategy = versionsStrategy;
	}
	
	public VersionsManager() {
		// TODO Auto-generated constructor stub
	}

	public boolean isEnabled() {
		return enabled;
	}
	
	public void enable() {
		enabled = true;
	}

	public void disable() {
		enabled = false;
	}
	
	
	public void setCurrentVersion(Document document) {
		this.currentDocument = document;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public VersionsStrategy getStrategy() {
		return strategy;
	}
	public void setStrategy(VersionsStrategy strategy) {
		this.strategy = strategy;
	}
	
	public Document getCurrentDocument() {
		return currentDocument;
	}
	
	public void setCurrentDocument(Document currentDocument) {
		this.currentDocument = currentDocument;
	}
	
	public LatexEditorController getController() {
		return controller;
	}
	public void setController(LatexEditorController controller) {
		this.controller = controller;
	}

	public void saveContents() {
		if(this.isEnabled()) {
			this.putVersion(currentDocument);
			currentDocument.changeVersion();
		}
		currentDocument.setContents(text);
	}

	public void saveToFile() {
		currentDocument.save(filename);
	}

	public void loadFromFile() {
		String fileContents = "";
		try {
			Scanner scanner = new Scanner(new FileInputStream(filename));
			while(scanner.hasNextLine()) {
				fileContents = fileContents + scanner.nextLine() + "\n";
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		currentDocument = new Document();
		currentDocument.setContents(fileContents);
		
		type = "emptyTemplate";
		
		fileContents = fileContents.trim();
		if(fileContents.startsWith("\\documentclass[11pt,twocolumn,a4paper]{article}")) {
			type = "articleTemplate";
		}
		else if(fileContents.startsWith("\\documentclass[11pt,a4paper]{book}")) {
			type = "bookTemplate";
		}
		else if(fileContents.startsWith("\\documentclass[11pt,a4paper]{report}")) {
			type = "reportTemplate";
		}
		else if(fileContents.startsWith("\\documentclass{letter}")) {
			type = "letterTemplate";
		}
	}

	public void enableStrategy() {
		// TODO Auto-generated method stub
		if(strategy instanceof VolatileVersionsStrategy) {
			enable();
		}
		else if(strategy instanceof StableVersionsStrategy) {
			enable();
		}
	}

	public void changeStrategy() {
		if(strategy instanceof VolatileVersionsStrategy) {
			VersionsStrategy newStrategy = new StableVersionsStrategy();
			newStrategy.setEntireHistory(strategy.getEntireHistory());
			strategy = newStrategy;
			enable();
		}
		else if(strategy instanceof StableVersionsStrategy) {
			VersionsStrategy newStrategy = new VolatileVersionsStrategy();
			newStrategy.setEntireHistory(strategy.getEntireHistory());
			strategy = newStrategy;
			enable();
		}
	}

	public void  putVersion(Document document) {
		// TODO Auto-generated method stub
		strategy.putVersion(document);
	}

	public void rollback() {
		// TODO Auto-generated method stub
		if(isEnabled() == false) {
			JOptionPane.showMessageDialog(null, "Strategy is not enabled", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			Document doc = strategy.getVersion();
			if(doc == null) {
				JOptionPane.showMessageDialog(null, "No version available", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				strategy.removeVersion();
				this.setCurrentDocument(doc);
			}
		}
		
	}

}
