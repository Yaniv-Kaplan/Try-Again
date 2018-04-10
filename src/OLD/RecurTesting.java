package OLD;

public class RecurTesting {
    public static void main (String[] args){
        Stack<Integer> s = new Stack<>();
        s.push(2);
        s.push(3);
        s.push(5);
        s.push(-1);
        s.push(13);
        s.push(28);

        System.out.println(s);

        System.out.println(RecursiveFunctions.sumOfIntegerStack(s));
        System.out.println(s);
        RecursiveFunctions.printNto1(10);
        System.out.println();
        int[] arr = {1,3,7,-7,9,3};
        System.out.println(RecursiveFunctions.maxVal(arr, 4));
        System.out.println();
        System.out.println(RecursiveFunctions.fibAtN(8));
        System.out.println();
        System.out.println(RecursiveFunctions.lowestCD(15, 10));
        System.out.println();

    }
}
