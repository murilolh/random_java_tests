package treeapp.leafsimilartrees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeafSimilarTreesTest {

    private LeafSimilarTrees leafSimilarTrees;

    @BeforeEach
    void setUp() {
        leafSimilarTrees = new LeafSimilarTrees();
    }

    @Test
    public void nullTreesAreSimilar() {
        assertTrue(leafSimilarTrees.leafSimilar(null, null));
    }

    @Test
    public void oneNullTreeIsNotSimilarToANonNullTree() {
        TreeNode root1 = new TreeNode(1);
        assertFalse(leafSimilarTrees.leafSimilar(root1, null));
        assertFalse(leafSimilarTrees.leafSimilar(null, root1));
    }

    @Test
    public void compareTreesWithOneElement() {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1);

        assertTrue(leafSimilarTrees.leafSimilar(root1, root2));
    }

    @Test
    public void compareSimilarTreesWithMultipleElements() {
        TreeNode root1LeftNode = new TreeNode(1);
        TreeNode root1RightNode = new TreeNode(2);

        TreeNode root2LeftNode = new TreeNode(1);
        TreeNode root2RightNode = new TreeNode(2);

        TreeNode root1 = new TreeNode(root1LeftNode, root1RightNode);
        TreeNode root2 = new TreeNode(root2LeftNode, root2RightNode);

        assertTrue(leafSimilarTrees.leafSimilar(root1, root2));
    }

    @Test
    public void compareNonSimilarTreesWithMultipleElements() {
        TreeNode root1LeftNode = new TreeNode(1);
        TreeNode root1RightNode = new TreeNode(2);

        TreeNode root2LeftNode = new TreeNode(1);
        TreeNode root2RightNode = new TreeNode(Integer.MAX_VALUE);

        TreeNode root1 = new TreeNode(root1LeftNode, root1RightNode);
        TreeNode root2 = new TreeNode(root2LeftNode, root2RightNode);

        assertFalse(leafSimilarTrees.leafSimilar(root1, root2));
    }

    @Test
    public void compareComplexSimilarTreesWithMultipleElements() {
        /*
                root
             A          B
         C      D    E       F
        G H    I J  K L     M N 
        */

        TreeNode tree1NodeG = new TreeNode(1);
        TreeNode tree1NodeH = new TreeNode(2);
        TreeNode tree1NodeI = new TreeNode(3);
        TreeNode tree1NodeJ = new TreeNode(4);
        TreeNode tree1NodeK = new TreeNode(5);
        TreeNode tree1NodeL = new TreeNode(6);
        TreeNode tree1NodeM = new TreeNode(7);
        TreeNode tree1NodeN = new TreeNode(8);

        TreeNode tree1NodeC = new TreeNode(tree1NodeG, tree1NodeH);
        TreeNode tree1NodeD = new TreeNode(tree1NodeI, tree1NodeJ);
        TreeNode tree1NodeE = new TreeNode(tree1NodeK, tree1NodeL);
        TreeNode tree1NodeF = new TreeNode(tree1NodeM, tree1NodeN);

        TreeNode tree1NodeA = new TreeNode(tree1NodeC, tree1NodeD);
        TreeNode tree1NodeB = new TreeNode(tree1NodeE, tree1NodeF);

        TreeNode root1 = new TreeNode(tree1NodeA, tree1NodeB);

        TreeNode tree2NodeG = new TreeNode(1);
        TreeNode tree2NodeH = new TreeNode(2);
        TreeNode tree2NodeI = new TreeNode(3);
        TreeNode tree2NodeJ = new TreeNode(4);
        TreeNode tree2NodeK = new TreeNode(5);
        TreeNode tree2NodeL = new TreeNode(6);
        TreeNode tree2NodeM = new TreeNode(7);
        TreeNode tree2NodeN = new TreeNode(8);

        TreeNode tree2NodeC = new TreeNode(tree2NodeG, tree2NodeH);
        TreeNode tree2NodeD = new TreeNode(tree2NodeI, tree2NodeJ);
        TreeNode tree2NodeE = new TreeNode(tree2NodeK, tree2NodeL);
        TreeNode tree2NodeF = new TreeNode(tree2NodeM, tree2NodeN);

        TreeNode tree2NodeA = new TreeNode(tree2NodeC, tree2NodeD);
        TreeNode tree2NodeB = new TreeNode(tree2NodeE, tree2NodeF);

        TreeNode root2 = new TreeNode(tree2NodeA, tree2NodeB);

        assertTrue(leafSimilarTrees.leafSimilar(root1, root2));
    }

    @Test
    public void compareComplexNonSimilarTreesWithMultipleElements() {
        /*
                root
             A          B
         C      D    E       F
        G H    I J  K L     M N
        */

        TreeNode tree1NodeG = new TreeNode(1);
        TreeNode tree1NodeH = new TreeNode(2);
        TreeNode tree1NodeI = new TreeNode(3);
        TreeNode tree1NodeJ = new TreeNode(4);
        TreeNode tree1NodeK = new TreeNode(5);
        TreeNode tree1NodeL = new TreeNode(6);
        TreeNode tree1NodeM = new TreeNode(7);
        TreeNode tree1NodeN = new TreeNode(8);

        TreeNode tree1NodeC = new TreeNode(tree1NodeG, tree1NodeH);
        TreeNode tree1NodeD = new TreeNode(tree1NodeI, tree1NodeJ);
        TreeNode tree1NodeE = new TreeNode(tree1NodeK, tree1NodeL);
        TreeNode tree1NodeF = new TreeNode(tree1NodeM, tree1NodeN);

        TreeNode tree1NodeA = new TreeNode(tree1NodeC, tree1NodeD);
        TreeNode tree1NodeB = new TreeNode(tree1NodeE, tree1NodeF);

        TreeNode root1 = new TreeNode(tree1NodeA, tree1NodeB);

        TreeNode tree2NodeG = new TreeNode(1);
        TreeNode tree2NodeH = new TreeNode(2);
        TreeNode tree2NodeI = new TreeNode(3);
        TreeNode tree2NodeJ = new TreeNode(4);
        TreeNode tree2NodeK = new TreeNode(5);
        TreeNode tree2NodeL = new TreeNode(6);
        TreeNode tree2NodeM = new TreeNode(7);
        TreeNode tree2NodeN = new TreeNode(Integer.MAX_VALUE);

        TreeNode tree2NodeC = new TreeNode(tree2NodeG, tree2NodeH);
        TreeNode tree2NodeD = new TreeNode(tree2NodeI, tree2NodeJ);
        TreeNode tree2NodeE = new TreeNode(tree2NodeK, tree2NodeL);
        TreeNode tree2NodeF = new TreeNode(tree2NodeM, tree2NodeN);

        TreeNode tree2NodeA = new TreeNode(tree2NodeC, tree2NodeD);
        TreeNode tree2NodeB = new TreeNode(tree2NodeE, tree2NodeF);

        TreeNode root2 = new TreeNode(tree2NodeA, tree2NodeB);

        assertFalse(leafSimilarTrees.leafSimilar(root1, root2));
    }

}
