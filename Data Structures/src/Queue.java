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

    public int length(){
        int counter = 0;
        Queue<T> q = new Queue<T>();
        while(!this.isEmpty()){
            counter++;
            q.insert(this.remove());
        }
        while(!q.isEmpty())
            this.insert(q.remove());

        return counter;
    }

    public boolean present(T x){
        boolean found = false;
        Queue<T> temp = new Queue<>();

        while (!this.isEmpty()){
            if (this.head().equals(x))
                found = true;
            temp.insert(this.remove());
        }
        while (!temp.isEmpty()) {
            this.insert(temp.remove());
        }
        return found;
    }
}
