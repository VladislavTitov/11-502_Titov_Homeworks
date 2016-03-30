import org.junit.Before;

import static org.junit.Assert.*;

public class BinarySearchTreeImplTest {

    @Before
    public void setUp() throws Exception{
        boolean searchTreeTest = true;
        Node rootTest = new Node(10);
        rootTest.setLeft(new Node(12));
        rootTest.setRight(new Node(9));

    }

    @org.junit.Test
    public void testIsSearchTreePrint() throws Exception {

    }
}