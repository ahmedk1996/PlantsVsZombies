package Tests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
/**
 *  The AllTests all the test classes at once for efficiency and to easily evaluate our program.
 * 
 * @author Group 1
 * @since November 22,2018

 */
public class AllTests extends TestCase {

 public static void main(String[] args) {
 junit.textui.TestRunner.run(AllTests.class);
 }
 
 public static Test suite() {
 TestSuite suite = new TestSuite("Test for com.saorsa.nowplaying.tests");
 suite.addTest(new TestSuite(ActionTest.class));
 suite.addTest(new TestSuite(GameTest.class));
 suite.addTest(new TestSuite(LayoutTest.class));
 suite.addTest(new TestSuite(PlantStoreTest.class));
 suite.addTest(new TestSuite(ShootingPlantTest.class));
 suite.addTest(new TestSuite(SunflowerTest.class));
 suite.addTest(new TestSuite(RugbyZombieTest.class));
 suite.addTest(new TestSuite(SprintZombieTest.class));
 suite.addTest(new TestSuite(ChomperTest.class));
 suite.addTest(new TestSuite(PotatoMineTest.class));
 suite.addTest(new TestSuite(WalkingZombieTest.class));
 return suite;
 }
}