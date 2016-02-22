package ru.itis.inform;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListIteratorImplTest {

    LinkedList listik = new LinkedList();
    Rational number = new Rational(1, 3);
    Rational number1 = new Rational(1, 4);

    @Before
    public void setUp(){
        listik.iterator.hasNext();
        Node numberNode = new Node(number);
        listik.iterator.current = numberNode;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNext() throws Exception {
        listik.iterator.next();
    }

    @Test
    public void testPeekNext() throws Exception {
        java.lang.Object actual = listik.iterator.peekNext();

        Rational expected = number1;

        assertEquals(expected, actual);
    }
}