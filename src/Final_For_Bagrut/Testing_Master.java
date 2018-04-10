package Final_For_Bagrut;

import Final_For_Bagrut.Node.Node;

public class Testing_Master {
    public static void main (String[] args){
        Node<Integer> lst = new Node<>(5, new Node<>(19));
        System.out.println(lst);
        test(lst);

        System.out.println(lst);
    }

    public static void test(Node<Integer> lst){
        lst = lst.getNext();
        lst = lst.getNext();
    }
}
