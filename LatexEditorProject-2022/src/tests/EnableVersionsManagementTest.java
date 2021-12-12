package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.commands.CreateCommand;
import controller.commands.EditCommand;
import controller.commands.EnableVersionsManagementCommand;
import model.DocumentManager;
import model.VersionsManager;
import model.strategies.VersionsStrategy;
import model.strategies.VolatileVersionsStrategy;;

public class EnableVersionsManagementTest {
	private DocumentManager documentManager = new DocumentManager();
	private VersionsManager versionsManager = new VersionsManager();
	private CreateCommand createCommand = new CreateCommand(documentManager, versionsManager);
	private EditCommand editCommand = new EditCommand(versionsManager);
	private EnableVersionsManagementCommand enableCommand = new EnableVersionsManagementCommand(versionsManager);

	@Test
	public void test() {
		versionsManager.setType("articleTemplate");
		createCommand.execute();
		
		String actualContents = versionsManager.getCurrentDocument().getContents();
		
		VersionsStrategy strategy = new VolatileVersionsStrategy();
		versionsManager.setStrategy(strategy);
		enableCommand.execute();
		versionsManager.setText("test edit contents\n");
		editCommand.execute();
		
		String contents = versionsManager.getStrategy().getVersion().getContents();
		
		assertEquals(contents, actualContents);
	}
}
