package treeapp.search;

import treeapp.domain.BinaryTreeNode;

import java.util.*;

/**
 * BFS: Level Per Level - Queue
 * DFS: Stack or Recursion
 * ------ Preorder:  Root -> Left  -> Right
 * ------ Inorder:   Left -> Root  -> Right
 * ------ Postorder: Left -> Right -> Root
 */
public class TreeSearch {

    public List<Integer> search(BinaryTreeNode root, SearchType searchType) {
        if (root == null)
            return null;

        List<Integer> orderedValues = new LinkedList<>();

        if (SearchType.BFS.equals(searchType))
            bfs(root, orderedValues);
        else if (SearchType.BFS_ONLY_LEAFS.equals(searchType))
            bfsOnlyLeafs(root, orderedValues);
        else if (SearchType.DFS_ONLY_LEAFS_RECURSIVE.equals(searchType))
            dfsOnlyLeafsRecursive(root, orderedValues);
        else if (SearchType.DFS_ONLY_LEAFS_ITERATIVE.equals(searchType))
            dfsOnlyLeafsIterative(root, orderedValues);
        else if (SearchType.DFS_PREORDER_RECURSIVE.equals(searchType))
            dfsPreOrderRecursive(root, orderedValues);
        else if (SearchType.DFS_PREORDER_ITERATIVE.equals(searchType))
            dfsPreOrderIterative(root, orderedValues);
        else if (SearchType.DFS_INORDER_RECURSIVE.equals(searchType))
            dfsInOrderRecursive(root, orderedValues);
        else if (SearchType.DFS_INORDER_ITERATIVE.equals(searchType))
            dfsInOrderIterative(root, orderedValues);
        else if (SearchType.DFS_POSTORDER_RECURSIVE.equals(searchType))
            dfsPostOrderRecursive(root, orderedValues);
        else if (SearchType.DFS_POSTORDER_ITERATIVE.equals(searchType))
            dfsPostOrderIterative(root, orderedValues);

        return orderedValues;
    }

    // Queue: Pool the root and add the child nodes
    private void bfs(BinaryTreeNode root, List<Integer> orderedValues) {
        final Queue<BinaryTreeNode> consumerQueue = new LinkedList<>();
        consumerQueue.add(root);

        while (!consumerQueue.isEmpty()) {
            BinaryTreeNode node = consumerQueue.poll();

            orderedValues.add(node.value);

            if (node.left != null) consumerQueue.add(node.left);
            if (node.right != null) consumerQueue.add(node.right);
        }
    }

    private void bfsOnlyLeafs(BinaryTreeNode root, List<Integer> orderedValues) {
        final Queue<BinaryTreeNode> consumerQueue = new LinkedList<>();
        consumerQueue.add(root);

        while (!consumerQueue.isEmpty()) {
            BinaryTreeNode node = consumerQueue.poll();

            if (node.left == null && node.right == null) orderedValues.add(node.value);

            if (node.left != null) consumerQueue.add(node.left);
            if (node.right != null) consumerQueue.add(node.right);
        }
    }

    private void dfsOnlyLeafsRecursive(BinaryTreeNode root, List<Integer> orderedValues) {
        if (root.left == null && root.right == null) orderedValues.add(root.value);

        if (root.left != null) dfsOnlyLeafsRecursive(root.left, orderedValues);
        if (root.right != null) dfsOnlyLeafsRecursive(root.right, orderedValues);
    }

    private void dfsOnlyLeafsIterative(BinaryTreeNode root, List<Integer> orderedValues) {
        final Deque<BinaryTreeNode> recursionStack = new LinkedList<>();
        recursionStack.push(root);

        while (!recursionStack.isEmpty()) {
            BinaryTreeNode node = recursionStack.pop();

            if (node.left == null && node.right == null) orderedValues.add(node.value);;

            if (node.right != null) recursionStack.push(node.right);
            if (node.left != null) recursionStack.push(node.left);
        }
    }

    // Root -> Left -> Right
    private void dfsPreOrderRecursive(BinaryTreeNode root, List<Integer> orderedValues) {
        orderedValues.add(root.value);
        if (root.left != null) dfsPreOrderRecursive(root.left, orderedValues);
        if (root.right != null) dfsPreOrderRecursive(root.right, orderedValues);
    }

    // Stack: Pop the root and stack the child nodes
    private void dfsPreOrderIterative(BinaryTreeNode root, List<Integer> orderedValues) {
        final Deque<BinaryTreeNode> recursionStack = new LinkedList<>();
        recursionStack.push(root);

        while (!recursionStack.isEmpty()) {
            BinaryTreeNode node = recursionStack.pop();

            orderedValues.add(node.value);

            if (node.right != null) recursionStack.push(node.right);
            if (node.left != null) recursionStack.push(node.left);
        }
    }

    // Left -> Root -> Right
    private void dfsInOrderRecursive(BinaryTreeNode root, List<Integer> orderedValues) {
        if (root.left != null) dfsInOrderRecursive(root.left, orderedValues);
        orderedValues.add(root.value);
        if (root.right != null) dfsInOrderRecursive(root.right, orderedValues);
    }

    // At each step, walk all the way to the left (adding nodes along the way), then root, then right
    // Whenever there's no right to go, pop a node from the stack
    private void dfsInOrderIterative(BinaryTreeNode root, List<Integer> orderedValues) {
        final Deque<BinaryTreeNode> recursionStack = new LinkedList<>();
        BinaryTreeNode current = root;

        while (!recursionStack.isEmpty() || current != null) {
            while (current != null) {
                recursionStack.push(current);
                current = current.left;
            }

            current = recursionStack.pop();
            orderedValues.add(current.value);

            current = current.right;
        }
    }

    // Left -> Right -> Root
    private void dfsPostOrderRecursive(BinaryTreeNode root, List<Integer> orderedValues) {
        if (root.left != null) dfsPostOrderRecursive(root.left, orderedValues);
        if (root.right != null) dfsPostOrderRecursive(root.right, orderedValues);
        orderedValues.add(root.value);
    }

    // Use a Stack to do Root -> Right -> Left and then return the stack as a list to get the reversed order
    private void dfsPostOrderIterative(BinaryTreeNode root, List<Integer> orderedValues) {
        final Deque<Integer> valueStack = new LinkedList<>();
        final Deque<BinaryTreeNode> recursionStack = new LinkedList<>();
        recursionStack.push(root);

        while (!recursionStack.isEmpty()) {
            BinaryTreeNode node = recursionStack.pop();

            valueStack.push(node.value);

            if (node.left != null) recursionStack.push(node.left);
            if (node.right != null) recursionStack.push(node.right);
        }

        orderedValues.addAll(valueStack.stream().toList());
    }
}
