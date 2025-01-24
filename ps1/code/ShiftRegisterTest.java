import org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * ShiftRegisterTest
 * @author dcsslg
 * Description: set of tests for a shift register implementation
 */
public class ShiftRegisterTest {
    /**
     * Returns a shift register to test.
     * @param size
     * @param tap
     * @return a new shift register
     */
    ILFShiftRegister getRegister(int size, int tap) {
        return new ShiftRegister(size, tap);
    }

    /**
     * Tests shift with simple example.
     */
    @Test
    public void testShift1() {
        ILFShiftRegister r = getRegister(9, 7);
        int[] seed = { 0, 1, 0, 1, 1, 1, 1, 0, 1 };
        r.setSeed(seed);
        int[] expected = { 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        for (int i = 0; i < 10; i++) {
            assertEquals(expected[i], r.shift());
        }
    }

    /**
     * Tests generate with simple example.
     */
    @Test
    public void testGenerate1() {
        ILFShiftRegister r = getRegister(9, 7);
        int[] seed = { 0, 1, 0, 1, 1, 1, 1, 0, 1 };
        r.setSeed(seed);
        int[] expected = { 6, 1, 7, 2, 2, 1, 6, 6, 2, 3 };
        for (int i = 0; i < 10; i++) {
            assertEquals("GenerateTest", expected[i], r.generate(3));
        }
    }

    /**
     * Tests register of length 1.
     */
    @Test
    public void testOneLength() {
        ILFShiftRegister r = getRegister(1, 0);
        int[] seed = { 1 };
        r.setSeed(seed);
        int[] expected = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, };
        for (int i = 0; i < 10; i++) {
            assertEquals(expected[i], r.generate(3));
        }
    }

    /**
     * Tests with erroneous seed.
     */
    @Test
    public void testError() {
        ILFShiftRegister r = getRegister(4, 1);
        int[] seed = { 1, 0, 0, 0, 1, 1, 0 };
        r.setSeed(seed);
        r.shift();
        r.generate(4);
    }

    /**
     *  the result should return that the input seed length
     *  is not the same as the size specified in the constructor getRegister.
     *  the method setSeed in class shiftRegister can be modified to report the error:
     *  public void setSeed(int[] seed) {
     *         // TODO:
     *         if (seed.length != _seed.length) {
     *             System.out.println("the length is wrong");
     *         } else {
     *             for (int i = 0; i < seed.length; i++) {
     *                 if (seed[i] != 0 && seed[i] != 1) {
     *                     System.out.println("error: seed only accepts 0 or 1");
     *                 } else {
     *                     _seed[i] = seed[seed.length - 1 - i];
     *                 }
     *             }
     *         }
     *     }
     */

    /**
     * Tests with erroneous tap number (tap exceeds the length).
     */
    public void testErrorTap() {
        ILFShiftRegister r = getRegister(7, 9);
        int[] seed = { 1, 0, 0, 0, 1, 1, 0 };
        r.setSeed(seed);
        r.shift();
        r.generate(4);
    }

    /**
     * Tests with erroneous seed (seed containing other values than 0/1).
     */
    public void testErrorSeed() {
        ILFShiftRegister r = getRegister(7, 1);
        int[] seed = { 1, 2, 3, 0, 1, 1, 0 };
        r.setSeed(seed);
        r.shift();
        r.generate(4);
    }
}
