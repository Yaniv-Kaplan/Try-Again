public class RecursiveFunctions {
    public static int sumOfIntegerStack(Stack<Integer> s){
        if (s.isEmpty())
            return 0;
        int x = s.pop();
        int val = x + sumOfIntegerStack(s);
        s.push(x);
        return val;
    }

    public static void printNto1(int n){
        if (n > 0){
            System.out.print(n + " ");
            printNto1(n-1);
        }
    }

    public static boolean inArray(int[] arr, int value, int n){
        if (n < 0)
            return false;
        return (arr[n] == value || inArray(arr, value, n-1));
    }

    public static int maxVal(int[] arr, int n){
        if (n < 0)
            return arr[0];
        return Math.max(arr[n], maxVal(arr, n-1));
    }

    public static int fibAtN(int n){
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fibAtN(n-1)+ fibAtN(n-2);
    }

    public static int lowestCD (int n1, int n2){
        if (n1 > n2)
            return lowestCD(n1, n2, n1);
        return lowestCD(n2, n1, n2);
    }

    public static int lowestCD(int n1, int n2, int bigger){
        if (n1 % n2 == 0)
            return n1;
        return lowestCD(n1 + bigger, n2, bigger);
    }

}