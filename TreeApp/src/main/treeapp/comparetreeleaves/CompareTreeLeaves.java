package treeapp.comparetreeleaves;

import treeapp.domain.ArrayTreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Question: Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * Return true if and only two given trees with head nodes root1 and root2 are leaf-similar.
 */
public class CompareTreeLeaves {

    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    public static boolean compare(ArrayTreeNode tree1, ArrayTreeNode tree2) {
        if (tree1 == null && tree2 == null)
            return true;
        else if (tree1 == null || tree2 == null)
            return false;

        return compareNonNullTrees(tree1, tree2);
    }

    private static boolean compareNonNullTrees(ArrayTreeNode tree1, ArrayTreeNode tree2) {
        final Deque<ArrayTreeNode> stack1 = new ArrayDeque<>();
        final Deque<ArrayTreeNode> stack2 = new ArrayDeque<>();

        stack1.push(tree1);
        stack2.push(tree2);

        while (!stack1.isEmpty() && !stack2.isEmpty())
            if (findNextLeafValue(stack1) != findNextLeafValue(stack2))
                return false;

        return stack1.isEmpty() && stack2.isEmpty();
    }

    private static int findNextLeafValue(Deque<ArrayTreeNode> stack) {
        while (true) {
            ArrayTreeNode node = stack.pop();
            if (node.nodes[RIGHT] != null)
                stack.push(node.nodes[RIGHT]);
            if (node.nodes[LEFT] != null)
                stack.push(node.nodes[LEFT]);
            if (node.nodes[LEFT] == null && node.nodes[RIGHT] == null)
                return node.value;
        }
    }
}
