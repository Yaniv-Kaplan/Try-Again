package Final_For_Bagrut.Tests;

import Final_For_Bagrut.BinNode.BinNode;
import Final_For_Bagrut.BinNode.BinNodeFunctions;
import Final_For_Bagrut.Queue.Queue;

public class PracticeMatkonet {
    public static void main (String[] args){
        Queue<String> t1_build = new Queue<>();
        t1_build.insert("12");
        t1_build.insert("-6");
        t1_build.insert("-5");
        t1_build.insert("-1");
        t1_build.insert("d");
        t1_build.insert("d");
        t1_build.insert("7");
        t1_build.insert("d");
        t1_build.insert("d");
        t1_build.insert("13");
        t1_build.insert("d");
        t1_build.insert("d");
        t1_build.insert("8");
        t1_build.insert("-3");
        t1_build.insert("d");
        t1_build.insert("d");
        t1_build.insert("4");
        t1_build.insert("-5");
        t1_build.insert("d");
        t1_build.insert("d");
        t1_build.insert("22");
        t1_build.insert("d");
        t1_build.insert("d");
        BinNode<Integer> t1 = BinNodeFunctions.QUEUEreadIntegerBinNode(t1_build);

        Queue<String> t2_build = new Queue<>();
        t2_build.insert("1");
        t2_build.insert("d");
        t2_build.insert("2");
        t2_build.insert("3");
        t2_build.insert("4");
        t2_build.insert("d");
        t2_build.insert("5");
        t2_build.insert("d");
        t2_build.insert("6");
        t2_build.insert("d");
        t2_build.insert("7");
        t2_build.insert("d");
        t2_build.insert("d");
        t2_build.insert("d");
        t2_build.insert("d");
        BinNode<Integer> t2 = BinNodeFunctions.QUEUEreadIntegerBinNode(t2_build);

        System.out.println(t1);
        System.out.println(t2);

        System.out.println(BinNodeFunctions.isUpZZ(t1, 1));
        System.out.println(BinNodeFunctions.isUpZZ(t2, 1));
    }


    //returns how many times a certain int is present in a tree;
    public static int exists(BinNode<Integer> t, int val){
        int c = 0;
        if (t == null)
            return 0;
        if (t.getValue() == val)
            c = 1;
        return c + exists(t.getLeft(), val) + exists(t.getRight(), val);
    }

    public static boolean noCommon(BinNode<Integer> t1, BinNode<Integer> t2){
        return true;
    }




}
