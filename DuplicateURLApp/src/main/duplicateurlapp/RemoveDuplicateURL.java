package duplicateurlapp;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Class to remove duplicated URL's of a file. A URL is equal to another if their value is equal.
 * A URL is represented in a file as a name:value pair, where the name is on odds lines and the value
 * is in the next even line. A Set is used to store only unique URL's.
 */
public class RemoveDuplicateURL {

    public static void main(String[] args) throws IOException {
        if (0 < args.length) {
            generateNewFileWithoutDuplicates(args[0]);
        } else {
            System.err.println("Invalid arguments count:" + args.length);
        }
    }

    private static void generateNewFileWithoutDuplicates(String argument) throws IOException {
        BufferedReader br = getBufferedReader(argument);
        FileOutputStream output = createOutputFileWithoutDuplications(argument, br);
        saveOutputFile(argument, output);
    }

    private static BufferedReader getBufferedReader(String argument) throws FileNotFoundException {
        File file = new File(argument);
        return new BufferedReader(new FileReader(file));
    }

    private static FileOutputStream createOutputFileWithoutDuplications(String argument, BufferedReader br) throws IOException {
        String nextLine;
        String currentLine;
        Set<String> urls = new HashSet<>();

        FileOutputStream output = new FileOutputStream(argument + " - altered.txt");
        while ((currentLine = br.readLine()) != null && (nextLine = br.readLine()) != null) {
            if (urls.add(nextLine)) {
                output.write((currentLine + "\n").getBytes());
                output.write((nextLine + "\n").getBytes());
            }
        }

        return output;
    }

    private static void saveOutputFile(String argument, FileOutputStream output) throws IOException {
        output.flush();
        output.close();
        System.out.println("File " + argument + " - altered.txt created successfully!");
    }
}
