package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.commands.CreateCommand;
import controller.commands.DisableVersionsManagementCommand;
import controller.commands.EditCommand;
import model.DocumentManager;
import model.VersionsManager;
import model.strategies.VersionsStrategy;
import model.strategies.VolatileVersionsStrategy;

public class DisableVersionsManagementTest {
	private DocumentManager documentManager = new DocumentManager();
	private VersionsManager versionsManager = new VersionsManager();
	private CreateCommand createCommand = new CreateCommand(documentManager, versionsManager);
	private EditCommand editCommand = new EditCommand(versionsManager);
	private DisableVersionsManagementCommand disableCommand = new DisableVersionsManagementCommand(versionsManager);

	@Test
	public void testVolatile() {
		
		versionsManager.setType("articleTemplate");
		createCommand.execute();
		VersionsStrategy strategy = new VolatileVersionsStrategy();
		versionsManager.setStrategy(strategy);
		
		disableCommand.execute();
		versionsManager.setText("test edit contents\n");
		editCommand.execute();
		
		assertEquals(versionsManager.isEnabled(), false);
		assertEquals(versionsManager.getStrategy().getEntireHistory().size(), 0);
	}
}
