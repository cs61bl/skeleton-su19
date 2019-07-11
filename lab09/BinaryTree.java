import java.util.LinkedList;
import java.util.List;

public class BinaryTree<T> {

    private TreeNode root;

    public BinaryTree() {
        root = null;
    }

    /**
     * This constructor constructs the binary tree from a list of the desired contents.
     * These trees are spelled out reading from top to bottom, left to right.
     * Empty spaces are represented explicitly with null, but in a typical BFS traversal, we ignore empty nodes.
     *
     * Do not delete or modify this constructor, or else the autograder will fail.
     */
    public BinaryTree(List<T> contents) {

        if (contents == null || contents.isEmpty()) {
            return;
        }

        int readIndex = 0;

        root = new TreeNode(contents.get(0), null, null);
        readIndex++;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        while (readIndex < contents.size()) {

            TreeNode currParent = queue.removeFirst();

            if (currParent == null) {
                readIndex += 2;
                queue.addLast(null);
                queue.addLast(null);
                continue;
            }

            // Create the left node.
            TreeNode left = null;
            if (contents.get(readIndex) != null) {
                left = new TreeNode(contents.get(readIndex));
            }
            readIndex++;
            currParent.left = left;
            queue.addLast(left);

            // Create the right node if there are more nodes to make.
            if (contents.size() - readIndex >= 1) {
                TreeNode right = null;
                if (contents.get(readIndex) != null) {
                    right = new TreeNode(contents.get(readIndex));
                }
                readIndex++;
                currParent.right = right;
                queue.addLast(right);
            }
        }
    }

    /**
     * This does the opposite of the constructor with argument contents.
     * It takes this BinaryTree and spells out its contents into a list in BFS order, but with empty spaces explicitly noted by null.
     * (In a typical BFS traversal, we ignore empty nodes.)
     *
     * Do not delete or modify this function, or else the autograder will fail.
     */
    public List<T> getContents() {
        LinkedList<T> result = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        int numNullInQueue = 0;
        queue.add(root);

        while (!queue.isEmpty() && numNullInQueue != queue.size()) {
            TreeNode curr = queue.removeFirst();

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

    /**
     * A recursive traversal, in which we process this node, then the left subtree, then the right.
     * Prints on a single line the items in preorder, each separated by a space.
     */
    public void preorder() {
        // TODO
    }

    /**
     * A recursive traversal, in which we process then the left subtree, then this node, then the right.
     * Prints on a single line the items in inorder, each separated by a space.
     */
    public void inorder() {
        // TODO
    }

    /**
     * A recursive traversal, in which we process then the left subtree, then the right, then this node.
     * Prints on a single line the items in postorder, each separated by a space.
     */
    public void postorder() {
        // TODO
    }

    /**
     * An iterative traversal, in which we process nodes in a depth-wise fashion.
     * Prints on a single line the items in dfs, each separated by a space.
     */
    public void dfs() {
        // TODO
    }

    /**
     * An iterative traversal, in which we process nodes in a breadth-wise fashion.
     * Prints on a single line the items in bfs, each separated by a space.
     */
    public void bfs() {
        // TODO
    }

    /**
     * Prints out all root-to-leaf paths whose values sum to k.
     * You may assume that this function will only be called when the generic `T` is `Integer`.
     * @return the dfs list of items.
     */
    public void printSumPaths(int k) {
        // FIXME
        sumPaths(null, -1, null);
    }

    private void sumPaths(TreeNode n, int k, String path) {
        int currItem = (int) n.item;
        // TODO
    }

    private class TreeNode {

        private T item;
        private TreeNode left;
        private TreeNode right;

        TreeNode(T obj) {
            item = obj;
            left = null;
            right = null;
        }

        TreeNode(T obj, TreeNode left, TreeNode right) {
            item = obj;
            this.left = left;
            this.right = right;
        }
    }
}
