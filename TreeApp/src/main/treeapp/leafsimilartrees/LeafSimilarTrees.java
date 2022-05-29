package treeapp.leafsimilartrees;

import treeapp.domain.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Leaf-Similar Trees Problem. LC: 872
 */
public class LeafSimilarTrees {

    public boolean leafSimilar(BinaryTreeNode tree1, BinaryTreeNode tree2) {
        if (tree1 == null && tree2 == null)
            return true;
        else if (tree1 == null || tree2 == null)
            return false;

        return leafSimilarNonNullTrees(tree1, tree2);
    }

    private boolean leafSimilarNonNullTrees(BinaryTreeNode root1, BinaryTreeNode root2) {
        final Deque<BinaryTreeNode> stack1 = new ArrayDeque<>();
        final Deque<BinaryTreeNode> stack2 = new ArrayDeque<>();

        stack1.push(root1);
        stack2.push(root2);

        while (!stack1.isEmpty() && !stack2.isEmpty())
            if (findNextLeafValue(stack1) != findNextLeafValue(stack2))
                return false;

        return stack1.isEmpty() && stack2.isEmpty();

    }

    private int findNextLeafValue(Deque<BinaryTreeNode> stack) {
        while (true) {
            BinaryTreeNode t = stack.pop();
            if (t.right != null) stack.push(t.right);
            if (t.left != null) stack.push(t.left);
            if (t.left == null && t.right == null) return t.value;
        }
    }

}
