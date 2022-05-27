package treeapp.comparetreeleaves;

public class ArrayTreeNode {
    int value;
    ArrayTreeNode[] nodes;

    public ArrayTreeNode(int value, ArrayTreeNode[] nodes) {
        this.value = value;
        this.nodes = nodes != null ? nodes : new ArrayTreeNode[2];
    }

}
