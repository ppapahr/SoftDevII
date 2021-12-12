package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ChangeVersionsStrategyTest.class, CreateTest.class, DisableVersionsManagementTest.class, EditTest.class,
		EnableVersionsManagementTest.class, LoadTest.class, RollbackToPreviousVersionTest.class, SaveTest.class })
public class AllTests {

}
