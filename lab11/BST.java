import java.util.LinkedList;
import java.util.Queue;

public class BST<T> {

    BSTNode<T> root;

    public BST(LinkedList<T> list) {
        root = sortedQueueToTree(list, list.size());
    }

    /* Returns the root node of a BST (Binary Search Tree) built from the given
       Queue Q  of N items. Q will output the items in sorted order,
       and Q will contain objects that will be the item of each BSTNode. */
    private BSTNode<T> sortedQueueToTree(Queue<T> Q, int N) {
        // TODO: YOUR CODE HERE
        // HINT: Remember to pass the same Queue to recursive calls, to
        //			take advantage of the fact that it is sorted.
        return null;
    }

    /* Prints the tree represented by ROOT. */
    private void print() {
        print(root, 0);
    }

    private void print(BSTNode<T> node, int d) {
        if (node == null) {
            return;
        }
        for (int i = 0; i < d; i++) {
            System.out.print("  ");
        }
        System.out.println(node.item);
        print(node.left, d + 1);
        print(node.right, d + 1);
    }

    class BSTNode<T> {
        T item;
        BSTNode<T> left;
        BSTNode<T> right;

        BSTNode(T item) {
            this.item = item;
        }
    }
}
