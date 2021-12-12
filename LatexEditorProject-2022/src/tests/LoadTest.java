package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.Scanner;

import controller.commands.CreateCommand;
import controller.commands.LoadCommand;
import model.DocumentManager;
import model.VersionsManager;

public class LoadTest {
	private DocumentManager documentManager = new DocumentManager();
	private VersionsManager versionsManager = new VersionsManager();
	private CreateCommand createCommand = new CreateCommand(documentManager, versionsManager);
	private LoadCommand loadCommand = new LoadCommand(versionsManager);

	@Test
	public void test() {
		versionsManager.setType("articleTemplate");
		createCommand.execute();
		
		versionsManager.setFilename("test.tex");
		loadCommand.execute();
		
		String fileContents = "";
		try {
			Scanner scanner = new Scanner(new FileInputStream("test.tex"));
			while(scanner.hasNextLine()) {
				fileContents = fileContents + scanner.nextLine() + "\n";
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fileContents = fileContents.trim();
		
		String actualContents = versionsManager.getCurrentDocument().getContents();
		actualContents = actualContents.trim();
		
		assertEquals(fileContents, actualContents);
	}

}
