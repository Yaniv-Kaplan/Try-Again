package Final_For_Bagrut.Tests;

import OLD.BinNode;
import OLD.BinNodeFunctions;
import OLD.Queue;
import OLD.Stack;

public class Test1 {
    public static void main (String[] args){
        //test4();
        //test5();
    }

    public static void test4(){
        Stack<Queue<Integer>> sq = new Stack<>();
        Queue<Integer> q1 = new Queue<>();
        q1.insert(1);
        q1.insert(7);
        q1.insert(10);
        q1.insert(20);

        Queue<Integer> q2 = new Queue<>();
        q2.insert(1);
        q2.insert(7);
        q2.insert(10);

        Queue<Integer> q3 = new Queue<>();
        q3.insert(10);
        q3.insert(7);

        sq.push(q1);
        sq.push(q2);
        sq.push(q3);

        Structures.addNum(sq, 10);
        System.out.println(sq);
    }
    public static void test5(){
        Queue<String> t1_build = new Queue<>();
        t1_build.insert("15");
        t1_build.insert("22");
        t1_build.insert("10");
        t1_build.insert("10");
        t1_build.insert("d");
        t1_build.insert("d");
        t1_build.insert("13");
        t1_build.insert("d");
        t1_build.insert("d");
        t1_build.insert("1");
        t1_build.insert("d");
        t1_build.insert("d");
        t1_build.insert("8");
        t1_build.insert("8");
        t1_build.insert("d");
        t1_build.insert("d");
        t1_build.insert("8");
        t1_build.insert("d");
        t1_build.insert("d");
        BinNode<Integer> t1 = BinNodeFunctions.QUEUEreadIntegerBinNode(t1_build);
        System.out.println(t1);
        System.out.println(Structures.triangles(t1));
        System.out.println(Structures.largestPerimeter(t1));
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*//1
public class Wallet{
    double quantity;


    //1.a)
    public void payment(double p){
        if (this.quantity >= p){
            this.quantity -= p;
            System.out.println("Paid");
        }
        else
            System.out.println("Insufficient funds");
    }
    //1.b) paid; insufficient funds; paid; paid; 235432,1049.80-349.80 = 700.0; 123456, 1000-250.50-200 = 549.50
}*/

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*//2
public class Game{
    //2.a)
    private int gameCode;
    private String gameName;
    private int minAge;
    private int timesPlayed;
    private int timesFatalError;

    //2.b)
    public Game(int gameCode, String gameName, int minAge){
        this.gameCode = gameCode;
        this.gameName = gameName;
        this.minAge = minAge;
        this.timesPlayed = 0;
        this.timesFatalError = 0;
    }

    //2.c)
    public void playedOnce(){
        this.timesPlayed += 1;
    }

    //2.d)
    public void fatal(){
        this.timesFatalError += 1;
    }

    //2.e)
    public String rating(){
        double x = this.timesFatalError/this.timesPlayed;

        if (x < 0.05)
            return "***";
        else if (x < 0.25)
            return "**";
        else
            return "*";
    }
}
//2.f)
public class MainGame{
    public static void gameList(Game[] games, int age){
        //for each loop - is this allowed?
        for (Game game: games){
            if (game.getMinAge() <= age && game.rating().equals("***"))
                System.out.println(game.getGameCode() + ": " + game.getGameName());
        }
    }
}*/

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//3
/*public class Apartment{
    private String tel;

    public String getTel(){
        return this.tel;
    }
}
public class Works{
    private Apartment[] a;
    private int n;

    public Works(){
        this.a = new Apartment[50];
        this.n = 0;
    }

    public void addCustomer(Apartment customer){
        this.a[this.n] = customer;
        n++;
    }

    public void delCustomer(String tel){
        boolean found = false;
        for (int i = 0; i < n; i++){
            if (!found && this.a[i].getTel().equals(tel)){
                found = true;
                n--;
            }
            if(found)
                this.a[i - 1] = this.a[i];
        }
    }
}*/

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

class Structures{
    //4
    public static void addNum (Stack<Queue<Integer>> SQ, int num){
        //runtime complexity: O(n^2)
        Stack<Queue<Integer>> temp = new Stack<>();
        boolean inserted = false;

        while (!SQ.isEmpty()){
            temp.push(SQ.pop());
        }

        while (!temp.isEmpty()){
            if ((! temp.top().present(num)) && !inserted){
                temp.top().insert(num);
                inserted = true;
            }
            SQ.push(temp.pop());
        }

        if (!inserted){
            Queue<Integer> additionalQ = new Queue<>();
            additionalQ.insert(num);

            SQ.push(additionalQ);
        }
    }

    //5.a)
    public static int triangles (BinNode<Integer> t){
        if (t == null || t.isLeaf())
            return 0;
        if (t.getLeft().getValue() == t.getRight().getValue() && t.getRight().getValue() == t.getValue())
            return 1 + triangles(t.getLeft()) + triangles(t.getRight());
        else
            return 0 + triangles(t.getLeft()) + triangles(t.getRight());
    }

    //5.b)
    public static int largestPerimeter(BinNode<Integer> t){
        //runtime complexity is O(n)
        if (t == null || t.isLeaf())
            return 0;
        return Math.max(largestPerimeter(t.getLeft()),
                Math.max((t.getValue() + t.getRight().getValue() + t.getLeft().getValue()),
                        largestPerimeter(t.getRight())));
    }

    //6
    //page 121 - notice smart way to insert node into list
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////