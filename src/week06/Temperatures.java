package week06;

import java.nio.DoubleBuffer;

/**
 * Labs 1011-011
 * Purpose:
 *
 * @author wesolowskitj
 * @version 1.0 Created on 5/15/2015 at 3:58 PM
 */
public class Temperatures {
    public static void main(String[] args) {
        double[] dataIn = new double[] {1.3,.4,-.6,-1.2,-1.8,-2.1,-2.3,-1.3,-.8,.2,1.4,2.3,3.5,4.8,5.7,6.5,5.1,4.2,3,1.9,.6,.1,-.1,-.6};
        double[] dataOut = new double[24];
        DoubleBuffer buffer = DoubleBuffer.allocate(24);
        buffer.mark();
        //sets dataIn as buffer source, and reads the first 12 values from the array into the buffer
        //then prints the value at index 9 in the buffer and then resets the buffer to index 0.
        buffer.put(dataIn, 0, 12);
        buffer.limit(buffer.position());
        System.out.println(buffer.get(9));
        buffer.reset();
        //transfers the values in index 0-5 of the buffer to the destination array then sets the mark to index 5, the position
        //to 11, and the limit to the length of the buffer
        buffer.get(dataOut,0,6);
        buffer.mark();
        buffer.position(buffer.limit());
        buffer.limit(buffer.capacity());
        //reads the remaining values of dataIn into the buffer and resets the position to the mark placed at index 5
        buffer.put(dataIn,buffer.position(),buffer.remaining());
        buffer.reset();
        //transfers the remaining values of the buffer beginning at 11, into the dataOut array
        buffer.get(dataOut,buffer.position(),buffer.remaining());
    }
}
