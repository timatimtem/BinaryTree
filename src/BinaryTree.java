
/**
 * Created by Tymur on 02.09.2016.
 */


public class BinaryTree <T extends Comparable<T>> {

    private BinaryTreeNode<T> root;

    public boolean add(T data){

        if(root == null){

            root = new BinaryTreeNode<T>(data);
            return true;

        } else {
            return root.add(data);
        }
    }

    public boolean remove(T data){
        int originalSize = size();

        if (root != null){
            root = root.remove(data);
        }
        return size() < originalSize;
    }

    public boolean contains(T data){
        return root != null && root.contains(data);
    }

    public void clear() {
        root = null;
    }

    public int depth(){
        if (root == null) {
            return -1;
        } else {
            return root.depth();
        }
    }

    public int size(){
        if (root == null){
            return 0;
        } else {
            return root.size();
        }
    }


    public BinaryTree recursiveCopy(){

        BinaryTree<T> newTree = new BinaryTree<>();
        newTree.add(this.root.getRootNode());
        newTree.root.rcopy(root);

        return newTree;

    }

    public String toString(){
        return "[" + (root == null ? "" : root.toString()) + "]";
    }
}
