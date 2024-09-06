import java.io.FileReader;
import  java.io.BufferedReader;
import java.io.IOException;

public class BlockingIOExample {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {  // read line by line
                System.out.println(line);  // Blocking call
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
// read() - char by char
//readLine() - line by line

