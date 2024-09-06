
import java.nio.ByteBuffer;

public class NioFlipExample {

  public static void main(String[] args){
      ByteBuffer buffer = ByteBuffer.allocate(10);
      //Write data into the buffer
      buffer.put((byte) 'H');
      buffer.put((byte) 'e');
      buffer.put((byte) 'l');
      buffer.put((byte) 'l');
      buffer.put((byte) 'o');
      System.out.println("After writing, postion = " + buffer.position() + "limit ="+ buffer.limit());//10 --5

      //flip to read mode

      buffer.flip();

      System.out.println("After flip-- = " + buffer.position() + "limit =  "+ buffer.limit());// 0, 5

      //read data
      while(buffer.hasRemaining()){
          System.out.print((char) buffer.get());  // Hello
      }

      System.out.println("\n After reading, poistion = " + buffer.position() + ",limit =   "+ buffer.limit());//5- 5

  }
}
