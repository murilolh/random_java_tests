package bookapp.service;

import bookapp.domain.Document;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DocumentServiceImplTest {

    private DocumentServiceImpl documentService;
    private List<Document> documentList;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        documentService = new DocumentServiceImpl();
        documentList = new ArrayList<>();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void sortDocumentListTest() {
        generateDummyDocumentList();

        documentService.sortDocumentList(documentList);

        for (int i = 0; i < documentList.size() - 1; i++) {
            if (documentList.get(i).getCreatedBy().equals(documentList.get(i + 1).getCreatedBy()))
                assertTrue(documentList.get(i).getCreatedTime() <= documentList.get(i + 1).getCreatedTime());
            else {
                assertTrue(documentList.get(i).getCreatedBy().compareTo(documentList.get(i + 1).getCreatedBy()) < 0);
            }
        }
    }

    @Test
    public void truncateShortDocumentDescriptionTest() {
        String documentDescription = "Short document desc.";
        String truncatedDescription = documentService.truncateDocumentDescription(documentDescription);

        assertEquals(documentDescription, truncatedDescription);
    }

    @Test
    public void truncateLongWordDocumentDescriptionTest() {
        String documentDescription = "ThisIsAReallyLongSingleWord";
        String truncatedDescription = documentService.truncateDocumentDescription(documentDescription);

        assertEquals("ThisIsAReallyLongSingleW ...", truncatedDescription);
    }

    @Test
    public void truncateLongPhraseDocumentDescriptionTest() {
        String documentDescription = "This Is A Really Long Description.";
        String truncatedDescription = documentService.truncateDocumentDescription(documentDescription);

        assertEquals("This Is A Really Long ...", truncatedDescription);
    }

    static Stream<Arguments> getFriendlyDocumentSizeTestArguments() {
        return Stream.of(
                Arguments.of(1L, "1 bytes"),

                Arguments.of(6L, "6 bytes"),
                Arguments.of(6000L, "6 kb"),
                Arguments.of(6000000L, "6 mb"),
                Arguments.of(6000000000L, "6 gb"),

                Arguments.of(5497558138880L, "5 tb"),
                Arguments.of(6000000000000L, "5 tb"),
                Arguments.of(6597069766656L, "6 tb"),

                Arguments.of(5629499534213120L, "5 pb"),
                Arguments.of(6000000000000000L, "5 pb"),
                Arguments.of(6755399441055744L, "6 pb"),

                Arguments.of(5764607523034235000L, "5 eb"),
                Arguments.of(6000000000000000000L, "5 eb"),
                Arguments.of(6917529027641082000L, "6 eb"));
    }

    @ParameterizedTest
    @MethodSource("getFriendlyDocumentSizeTestArguments")
    public void getFriendlyDocumentSizeTest(Long givenSizeInBytes, String expectedFriendlyString) {
        String friendlyString = documentService.getFriendlyDocumentSize(givenSizeInBytes);

        assertEquals(expectedFriendlyString, friendlyString);
    }

    static Stream<Arguments> getFormattedDocumentDateTestArguments() {
        return Stream.of(
                Arguments.of(1262322000000L, "2010-01-01"),
                Arguments.of(1262408399000L, "2010-01-01"),
                Arguments.of(1262408400000L, "2010-01-02"),
                Arguments.of(1652414400000L, "2022-05-13"));
    }

    @ParameterizedTest
    @MethodSource("getFormattedDocumentDateTestArguments")
    public void getFormattedDocumentDateTest(Long givenLongDate, String expectedDate) {
        String formattedDate = documentService.getFormattedDocumentDate(givenLongDate);

        assertEquals(expectedDate, formattedDate);
    }

    @Test
    public void printDocumentsReportTest() {
        generateDummyDocumentList();

        documentService.printDocumentsReport(documentList);

        String expectedOutput = "Author1" + System.lineSeparator() +
                "\t\"Name5\", \"Longer than 25 chars ...\", 222 mb, 2013-05-09, 2019-03-08" + System.lineSeparator() +
                "\t\"Name1\", \"Description of Small Size\", 902 kb, 2019-03-08, 2019-03-08" + System.lineSeparator() +
                "\t\"Name2\", \"Very small size.\", 81 gb, 2019-03-08, 2019-03-08" + System.lineSeparator() +
                "Author2" + System.lineSeparator() +
                "\t\"Name3\", \"Long last single word ...\", 6 mb, 2019-03-08, 2019-03-08" + System.lineSeparator() +
                "\t\"Name4\", \"Long description with ...\", 413 kb, 2019-03-08, 2019-03-08";

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    private void generateDummyDocumentList() {
        documentList.add(new Document("Name1", "Description of Small Size",
                "Author1", "Author1",
                924000L, 1552058240105L, 1552058240105L));
        documentList.add(new Document("Name2", "Very small size.",
                "Author1", "Author1",
                87000000000L, 1552058240105L, 1552058240105L));
        documentList.add(new Document("Name3", "Long last single word wooooooooooooooooooooooord.",
                "Author2", "Author2",
                6000000L, 1552058240105L, 1552058240105L));
        documentList.add(new Document("Name4", "Long description with long last words.",
                "Author2", "Author2",
                423000L, 1552058240105L, 1552058240105L));
        documentList.add(new Document("Name5", "Longer than 25 chars description.",
                "Author1", "Author1",
                233000000L, 1368144000000L, 1552058240105L));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
