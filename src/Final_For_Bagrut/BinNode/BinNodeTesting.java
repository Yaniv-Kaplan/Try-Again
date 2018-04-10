package Final_For_Bagrut.BinNode;

import Final_For_Bagrut.Queue.Queue;
import Final_For_Bagrut.BinNode.BinNodeFunctions;

public class BinNodeTesting {
    public static void main (String[] args){
    }

    public static void buildTree(){
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
    }

    public static void sortedTreeFunctionTests(){
        BinNode<Integer> t = new BinNode<>(20);
        BinSearchTreeFuncs.insertSorted(t, 6);
        BinSearchTreeFuncs.insertSorted(t, 3);
        BinSearchTreeFuncs.insertSorted(t, 6);
        BinSearchTreeFuncs.insertSorted(t, 26);
        BinSearchTreeFuncs.insertSorted(t, 6);
        BinSearchTreeFuncs.insertSorted(t, 5);
        BinSearchTreeFuncs.insertSorted(t, 7);
        BinSearchTreeFuncs.insertSorted(t, 5);
        BinSearchTreeFuncs.insertSorted(t, 6);
        BinSearchTreeFuncs.insertSorted(t, 6);
        System.out.println(t);
        BinNodeFunctions.printInOrder(t);
        System.out.println();
        System.out.println(BinSearchTreeFuncs.existsInSorted(t, 30));
        System.out.println(BinSearchTreeFuncs.minimum(t));
        System.out.println(BinSearchTreeFuncs.maximum(t));
    }
}
