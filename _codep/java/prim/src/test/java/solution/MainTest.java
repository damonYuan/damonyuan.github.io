package solution;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import java.util.*;
import java.lang.*;

public class MainTest {

    @Before
    public void setup() throws Exception {
        // This method will be called by JUnit _before_ execution of each test
        // Do whatever is needed to initialize the runtime environment for your tests
    }

    @Test
    public void testPrim() {
        int[][] graph = new int[][] {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}};
        PrimAlgorithm p = new PrimAlgorithm(graph);
        Set<Edge> mst = p.primMST();
        assertEquals(mst.contains(p.g.getEdge(0, 1)), true);
        assertEquals(mst.contains(p.g.getEdge(1, 2)), true);
        assertEquals(mst.contains(p.g.getEdge(0, 3)), true);
        assertEquals(mst.contains(p.g.getEdge(1, 4)), true);
        assertEquals(mst.size(), 4);
    }

    @After
    public void tearDown() throws Exception {
        // This method will be called by JUnit _after_ execution of each test
        // Free resources allocated during the initialization or the tests themselves
    }
}