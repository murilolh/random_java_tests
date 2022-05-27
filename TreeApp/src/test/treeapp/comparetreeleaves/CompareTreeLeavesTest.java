package treeapp.comparetreeleaves;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompareTreeLeavesTest {

    @Test
    public void nullTreesAreSimilar() {
        assertTrue(CompareTreeLeaves.compare(null, null));
    }

    @Test
    public void oneNullTreeIsNotSimilarToANonNullTree() {
        ArrayTreeNode root1 = new ArrayTreeNode(1, null);
        assertFalse(CompareTreeLeaves.compare(root1, null));
        assertFalse(CompareTreeLeaves.compare(null, root1));
    }

    @Test
    public void compareTreesWithOneElement() {
        ArrayTreeNode root1 = new ArrayTreeNode(1, null);
        ArrayTreeNode root2 = new ArrayTreeNode(1, null);

        assertTrue(CompareTreeLeaves.compare(root1, root2));
    }

    @Test
    public void compareSimilarTreesWithMultipleElements() {
        ArrayTreeNode root1LeftNode = new ArrayTreeNode(1, null);
        ArrayTreeNode root1RightNode = new ArrayTreeNode(2, null);

        ArrayTreeNode root2LeftNode = new ArrayTreeNode(1, null);
        ArrayTreeNode root2RightNode = new ArrayTreeNode(2, null);

        ArrayTreeNode root1 = new ArrayTreeNode(0, new ArrayTreeNode[]{root1LeftNode, root1RightNode});
        ArrayTreeNode root2 = new ArrayTreeNode(0, new ArrayTreeNode[]{root2LeftNode, root2RightNode});

        assertTrue(CompareTreeLeaves.compare(root1, root2));
    }

    @Test
    public void compareNonSimilarTreesWithMultipleElements() {
        ArrayTreeNode root1LeftNode = new ArrayTreeNode(1, null);
        ArrayTreeNode root1RightNode = new ArrayTreeNode(2, null);

        ArrayTreeNode root2LeftNode = new ArrayTreeNode(1, null);
        ArrayTreeNode root2RightNode = new ArrayTreeNode(3, null);

        ArrayTreeNode root1 = new ArrayTreeNode(0, new ArrayTreeNode[]{root1LeftNode, root1RightNode});
        ArrayTreeNode root2 = new ArrayTreeNode(0, new ArrayTreeNode[]{root2LeftNode, root2RightNode});

        assertFalse(CompareTreeLeaves.compare(root1, root2));
    }

    @Test
    public void compareComplexSimilarTreesWithMultipleElements() {
        /*
                root
             A          B
         C      D    E       F
        G H    I J  K L     M N 
        */

        ArrayTreeNode tree1NodeG = new ArrayTreeNode(1, null);
        ArrayTreeNode tree1NodeH = new ArrayTreeNode(2, null);
        ArrayTreeNode tree1NodeI = new ArrayTreeNode(3, null);
        ArrayTreeNode tree1NodeJ = new ArrayTreeNode(4, null);
        ArrayTreeNode tree1NodeK = new ArrayTreeNode(5, null);
        ArrayTreeNode tree1NodeL = new ArrayTreeNode(6, null);
        ArrayTreeNode tree1NodeM = new ArrayTreeNode(7, null);
        ArrayTreeNode tree1NodeN = new ArrayTreeNode(8, null);

        ArrayTreeNode tree1NodeC = new ArrayTreeNode(0, new ArrayTreeNode[]{tree1NodeG, tree1NodeH});
        ArrayTreeNode tree1NodeD = new ArrayTreeNode(0, new ArrayTreeNode[]{tree1NodeI, tree1NodeJ});
        ArrayTreeNode tree1NodeE = new ArrayTreeNode(0, new ArrayTreeNode[]{tree1NodeK, tree1NodeL});
        ArrayTreeNode tree1NodeF = new ArrayTreeNode(0, new ArrayTreeNode[]{tree1NodeM, tree1NodeN});
        
        ArrayTreeNode tree1NodeA = new ArrayTreeNode(0, new ArrayTreeNode[]{tree1NodeC, tree1NodeD});
        ArrayTreeNode tree1NodeB = new ArrayTreeNode(0, new ArrayTreeNode[]{tree1NodeE, tree1NodeF});

        ArrayTreeNode root1 = new ArrayTreeNode(0, new ArrayTreeNode[]{tree1NodeA, tree1NodeB});

        ArrayTreeNode tree2NodeG = new ArrayTreeNode(1, null);
        ArrayTreeNode tree2NodeH = new ArrayTreeNode(2, null);
        ArrayTreeNode tree2NodeI = new ArrayTreeNode(3, null);
        ArrayTreeNode tree2NodeJ = new ArrayTreeNode(4, null);
        ArrayTreeNode tree2NodeK = new ArrayTreeNode(5, null);
        ArrayTreeNode tree2NodeL = new ArrayTreeNode(6, null);
        ArrayTreeNode tree2NodeM = new ArrayTreeNode(7, null);
        ArrayTreeNode tree2NodeN = new ArrayTreeNode(8, null);

        ArrayTreeNode tree2NodeC = new ArrayTreeNode(0, new ArrayTreeNode[]{tree2NodeG, tree2NodeH});
        ArrayTreeNode tree2NodeD = new ArrayTreeNode(0, new ArrayTreeNode[]{tree2NodeI, tree2NodeJ});
        ArrayTreeNode tree2NodeE = new ArrayTreeNode(0, new ArrayTreeNode[]{tree2NodeK, tree2NodeL});
        ArrayTreeNode tree2NodeF = new ArrayTreeNode(0, new ArrayTreeNode[]{tree2NodeM, tree2NodeN});

        ArrayTreeNode tree2NodeA = new ArrayTreeNode(0, new ArrayTreeNode[]{tree2NodeC, tree2NodeD});
        ArrayTreeNode tree2NodeB = new ArrayTreeNode(0, new ArrayTreeNode[]{tree2NodeE, tree2NodeF});

        ArrayTreeNode root2 = new ArrayTreeNode(0, new ArrayTreeNode[]{tree2NodeA, tree2NodeB});

        assertTrue(CompareTreeLeaves.compare(root1, root2));
    }

    @Test
    public void compareComplexNonSimilarTreesWithMultipleElements() {
        /*
                root
             A          B
         C      D    E       F
        G H    I J  K L     M N
        */

        ArrayTreeNode tree1NodeG = new ArrayTreeNode(1, null);
        ArrayTreeNode tree1NodeH = new ArrayTreeNode(2, null);
        ArrayTreeNode tree1NodeI = new ArrayTreeNode(3, null);
        ArrayTreeNode tree1NodeJ = new ArrayTreeNode(4, null);
        ArrayTreeNode tree1NodeK = new ArrayTreeNode(5, null);
        ArrayTreeNode tree1NodeL = new ArrayTreeNode(6, null);
        ArrayTreeNode tree1NodeM = new ArrayTreeNode(7, null);
        ArrayTreeNode tree1NodeN = new ArrayTreeNode(8, null);

        ArrayTreeNode tree1NodeC = new ArrayTreeNode(0, new ArrayTreeNode[]{tree1NodeG, tree1NodeH});
        ArrayTreeNode tree1NodeD = new ArrayTreeNode(0, new ArrayTreeNode[]{tree1NodeI, tree1NodeJ});
        ArrayTreeNode tree1NodeE = new ArrayTreeNode(0, new ArrayTreeNode[]{tree1NodeK, tree1NodeL});
        ArrayTreeNode tree1NodeF = new ArrayTreeNode(0, new ArrayTreeNode[]{tree1NodeM, tree1NodeN});

        ArrayTreeNode tree1NodeA = new ArrayTreeNode(0, new ArrayTreeNode[]{tree1NodeC, tree1NodeD});
        ArrayTreeNode tree1NodeB = new ArrayTreeNode(0, new ArrayTreeNode[]{tree1NodeE, tree1NodeF});

        ArrayTreeNode root1 = new ArrayTreeNode(0, new ArrayTreeNode[]{tree1NodeA, tree1NodeB});

        ArrayTreeNode tree2NodeG = new ArrayTreeNode(1, null);
        ArrayTreeNode tree2NodeH = new ArrayTreeNode(2, null);
        ArrayTreeNode tree2NodeI = new ArrayTreeNode(3, null);
        ArrayTreeNode tree2NodeJ = new ArrayTreeNode(4, null);
        ArrayTreeNode tree2NodeK = new ArrayTreeNode(5, null);
        ArrayTreeNode tree2NodeL = new ArrayTreeNode(6, null);
        ArrayTreeNode tree2NodeM = new ArrayTreeNode(7, null);
        ArrayTreeNode tree2NodeN = new ArrayTreeNode(Integer.MAX_VALUE, null);

        ArrayTreeNode tree2NodeC = new ArrayTreeNode(0, new ArrayTreeNode[]{tree2NodeG, tree2NodeH});
        ArrayTreeNode tree2NodeD = new ArrayTreeNode(0, new ArrayTreeNode[]{tree2NodeI, tree2NodeJ});
        ArrayTreeNode tree2NodeE = new ArrayTreeNode(0, new ArrayTreeNode[]{tree2NodeK, tree2NodeL});
        ArrayTreeNode tree2NodeF = new ArrayTreeNode(0, new ArrayTreeNode[]{tree2NodeM, tree2NodeN});

        ArrayTreeNode tree2NodeA = new ArrayTreeNode(0, new ArrayTreeNode[]{tree2NodeC, tree2NodeD});
        ArrayTreeNode tree2NodeB = new ArrayTreeNode(0, new ArrayTreeNode[]{tree2NodeE, tree2NodeF});

        ArrayTreeNode root2 = new ArrayTreeNode(0, new ArrayTreeNode[]{tree2NodeA, tree2NodeB});

        assertFalse(CompareTreeLeaves.compare(root1, root2));
    }
}

