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
    public void justAnExample() {
        Solution s = new Solution();
        int[] input_one = {1, 2, 3};
        assertEquals(s.rob(input_one), 4);
        int[] input_two = {1, 3, 1};
        assertEquals(s.rob(input_two), 3);
    }

    @After
    public void tearDown() throws Exception {
        // This method will be called by JUnit _after_ execution of each test
        // Free resources allocated during the initialization or the tests themselves
    }
}