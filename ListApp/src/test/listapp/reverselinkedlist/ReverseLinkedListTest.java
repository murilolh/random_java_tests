package listapp.reverselinkedlist;

import listapp.domain.ListNode;
import listapp.utils.ListTestUtils;
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
    private final ListTestUtils utils = new ListTestUtils();

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
                Arguments.of(Arrays.asList(1, 2, 3, 4)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(Arrays.asList(Integer.MIN_VALUE, 2, 3, 4, 5, 6, Integer.MAX_VALUE))
        );
    }

    @ParameterizedTest
    @MethodSource("reverseListArguments")
    public void reverseListsWithMultipleElements(List<Integer> elementList) {
        ListNode listToBeReversed = utils.generateLinkedList(elementList);
        ListNode expectedReversedList = generateReversedList(elementList);

        ListNode reversedList = reverseLinkedList.reverseList(listToBeReversed);

        utils.assertListNodesAreEqual(expectedReversedList, reversedList);
    }

    @ParameterizedTest
    @MethodSource("reverseListArguments")
    public void reverseListsWithMultipleElementsRecursive(List<Integer> elementList) {
        ListNode listToBeReversed = utils.generateLinkedList(elementList);
        ListNode expectedReversedList = generateReversedList(elementList);

        ListNode reversedListRecursive = reverseLinkedList.reverseListRecursive(listToBeReversed);

        utils.assertListNodesAreEqual(expectedReversedList, reversedListRecursive);
    }

    private ListNode generateReversedList(List<Integer> elementList) {
        Collections.reverse(elementList);
        return utils.generateLinkedList(elementList);
    }
}
