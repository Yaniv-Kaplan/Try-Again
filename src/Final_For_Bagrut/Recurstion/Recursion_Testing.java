package Final_For_Bagrut.Recurstion;

public class Recursion_Testing {
    public static void main(String[]args){
        //testArrowPlusArrowIsPossible();
        //System.out.println(Recursion.pow(1, 3)); //Pow
        //System.out.println(Recursion.multiply(9,5)); //Multiplication
        //Recursion.printXtoY(1, 5); //Print from 1 to 5
        //testMaxBetween();
        //System.out.println(Recursion.fibAtN(9));
        //System.out.println(Recursion.lowestCommmonDenominator(8, 60, 8));
        //System.out.println(Recursion.allEvenOrAllOdd(19531971));
        //System.out.println(Recursion.isPrime( 9349, 2));
        //System.out.println(Recursion.notFib(5));
        //System.out.println(Recursion.sumNotFib(5));

        //int[][] array = {{5,7,8,3,5,7,9,3,2},{5,3,2,6,8,3,1,9,7},{3,21,4,1,8,6,4,3,0}};
        //System.out.println(Recursion.timesIn2DArray(array, array.length-1, 3));

    }

    /**
     * Tests arrow function + ArrowIsPossible function
     */
    public static void testArrowPlusArrowIsPossible(){
        Boolean[][] birds = new Boolean[13][20];
        Recursion.initialize2DBool(birds, 0,0);
        birds[4][17] = true;
        System.out.println(Recursion.arrowIsPossible(birds, 2, 15, 0));
        System.out.println(Recursion.arrow(birds, 2,15, 0));
        Recursion.print2D(birds, 0, 0);
    }
    public static void testMaxBetween(){
        int[] array = {1,5,24,6,6,82,34,1,2,45,1,5,32};
        System.out.println(Recursion.maxBetween(array, 10, 12));
    }
}
