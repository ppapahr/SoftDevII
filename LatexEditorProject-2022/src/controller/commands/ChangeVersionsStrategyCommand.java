package controller.commands;

import model.VersionsManager;
import model.strategies.StableVersionsStrategy;
import model.strategies.VersionsStrategy;
import model.strategies.VolatileVersionsStrategy;

public class ChangeVersionsStrategyCommand extends CommandTemplate {
	
	public ChangeVersionsStrategyCommand(VersionsManager versionsManager) {
		super(versionsManager);
	}

	@Override
	public void execute() {
		if(versionsManager.getStrategy() instanceof VolatileVersionsStrategy) {
			VersionsStrategy newStrategy = new StableVersionsStrategy();
			newStrategy.setEntireHistory(versionsManager.getStrategy().getEntireHistory());
			versionsManager.setStrategy(newStrategy);
			versionsManager.enable();
		}
		else if(versionsManager.getStrategy() instanceof StableVersionsStrategy) {
			VersionsStrategy newStrategy = new VolatileVersionsStrategy();
			newStrategy.setEntireHistory(versionsManager.getStrategy().getEntireHistory());
			versionsManager.setStrategy(newStrategy);
			versionsManager.enable();
		}
	}

}
