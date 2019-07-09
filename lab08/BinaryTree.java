import java.util.LinkedList;
import java.util.List;

public class BinaryTree<T> {

    private TreeNode<T> root;

    public BinaryTree() {
        root = null;
    }

    /**
     * This constructor constructs the binary tree from a list of the desired contents.
     * These trees are spelled out reading from top to bottom, left to right.
     * This is called a level-order traversal or a breadth-first search (BFS) traversal.
     * We will learn more about traversals in the next lab.
     *
     * Do not delete or modify this constructor, or else the autograder will fail.
     */
    public BinaryTree(List<T> contents) {

        if (contents == null || contents.isEmpty()) {
            return;
        }

        int readIndex = 0;

        root = new TreeNode<>(contents.get(0), null, null);
        readIndex++;
        LinkedList<TreeNode<T>> queue = new LinkedList<>();
        queue.addLast(root);

        while (readIndex < contents.size()) {

            TreeNode<T> currParent = queue.removeFirst();

            if (currParent == null) {
                readIndex += 2;
                queue.addLast(null);
                queue.addLast(null);
                continue;
            }

            // Create the left node.
            TreeNode<T> left = null;
            if (contents.get(readIndex) != null) {
                left = new TreeNode<>(contents.get(readIndex));
            }
            readIndex++;
            currParent.left = left;
            queue.addLast(left);

            // Create the right node if there are more nodes to make.
            if (contents.size() - readIndex >= 1) {
                TreeNode<T> right = null;
                if (contents.get(readIndex) != null) {
                    right = new TreeNode<>(contents.get(readIndex));
                }
                readIndex++;
                currParent.right = right;
                queue.addLast(right);
            }
        }
    }

    /**
     * This does the opposite of the constructor with argument contents.
     * It takes this BinaryTree and spells out its contents into a list in BFS order.
     *
     * Do not delete or modify this function, or else the autograder will fail.
     */
    public List<T> getContents() {
        LinkedList<T> result = new LinkedList<>();
        LinkedList<TreeNode<T>> queue = new LinkedList<>();
        int numNullInQueue = 0;
        queue.add(root);

        while (!queue.isEmpty() && numNullInQueue != queue.size()) {
            TreeNode<T> curr = queue.removeFirst();

            if (curr == null) {
                numNullInQueue--;
                result.addLast(null);
                queue.addLast(null);
                queue.addLast(null);
                numNullInQueue += 2;
            } else {
                result.addLast(curr.item);
                queue.addLast(curr.left);
                queue.addLast(curr.right);

                if (curr.left == null) {
                    numNullInQueue++;
                }
                if (curr.right == null) {
                    numNullInQueue++;
                }
            }
        }
        return result;
    }

    /* Returns the height of the tree. */
    public int height() {
        // TODO
        return -1;
    }

    /* Returns true if the tree's left and right children are the same height
       and are themselves completely balanced. */
    public boolean isCompletelyBalanced() {
        // TODO
        return false;
    }

    public static BinaryTree<Integer> fibTree(int N) {
        // TODO
        return null;
    }

    private static class TreeNode<T> {

        private T item;
        private TreeNode<T> left;
        private TreeNode<T> right;

        TreeNode(T obj) {
            item = obj;
            left = null;
            right = null;
        }

        TreeNode(T obj, TreeNode<T> left, TreeNode<T> right) {
            item = obj;
            this.left = left;
            this.right = right;
        }
    }
}
