package leo.luz.com.structures;

/**
 * Node
 */
class Node<T> {
    public T value;
    public Node<T> next;

    Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }
}

/**
 * LinkedList
 */
public class LinkedList<T> {
    private int qty;
    private Node<T> head;
    private Node<T> tail;

    public LinkedList() {
        this.qty = 0;
        this.head = null;
        this.tail = null;
    }

    public void insert(T value) {
        this.qty++;

        Node<T> newNode = new Node<>(value, null);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            Node<T> temp = this.head;
            this.head = newNode;
            newNode.next = temp;
        }
    }

    public void insert(T value, int position) {
        Node<T> current = this.head;
        Node<T> ant = null;
        int count = 0;
        while (current != null && current.next != null && position != count) {
            ant = current;
            current = current.next;
            count++;
        }

        if (this.head == null) {
            Node<T> node = new Node<>(value, null);
            this.head = node;
            this.tail = node;
            this.qty++;
        } else if (ant == null) {
            insert(value);
        } else if (position == count) {
            Node<T> node = new Node<>(value, current);
            ant.next = node;
            this.qty++;
        } else if (current.next == null) {
            Node<T> node = new Node<>(value, null);
            this.tail = node;
            current.next = tail;
            this.qty++;
        }
    }

    public void balancedInsert(T value) {
        Node<T> current = this.head;
        Node<T> ant = null;
        while (current != null && current.next != null && (int) value > (int) current.value) {
            ant = current;
            current = current.next;
        }

        if (this.head == null) {
            Node<T> node = new Node<>(value, null);
            this.head = node;
            this.tail = node;
            this.qty++;
        } else if (ant == null) {
            insert(value);
        } else if ((int) value <= (int) current.value) {
            Node<T> node = new Node<>(value, current);
            ant.next = node;
            this.qty++;
        } else if (current.next == null) {
            Node<T> node = new Node<>(value, null);
            this.tail = node;
            current.next = tail;
            this.qty++;
        }
    }

    public T get(T value) {
        Node<T> current = this.head;
        while (current != null && current.next != null && current.value != value) {
            current = current.next;
        }

        if (current.value == value) return current.value;

        return null;
    }

    public T get(int index) {
        Node<T> current = this.head;
        int count = 0;
        while (current != null && current.next != null && count != index) {
            current = current.next;
            count++;
        }

        System.out.println(this.toString());

        if (count == index) return current.value;

        return null;
    }

    public T remove(T value) {
        Node<T> current = this.head;
        Node<T> ant = null;
        while (current != null && current.next != null && current.value != value) {
            ant = current;
            current = current.next;
        }

        if (current.value == value) {
            this.qty--;
            ant.next = current.next;
            return current.value;
        }

        return null;
    }

    public int getQty() {
            return qty;
    }

    public T getHead() {
            return head.value;
    }

    public T getTail() {
            return tail.value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("LinkedList{qty=");
        sb.append(qty);
        sb.append(", head=");
        sb.append(head.value);
        sb.append(", tail=");
        sb.append(tail.value);
        sb.append(", nodes=[");

        Node<T> current = head;
        while (current != null) {
            sb.append(current.value);
            current = current.next;
            if (current != null) {
                sb.append(", ");
            }
        }
        sb.append("]}");
        return sb.toString();
    }
}
