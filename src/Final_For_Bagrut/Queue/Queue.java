package Final_For_Bagrut.Queue;
import Final_For_Bagrut.Node.Node;

public class Queue<T> {
    private Node<T> first;
    private Node<T> last;

    public Queue(){
        this.first = null;
        this.last = null;
    }

    public void insert(T x){
        Node<T> temp = new Node<T>(x);
        if (first == null)
            first = temp;
        else
            last.setNext(temp);
        last = temp;
    }

    public T remove(){
        T x = first.getValue();
        first = first.getNext();
        if(first == null)
            last = null;
        return x;
    }

    public T head(){
        return first.getValue();
    }

    public boolean isEmpty(){
        return first == null;
    }

    public String toString(){
        if (this.isEmpty()) return "[]";
        this.insert(null);
        String s = "[";
        T temp = this.remove();
        while(temp != null){
            s = s + temp + ",";
            this.insert(temp);
            temp = this.remove();
        }
        s = s.substring(0, s.length()-1) + "]";
        return s;
    }
}
