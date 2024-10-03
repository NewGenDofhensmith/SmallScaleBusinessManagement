package Common;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Scanner;

@Component
public class FileUtility {

    public static String readFile(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = reader.readLine();
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = reader.readLine();
        }
        reader.close();
        return sb.toString();
    }
    public static String writeFile(String filePath, String content) throws IOException {
        // Create a File object for the specified file path
        File file = new File(filePath);

        // Open a BufferedWriter to write to the file
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        // Write the content to the file
        writer.write(content);
        writer.close();

        // Open a Scanner to read the content of the file
        Scanner scanner = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine());
            sb.append(System.lineSeparator());
        }
        scanner.close();

        // Return the content of the file as a String
        return sb.toString();
    }

}
