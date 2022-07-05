package utils.tree;

public class Node<T> {
    public T val;
    public Node<T> left;
    public Node<T> right;

    public Node(T x){
        this.val = x;
    }
}
