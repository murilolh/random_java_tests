package bookapp.service;

import bookapp.domain.Document;
import org.jetbrains.annotations.VisibleForTesting;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.List;

public class DocumentServiceImpl implements DocumentService {

    private static final int UNIT = 1024;
    private static final int DESCRIPTION_MAX_SIZE = 25;
    private static final String BYTE_REPRESENTATION = " bytes";
    private static final String LARGE_SIZE_REPRESENTATION = "kmgtpe";
    private static final String TRUNCATE_STRING = "...";

    @Override
    public void printDocumentsReport(List<Document> documents) {
        sortDocumentList(documents);
        printDocumentList(documents);
    }

    @VisibleForTesting
    protected void sortDocumentList(List<Document> documents) {
        documents.sort(Comparator.comparing(Document::getCreatedBy)
                .thenComparing(Document::getCreatedTime));
    }

    @VisibleForTesting
    protected void printDocumentList(List<Document> documents) {
        String currentCreatedBy = null;
        for (Document document : documents) {
            if (currentCreatedBy == null || !currentCreatedBy.equals(document.getCreatedBy())) {
                currentCreatedBy = document.getCreatedBy();
                System.out.println(document.getCreatedBy());
            }
            printFormattedDocument(document);
        }
    }

    @VisibleForTesting
    protected void printFormattedDocument(Document document) {
        System.out.println("\t" +
                "\"" + document.getName() + "\", " +
                "\"" + truncateDocumentDescription(document.getDescription()) + "\", " +
                getFriendlyDocumentSize(document.getSizeInBytes()) + ", " +
                getFormattedDocumentDate(document.getCreatedTime()) + ", " +
                getFormattedDocumentDate(document.getModifiedTime()));
    }

    @VisibleForTesting
    protected String truncateDocumentDescription(String documentDescription) {
        if (documentDescription.length() <= DESCRIPTION_MAX_SIZE)
            return documentDescription;

        return truncateLongDocumentDescription(documentDescription);
    }

    private String truncateLongDocumentDescription(String documentDescription) {
        String[] splitDescription = documentDescription.split(" ");

        if (splitDescription[0].length() > DESCRIPTION_MAX_SIZE) {
            return truncateLongWord(splitDescription[0]);
        }

        return truncateLongPhrase(splitDescription);
    }

    private String truncateLongWord(String s) {
        return s.substring(0, DESCRIPTION_MAX_SIZE - 1) + " " + TRUNCATE_STRING;
    }

    private String truncateLongPhrase(String[] phrase) {
        StringBuilder result = new StringBuilder();
        for (String word : phrase) {
            if (result.length() + word.length() < DESCRIPTION_MAX_SIZE) {
                result.append(word).append(" ");
            } else {
                result.append(TRUNCATE_STRING);
                break;
            }
        }

        return result.toString();
    }

    @VisibleForTesting
    protected String getFriendlyDocumentSize(long documentSizeInBytes) {
        if (documentSizeInBytes < UNIT)
            return documentSizeInBytes + BYTE_REPRESENTATION;

        return getFriendlyLargeDocumentSize(documentSizeInBytes);
    }

    private String getFriendlyLargeDocumentSize(long documentSizeInBytes) {
        final int exp = (int) (Math.log(documentSizeInBytes) / Math.log(UNIT));
        final double finalValue = Math.abs(documentSizeInBytes / Math.pow(UNIT, exp));
        final String finalUnit = String.valueOf(LARGE_SIZE_REPRESENTATION.charAt(exp - 1));

        return String.format("%.0f %sb", finalValue, finalUnit);
    }

    @VisibleForTesting
    protected String getFormattedDocumentDate(Long date) {
        return Instant
                .ofEpochMilli(date)
                .atZone(ZoneId.systemDefault())
                .toLocalDate()
                .toString();
    }
}
