package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.commands.ChangeVersionsStrategyCommand;
import model.VersionsManager;
import model.strategies.StableVersionsStrategy;
import model.strategies.VersionsStrategy;
import model.strategies.VolatileVersionsStrategy;


public class ChangeVersionsStrategyTest {
	private VersionsManager versionsManager = new VersionsManager();
	private ChangeVersionsStrategyCommand changeCommand = new ChangeVersionsStrategyCommand(versionsManager);
	
	@Test
	public void testVolatile() {
		VersionsStrategy strategy = new StableVersionsStrategy();
		
		versionsManager.setType("articleTemplate");
		versionsManager.setStrategy(strategy);
		changeCommand.execute();
		
		String status = "pass";
		if(versionsManager.getStrategy() instanceof StableVersionsStrategy)
			status = "fail";
		
		assertEquals("pass", status);
	}
	
	@Test
	public void testStable() {
		VersionsStrategy strategy = new VolatileVersionsStrategy();
		
		versionsManager.setType("articleTemplate");
		versionsManager.setStrategy(strategy);
		changeCommand.execute();
		
		String status = "pass";
		if(versionsManager.getStrategy() instanceof VolatileVersionsStrategy)
			status = "fail";
		
		assertEquals("pass", status);
	}
		
}
