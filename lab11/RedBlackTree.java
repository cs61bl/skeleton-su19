public class RedBlackTree<T extends Comparable<T>> {

    /* Root of the tree. */
    RBTreeNode<T> root;

    /* Creates an empty RedBlackTree. */
    public RedBlackTree() {
        root = null;
    }

    /* Creates a RedBlackTree from a given BTree (2-3-4) TREE. */
    public RedBlackTree(BTree<T> tree) {
        Node<T> btreeRoot = tree.root;
        root = buildRedBlackTree(btreeRoot);
    }

    /* Builds a RedBlackTree that has isometry with given 2-3-4 tree rooted at
       given node R, and returns the root node. */
    RBTreeNode<T> buildRedBlackTree(Node<T> r) {
        // TODO: YOUR CODE HERE
        // HINT: Having a case for each number of items in r might help
        return null;
    }

    /* Flips the color of NODE and its children. Assume that NODE has both left
       and right children. */
    void flipColors(RBTreeNode<T> node) {
        node.isBlack = !node.isBlack;
        node.left.isBlack = !node.left.isBlack;
        node.right.isBlack = !node.right.isBlack;
    }

    /* Rotates the given node NODE to the right. Returns the new root node of
       this subtree. */
    RBTreeNode<T> rotateRight(RBTreeNode<T> node) {
        // TODO: YOUR CODE HERE
        return null;
    }

    /* Rotates the given node NODE to the left. Returns the new root node of
       this subtree. */
    RBTreeNode<T> rotateLeft(RBTreeNode<T> node) {
        // TODO: YOUR CODE HERE
        return null;
    }

    void insert(T item) {
        // TODO: YOUR CODE HERE
    }

    private RBTreeNode<T> insert(RBTreeNode<T> node, T item) {
    	// Optional helper method
    	// HINT: Remember to handle each of the cases from the spec
    	return null;
    }

    /* Returns whether the given node NODE is red. Null nodes (children of leaf
       nodes are automatically considered black. */
    private boolean isRed(RBTreeNode<T> node) {
        return node != null && !node.isBlack;
    }

    static class RBTreeNode<T> {

        final T item;
        boolean isBlack;
        RBTreeNode<T> left;
        RBTreeNode<T> right;

        /* Creates a RBTreeNode with item ITEM and color depending on ISBLACK
           value. */
        RBTreeNode(boolean isBlack, T item) {
            this(isBlack, item, null, null);
        }

        /* Creates a RBTreeNode with item ITEM, color depending on ISBLACK
           value, left child LEFT, and right child RIGHT. */
        RBTreeNode(boolean isBlack, T item, RBTreeNode<T> left,
                   RBTreeNode<T> right) {
            this.isBlack = isBlack;
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }

    /* Main method to help test constructor. Feel free to modify */
    public static void main(String[] args) {
        BTree<Integer> bTree = new BTree<>();
        bTree.root = new BTree.TwoThreeFourNode<>(3, 4);
        RedBlackTree<Integer> rbTree = new RedBlackTree<>(bTree);
        System.out.println((rbTree.root != null));
        System.out.println((rbTree.root.left == null));
        System.out.println((rbTree.root.right != null));
        System.out.println((rbTree.root.isBlack));
        System.out.println((!rbTree.root.right.isBlack));
        System.out.println(3 == rbTree.root.item);
        System.out.println(4 == rbTree.root.right.item);
    }

}
