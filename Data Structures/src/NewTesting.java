public class NewTesting {
    public static void main (String[] args){

        Queue<String> t1_build = new Queue<>();
        t1_build.insert("-2");
        t1_build.insert("1");
        t1_build.insert("3");
        t1_build.insert("d");
        t1_build.insert("d");
        t1_build.insert("7");
        t1_build.insert("1");
        t1_build.insert("d");
        t1_build.insert("d");
        t1_build.insert("9");
        t1_build.insert("d");
        t1_build.insert("d");
        t1_build.insert("8");
        t1_build.insert("1");
        t1_build.insert("d");
        t1_build.insert("d");
        t1_build.insert("1");
        t1_build.insert("d");
        t1_build.insert("d");
        BinNode<Integer> t1 = BinNodeFunctions.QUEUEreadIntegerBinNode(t1_build);

        t1_build.insert("1");
        t1_build.insert("1");
        t1_build.insert("3");
        t1_build.insert("d");
        t1_build.insert("d");
        t1_build.insert("7");
        t1_build.insert("1");
        t1_build.insert("d");
        t1_build.insert("d");
        t1_build.insert("d");
        t1_build.insert("8");
        t1_build.insert("d");
        t1_build.insert("12");
        t1_build.insert("d");
        t1_build.insert("d");
        BinNode<Integer> t2 = BinNodeFunctions.QUEUEreadIntegerBinNode(t1_build);

        System.out.println(t1);
        System.out.println(t2);
        BinNodeFunctions.printEven(t1);
        System.out.println();
        System.out.println(BinNodeFunctions.numNodes(t1));
        System.out.println();
        System.out.println(BinNodeFunctions.sumNodes(t1));
        System.out.println();
        System.out.println(BinNodeFunctions.exists(1, t1));
        System.out.println();
        System.out.println(BinNodeFunctions.eachHasTwoChildren(t1));
        System.out.println();
        BinNodeFunctions.printInOrder(t1);
        System.out.println();
        BinNodeFunctions.printPreOrder(t1);
        System.out.println();
        BinNodeFunctions.printPostOrder(t1);
        System.out.println();
        System.out.println(BinNodeFunctions.numLeaves(t1));
        System.out.println();
        System.out.println(BinNodeFunctions.treeHeight(t1));
        System.out.println();
        System.out.println(BinNodeFunctions.howManyN(t1, 1));
        System.out.println();
        System.out.println(BinNodeFunctions.similar(t1, t1));
    }
}
