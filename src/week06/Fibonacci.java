package week06;

import java.nio.DoubleBuffer;
import java.nio.IntBuffer;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.function.DoubleBinaryOperator;

/**
 * Labs 1011-011
 * Purpose:
 *
 * @author wesolowskitj
 * @version 1.0 Created on 5/15/2015 at 4:36 PM
 */
public class Fibonacci {
    public static void main(String[] args) {
        int[] sequence = new int[]{1,1,2,3,5,8};
        double[] ratio = new double[]{1.0,2.0,1.5,1.67,1.6};
        IntBuffer seq_buffer = IntBuffer.allocate(sequence.length);
        DoubleBuffer ratio_buffer;
        DecimalFormat df = new DecimalFormat("#.########");
        for (int i = 0; i < 20; i++) {
            seq_buffer = IntBuffer.allocate(sequence.length+1);
            seq_buffer.mark();
            seq_buffer.limit(seq_buffer.capacity());
            seq_buffer.put(sequence);
            seq_buffer.put((seq_buffer.get(seq_buffer.limit()-2)+seq_buffer.get(seq_buffer.limit()-3)));
            sequence = new int[seq_buffer.capacity()];
            seq_buffer.reset();
            seq_buffer.get(sequence);
            System.out.println(Arrays.toString(sequence));
        }
        for (int i = 0; i < 20; i++) {
            ratio_buffer = DoubleBuffer.allocate(ratio.length+1);
            ratio_buffer.mark();
            ratio_buffer.limit(ratio_buffer.capacity());
            ratio_buffer.put(ratio);
            ratio_buffer.put(((double)seq_buffer.get(ratio_buffer.limit()) / seq_buffer.get(ratio_buffer.limit()-1)));
            ratio = new double[ratio_buffer.capacity()];
            ratio_buffer.reset();
            ratio_buffer.get(ratio);
            System.out.println(Arrays.toString(ratio));
        }
        System.out.println("The Golden Ratio is: " + df.format(ratio[ratio.length-1]));
    }
}
