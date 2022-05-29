package listapp.app;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list. LC: 206
 */
public class ReverseLinkedList {
    /*
    null	<-	1	<-	2	<-	3	<-	4	<-	5	<-	6		null
    nh			h		n

    n = h.n
    h.n = nh
    nh = h
    h = n

    */
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;
    }

    public ListNode reverseListRecursive(ListNode head) {
        return (head == null || head.next == null) ? head : reverseListRecursive(head, null);
    }

    private ListNode reverseListRecursive(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;

        ListNode next = head.next;
        head.next = newHead;

        return reverseListRecursive(next, head);
    }
}
