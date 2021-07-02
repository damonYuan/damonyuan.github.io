package solution;

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Before
    public void setup() throws Exception {
        // This method will be called by JUnit _before_ execution of each test
        // Do whatever is needed to initialize the runtime environment for your tests
    }

    @Test
    public void solutionTest() {
        Solution s = new Solution();
        assertEquals(10, s.subsequence(new int[] {4, 3, 1, 2, 5}));
    }

    @After
    public void tearDown() throws Exception {
        // This method will be called by JUnit _after_ execution of each test
        // Free resources allocated during the initialization or the tests themselves
    }
}