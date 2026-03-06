package utilities;

import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

    /**
     * Writes text to a file and overwrites existing content
     * @param filePath - absolute or relative file path
     * @param text - content to write
     */
    public static void writeToFile(String filePath, String text) {
        try (FileWriter writer = new FileWriter(filePath, false)) { // false = overwrite
            writer.write(text);
        } catch (IOException e) {
            System.out.println("⚠ Error writing file: " + e.getMessage());
        }
    }
}