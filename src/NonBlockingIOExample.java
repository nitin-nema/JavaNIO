import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NonBlockingIOExample {
    public static void main(String[] args) {
        try (FileChannel fileChannel = FileChannel.open(Paths.get(("input.txt")), StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (fileChannel.read(buffer) > 0) {
                buffer.flip();  // Switch from writing to reading
                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());
                }
                buffer.clear();  // Prepare buffer for next read
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
