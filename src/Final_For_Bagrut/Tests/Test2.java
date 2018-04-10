package Final_For_Bagrut.Tests;

import OLD.*;

public class Test2 {
    public static void main (String[] args){
        //test4();
        //test6();
    }

    public static void test4(){
        Node<Integer> list = new Node<>(8, new Node<>(22, new Node<>(8, new Node<>(15))));
        Stack<Integer> stack = new Stack<>();
        stack.push(13);
        stack.push(22);
        stack.push(15);
        stack.push(20);
        stack.push(13);
        stack.push(15);

        System.out.println(timesIn(stack, list));

    }


    //4
    public static Queue<Integer> keepUnique(Queue<Integer> q){
        Queue<Integer> temp = new Queue<>();
        Queue<Integer> temp2 = new Queue<>();
        int current = 0;

        while(!q.isEmpty()){
            current = q.remove();
            temp2.insert(current);

            while (!q.isEmpty()){
                if(q.head() != current)
                    temp.insert(q.remove());
                else
                    q.remove();
            }
            while(!temp.isEmpty()){
                q.insert(temp.remove());
            }
        }
        return temp2;
    }
    public static Queue<Integer> allNums(Stack<Integer> stack, Node<Integer> list){
        Node<Integer> lP = list;

        Queue<Integer> numsToCheck = new Queue<>();

        Stack<Integer> temp = new Stack<>();
        while(!stack.isEmpty()){
            temp.push(stack.pop());
            numsToCheck.insert(temp.top());
        }
        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }

        while(lP != null){
            numsToCheck.insert(lP.getValue());
            lP = lP.getNext();
        }
        return numsToCheck;
    }
    public static Node<Item> timesIn(Stack<Integer> stack, Node<Integer> list){

        Node<Item> times = new Node<>();
        Queue<Integer> numsToCheck = new Queue<>();
        numsToCheck = keepUnique(allNums(stack, list));
        while (!numsToCheck.isEmpty()){
            times = new Node<>(Item.timesIn(list, stack, numsToCheck.remove()), times);
        }

        return times;
    }
    //and another function inside Item which really can be put here.


}

//4
class Item{
    private int Value;
    private int timesInList;
    private int timesInStack;

    public Item(int value, int timesInList, int timesInStack) {
        Value = value;
        this.timesInList = timesInList;
        this.timesInStack = timesInStack;
    }

    public int getValue() {
        return Value;
    }

    public void setValue(int value) {
        Value = value;
    }

    public int getTimesInList() {
        return timesInList;
    }

    public void setTimesInList(int timesInList) {
        this.timesInList = timesInList;
    }

    public int getTimesInStack() {
        return timesInStack;
    }

    public void setTimesInStack(int timesInStack) {
        this.timesInStack = timesInStack;
    }

    public static Item timesIn(Node<Integer> l, Stack<Integer> s, int num){
        int countS = 0, countL = 0;
        Stack<Integer> temp = new Stack<>();
        Node<Integer> p = l;

        while(!s.isEmpty()){
            temp.push(s.pop());
            if (temp.top() == num)
                    countS++;
        }
        while(!temp.isEmpty()){
            s.push(temp.pop());
        }

        while(p != null){
            if(p.getValue() == num)
                countL++;
            p = p.getNext();
        }

        return new Item(num, countL, countS);
    }

    public String toString(){
        return "Value: " + this.Value + ". Appears " + this.timesInList + " times in the node, and appears in the stack " + this.timesInStack + " times.";
    }


}
