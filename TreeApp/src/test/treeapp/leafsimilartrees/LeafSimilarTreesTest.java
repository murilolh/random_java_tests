package treeapp.leafsimilartrees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import treeapp.domain.BinaryTreeNode;

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
        BinaryTreeNode root1 = new BinaryTreeNode(1);
        assertFalse(leafSimilarTrees.leafSimilar(root1, null));
        assertFalse(leafSimilarTrees.leafSimilar(null, root1));
    }

    @Test
    public void compareTreesWithOneElement() {
        BinaryTreeNode root1 = new BinaryTreeNode(1);
        BinaryTreeNode root2 = new BinaryTreeNode(1);

        assertTrue(leafSimilarTrees.leafSimilar(root1, root2));
    }

    @Test
    public void compareSimilarTreesWithMultipleElements() {
        BinaryTreeNode root1LeftNode = new BinaryTreeNode(1);
        BinaryTreeNode root1RightNode = new BinaryTreeNode(2);

        BinaryTreeNode root2LeftNode = new BinaryTreeNode(1);
        BinaryTreeNode root2RightNode = new BinaryTreeNode(2);

        BinaryTreeNode root1 = new BinaryTreeNode(root1LeftNode, root1RightNode);
        BinaryTreeNode root2 = new BinaryTreeNode(root2LeftNode, root2RightNode);

        assertTrue(leafSimilarTrees.leafSimilar(root1, root2));
    }

    @Test
    public void compareNonSimilarTreesWithMultipleElements() {
        BinaryTreeNode root1LeftNode = new BinaryTreeNode(1);
        BinaryTreeNode root1RightNode = new BinaryTreeNode(2);

        BinaryTreeNode root2LeftNode = new BinaryTreeNode(1);
        BinaryTreeNode root2RightNode = new BinaryTreeNode(Integer.MAX_VALUE);

        BinaryTreeNode root1 = new BinaryTreeNode(root1LeftNode, root1RightNode);
        BinaryTreeNode root2 = new BinaryTreeNode(root2LeftNode, root2RightNode);

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

        BinaryTreeNode tree1NodeG = new BinaryTreeNode(1);
        BinaryTreeNode tree1NodeH = new BinaryTreeNode(2);
        BinaryTreeNode tree1NodeI = new BinaryTreeNode(3);
        BinaryTreeNode tree1NodeJ = new BinaryTreeNode(4);
        BinaryTreeNode tree1NodeK = new BinaryTreeNode(5);
        BinaryTreeNode tree1NodeL = new BinaryTreeNode(6);
        BinaryTreeNode tree1NodeM = new BinaryTreeNode(7);
        BinaryTreeNode tree1NodeN = new BinaryTreeNode(8);

        BinaryTreeNode tree1NodeC = new BinaryTreeNode(tree1NodeG, tree1NodeH);
        BinaryTreeNode tree1NodeD = new BinaryTreeNode(tree1NodeI, tree1NodeJ);
        BinaryTreeNode tree1NodeE = new BinaryTreeNode(tree1NodeK, tree1NodeL);
        BinaryTreeNode tree1NodeF = new BinaryTreeNode(tree1NodeM, tree1NodeN);

        BinaryTreeNode tree1NodeA = new BinaryTreeNode(tree1NodeC, tree1NodeD);
        BinaryTreeNode tree1NodeB = new BinaryTreeNode(tree1NodeE, tree1NodeF);

        BinaryTreeNode root1 = new BinaryTreeNode(tree1NodeA, tree1NodeB);

        BinaryTreeNode tree2NodeG = new BinaryTreeNode(1);
        BinaryTreeNode tree2NodeH = new BinaryTreeNode(2);
        BinaryTreeNode tree2NodeI = new BinaryTreeNode(3);
        BinaryTreeNode tree2NodeJ = new BinaryTreeNode(4);
        BinaryTreeNode tree2NodeK = new BinaryTreeNode(5);
        BinaryTreeNode tree2NodeL = new BinaryTreeNode(6);
        BinaryTreeNode tree2NodeM = new BinaryTreeNode(7);
        BinaryTreeNode tree2NodeN = new BinaryTreeNode(8);

        BinaryTreeNode tree2NodeC = new BinaryTreeNode(tree2NodeG, tree2NodeH);
        BinaryTreeNode tree2NodeD = new BinaryTreeNode(tree2NodeI, tree2NodeJ);
        BinaryTreeNode tree2NodeE = new BinaryTreeNode(tree2NodeK, tree2NodeL);
        BinaryTreeNode tree2NodeF = new BinaryTreeNode(tree2NodeM, tree2NodeN);

        BinaryTreeNode tree2NodeA = new BinaryTreeNode(tree2NodeC, tree2NodeD);
        BinaryTreeNode tree2NodeB = new BinaryTreeNode(tree2NodeE, tree2NodeF);

        BinaryTreeNode root2 = new BinaryTreeNode(tree2NodeA, tree2NodeB);

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

        BinaryTreeNode tree1NodeG = new BinaryTreeNode(1);
        BinaryTreeNode tree1NodeH = new BinaryTreeNode(2);
        BinaryTreeNode tree1NodeI = new BinaryTreeNode(3);
        BinaryTreeNode tree1NodeJ = new BinaryTreeNode(4);
        BinaryTreeNode tree1NodeK = new BinaryTreeNode(5);
        BinaryTreeNode tree1NodeL = new BinaryTreeNode(6);
        BinaryTreeNode tree1NodeM = new BinaryTreeNode(7);
        BinaryTreeNode tree1NodeN = new BinaryTreeNode(8);

        BinaryTreeNode tree1NodeC = new BinaryTreeNode(tree1NodeG, tree1NodeH);
        BinaryTreeNode tree1NodeD = new BinaryTreeNode(tree1NodeI, tree1NodeJ);
        BinaryTreeNode tree1NodeE = new BinaryTreeNode(tree1NodeK, tree1NodeL);
        BinaryTreeNode tree1NodeF = new BinaryTreeNode(tree1NodeM, tree1NodeN);

        BinaryTreeNode tree1NodeA = new BinaryTreeNode(tree1NodeC, tree1NodeD);
        BinaryTreeNode tree1NodeB = new BinaryTreeNode(tree1NodeE, tree1NodeF);

        BinaryTreeNode root1 = new BinaryTreeNode(tree1NodeA, tree1NodeB);

        BinaryTreeNode tree2NodeG = new BinaryTreeNode(1);
        BinaryTreeNode tree2NodeH = new BinaryTreeNode(2);
        BinaryTreeNode tree2NodeI = new BinaryTreeNode(3);
        BinaryTreeNode tree2NodeJ = new BinaryTreeNode(4);
        BinaryTreeNode tree2NodeK = new BinaryTreeNode(5);
        BinaryTreeNode tree2NodeL = new BinaryTreeNode(6);
        BinaryTreeNode tree2NodeM = new BinaryTreeNode(7);
        BinaryTreeNode tree2NodeN = new BinaryTreeNode(Integer.MAX_VALUE);

        BinaryTreeNode tree2NodeC = new BinaryTreeNode(tree2NodeG, tree2NodeH);
        BinaryTreeNode tree2NodeD = new BinaryTreeNode(tree2NodeI, tree2NodeJ);
        BinaryTreeNode tree2NodeE = new BinaryTreeNode(tree2NodeK, tree2NodeL);
        BinaryTreeNode tree2NodeF = new BinaryTreeNode(tree2NodeM, tree2NodeN);

        BinaryTreeNode tree2NodeA = new BinaryTreeNode(tree2NodeC, tree2NodeD);
        BinaryTreeNode tree2NodeB = new BinaryTreeNode(tree2NodeE, tree2NodeF);

        BinaryTreeNode root2 = new BinaryTreeNode(tree2NodeA, tree2NodeB);

        assertFalse(leafSimilarTrees.leafSimilar(root1, root2));
    }

}
