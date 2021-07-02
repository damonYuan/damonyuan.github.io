package solution;

import org.junit.*;
import static org.junit.Assert.assertArrayEquals;

public class MainTest {

    @Before
    public void setup() throws Exception {
        // This method will be called by JUnit _before_ execution of each test
        // Do whatever is needed to initialize the runtime environment for your tests
    }

    @Test
    public void solutionTest() {
        int[] input = new int[] {1, 2, 3, 4};
        int[] result = Solution.productExceptSelf(input);
        assertArrayEquals(result, new int[] {24, 12, 8, 6});
    }

    @After
    public void tearDown() throws Exception {
        // This method will be called by JUnit _after_ execution of each test
        // Free resources allocated during the initialization or the tests themselves
    }
}