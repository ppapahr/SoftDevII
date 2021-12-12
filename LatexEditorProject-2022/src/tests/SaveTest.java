package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import controller.commands.CreateCommand;
import controller.commands.SaveCommand;
import model.DocumentManager;
import model.VersionsManager;


public class SaveTest {
	private DocumentManager documentManager = new DocumentManager();
	private VersionsManager versionsManager = new VersionsManager();
	private CreateCommand createCommand = new CreateCommand(documentManager, versionsManager);
	private SaveCommand saveCommand = new SaveCommand(versionsManager);

	@Test
	public void test() {
		
		versionsManager.setType("articleTemplate");
		createCommand.execute();
		
		versionsManager.setFilename("test.tex");
		saveCommand.execute();
		
		String fileContents = "";
		try {
			fileContents = new String(Files.readAllBytes(Paths.get("test.tex")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fileContents = fileContents.trim();
		String actualContents = versionsManager.getCurrentDocument().getContents();
		assertEquals(actualContents, fileContents);
	}
	
}
