import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.IOException;
import java.nio.file.*;

public class CopyFileExample {
    public static void main(String[] args) {

        Path sourceFilePath =Paths.get("source.txt");
        Path destinationFilePath = Paths.get("destination.txt");

        try {
            // Creating a file
            Files.createFile(sourceFilePath);

            // Writing to the file
            Files.write(sourceFilePath, "This is Java NIO!".getBytes());

            // Reading from the file
            String content = Files.readString(sourceFilePath);
            System.out.println("File content: " + content);

            //copy
            Files.copy(sourceFilePath,destinationFilePath,StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied to " + destinationFilePath);

            //Read from copied files
            String copiedContent = Files.readString(destinationFilePath);
            System.out.println("File content: " + copiedContent);

            // Deleting the file
            Files.delete(sourceFilePath);
            Files.delete(destinationFilePath);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
