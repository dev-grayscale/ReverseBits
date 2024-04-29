/**
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * Note that in some languages, such as Java, there is no unsigned integer type.
 * In this case, both input and output will be given as a signed integer type.
 * They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation.
 *
 * Input: n = 00000010100101000001111010011100
 * Output: 964176192 (00111001011110000010100101000000)
 */
public class Main {
  /**
   * 1. Pass through all the 32 bits, starting from LSB and heading to MSB of the input.
   * 2. Get the current bit and place it at the LSB position in the result
   * 3. Shift the bits in <b>result</b> to MSB direction and free the LSB for the next one
   *
   * Pushing and shifting this way results to reverse as long as you pass through all 32 bits and do not
   * omit 0s.
   *
   * The problem could also be solved using StringBuilder that holds the bits, then swap the elements with the counterpart positions
   * as you traverse through the first half, similar to how it's done here: https://algorational.com/posts/reverse-a-string#solution-3
   */
  public static int reverseBits(int n) {
    int result = 0;

    for (int i = 0; i < Integer.BYTES * 8; i++, n >>>= 1) {
      result = (result << 1 | (1 & n));
    }

    return result;
  }
}
