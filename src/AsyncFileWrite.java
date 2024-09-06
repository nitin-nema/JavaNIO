import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class AsyncFileWrite {
    public static void main(String[] args) {
        try (AsynchronousFileChannel asyncFileChannel = AsynchronousFileChannel.open(Paths.get("asyncoutput.txt"), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            ByteBuffer buffer = ByteBuffer.wrap("Asynchronous File Writing in NIO".getBytes());
            Future<Integer> result = asyncFileChannel.write(buffer, 0);

            while (!result.isDone()) {
                // Do something else while writing is in progress
                System.out.println("Writing to file...");
            }

            System.out.println("Write completed!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
