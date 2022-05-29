package treeapp.deepclone;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import treeapp.domain.BinaryTreeNode;

import static org.junit.jupiter.api.Assertions.*;

public class TreeDeepCloneTest {

    private static TreeDeepClone treeDeepClone;

    @BeforeAll
    static void beforeAll() {
        treeDeepClone = new TreeDeepClone();
    }

    @Test
    void deepCloneDFSRecursiveTest() {
        BinaryTreeNode original = generateSampleTree();
        assertDifferentObjectSameValues(original, treeDeepClone.deepCloneDFSRecursive(original));
    }

    private void assertDifferentObjectSameValues(BinaryTreeNode original, BinaryTreeNode deepClone) {
        if (original != null && deepClone != null) {
            assertNotEquals(original, deepClone);
            assertEquals(original.value, deepClone.value);
            assertDifferentObjectSameValues(original.left, deepClone.left);
            assertDifferentObjectSameValues(original.right, deepClone.right);
        } else {
            assertNull(original);
            assertNull(deepClone);
        }
    }

    private BinaryTreeNode generateSampleTree() {
        return generateSampleTree(1, 2, 9, 3, 6, 10, 13, 4, 5, 7, 8, 11, 12, 14, 15);
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
}
