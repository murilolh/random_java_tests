package listapp.mergesortedlinkedlists;

import listapp.domain.ListNode;
import listapp.utils.ListTestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class MergeSortedLinkedListsTest {

    private MergeSortedLinkedLists merge;
    private final ListTestUtils utils = new ListTestUtils();

    @BeforeEach
    void setUp() {
        merge = new MergeSortedLinkedLists();
    }

    static Stream<Arguments> mergeLinkedListsArguments() {
        return Stream.of(
                Arguments.of(Collections.emptyList(), Collections.emptyList(), Collections.emptyList()),
                Arguments.of(Arrays.asList(1, 2, 3, 4), Arrays.asList(5, 6, 7, 8), Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)),
                Arguments.of(Arrays.asList(1, 3, 5, 7), Arrays.asList(2, 4, 6, 8), Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8))
        );
    }

    @ParameterizedTest
    @MethodSource("mergeLinkedListsArguments")
    public void mergeLinkedListsTest(List<Integer> elements1, List<Integer> elements2, List<Integer> elementsResult) {
        ListNode list1 = utils.generateLinkedList(elements1);
        ListNode list2 = utils.generateLinkedList(elements2);
        ListNode expectedResult = utils.generateLinkedList(elementsResult);

        ListNode result = merge.mergeTwoLists(list1, list2);

        utils.assertListNodesAreEqual(expectedResult, result);
    }
}
