import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestTest {

    @Test
    void add() {
        Request request = new Request();
        request.add(1, 1, 1);
        request.add(1, 1, 2);
        request.add(1, 2, 1);
        request.add(3, 1, 1);
        request.add(5, 2, 7);
        assertTrue(request.getOrdered().contains(3), "Array should contain number 1");
        assertTrue(request.getOrdered().contains(5), "Array should contain number 2");
        assertFalse(request.getOrdered().contains(1), "Array should not contain number 1");
        assertTrue(request.getSet().contains(3), "Set should contain number 1");
        assertTrue(request.getSet().contains(5), "Set should contain number 2");
        assertFalse(request.getSet().contains(1), "Set should not contain number 1");


    }

    @Test
    void getSize() {
        Request request = new Request();
        request.add(1, 1, 1);
        request.add(3, 1, 1);
        request.add(5, 2, 7);
        assertEquals(2, request.getSize(), "Wrong Size 1");
        request.add(4, 2, 7);
        request.add(18, 2, 7);
        assertEquals(4, request.getSize(), "Wrong Size 1");
        request.add(14, 2, 7);
        request.add(14, 2, 7);
        assertEquals(5, request.getSize(), "Wrong Size 1");
    }

    @Test
    void remove() {
        Request request = new Request();
        request.add(1, 1, 1);
        request.add(3, 1, 1);
        request.add(5, 2, 7);
        request.remove(4);
        assertEquals(2, request.getSize(), "Wrong Size 1");
        request.remove(5);
        assertEquals(1, request.getSize(), "Wrong Size 2");
        request.remove(3);
        assertEquals(0, request.getSize(), "Wrong Size 3");

    }

    @Test
    void pop() {
        Request request = new Request();
        request.add(1, 1, 1);
        request.add(3, 1, 1);
        request.add(5, 2, 7);
        assertEquals(3, request.pop(), "Wrong number given 1");
        assertEquals(5, request.pop(), "Wrong number given 2");
    }

    @Test
    void contains() {
        Request request = new Request();
        request.add(5, 1, 1);
        assertFalse(request.contains(1), "");
        assertTrue(request.contains(5));
        request.add(1, 1, 1);
        request.remove(5);
        assertFalse(request.contains(1));
        assertFalse(request.contains(5));
    }

    @Test
    void isEmpty() {
        Request request = new Request();
        assertTrue(request.isEmpty(), "Wrong answer 1");
        request.add(1, 2, 1);
        assertTrue(request.isEmpty(), "Wrong answer 2");
        request.add(1, 1, 2);
        assertTrue(request.isEmpty(), "Wrong answer 3");
        request.add(1, 5, 2);
        assertFalse(request.isEmpty(), "Wrong answer 4");
        request.remove(1);
        assertTrue(request.isEmpty(), "Wrong answer 5");
        request.remove(1);
        request.add(150, 5, 2);
        request.add(275, 5, 2);
        assertFalse(request.isEmpty(), "Wrong answer 7");
        request.remove(150);
        request.remove(275);
        assertTrue(request.isEmpty(), "Wrong answer 8");
    }
}