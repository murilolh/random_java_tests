package treeapp.domain;

public class ArrayTreeNode {
    public int value;
    public ArrayTreeNode[] nodes;

    public ArrayTreeNode(int value, ArrayTreeNode[] nodes) {
        this.value = value;
        this.nodes = nodes != null ? nodes : new ArrayTreeNode[2];
    }

}
