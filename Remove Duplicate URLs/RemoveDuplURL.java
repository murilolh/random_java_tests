package com.random_tests_java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Class to remove duplicated URL's of a file. An URL is equal to another if
 * their value is equal. An URL is represented in a file as a name:value pair,
 * where the name is on odds lines and the value is in the next even line. A Set
 * is used to store only unique URL's.
 *
 */
public class RemoveDuplURL {

	public static void main(String[] args) throws IOException {

		File file = null;
		if (0 < args.length) {
			file = new File(args[0]);
		} else {
			System.err.println("Invalid arguments count:" + args.length);
			return;
		}

		String currentLine;
		String nextLine;
		BufferedReader br = new BufferedReader(new FileReader(file));
		Set<URL> urls = new HashSet<URL>();
		FileOutputStream output = new FileOutputStream(args[0] + " - altered.txt");

		while ((currentLine = br.readLine()) != null && (nextLine = br.readLine()) != null) {
			if (urls.add(new URL(currentLine, nextLine))) {
				output.write((currentLine + "\n").getBytes());
				output.write((nextLine + "\n").getBytes());
			}
		}

		output.flush();
		output.close();

		System.out.println("File " + args[0] + " - altered.txt created succesfully!");

	}

}
