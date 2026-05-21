package edu.miracosta.cs112.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A generic utility class for reading CSV files using a Scanner.
 * It reads each row and parses the data into a List of Strings.
 */
public class CSVReader { // Renamed from GenericCsvReader to CSVReader

    /**
     * Reads a CSV file from the given file path using a Scanner.
     * Each row is parsed into a List of Strings, and all rows are returned as a List of List of Strings.
     *
     * @param filePath The absolute path to the CSV file.
     * @param delimiter The delimiter used in the CSV file (e.g., ",").
     * @return A List where each element is a List of Strings representing a row in the CSV.
     * @throws FileNotFoundException If the file specified by filePath does not exist.
     */
    public static List<List<String>> readCsv(String filePath, String delimiter) throws FileNotFoundException {
        List<List<String>> records = new ArrayList<>();
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                List<String> row = parseCsvLine(line, delimiter);
                records.add(row);
            }
        }
        return records;
    }

    /**
     * Parses a single line of CSV data into a List of Strings.
     *
     * @param line The CSV line to parse.
     * @param delimiter The delimiter used in the CSV line.
     * @return A List of Strings representing the fields in the line.
     */
    private static List<String> parseCsvLine(String line, String delimiter) {
        List<String> fields = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(delimiter);
            while (rowScanner.hasNext()) {
                fields.add(rowScanner.next().trim());
            }
        }
        return fields;
    }
}
