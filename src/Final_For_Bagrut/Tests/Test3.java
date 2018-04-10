package Final_For_Bagrut.Tests;

import OLD.Queue;

import java.util.Arrays;

public class Test3 {
    public static void main (String[] args){
        //test4();
        //test1();
        //test2();
        //test3();
        test6();
    }

    public static void test4(){

        int[][] array = {{7,10,15,12,7},{1,3,24,11,7},{3,12,3,9,15},{1,5,13,17,8},{8,2,1,5,1}};
        System.out.println(symmetricAlongMain(array));
    }
    public static void test1(){
        Garbage b3 = new Garbage();
        int count = 0;

        count += b3.addQuantity(10.3);
        count += b3.addQuantity(79);
        count += b3.addQuantity(15.9);
        count += b3.addQuantity(212);
        count += b3.addQuantity(12.4);
        count += b3.addQuantity(13.97);
        count += b3.addQuantity(87.3);
        count += b3.addQuantity(99.1);
        System.out.println(b3.quantity);
        System.out.println(count);
    }
    public static void test2(){
        Rain r1 = new Rain();
        r1.amount = 100;
        r1.zone = "B";
        r1.year = 1900;
        Rain r2 = new Rain();
        r2.amount = 200;
        r2.zone = "B";
        r2.year = 1800;
        Rain r3 = new Rain();
        r3.amount = 300;
        r3.zone = "A";
        r3.year = 1900;

        System.out.println(r1.moreRain(r3));
        System.out.println(r2.moreRain(r1));

    }
    public static void test3(){
        int[] rankings = {5,1,4,5,3,3,2,1,3,3,2,4,5,2,2,3,4,2,1,3,4,2,3,4};
        sortToArray(rankings);
    }
    public static void test6(){
        Queue<Integer> q = new Queue<>();
        q.insert(-22);
        q.insert(4);
        q.insert(3);
        q.insert(5);
        q.insert(2);
        q.insert(7);
        q.insert(16);
        q.insert(8);
        q.insert(-2);
        q.insert(11);
        q.insert(-4);
        q.insert(13);
        q.insert(15);

        System.out.println(queueExistSubSeq(q, -22));
        System.out.println(longestSubSeq(q));
    }

    //4
    public static int aboveDiag(int[][] array, int offset, int diagOffset){
        if (diagOffset == array.length-1){
            return array[0][0];
        }
        if(offset == (array.length-1)-diagOffset){
            return aboveDiag(array, 0, diagOffset+1);
        }
        return array[offset][(array.length-1)-diagOffset] + aboveDiag(array, offset+1, diagOffset);
    }
    public static int belowDiag(int[][] array, int offset, int diagOffset){
        if (diagOffset == array.length-1){
            return array[array.length-1][array[0].length-1];
        }
        if(offset == diagOffset-1){
            return belowDiag(array, array.length-1, diagOffset+1);
        }
        return array[offset][diagOffset+(array.length-1-offset)] + belowDiag(array, offset-1, diagOffset);
    }
    public static boolean symmetricAlongMain(int[][] array){
        int above = aboveDiag(array, 0, 1);
        System.out.println(above);
        int below = belowDiag(array, array.length-1, 1);
        System.out.println(below);

        if (below == above)
            return true;

        return false;
    }

    //3
    public static int[] sortToArray(int[] array){
        int[] sorted = {0,0,0,0,0};

        for (int i = 0; i<array.length; i++)
            sorted[(array[i])-1]++;

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(sorted));

        return sorted;
    }

    //171 - question 5 - smart way to implement exist;
    //172 - question 5 - nice way to erase Node from chain;

    //6
    public static int queueExistSubSeq(Queue<Integer> q, int x){
        Queue<Integer> temp = new Queue<>();
        boolean found = false;
        int count = 1;
        int head = 0;

        while(!q.isEmpty()){
            head = q.remove();
            temp.insert(head);

            if (head == x && !found){
                while (!q.isEmpty() && !found){
                    count++;
                    head = q.remove();
                    temp.insert(head);
                    if (head == -x)
                        found = true;
                }
            }
            else if(head == -x && !found){
                while (!q.isEmpty() && !found){
                    count++;
                    head = q.remove();
                    temp.insert(head);
                    if (head == x)
                        found = true;
                }
            }
        }

        while(!temp.isEmpty()){
            q.insert(temp.remove());
        }

        if (found)
            return count;
        return 0;

    }
    public static int longestSubSeq(Queue<Integer> q){
        int max = 0;
        Queue<Integer> temp = new Queue<>();

        while(!q.isEmpty()){
            int head = q.head();
            if (queueExistSubSeq(q, head) > max)
                max = queueExistSubSeq(q, head);
            temp.insert(q.remove());
        }

        while(!temp.isEmpty()){
            q.insert(temp.remove());
        }

        return max;
    }
}
//1
class Garbage{
    public double quantity;
    public double capacity;

    public Garbage(){
        this.quantity = 0;
        this.capacity = 100.0;
    }

    public int addQuantity(double x){
        if (this.quantity+x <= this.capacity){
            this.quantity += x;
            return 0;
        }
        else{
            if (x >= this.capacity) {
                System.out.println("This garbage can doesn't have enough capacity!");
                return 0;
            }
            else if (this.capacity != 0){

                System.out.println("Too full! emptying!");
                this.toEmpty();
                addQuantity(x);

                return 1;
            }
        }
        return 0;
    }

    public void toEmpty(){
        this.quantity = 0;
    }
}
//2
class Rain{

    public int amount;
    public int year;
    public String zone;

    public void addAmount(int x){
        this.amount += x;
    }

    public String moreRain(Rain r){
        if (this.year == r.year){
            if(this.zone != r.zone){
                if (this.amount < r.amount)
                    return "Had more rain";
                else
                    return "Didn't";
            }
            else
                return "Didn't";
        }
        else
            return "Didn't";
    }
}