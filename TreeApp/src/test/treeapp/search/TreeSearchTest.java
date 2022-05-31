package treeapp.search;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import treeapp.domain.BinaryTreeNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TreeSearchTest {

    private static TreeSearch treeDFS;

    @BeforeAll
    static void beforeAll() {
        treeDFS = new TreeSearch();
    }

    @Test
    public void nullTree() {
        assertNull(treeDFS.search(null, SearchType.BFS));
    }

    @Test
    void bfsOnlyLeafsTest() {
        assertExpectedLeafs(treeDFS.search(generateBFSSampleTree(), SearchType.BFS_ONLY_LEAFS));
    }

    @Test
    void dfsRecursiveOnlyLeafsTest() {
        assertExpectedLeafs(treeDFS.search(generateBFSSampleTree(), SearchType.DFS_ONLY_LEAFS_RECURSIVE));
    }

    @Test
    void dfsIterativeOnlyLeafsTest() {
        assertExpectedLeafs(treeDFS.search(generateBFSSampleTree(), SearchType.DFS_ONLY_LEAFS_ITERATIVE));
    }

    @Test
    void dfsBFsTest() {
        assertExpected(treeDFS.search(generateBFSSampleTree(), SearchType.BFS));
    }

    @Test
    void dfsPreOrderRecursiveTest() {
        assertExpected(treeDFS.search(generateDFSPreOrderSampleTree(), SearchType.DFS_PREORDER_RECURSIVE));
    }

    @Test
    void dfsPreOrderIterativeTest() {
        assertExpected(treeDFS.search(generateDFSPreOrderSampleTree(), SearchType.DFS_PREORDER_ITERATIVE));
    }

    @Test
    void dfsInOrderRecursiveTest() {
        assertExpected(treeDFS.search(generateDFSInOrderSampleTree(), SearchType.DFS_INORDER_RECURSIVE));
    }

    @Test
    void dfsInOrderIterativeTest() {
        assertExpected(treeDFS.search(generateDFSInOrderSampleTree(), SearchType.DFS_INORDER_ITERATIVE));
    }

    @Test
    void dfsPostOrderRecursiveTest() {
        assertExpected(treeDFS.search(generateDFSPostOrderSampleTree(), SearchType.DFS_POSTORDER_RECURSIVE));
    }

    @Test
    void dfsPostOrderIterativeTest() {
        assertExpected(treeDFS.search(generateDFSPostOrderSampleTree(), SearchType.DFS_POSTORDER_ITERATIVE));
    }

    /*
                1
         2                 3
     4       5         6        7
    8 9    10 11     12 13    14 15
    */
    private BinaryTreeNode generateBFSSampleTree() {
        return generateSampleTree(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
    }

    /*  Root -> Left -> Right
                1
         2              9
     3      6       10       13
    4 5    7 8     11 12    14 15
    */
    private BinaryTreeNode generateDFSPreOrderSampleTree() {
        return generateSampleTree(1, 2, 9, 3, 6, 10, 13, 4, 5, 7, 8, 11, 12, 14, 15);
    }

    /*  Left -> Root -> Right
                8
         4              12
     2      6       10       14
    1 3    5 7     9 11     13 15
    */
    private BinaryTreeNode generateDFSInOrderSampleTree() {
        return generateSampleTree(8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15);
    }

    /*  Left -> Right -> Root
                15
         7              14
     3      6       10       13
    1 2    4 5     8  9     11 12
    */
    private BinaryTreeNode generateDFSPostOrderSampleTree() {
        return generateSampleTree(15, 7, 14, 3, 6, 10, 13, 1, 2, 4, 5, 8, 9, 11, 12);
    }

    private BinaryTreeNode generateSampleTree(Integer... values) {
    /*
                      v0
            v1                    v2
       v3       v4          v5          v6
     v7  v8   v9  v10    v11  v12    v13  v14
    */

        BinaryTreeNode tree1NodeV7 = new BinaryTreeNode(values[7]);
        BinaryTreeNode tree1NodeV8 = new BinaryTreeNode(values[8]);
        BinaryTreeNode tree1NodeV9 = new BinaryTreeNode(values[9]);
        BinaryTreeNode tree1NodeV10 = new BinaryTreeNode(values[10]);
        BinaryTreeNode tree1NodeV11 = new BinaryTreeNode(values[11]);
        BinaryTreeNode tree1NodeV12 = new BinaryTreeNode(values[12]);
        BinaryTreeNode tree1NodeV13 = new BinaryTreeNode(values[13]);
        BinaryTreeNode tree1NodeV14 = new BinaryTreeNode(values[14]);

        BinaryTreeNode tree1NodeV3 = new BinaryTreeNode(values[3], tree1NodeV7, tree1NodeV8);
        BinaryTreeNode tree1NodeV4 = new BinaryTreeNode(values[4], tree1NodeV9, tree1NodeV10);
        BinaryTreeNode tree1NodeV5 = new BinaryTreeNode(values[5], tree1NodeV11, tree1NodeV12);
        BinaryTreeNode tree1NodeV6 = new BinaryTreeNode(values[6], tree1NodeV13, tree1NodeV14);

        BinaryTreeNode tree1NodeV1 = new BinaryTreeNode(values[1], tree1NodeV3, tree1NodeV4);
        BinaryTreeNode tree1NodeV2 = new BinaryTreeNode(values[2], tree1NodeV5, tree1NodeV6);

        return new BinaryTreeNode(values[0], tree1NodeV1, tree1NodeV2);
    }

    private void assertExpected(List<Integer> orderedValues) {
        assertEquals(generateExpectedList(), orderedValues);
    }

    private List<Integer> generateExpectedList() {
        return List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
    }

    private void assertExpectedLeafs(List<Integer> orderedValues) {
        assertEquals(generateExpectedLeafList(), orderedValues);
    }

    private List<Integer> generateExpectedLeafList() {
        return List.of(8,9,10,11,12,13,14,15);
    }
}
