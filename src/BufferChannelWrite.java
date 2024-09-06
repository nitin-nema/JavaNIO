import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BufferChannelWrite {
    public static void main(String[] args) {
        try (FileChannel channel = FileChannel.open(Paths.get("outputttt.txt"), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            String message = "Hello, NIO!";
            buffer.put(message.getBytes());
            buffer.flip();  // Switch to write mode
            channel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
