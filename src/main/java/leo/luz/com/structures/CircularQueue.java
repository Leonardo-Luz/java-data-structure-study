package leo.luz.com.structures;

@SuppressWarnings("unchecked")
public class CircularQueue<T> {
    private int size;
    private int qty;
    private int lead;
    private int tail;
    private T[] list;

    public CircularQueue(int size) {
        this.size = size;
        this.qty = 0;
        this.lead = -1;
        this.tail = -1;

        this.list = (T[]) new Object[size];
    }

    public void enqueue(T value) {
        if (this.isFull()) {
            throw new RuntimeException("Queue is full");
        }

        this.tail++;

        if (this.tail == this.size) {
            this.tail = 0;
        }

        this.list[this.tail] = value;
        this.qty++;
    }

    public T dequeue() {
        if (this.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        this.lead++;

        if (this.lead == this.size) {
            this.lead = 0;
        }

        this.qty--;

        return this.list[this.lead];
    }

    public T peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return this.list[0];
    }

    public int size() {
        return qty;
    }

    public boolean isFull() {
        return this.qty == this.size;
    }

    public boolean isEmpty() {
        return this.qty == 0;
    }
}
