package OLD;

import java.util.*;
public class BinNodeFunctions {
    public static Scanner reader = new Scanner(System.in);

    /**
     * Prints all even numbers in a binary tree
     * @param t the tree
     */
    public static void printEven (BinNode<Integer> t){
        if (t != null){
            if (t.getValue() % 2 == 0)
                System.out.println(t.getValue());
            printEven(t.getLeft());
            printEven(t.getRight());
        }
    }

    /**
     * number of צמתים (nodes) in the tree
     * @param t
     * @param <T>
     * @return
     */
    public static<T> int numNodes (BinNode<T> t){
        if (t == null)
            return 0;
        return 1+numNodes(t.getRight())+numNodes(t.getLeft());
    }

    /**
     * The sum of all the nodes in a tree
     * @param t
     * @return
     */
    public static int sumNodes (BinNode<Integer> t){
        if (t == null)
            return 0;
        return (t.getValue() + sumNodes(t.getLeft()) + sumNodes(t.getRight()));
    }

    /**
     * does value T exist in the tree t
     * @param value
     * @param t
     * @param <T>
     * @return
     */
    public static<T> boolean exists (T value, BinNode<T> t){
        if (t==null)
            return false;
        if (t.getValue().equals(value))
            return true;
        return exists(value, t.getRight()) || exists(value, t.getLeft());
    }

    /**
     * Is the tree "stable" - does each node which is not a leaf have 2 children?
     * @param t
     * @param <T>
     * @return
     */
    public static<T> boolean eachHasTwoChildren(BinNode<T> t){
        if (t == null || t.isLeaf())
            return true;
        if (!t.hasRight() || !t.hasLeft())
            return false;
        return eachHasTwoChildren(t.getLeft()) && eachHasTwoChildren(t.getRight());
    }

    /**
     * print left - root - right
     * @param t
     * @param <T>
     */
    public static<T> void printInOrder(BinNode<T> t){
        if(t != null){
            printInOrder(t.getLeft());
            System.out.print(" "+ t.getValue());
            printInOrder(t.getRight());
        }
    }

    /**
     * print root - left - right
     * @param t
     * @param <T>
     */
    public static<T> void printPreOrder(BinNode<T> t){
        if(t != null){
            System.out.print(" " + t.getValue());
            printPreOrder(t.getLeft());
            printPreOrder(t.getRight());
        }
    }

    /**
     * print left - right - root
     * @param t
     * @param <T>
     */
    public static<T> void printPostOrder(BinNode<T> t){
        if(t != null){
            printPostOrder(t.getLeft());
            printPostOrder(t.getRight());
            System.out.print(" " + t.getValue());
        }
    }

    /**
     * number of leafs in a tree
     * @param t
     * @param <T>
     * @return
     */
    public static<T> int numLeaves (BinNode<T> t){
        int c = 0;
        if (t==null)
            return 0;
        if (t.isLeaf())
            c = 1;
        return c + numLeaves(t.getLeft()) + numLeaves(t.getRight());
    }

    /**
     * the height of the tree. empty is -1, root only is 0 ...
     * @param t
     * @param <T>
     * @return
     */
    public static<T> int treeHeight(BinNode<T> t){
        if (t == null)
            return -1;
        return Math.max(treeHeight(t.getRight()), treeHeight(t.getLeft())) +1;
    }

    /**
     * How many times does n appear in the tree
     * @param t
     * @param n
     * @param <T>
     * @return
     */
    public static<T> int howManyN(BinNode<T> t, T n){
        int c = 0;
        if (t == null)
            return 0;
        if (t.getValue().equals(n))
            c = 1;
        return c + howManyN(t.getLeft(), n) + howManyN(t.getRight(), n);
    }

    /**
     * Are two trees similarly built. for better soloution:
     * Page 184 - הכנה לבגרות
     * @param t1
     * @param t2
     * @param <T>
     * @return
     */
    public static<T> boolean similar(BinNode<T> t1, BinNode<T> t2){
        if (t1 == null && t2 == null)
            return true;
        if (t1 != null && t2 != null){
            if(t1.isLeaf() && t2.isLeaf())
                return true;
            if (!t1.isLeaf() && !t1.isLeaf())
                return similar(t1.getLeft(), t2.getLeft()) && similar(t1.getRight(), t2.getRight());
            return false;
        }
        return false;


    }

    // these four functions are used to create a binary tree, in two different ways.

    public static BinNode<Integer> readIntegerBinNode(){
        System.out.println("Please input the root of the tree or string d to stop: ");
        return readIntegerTree();
    }
    public static BinNode<Integer> readIntegerTree(){
        String input = reader.next();

        if(input.equals("d"))
            return null;
        int root = Integer.parseInt(input);

        System.out.println("Left tree: ");
        BinNode<Integer> left = readIntegerTree();
        System.out.println("Right tree: ");
        BinNode<Integer> right = readIntegerTree();
        return new BinNode<>(root, left, right);
    }
    public static BinNode<Integer> QUEUEreadIntegerBinNode(Queue<String> buildQueue){
        return QUEUEreadIntegerTree(buildQueue);
    }
    public static BinNode<Integer> QUEUEreadIntegerTree(Queue<String> buildQueue){
        String input = buildQueue.remove();

        if(input.equals("d"))
            return null;
        int root = Integer.parseInt(input);

        BinNode<Integer> left = QUEUEreadIntegerTree(buildQueue);
        BinNode<Integer> right = QUEUEreadIntegerTree(buildQueue);
        return new BinNode<>(root, left, right);
    }

}
