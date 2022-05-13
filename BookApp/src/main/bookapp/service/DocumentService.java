package bookapp.service;

import bookapp.domain.Document;

import java.util.List;

public interface DocumentService {

    /**
     * Prints a report of the list of documents in the following format:
     *
     * Group by document.createdBy
     * Sort the groups using document.createdBy ascending, case-insensitive
     *      Sort each sub list of documents by document.createdTime ascending
     * Format the output of document.size to be a more friendly format. Ex.  50 mb, 900 k, 342 bytes, etc...
     * Format the dates using the format: yyyy-MM-dd
     * Format the output of document.description such that
     *  - no more than the first 25 characters of the description are displayed
     *  - don't truncate any words unless the first word is longer than 25 characters
     *  - display "..." at the end of the description to indicate that it has been truncated
     *  (these three characters do not count as part of the 25-character limit)
     *
     * Example:
     * Author1
     * 	    "Name5", "Longer than 25 chars  ...", 222 mb, 2013-05-09, 2019-03-08
     *  	"Name1", "Description of Small Size", 902 kb, 2019-03-08, 2019-03-08
     * 	    "Name2", "Very small size.", 81 gb, 2019-03-08, 2019-03-08
     * Author2
     * 	    "Name3", "Long last single word  ...", 6 mb, 2019-03-08, 2019-03-08
     * 	    "Name4", "Long description with  ...", 413 kb, 2019-03-08, 2019-03-08
     */
    void printDocumentsReport(List<Document> documents);
}
