package Test;

import org.junit.Test;
import ru.itis.inform.GraphMatrixImpl;

import static org.junit.Assert.*;

public class GraphMatrixImplTest {
    private GraphMatrixImpl graph;

    @org.junit.Before
    public void setUp() throws Exception{
        this.graph = new GraphMatrixImpl();
        this.graph.points = 2;
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testAddEdge() throws Exception{
        graph.addEdge(4, 3 , 5);
    }

}