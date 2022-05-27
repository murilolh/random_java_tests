package treeapp.leafsimilartrees;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Leaf-Similar Trees Problem. LC 872
 */
public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null)
            return true;
        else if (tree1 == null || tree2 == null)
            return false;

        return leafSimilarNonNullTrees(tree1, tree2);
    }

    private boolean leafSimilarNonNullTrees(TreeNode root1, TreeNode root2) {
        final Deque<TreeNode> stack1 = new ArrayDeque<>();
        final Deque<TreeNode> stack2 = new ArrayDeque<>();

        stack1.push(root1);
        stack2.push(root2);

        while (!stack1.isEmpty() && !stack2.isEmpty())
            if (findNextLeafValue(stack1) != findNextLeafValue(stack2)) return false;

        return stack1.isEmpty() && stack2.isEmpty();

    }

    private int findNextLeafValue(Deque<TreeNode> stack) {
        while (true) {
            TreeNode t = stack.pop();
            if (t.right != null) stack.push(t.right);
            if (t.left != null) stack.push(t.left);
            if (t.left == null && t.right == null) return t.value;
        }
    }

}
