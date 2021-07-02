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
    public void testLis() {
        int result = Solution.lis(new int[] {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11,4,5,6, 7, 15, 8, 9});
        System.out.println(result);
        assertEquals(result, 9);
    }

    @After
    public void tearDown() throws Exception {
        // This method will be called by JUnit _after_ execution of each test
        // Free resources allocated during the initialization or the tests themselves
    }
}