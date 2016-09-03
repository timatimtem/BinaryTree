import java.util.Queue;

/**
 * Created by Tymur on 02.09.2016.
 */


public class BinaryTreeNode<T extends Comparable<T>> {

    private T data;
    private BinaryTreeNode<T> left, right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }


    /**
     * Insert value
     * @param data
     * @return
     */
    public boolean add(T data){

        if (contains(data)){
            return false;
        }

        if (this.data.compareTo(data) > 0) {
            // new data is less then root, add to left
            if (left == null) {
                this.left = new BinaryTreeNode<>(data);
                System.out.println(data + " < " + this.data);
            }else {
                left.add(data);
            }
            return true;

        } else

        if (this.data.compareTo(data) < 0) {
            // new data is greater then root, add to right
            if (right == null){
                this.right = new BinaryTreeNode<>(data);
                System.out.println(data + " > " + this.data);
            }else {
                right.add(data);
            }
            return true;
        } else

        if (this.data.compareTo(data) == 0) {
            return true;
        }
        return false;
    }
    public T getRootNode(){
        return this.data;
    }

    public void rcopy(BinaryTreeNode<T> current){
       if (current.left != null){
           this.add(current.left.data);
           this.rcopy(current.left);
       }
       if (current.right != null){
           this.add(current.right.data);
           this.rcopy(current.right);
       }

    }

    public BinaryTreeNode<T> remove(T data){

        if (this.data == null || !contains(data) ){
            return this;
        }

        if(this.data.compareTo(data) > 0 && this.left != null){
            // check left
            this.left = left.remove(data);
        } else

        if (this.data.compareTo(data) < 0 && this.right != null){
            // check right
            this.right = right.remove(data);
        } else {
            if (left != null && right != null){
                // two child nodes
                this.data = right.findMin();
                this.right = right.remove(this.data);
                return this;
            }
            if (this.left == null){
                return this.right;
            }
            if (this.right == null){
                return this.left;
            }
        }
        return this;
    }


    /**
     * Returns the smallest key in root
     * @return
     */
    private T findMin(){
        if (left == null){
            return data;
        }else{
            return left.findMin();
        }
    }


    /**
     * check does this tree contain the given param
     *
     * @param data searched arg
     *
     * @return (true) if elem is found ,otherwise (false)
     */
    public boolean contains(T data) {
        if (this.data.compareTo(data) == 0){
            return true;
        } else
            if (this.data.compareTo(data) > 0){
                //check left
                return left != null && left.contains(data);
            }else
                if (this.data.compareTo(data) < 0 ){
                    // check right
                    return right != null && right.contains(data);
                }
                return false;
    }

    /**
     * Count nodes
     * @return number of nodes
     */
    public int size(){
        int nodes = 1;

        if(left != null){
            nodes += left.size();
        }
        if (right != null){
            nodes += right.size();
        }
        return nodes;
    }


    /**
     * return depth of tree
     * @return depth
     */
    public int depth() {
        int leftDepth = 0;
        int rightDepth = 0;

        if (left != null){
            leftDepth = 1;
            leftDepth += left.depth();
        }
        if (right != null){
            rightDepth = 1;
            rightDepth += right.depth();
        }
        if (leftDepth > rightDepth){
            return leftDepth;
        } else {
            return rightDepth;
        }
    }


    public String toString() {
        String message = "";
        if (left != null){
            message += left.toString() + ", ";
        }
        message += data;
        if (right != null){
            message += ", " + right.toString();
        }
        return message;
    }
}
