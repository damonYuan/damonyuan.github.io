package solution;

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Before
    public void setup() throws Exception {
        // This method will be called by JUnit _before_ execution of each test
        // Do whatever is needed to initialize the runtime environment for your tests
    }

    @Test
    public void testOne() {
        boolean result = true;
        // Base test case
        result &= Solution.optimalPath(new Integer[][]{
                {0,0,0,0,5},
                {0,1,1,1,0},
                {2,0,0,0,0}}) == 10;
        assertEquals(result, true);
    }

    @Test
    public void testTwo() {
        boolean result = true;
        // Base test case
        result &= Solution.optimalPath(new Integer[][]{
                {0,3,0,0,5},
                {0,1,1,1,7},
                {2,0,0,0,0}}) == 17;
        assertEquals(result, true);
    }

    @After
    public void tearDown() throws Exception {
        // This method will be called by JUnit _after_ execution of each test
        // Free resources allocated during the initialization or the tests themselves
    }
}