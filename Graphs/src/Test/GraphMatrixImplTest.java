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

    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testAddEdge() throws Exception{
        graph.addEdge(1, 2 , 5);                               //тест рухнет
    }

}