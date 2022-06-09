package stringapp.encodedecode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EncodeDecodeTest {

    private EncodeDecode encodeDecode;

    @BeforeEach
    void setUp() {
        encodeDecode = new EncodeDecode();
    }

    static Stream<Arguments> encodeDecodeArguments() {
        return Stream.of(
                Arguments.of(List.of("Original", "List", "of", "Strings")),
                Arguments.of(List.of("Hello","World")),
                Arguments.of(List.of("")),
                Arguments.of(List.of("", "")),
                Arguments.of(List.of("","4 "))
        );
    }

    @ParameterizedTest
    @MethodSource("encodeDecodeArguments")
    void encodeDecodeTest(List<String> originalList) {
        String encodedString = encodeDecode.encode(originalList);
        List<String> decodedStringList = encodeDecode.decode(encodedString);

        assertEquals(originalList.size(), decodedStringList.size());
        for (int i = 0; i < originalList.size(); i++)
            assertEquals(originalList.get(i), decodedStringList.get(i));
    }
}
