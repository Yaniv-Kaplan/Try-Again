package Final_For_Bagrut.Stack;
import Final_For_Bagrut.Node.Node;

public class Stack<T> {
    //added .equals


    private Node<T> head;

    public Stack() {
        this.head = null;
    }

    public void push(T x) {
        Node<T> temp = new Node<T>(x);
        temp.setNext(head);
        head = temp;
    }

    public T pop() {
        T x = head.getValue();
        head = head.getNext();
        return x;
    }

    public T top() {
        return head.getValue();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String toString() {
        if(this.isEmpty()) return "[]";

        Stack<T> temp = new Stack<T>();
        while(!this.isEmpty())
            temp.push(this.pop());
        String s = "[";
        while(!temp.isEmpty()) {
            s = s + temp.top() + ',';
            this.push(temp.pop());
        }
        s = s.substring(0,s.length()-1 ) + "]";
        return s;
    }

    //recursive is equals
    public boolean equals(Stack<T> s2){
        if (this.isEmpty() && s2.isEmpty())
            return true;
        else if (this.isEmpty() && !s2.isEmpty() || !this.isEmpty() && s2.isEmpty())
            return false;

        boolean b = false;
        T t1 = this.pop();
        T t2 = s2.pop();

        if (t1.equals(t2)){
            b = this.equals(s2);
        }
        this.push(t1);
        s2.push(t2);

        return b;
    }
}
