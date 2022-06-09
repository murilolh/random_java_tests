package stringapp.anagram;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnagramTest {
    static Stream<Arguments> getIsAnagramArguments() {
        return Stream.of(
                Arguments.of("", "", true),
                Arguments.of("    ", " ", false),
                Arguments.of("aaaaaaaaa", "aaaaaaaaaa", false),
                Arguments.of("test", "stte", true),
                Arguments.of("abcdefghijklmnopqrstuvwxyz", "dguasmzerbcihvypkxqntfwloj", true),
                Arguments.of("babcdefghijklmnopqrstuvwxyz", "dguasmzerbcihvypkxqntfwloj", false)
        );
    }

    @ParameterizedTest
    @MethodSource("getIsAnagramArguments")
    void isAnagramArrayTest(String s1, String s2, boolean result) {
        assertEquals(result, Anagram.isAnagramArray(s1, s2));
    }

    @ParameterizedTest
    @MethodSource("getIsAnagramArguments")
    void isAnagramMapTest(String s1, String s2, boolean result) {
        assertEquals(result, Anagram.isAnagramMap(s1, s2));
    }

    static Stream<Arguments> getFindAnagramsArguments() {
        return Stream.of(
                Arguments.of("cbaebabacd", "abc", List.of(0, 6)),
                Arguments.of("abab", "ab", List.of(0, 1, 2)),
                Arguments.of("abcdefghijklmnopqrstuvwxyz", "dguasmzerbcihvypkxqntfwloj", List.of(0)),
                Arguments.of("abbaabbaabba", "ab", List.of(0, 2, 4, 6, 8, 10)),
                Arguments.of("ababababababababababababab", "ab", List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24)),
                Arguments.of("adsgahtstejdtjhadgjahdstestasdkjgadhjkghttsejadk", "etst", List.of(6, 23, 40)),
                Arguments.of("0tt1e2s3test4567test89test", "etst", List.of(8, 16, 22)),
                Arguments.of("akhfasksbcxnbzCEARAxwuyfgsdiicearajkasdn,mbhjkcn\n\t2348\n743jhcnmbzxch1276asbcalakacera327fd &&^&*%&*bsdfhg\nsdfsadjhsdeaacr32897324sdfnasdfjhlskad",
                        "ceara", List.of(29, 80, 116))
        );
    }

    @ParameterizedTest
    @MethodSource("getFindAnagramsArguments")
    void findAnagramsTest(String s1, String s2, List<Integer> result) {
        assertEquals(result, Anagram.findAnagrams(s1, s2));
    }

    static Stream<Arguments> getGroupAnagramsArguments() {
        return Stream.of(
                Arguments.of(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}, List.of(List.of("bat"), List.of("nat", "tan"), List.of("ate","eat","tea"))),
                Arguments.of(new String[]{""}, List.of(List.of(""))),
                Arguments.of(new String[]{"a"}, List.of(List.of("a")))
        );
    }

    @ParameterizedTest
    @MethodSource("getGroupAnagramsArguments")
    void groupAnagramsTest(String[] strings, List<List<String>> expectedResult) {
        List<List<String>> result = Anagram.groupAnagrams(strings);
        for (List<String> resultList : result)
            assertTrue(assertThatListExists(expectedResult, resultList));
    }

    private boolean assertThatListExists(List<List<String>> expectedResult, List<String> resultList) {
        for (List<String> expectedResultList: expectedResult)
            if (expectedResultList.containsAll(resultList))
                return true;
        return false;
    }
}
