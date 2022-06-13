package listapp.mergesortedlinkedlists;

import listapp.domain.ListNode;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 * LC: 21
 */
public class MergeSortedLinkedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        final ListNode newRoot = new ListNode();

        ListNode currentNode = newRoot;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                currentNode.next = list1;
                list1 = list1.next;
            } else {
                currentNode.next = list2;
                list2 = list2.next;
            }
            currentNode = currentNode.next;
        }
        currentNode.next = list1 != null ? list1 : list2;

        return newRoot.next;
    }
}
