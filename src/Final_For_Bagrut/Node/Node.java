package Final_For_Bagrut.Node;
public class Node<T> {

    T value;
    Node<T> next;

    //C'tors
    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public Node(T value) {
        this.value = value;
    }

    public Node(Node<T> next) {
        this.next = next;
    }

    public Node() {

    }

    //Getters
    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

    //Setters
    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public boolean isEmpty() {
        return this != null;
    }

    public String toString() {
        if(this.next != null)
            return this.value + " ---> " + this.next;
        else
            return ""+this.value;
    }
}
