package Final_For_Bagrut.BinNode;
public class BinNode<T> {
    private T value;
    private BinNode<T> left;
    private BinNode<T> right;

    public BinNode(T value){
        this.value = value;
        this. left = null;
        this.right = null;
    }

    public BinNode(T value, BinNode<T> left, BinNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public BinNode<T> getLeft() {
        return left;
    }

    public BinNode<T> getRight() {
        return right;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setLeft(BinNode<T> left) {
        this.left = left;
    }

    public void setRight(BinNode<T> right) {
        this.right = right;
    }

    public boolean hasRight(){
        return (right != null);
    }

    public boolean hasLeft(){
        return (left != null);
    }

    public boolean isLeaf(){
        return (!hasLeft() && !hasRight());
    }


    @Override
    public String toString() {
        return "(" + left + " " + value + " " + right + ")";
    }
}
