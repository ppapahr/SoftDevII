package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.commands.CreateCommand;
import controller.commands.EditCommand;
import model.DocumentManager;
import model.VersionsManager;

public class EditTest {
	private DocumentManager documentManager = new DocumentManager();
	private VersionsManager versionsManager = new VersionsManager();
	private CreateCommand createCommand = new CreateCommand(documentManager, versionsManager);
	private EditCommand editCommand = new EditCommand(versionsManager);


	@Test
	public void test() {
		versionsManager.setType("articleTemplate");
		createCommand.execute();
		
		versionsManager.setText("test edit contents\n");
		editCommand.execute();
		String actualContents = versionsManager.getCurrentDocument().getContents();
		
		assertEquals("test edit contents\n", actualContents);
	}

}
