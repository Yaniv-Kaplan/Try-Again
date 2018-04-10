package Final_For_Bagrut.Node;

import Final_For_Bagrut.Recurstion.Recursion;

public class NodeFunctions {

    //recursively scan Node
    public static int equalSum(Node<Integer> ls, int sum){
        int c = 0;
        if (ls == null)
            return 0;

        if(Recursion.sumDigits(ls.getValue()) == sum)
            c = 1;

        return c + equalSum(ls.getNext(), sum);
    }

    //remove all even
    public static Node<Integer> removeEven(Node<Integer> ls){
        while(ls != null && ls.getValue() % 2 == 0)
            ls = ls.getNext();

        Node<Integer> pointer = ls;
        while(pointer != null && pointer.getNext() != null ){
            if (pointer.getNext().getValue() % 2 == 0){
                pointer.setNext(pointer.getNext().getNext());
            }
            else{
                pointer = pointer.getNext();
            }
        }
        return ls;
    }

    //flip
    public static<T> Node<T> reverse(Node<T> ls){
        Node<T> p = ls;
        Node<T> n = null;

        while(p != null){
            n = new Node<>(p.getValue(), n);
            p = p.getNext();
        }
        return n;
    }

    //remove value n from chain
    public static<T> Node<T> removeN(Node<T> ls, T value){
        Node<T> p = ls;

        while(ls != null && ls.getValue().equals(value)) {
            ls = ls.getNext();
        }

        while(p != null && p.getNext() != null){
            if (p.getNext().getValue().equals(value))
                p.setNext(p.getNext().getNext());
            else
                p = p.getNext();
        }

        return ls;
    }

    //easy way to create node -> uses reverse function.
    public static<T> Node<T> create(T[] values){
        Node<T> t = null;
        for (T value : values){
            t = new Node<>(value, t);
        }

        return NodeFunctions.reverse(t);
    }

    public static int howManyNum(Node<Integer> ls, int num){
        int c = 0;
        if(ls == null)
            return 0;
        if(ls.getValue() == num)
            c = 1;
        return c + howManyNum(ls.getNext(), num);
    }

}
