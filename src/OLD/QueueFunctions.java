package OLD;

public class QueueFunctions {
    public static Node<Integer> complementeryNode(Queue<Integer> q){
        Node<Integer> complementery = new Node<>(-1);
        Node<Integer> pointer = complementery;

        int head = q.remove();
        while(!q.isEmpty()){
            while (head != q.head() - 1){
                head++;

                pointer.setNext(new Node<>(head));
                pointer = pointer.getNext();
            }
            head = q.remove();
        }
        return complementery.getNext();
    }

    public static Stack<Node<Integer>> complementeryStack (Stack<Queue<Integer>> sq){
        Stack<Node<Integer>> sl = new Stack<>();

        while(!sq.isEmpty()){
            sl.push(complementeryNode(sq.pop()));
        }

        Stack<Node<Integer>> sl_final = new Stack<>();
        StackFunctions.pourBtoA(sl_final, sl);
        return sl_final;
    }

    public static <T>void what(Queue<T> qu, T x){
        Stack<T> temp = new Stack<>();

        while(!qu.isEmpty()){
            if(!qu.head().equals(x))
                temp.push(qu.head());
            qu.remove();
        }

        Stack<T> sl_final = new Stack<>();
        StackFunctions.pourBtoA(sl_final, temp);

        while(!sl_final.isEmpty()){
            qu.insert(sl_final.pop());
        }
    }

    public static int print(Queue<Queue<Integer>> q, Stack<Integer> s){
        if(q.isEmpty())
            return 0;
        Queue<Integer> q2 = q.remove();
        s.push(q2.remove());
        if(!q2.isEmpty()){
            q.insert(q2);
        }
        return print(q,s) + 1;
    }

    public static String minPriority(Queue<Integer> q){
        return "";
    }
}
