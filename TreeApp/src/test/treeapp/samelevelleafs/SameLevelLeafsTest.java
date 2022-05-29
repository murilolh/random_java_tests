package treeapp.samelevelleafs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import treeapp.domain.BinaryTreeNode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SameLevelLeafsTest {

    private static SameLevelLeafs sameLevelLeafs;

    @BeforeAll
    static void beforeAll() {
        sameLevelLeafs = new SameLevelLeafs();
    }

    @Test
    public void sameLevelLeafs() {
        assertTrue(sameLevelLeafs.sameLevelLeafs(generateSampleTree()));
    }

    @Test
    public void notSameLevelLeafs() {
        assertFalse(sameLevelLeafs.sameLevelLeafs(generateUnbalancedSampleTree()));
    }

    private BinaryTreeNode generateSampleTree() {
        return generateSampleTree(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
    }

    private BinaryTreeNode generateSampleTree(Integer... values) {
    /*
                1
         2                 3
     4       5         6        7
    8 9    10 11     12 13    14 15
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

    private BinaryTreeNode generateUnbalancedSampleTree() {
    /*
                1
         2                 3
     4       5         6        7
    8 9    10 11     12 13
    */
        BinaryTreeNode tree1NodeV7 = new BinaryTreeNode(8);
        BinaryTreeNode tree1NodeV8 = new BinaryTreeNode(9);
        BinaryTreeNode tree1NodeV9 = new BinaryTreeNode(10);
        BinaryTreeNode tree1NodeV10 = new BinaryTreeNode(11);
        BinaryTreeNode tree1NodeV11 = new BinaryTreeNode(12);
        BinaryTreeNode tree1NodeV12 = new BinaryTreeNode(13);

        BinaryTreeNode tree1NodeV3 = new BinaryTreeNode(4, tree1NodeV7, tree1NodeV8);
        BinaryTreeNode tree1NodeV4 = new BinaryTreeNode(5, tree1NodeV9, tree1NodeV10);
        BinaryTreeNode tree1NodeV5 = new BinaryTreeNode(6, tree1NodeV11, tree1NodeV12);
        BinaryTreeNode tree1NodeV6 = new BinaryTreeNode(7, null, null);

        BinaryTreeNode tree1NodeV1 = new BinaryTreeNode(2, tree1NodeV3, tree1NodeV4);
        BinaryTreeNode tree1NodeV2 = new BinaryTreeNode(3, tree1NodeV5, tree1NodeV6);

        return new BinaryTreeNode(1, tree1NodeV1, tree1NodeV2);
    }
}
