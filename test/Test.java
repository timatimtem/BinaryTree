/**
 * Created by Tymur on 02.09.2016.
 */

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.*;
import static org.junit.Assert.*;

public class Test {

    private BinaryTree<Integer> tree = new BinaryTree<>();

    @org.junit.Test
    public void testEmptyTree() {
        tree.clear();
        assertEquals(0, tree.size());
        assertEquals(-1, tree.depth());
        assertEquals("[]", tree.toString());
    }


    @Before
    public void setUp() throws Exception {
        tree.add(5);
        tree.add(4);
        tree.add(2);
        tree.add(3);
        tree.add(6);
        tree.add(1);
    }

    @org.junit.Test
    public void testAddUnique() {
        for (int n = 1; n <= 6; n++) {
            assertTrue(tree.contains(n));
        }
    }

    @org.junit.Test
    public void testSize() {
        assertEquals(6, tree.size());
    }

    @org.junit.Test
    public void testDepth() {
        assertEquals(3, tree.depth());
    }

    @org.junit.Test
    public void testToString() {
        assertEquals("[1, 2, 3, 4, 5, 6]", tree.toString());
    }

    @org.junit.Test
    public void testAddDuplicates() {
        for (int n = 1; n <= 6; n += 2)
            assertFalse(tree.add(n));
    }

    @org.junit.Test
    public void testRemoveExistingLeaf() {
        assertTrue(tree.remove(1));
        assertEquals(5, tree.size());
        assertEquals("[2, 3, 4, 5, 6]", tree.toString());
    }

    @org.junit.Test
    public void testRemoveExistingMiddleItemWithEmptyRightChild() {
        assertTrue(tree.remove(4));
        assertEquals(5, tree.size());
        assertEquals("[1, 2, 3, 5, 6]", tree.toString());
    }

    @org.junit.Test
    public void testRemoveExistingMiddleItemWithEmptyLeftChild() {
        tree.add(7);
        assertTrue(tree.remove(6));
        assertEquals(6, tree.size());
        assertEquals("[1, 2, 3, 4, 5, 7]", tree.toString());
    }

    @org.junit.Test
    public void testRemoveExistingMiddleItemWithTwoChildren() {
        assertTrue(tree.remove(2));
        assertEquals(5, tree.size());
        assertEquals("[1, 3, 4, 5, 6]", tree.toString());
    }

    @org.junit.Test
    public void testRemoveRoot() {
        assertTrue(tree.remove(5));
        assertEquals(5, tree.size());
        assertEquals("[1, 2, 3, 4, 6]", tree.toString());
    }

    @org.junit.Test
    public void testRandomAddAndRemove() {
        Random rnd = new Random();

        SortedSet<Integer> oracle = new TreeSet<Integer>();

        for (int n = 1; n <= 6; n++)
            oracle.add(n);

        for (int n = 0; n < 1000; n++) {
            int toAdd = rnd.nextInt(10);

            assertEquals(oracle.add(toAdd), tree.add(toAdd));

            int toRemove = rnd.nextInt(10);
            System.out.println(tree.toString());
            System.out.println(toRemove);
            assertEquals(oracle.remove(toRemove), tree.remove(toRemove));

            int checkExists = rnd.nextInt(10);

            assertEquals(oracle.contains(checkExists), tree.contains(checkExists));
            assertEquals(oracle.size(), tree.size());
            assertEquals(oracle.toString(), tree.toString());
        }
    }

    @org.junit.Test
    public void testOtherType(){

        BinaryTree<String> stringTree = new BinaryTree<String>();

        stringTree.add("D");
        stringTree.add("A");
        stringTree.add("C");
        stringTree.add("A");
        stringTree.add("B");
        assertEquals(4, stringTree.size());
        assertTrue(stringTree.contains("C"));
        stringTree.remove("C");
        assertFalse(stringTree.contains("C"));
    }

}
