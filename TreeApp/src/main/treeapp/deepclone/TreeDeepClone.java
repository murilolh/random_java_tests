package treeapp.deepclone;

import treeapp.domain.BinaryTreeNode;

public class TreeDeepClone {

    public BinaryTreeNode deepCloneDFSRecursive(BinaryTreeNode root) {
        if (root == null)
            return null;

        BinaryTreeNode newRoot = new BinaryTreeNode(root.value);
        newRoot.left = deepCloneDFSRecursive(root.left);
        newRoot.right = deepCloneDFSRecursive(root.right);

        return newRoot;
    }
}
