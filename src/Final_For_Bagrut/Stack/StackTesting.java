package Final_For_Bagrut.Stack;

public class StackTesting {
    public static void main(String[] args){
        Stack<Integer> s1 = new Stack<>();
        s1.push(1);
        s1.push(3);
        s1.push(41);
        s1.push(5);
        s1.push(6);

        Stack<Integer> s2 = new Stack<>();
        s2.push(1);
        s2.push(3);
        s2.push(4);
        s2.push(5);
        s2.push(6);

        System.out.println(s1.equals(s2));
        System.out.println(s1);
        System.out.println(s2);
    }
}
