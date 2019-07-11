import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    @Test
    public void test() {
        BinaryTree<Integer> tree = worksheetTree();

        List<Integer> treeContents = tree.getContents();
        assertEquals(10, (int) treeContents.get(0));

        // TODO
        fail("Add your own tests here, using the provided sample tree or your own trees.");
    }

    // SAMPLE TREES
    // These trees are spelled out reading from top to bottom, left to right.
    // Empty spaces are represented explicitly with null, but in a typical BFS traversal, we ignore empty nodes.

    /*  This is the tree from the worksheet, but you may modify this if you would like. */
    static BinaryTree<Integer> worksheetTree() {
        ArrayList<Integer> contents = new ArrayList<>();
        contents.add(10);
        contents.add(3);
        contents.add(12);
        contents.add(1);
        contents.add(7);
        contents.add(11);
        contents.add(14);
        contents.add(null);
        contents.add(null);
        contents.add(null);
        contents.add(null);
        contents.add(null);
        contents.add(null);
        contents.add(13);
        contents.add(15);
        return new BinaryTree<>(contents);
    }

    /*  This is the tree for sumPaths, but you may modify this if you would like. */
    static BinaryTree<Integer> sumPathsTree() {
        ArrayList<Integer> contents = new ArrayList<>();
        contents.add(10);
        contents.add(2);
        contents.add(4);
        contents.add(5);
        contents.add(1);
        contents.add(null);
        contents.add(-1);
        return new BinaryTree<>(contents);
    }
}
