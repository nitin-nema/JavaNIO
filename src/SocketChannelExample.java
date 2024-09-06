import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import  java.net.InetSocketAddress;


public class SocketChannelExample {
    public static void main(String[] args) {
        try (SocketChannel socketChannel = SocketChannel.open()) {
            //connection establishment
            socketChannel.connect(new InetSocketAddress("localhost",5000));
            String message = "Hello, Serverrrrrr!";

            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
            socketChannel.write(buffer);

            //read respone
            buffer.clear();
            socketChannel.read(buffer);
            buffer.flip();  // Switch to write mode

            while(buffer.hasRemaining()){
                System.out.print((char) buffer.get());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
