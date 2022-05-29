package listapp.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ReverseLinkedListTest {

    private ReverseLinkedList reverseLinkedList;

    @BeforeEach
    void setUp() {
        reverseLinkedList = new ReverseLinkedList();
    }

    @Test
    public void reverseNullList() {
        ListNode list = reverseLinkedList.reverseList(null);
        ListNode listRecursive = reverseLinkedList.reverseListRecursive(null);

        assertNull(list);
        assertNull(listRecursive);
    }

    @Test
    public void reverseListWithOneElement() {
        ListNode listToBeReversed = new ListNode(1);

        ListNode reversedList = reverseLinkedList.reverseList(listToBeReversed);
        ListNode reversedListRecursive = reverseLinkedList.reverseListRecursive(listToBeReversed);

        assertEquals(reversedList, listToBeReversed);
        assertEquals(reversedListRecursive, listToBeReversed);
    }

    static Stream<Arguments> reverseListArguments() {
        return Stream.of(
                Arguments.of(Collections.emptyList()),
                Arguments.of(Arrays.asList(1,2,3,4)),
                Arguments.of(Arrays.asList(1,2,3,4,5,6,7)),
                Arguments.of(Arrays.asList(Integer.MIN_VALUE,2,3,4,5,6,Integer.MAX_VALUE))
        );
    }

    @ParameterizedTest
    @MethodSource("reverseListArguments")
    public void reverseListsWithMultipleElements(List<Integer> elementList) {
        ListNode listToBeReversed = generateLinkedList(elementList.toArray());
        ListNode expectedReversedList = generateReversedList(elementList);

        ListNode reversedList = reverseLinkedList.reverseList(listToBeReversed);

        assertListNodeAreEqual(expectedReversedList, reversedList);
    }

    @ParameterizedTest
    @MethodSource("reverseListArguments")
    public void reverseListsWithMultipleElementsRecursive(List<Integer> elementList) {
        ListNode listToBeReversed = generateLinkedList(elementList.toArray());
        ListNode expectedReversedList = generateReversedList(elementList);

        ListNode reversedListRecursive = reverseLinkedList.reverseListRecursive(listToBeReversed);

        assertListNodeAreEqual(expectedReversedList, reversedListRecursive);
    }

    private ListNode generateLinkedList(Object... values) {
        ListNode currentNode = null;
        ListNode nextNode = null;
        for (int i = values.length - 1; i >= 0; i--) {
            currentNode = new ListNode((int) values[i], nextNode);
            nextNode = currentNode;
        }

        return currentNode;
    }

    private ListNode generateReversedList(List<Integer> elementList) {
        Collections.reverse(elementList);
        return generateLinkedList(elementList.toArray());
    }

    private void assertListNodeAreEqual(ListNode expectedReversedList, ListNode reversedList) {
        while (expectedReversedList != null && reversedList != null) {
            assertEquals(expectedReversedList.val, reversedList.val);
            expectedReversedList = expectedReversedList.next;
            reversedList = reversedList.next;
        }
    }
}
