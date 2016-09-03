/**
 * Created by Тимур on 03.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(20);
        tree.add(25);

        System.out.println(tree.toString());


        // test of recursive copy
        BinaryTree<Integer> newTree = tree.recursiveCopy();

        System.out.println(newTree.toString());



    }
}
