import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;


public class DatagramChannelExample {
    public static void main(String[] args) {
        try (DatagramChannel datagramChannel = DatagramChannel.open()) {
            //connection establishment
            datagramChannel.bind(new InetSocketAddress(5000));

            String message = "Hello, Serverrrrrr!";

            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());

            datagramChannel.send(buffer, new InetSocketAddress("localhost",5001));

            //receiving the data
            buffer.clear();
            datagramChannel.receive(buffer);

            buffer.flip();  // Switch to write mode

            while(buffer.hasRemaining()){
                System.out.print((char) buffer.get());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

