import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    @Test
    public void test() {
        BinaryTree<String> sampleTree1 = sampleTree1();
        BinaryTree<String> sampleTree2 = sampleTree2();
        BinaryTree<String> sampleTree3 = sampleTree3();
        BinaryTree<String> sampleTree4 = sampleTree4();

        List<String> tree1Contents = sampleTree1.getContents();
        assertEquals("a", tree1Contents.get(0));

        // TODO
        fail("Add your own tests here, using the provided sample trees or your own trees.");
    }

    // SAMPLE TREES
    // These trees are spelled out reading from top to bottom, left to right.
    // This is called a level-order traversal or a breadth-first search (BFS) traversal.
    // We will learn more about traversals in the next lab.

    /*  This is the sample tree used by the autograder, but you may modify this if you would like. */
    static BinaryTree<String> sampleTree1() {
        ArrayList<String> contents = new ArrayList<>();
        // a as the root, b and c as its left and right, respectively.
        contents.add("a");
        contents.add("b");
        contents.add("c");
        return new BinaryTree<>(contents);
    }

    /* This is the sample tree used by the autograder, but you may modify this if you would like. */
    static BinaryTree<String> sampleTree2() {
        ArrayList<String> contents = new ArrayList<>();
        // a as the root, b and c as its left and right, respectively.
        contents.add("a");
        contents.add("b");
        contents.add("c");
        // d as b's left.
        contents.add("d");
        // nothing at b's right.
        contents.add(null);
        // nothing at c's left.
        contents.add(null);
        // g at c's right.
        contents.add("g");
        // e and f as d's left and right, respectively.
        contents.add("e");
        contents.add("f");
        contents.add(null);
        contents.add(null);
        contents.add(null);
        contents.add(null);
        // h and i as g's left and right, respectively.
        contents.add("h");
        contents.add("i");

        return new BinaryTree<>(contents);
    }

    /*  This is the sample tree used by the autograder, but you may modify this if you would like. */
    static BinaryTree<String> sampleTree3() {
        ArrayList<String> contents = new ArrayList<>();
        // a as the root, b and c as its left and right, respectively.
        contents.add("a");
        contents.add("b");
        contents.add("c");
        // nothing at b's left.
        contents.add(null);
        // nothing at b's right.
        contents.add(null);
        // d at c's left.
        contents.add("d");
        // nothing at c's right.
        contents.add(null);

        contents.add(null);
        contents.add(null);
        contents.add(null);
        contents.add(null);

        // e and f as d's left and right, respectively.
        contents.add("e");
        contents.add("f");

        return new BinaryTree<>(contents);
    }

    /*  This is the sample tree used by the autograder, but you may modify this if you would like. */
    static BinaryTree<String> sampleTree4() {
        ArrayList<String> contents = new ArrayList<>();
        contents.add("a");
        contents.add("b");
        contents.add("c");
        contents.add("c");
        contents.add("d");
        contents.add("c");
        contents.add("c");

        return new BinaryTree<>(contents);
    }
}
