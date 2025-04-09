package leo.luz.com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import leo.luz.com.structures.Stack;

public class StackTest {
    private Stack<Integer> stack;

    @BeforeEach
    public void setup() {
        this.stack = new Stack<>(10);
        this.stack.push(1);
        this.stack.push(2);
        this.stack.push(3);
    }

    @Test
    public void shouldPushValue() {
        this.stack.push(4);

        assertEquals(4, this.stack.top());
    }

    @Test
    public void shouldPopValue() {
        assertEquals(3, this.stack.pop());
    }

    @Test
    public void shouldGetSize() {
        assertEquals(3, this.stack.size());
    }

    @Test
    public void shouldGetTop() {
        assertEquals(3, this.stack.top());
    }

    @Test
    public void shouldBeEmpty() {
        this.stack.pop();
        this.stack.pop();
        this.stack.pop();
        assertTrue(this.stack.isEmpty());
    }

    @Test
    public void shouldBeFull() {
        this.stack.push(1);
        this.stack.push(1);
        this.stack.push(1);
        this.stack.push(1);
        this.stack.push(1);
        this.stack.push(1);
        this.stack.push(1);
        assertTrue(this.stack.isFull());
    }

    @Test
    public void shouldThrowOnPopEmpty() {
        this.stack.pop();
        this.stack.pop();
        this.stack.pop();
        assertThrows(RuntimeException.class, () -> {
            this.stack.pop();
        });
    }

    @Test
    public void shouldThrowOnPushFull() {
        this.stack.push(1);
        this.stack.push(1);
        this.stack.push(1);
        this.stack.push(1);
        this.stack.push(1);
        this.stack.push(1);
        this.stack.push(1);
        assertThrows(RuntimeException.class, () -> {
            this.stack.push(1);
        });
    }

    @Test
    public void shouldThrowOnTopEmpty() {
        this.stack.pop();
        this.stack.pop();
        this.stack.pop();
        assertThrows(RuntimeException.class, () -> {
            this.stack.top();
        });
    }
}
