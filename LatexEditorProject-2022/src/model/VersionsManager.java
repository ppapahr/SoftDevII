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

	public void  putVersion(Document document) {
		// TODO Auto-generated method stub
		strategy.putVersion(document);
	}

}
