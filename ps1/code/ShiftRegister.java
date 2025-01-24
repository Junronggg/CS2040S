///////////////////////////////////
// This is the main shift register class.
// Notice that it implements the ILFShiftRegister interface.
// You will need to fill in the functionality.
///////////////////////////////////

/**
 * class ShiftRegister
 * @author
 * Description: implements the ILFShiftRegister interface.
 */
public class ShiftRegister implements ILFShiftRegister {
    ///////////////////////////////////
    // Create your class variables here
    ///////////////////////////////////
    // TODO:
    int[] _seed;
    int tap;

    ///////////////////////////////////
    // Create your constructor here:
    ///////////////////////////////////
    ShiftRegister(int size, int tap) {
        // TODO:
        _seed=new int [size];
        this.tap=tap;

    }

    ///////////////////////////////////
    // Create your class methods here:
    ///////////////////////////////////
    /**
     * setSeed
     * @param seed
     * Description: : Sets the shift register to the specified initial seed.
     * If the array contains any other value, it reports an error
     */
    @Override
    public void setSeed(int[] seed) {
        // TODO:
        if (seed.length != _seed.length) {
            System.out.println("the length is wrong");
        } else {
            for (int i = 0; i < seed.length; i++) {
                if (seed[i] != 0 && seed[i] != 1) {
                    System.out.println("error: seed only accepts 0 or 1");
                } else {
                    _seed[i] = seed[seed.length - 1 - i];
                }
            }
        }

    }

    /**
     * shift
     * @return
     * Description: Executes one shift step and
     * returns the least significant bit (right most) of the resulting register.
     */
    @Override
    public int shift() {
        // TODO:
        int least_sig = _seed[0] ^ _seed[_seed.length-1-tap];    //XOR: results in 1 iff the two inputs are diff
        for (int i=0; i< _seed.length-1; i++) {
            _seed[i]=_seed[i+1];
        }
        _seed[_seed.length-1]=least_sig;
        return least_sig;



    }

    /**
     * generate
     * @param k
     * @return
     * Description: executes the shift operation k times, saving the k bits returned.
     * It then converts these k bits from binary into an integer.
     * For example: if generate is called with a value of 3, then it calls shift 3 times.
     * If the shift operations return 1 and then 1 and then 0, then generate returns the
     * value 6 (i.e., “110” in binary).
     */
    @Override
    public int generate(int k) {
        // TODO:
        int sum = 0;
        for (int i=1; i<=k; i++) {
            sum+=shift() * (int)Math.pow(2, k-i);
        }
        return sum;

    }

    /**
     * Returns the integer representation for a binary int array.
     * @param array
     * @return
     */
    private int toDecimal(int[] array) {
        // TODO:
        int result=0;
        int length=array.length;
        if (length!=0) {
            for (int i=length-1; i>=0; i--) {
                int base=1;
                for (int j=0; j<i; j++) {
                    base*=2;
                }
                result+=array[length-1-i]*base;
            }
        }
        return result;
    }
}
