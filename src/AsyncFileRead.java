import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class AsyncFileRead {
    public static void main(String[] args) {
        try (AsynchronousFileChannel asyncFileChannel = AsynchronousFileChannel.open(Paths.get("asyncinput.txt"), StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // result of the read operation
            Future<Integer> result = asyncFileChannel.read(buffer, 0);

            while (!result.isDone()) {
                // Do something else while the read is happening
                System.out.println("Waiting for the file to be read...");
            }

            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
