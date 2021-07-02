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
    public void fibonacci() {
        long result = Solution.fibonacci(5);
        assertEquals(result, 5);
    }

    @Test
    public void dpFibonacci() {
        long result = Solution.dpFibonacci(6);
        assertEquals(result, 8);
    }

    @After
    public void tearDown() throws Exception {
        // This method will be called by JUnit _after_ execution of each test
        // Free resources allocated during the initialization or the tests themselves
    }
}