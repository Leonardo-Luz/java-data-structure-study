package leo.luz.com.structures;

@SuppressWarnings("unchecked")
public class Queue<T> {
    private int size;
    private int qty;
    private T[] list;

    public Queue(int size) {
        this.size = size;
        this.qty = 0;

        this.list = (T[]) new Object[size];
    }

    public void enqueue(T value) {
        if (this.isFull()) {
            throw new RuntimeException("Queue is full");
        }

        this.list[this.qty] = value;
        this.qty++;
    }

    public T dequeue() {
        if (this.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        T value = this.list[0];

        for (int i = 1; i < this.qty; i++) {
            list[i - 1] = list[i];
        }

        this.qty--;

        return value;
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
