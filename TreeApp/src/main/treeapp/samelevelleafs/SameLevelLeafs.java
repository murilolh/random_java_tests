package treeapp.samelevelleafs;

import treeapp.domain.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SameLevelLeafs {

    public boolean sameLevelLeafs(BinaryTreeNode root) {
        final Queue<BinaryTreeNode> consumerQueue = new LinkedList<>();
        consumerQueue.add(root);

        int currentNodeIndex = 1;
        int earliestLeafLevel = Integer.MAX_VALUE;

        while (!consumerQueue.isEmpty()) {
            BinaryTreeNode node = consumerQueue.poll();

            if(node.left == null && node.right == null) {
                int currentLevel = getCurrentTreeLevel(currentNodeIndex);

                if (!isFirstLeaf(earliestLeafLevel) && (currentLevel != earliestLeafLevel))
                    return false;

                earliestLeafLevel = currentLevel;
            }

            if (node.left != null) consumerQueue.add(node.left);
            if (node.right != null) consumerQueue.add(node.right);
            currentNodeIndex++;
        }

        return true;
    }

    private boolean isFirstLeaf(int earliestLeafLevel) {
        return earliestLeafLevel == Integer.MAX_VALUE;
    }

    private int getCurrentTreeLevel(int currentNodeIndex) {
        return (int) Math.floor(Math.log(currentNodeIndex) / Math.log(2));
    }
}
