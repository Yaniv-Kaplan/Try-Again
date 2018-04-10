package Final_For_Bagrut.BinNode;

public class BinSearchTreeFuncs {
    //left = lower than root, right = higher or equal.

    //O(nlog n)
    public static void insertSorted(BinNode<Integer> t, int num){
        if (num < t.getValue()){
            if(t.getLeft() == null)
                t.setLeft(new BinNode<>(num));
            else
                insertSorted(t.getLeft(), num);
        }
        else{
            if(t.getRight() == null)
                t.setRight(new BinNode<>(num));
            else
                insertSorted(t.getRight(), num);
        }
    }

    //O(log n)
    public static boolean existsInSorted(BinNode<Integer> t, int num){
        if (t == null)
            return false;
        if(t.getValue() == num)
            return true;
        if(num < t.getValue())
            return existsInSorted(t.getLeft(), num);
        else
            return existsInSorted(t.getRight(), num);
    }

    public static int minimum(BinNode<Integer> t){
        if (t != null && !t.hasLeft())
            return t.getValue();
        else
            return minimum(t.getLeft());
    }

    public static int maximum(BinNode<Integer> t){
        if(t != null && !t.hasRight())
            return t.getValue();
        else
            return maximum(t.getRight());
    }
}
