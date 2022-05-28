package treeapp.domain;

public class BinaryTreeNode {

    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this(value, null, null);
    }

    public BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right) {
        this(left, right);
        this.value = value;
    }

    public BinaryTreeNode(BinaryTreeNode left, BinaryTreeNode right) {
        this.left = left;
        this.right = right;
    }

}
