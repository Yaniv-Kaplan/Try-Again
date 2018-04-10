package Final_For_Bagrut.Recurstion;

public class Recursion {

    /**
     * draws a symmetric arrow with "true"s in a 2 dimensional boolean array
     * @param locations the array
     * @param headRow the Row from which the arrow should start
     * @param headCol the Column from which the arrow should start
     * @param offset used internally, set to 0 when calling function
     * @return the number of places set to "true"
     *
     * answer to question 3 page 49 in book "Hachana Lebagrut".
     */
    public static int arrow(Boolean[][] locations, int headRow, int headCol, int offset){

        if (headRow + offset > locations.length || headCol + offset >= locations[0].length || headCol - offset < 0){
            return 1;
        }

        locations[headRow+offset][headCol+offset] = true;
        locations[headRow+offset][headCol-offset] = true;

        return 2 + arrow(locations, headRow, headCol, offset+1);
    }

    public static boolean arrowIsPossible(Boolean[][] locations, int headRow, int headCol, int offset){

        if (headRow + offset > locations.length || headCol + offset >= locations[0].length || headCol - offset < 0)
            return true;

        return (locations[headRow+offset][headCol+offset] == false && locations[headRow+offset][headCol-offset] == false)
                && arrowIsPossible(locations, headRow, headCol, offset+1);
    }

    /**
     * x to the power of y
     * @param x
     * @param y
     * @return x to the power of y
     */
    public static int pow(int x, int y){
        if (y == 1)
            return x;
        return x*pow(x, y-1);
    }

    /**
     * Multiplication
     * @param x
     * @param y
     * @return x times y
     */
    public static int multiply(int x, int y){
        if(y==1)
            return x;
        return x + multiply(x, y-1);
    }

    /**
     * Print all numbers from x to y, in ascending order (inclusive)
     * @param x
     * @param y
     */
    public static void printXtoY(int x, int y){
        if (x != y+1) {
            System.out.print(x);
            printXtoY(x+1, y);
        }
    }

    /**
     * Find max in array
     * @param x start index
     * @param y end index
     * @param array array to search in
     * @return the maximum value between the two indexes
     */
    public static int maxBetween(int[] array, int x, int y){
        if (x == y)
            return array[x];
        return Math.max(array[x], maxBetween(array, x+1, y));
    }

    /**
     * fibonacci
     * @param n location
     * @return fibonacci at location n
     */
    public static int fibAtN(int n){
        if (n == 0 || n == 1)
            return n;
        return fibAtN(n-1)+fibAtN(n-2);
    }

    /**
     * find the lowest common denominator of the numbers x and y
     * @param x is always the lowest number
     * @param y is always the higher number
     * @param lower the lowest of the two (x)
     * @return lowest common denominator
     */
    public static int lowestCommmonDenominator(int x, int y, int lower){
        if (x%y == 0)
            return x;
        return lowestCommmonDenominator(x+lower, y, lower);
    }

    //all even or all odd
    public static boolean allEven(int x){
        if (x < 10)
            return x%2 == 0;
        return x%2 == 0 && allEven((x/10));
    }
    public static boolean allOdd(int x){
        if (x < 10)
            return x%2 != 0;
        return x%2 == 1 && allOdd(x/10);
    }
    public static boolean allEvenOrAllOdd(int x){
        if (x%2 == 0)
            return allEven(x);
        else
            return allOdd(x);
    }

    //isPrime
    public static boolean isPrime(int x, int curr){
        if (curr == (x/2) + 1)
            return true;
        return x%curr != 0 && isPrime(x, curr+1);
    }

    //like fibonacci but not
    public static double notFib(int n){
        if (n == 0 || n == 1)
            return n;
        return Math.pow(notFib(n-1),2) + Math.pow(notFib(n-2), 2);
    }
    public static double sumNotFib(int n){
        if (n == 0 || n == 1)
            return n;
        return notFib(n) + sumNotFib(n-1);
    }

    //
    public static int timesIn2DArray(int[][] array, int row, int num){
        int c = 0;
        if (row < 0)
            return 0;
        if (isInArray(array[row], 0, num))
            c = 1;
        return c + timesIn2DArray(array, row-1, num);
    }
    public static boolean isInArray(int[] array, int col, int num){
        if (col > array.length-1)
            return false;
        return array[col] == num || isInArray(array, col+1, num);
    }

    public static int sumDigits(int x){
        if (x<10)
            return x;
        return x%10 + sumDigits(x/10);
    }






    /**
     * Prints 2 dimensional array
     * @param array array to print
     * @param row row from which to start printing
     * @param col column from which to start printing
     * @param <T> type of elements in the array
     */
    public static<T> void print2D(T[][] array, int row, int col){
        if (col < array[row].length){
            System.out.print(array[row][col] + " ");
            print2D(array, row, col+1);
        }
        else if (row < array.length-1){
            System.out.println();
            print2D(array, row+1, 0);
        }
    }

    /**
     * Set cells of a 2D array to false
     * @param array
     * @param row
     * @param col
     */
    public static void initialize2DBool(Boolean[][] array, int row, int col){
        if (col < array[row].length){
            array[row][col] = false;
            initialize2DBool(array, row, col+1);
        }
        else if (row < array.length-1){
            initialize2DBool(array, row+1, 0);
        }
    }
}
