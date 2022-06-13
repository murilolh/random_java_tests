package listapp.utils;

import listapp.domain.ListNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ListTestUtils {
    public ListNode generateLinkedList(List<Integer> values) {
        ListNode currentNode = null;
        ListNode nextNode = null;
        for (int i = values.size() - 1; i >= 0; i--) {
            currentNode = new ListNode((int) values.get(i), nextNode);
            nextNode = currentNode;
        }

        return currentNode;
    }

    public void assertListNodesAreEqual(ListNode expectedList, ListNode resultList) {
        while (expectedList != null && resultList != null) {
            assertEquals(expectedList.val, resultList.val);
            expectedList = expectedList.next;
            resultList = resultList.next;
        }
        assertNull(expectedList);
        assertNull(resultList);
    }
}
