package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.commands.CreateCommand;
import controller.commands.EditCommand;
import controller.commands.EnableVersionsManagementCommand;
import controller.commands.RollbackToPreviousVersionCommand;
import model.DocumentManager;
import model.VersionsManager;
import model.strategies.StableVersionsStrategy;
import model.strategies.VersionsStrategy;
import model.strategies.VolatileVersionsStrategy;


public class RollbackToPreviousVersionTest {
	private DocumentManager documentManager = new DocumentManager();
	private VersionsManager versionsManager = new VersionsManager();
	private CreateCommand createCommand = new CreateCommand(documentManager, versionsManager);
	private EditCommand editCommand = new EditCommand(versionsManager);
	private EnableVersionsManagementCommand enableCommand = new EnableVersionsManagementCommand(versionsManager);
	private RollbackToPreviousVersionCommand rollback = new RollbackToPreviousVersionCommand(versionsManager);
	
	
	@Test
	public void testStable() {
		VersionsStrategy strategy = new StableVersionsStrategy();
		versionsManager.setStrategy(strategy);
		
		versionsManager.setType("articleTemplate");
		createCommand.execute();
		
		String actualContents = versionsManager.getCurrentDocument().getContents();
		
		strategy = new VolatileVersionsStrategy();
		versionsManager.setStrategy(strategy);
		enableCommand.execute();
		
		versionsManager.setText("test edit contents\n");
		editCommand.execute();
		
		rollback.execute();
		String contents = versionsManager.getCurrentDocument().getContents();
		
		assertEquals(contents, actualContents);
	}
}
