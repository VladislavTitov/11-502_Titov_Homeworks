package Test;

import org.junit.Before;
import org.junit.Test;
import ru.itis.inform.GraphMatrixImpl;

import static org.junit.Assert.*;

public class GraphMatrixImplTest {
    private GraphMatrixImpl graph;

    @Before
    public void setUp() throws Exception{
        this.graph = new GraphMatrixImpl();

        graph.addPoint();
        graph.addPoint();
        graph.addPoint();
        graph.addPoint();

        graph.addDirectedEdge(0, 1, 3);
        graph.addDirectedEdge(1, 2, 2);
        graph.addDirectedEdge(0, 2, 300);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testAddEdge() throws Exception{
        graph.addEdge(1, 3 , 5);                               //тест рухнет
    }

    @Test

    public void testRunFloyd() {
        int[][] actual = new int[15][15];
        int[][] expected = new int[15][15];
        graph.runFloyd(4);
        actual = graph.dMatrix;

        assertEquals(expected, actual);

    }
}