import java.io.IOException;
import java.nio.file.*;

public class FileHandlingNIO {
    public static void main(String[] args) {
        try {
            // Creating a file
            Path filePath = Paths.get("sampleText.txt");
            Files.createFile(filePath);

            // Writing to the file
            Files.write(filePath, "This is Java NIO!".getBytes());

            // Reading from the file
            String content = Files.readString(filePath);
            System.out.println("File content: " + content);

            // Deleting the file
            Files.delete(filePath);

            //copy
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
