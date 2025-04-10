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
        this.lead = 0;
        this.tail = 0;

        this.list = (T[]) new Object[size];
    }

    public void enqueue(T value) {
        if (this.isFull()) {
            throw new RuntimeException("Queue is full");
        }

        this.list[this.tail] = value;

        this.tail = (this.tail + 1) % this.size;
        this.qty++;
    }

    public T dequeue() {
        if (this.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T remove = this.list[this.lead];

        this.lead = (this.lead++) % this.size;
        this.qty--;

        return remove;
    }

    public T peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return this.list[this.lead];
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
