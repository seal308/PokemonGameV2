package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.framework.TestCase;
import junit.framework.TestSuite;

@RunWith(Suite.class)
@SuiteClasses({ MoveGeneratorTest.class, MoveTest.class, PokemonTest.class, TypeEfficienciesTest.class,
		TrainerTest.class })

public class CombinedTests extends TestCase {

	static public TestSuite suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(MoveGeneratorTest.class);
		suite.addTestSuite(MoveTest.class);
		suite.addTestSuite(PokemonTest.class);
		suite.addTestSuite(TypeEfficienciesTest.class);
		suite.addTestSuite(TrainerTest.class);
		return suite;
	}

}
