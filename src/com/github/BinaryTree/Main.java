package com.github.BinaryTree;


public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.add(50);
        tree.add(40);
        tree.add(60);
        tree.add(35);
        tree.add(45);
        tree.add(55);
        tree.add(65);

        System.out.println(tree.toString());


        // test of recursive copy
        BinaryTree<Integer> newTree = tree.recursiveCopy();

        System.out.println(newTree.toString());
        System.out.println("----------------------");
        System.out.println("----------------------");


        tree.preOrderedPrint();
        tree.inOrderedPrint();
        tree.postOrderedPrint();



    }
}
