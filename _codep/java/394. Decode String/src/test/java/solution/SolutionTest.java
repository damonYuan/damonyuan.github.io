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
//        assertEquals("aaabcbc", s.decodeString("3[a]2[bc]"));
//        assertEquals("accaccacc", s.decodeString("3[a2[c]]"));

//        assertEquals("abcabccdcdcdef", s.decodeString("2[abc]3[cd]ef"));
        assertEquals("aaabFFFFcbFFFFc", s.decodeString("3[a]2[b4[F]c]"));
        assertEquals("abc", s.decodeString("abc"));
    }

    @After
    public void tearDown() throws Exception {
        // This method will be called by JUnit _after_ execution of each test
        // Free resources allocated during the initialization or the tests themselves
    }
}