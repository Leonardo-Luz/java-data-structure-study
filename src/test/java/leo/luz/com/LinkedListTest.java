package leo.luz.com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import leo.luz.com.structures.LinkedList;

public class LinkedListTest {

    private LinkedList<Integer> list;

    @BeforeEach
    public void setup() {
        this.list = new LinkedList<>();
        this.list.insert(9);
        this.list.insert(7);
        this.list.insert(5);
    }

    @Test
    public void shouldInsertFirst() {
        this.list.insert(4);
        assertEquals(4, this.list.getHead());
    }

    @Test
    public void shouldInsertLast() {
        this.list.balancedInsert(10);
        assertEquals(10, this.list.getTail());
    }

    @Test
    public void shouldBalancedInsert() {
        this.list.balancedInsert(8);
        assertEquals(8, this.list.get((int) 2));
    }

    @Test
    public void shouldInsertInIndex() {
        this.list.insert(4, 1);
        assertEquals(4, this.list.get((int) 1));
    }

    @Test
    public void shouldRemove() {
        assertEquals(7, this.list.remove(7));
    }

    @Test
    public void shouldGetSize() {
        assertEquals(3, this.list.getQty());
    }

    @Test
    public void shouldGetFirst() {
        assertEquals(5, this.list.get(0));
    }
}
