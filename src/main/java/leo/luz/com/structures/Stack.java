package leo.luz.com.structures;

@SuppressWarnings("unchecked")
public class Stack<T> {
    private int size;
    private int qty;
    private T[] list;

    public Stack(int size){
        this.size = size;
        this.qty = 0;

        this.list = (T[]) new Object[size];
    }

    public void push(T element){
        if (this.isFull()) {
            throw new RuntimeException("Stack is full");
        }

        this.list[this.qty] = element;
        qty++;
    }

    public T pop(){
        if (this.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        qty--;
        return this.list[this.qty];
    }

    public T top(){
        if (this.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return this.list[this.qty-1];
    }

    public boolean isEmpty(){
        return this.qty == 0;
    }

    public boolean isFull(){
        return this.qty == this.size;
    }

    public int getSize() {
        return size;
    }

    public int getQty() {
        return qty;
    }
}
