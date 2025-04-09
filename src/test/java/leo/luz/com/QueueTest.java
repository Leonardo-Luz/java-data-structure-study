package leo.luz.com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import leo.luz.com.structures.Queue;

public class QueueTest {
    private Queue<Integer> queue;

    @BeforeEach
    public void setup() {
        this.queue = new Queue<>(5);
        this.queue.enqueue(1);
        this.queue.enqueue(2);
        this.queue.enqueue(3);
    }

    @Test
    public void shouldEnqueue() {
        this.queue.enqueue(4);
        assertEquals(4, this.queue.size());
    }

    @Test
    public void shouldDequeue() {
        assertEquals(1, this.queue.dequeue());
    }

    @Test
    public void shouldGetSize() {
        assertEquals(3, this.queue.size());
    }

    @Test
    public void shouldPeek() {
        assertEquals(1, this.queue.peek());
    }

    @Test
    public void shouldBeFull() {
        this.queue.enqueue(4);
        this.queue.enqueue(5);
        assertTrue(this.queue.isFull());
    }

    @Test
    public void shouldBeEmpty() {
        this.queue.dequeue();
        this.queue.dequeue();
        this.queue.dequeue();
        assertTrue(this.queue.isEmpty());
    }

    @Test
    public void shouldThrowOnEnqueue() {
        this.queue.enqueue(4);
        this.queue.enqueue(5);
        assertThrows(RuntimeException.class, () -> {
            this.queue.enqueue(6);
        });
    }

    @Test
    public void shouldThrowOnDequeue() {
        this.queue.dequeue();
        this.queue.dequeue();
        this.queue.dequeue();
        assertThrows(RuntimeException.class, () -> {
            this.queue.dequeue();
        });
    }
}
