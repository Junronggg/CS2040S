public class Test {
    public static void main (String[] args) {
        int[] array = new int[] {0, 1, 0, 1, 1, 1, 1, 0, 1};
        ShiftRegister2 shifter = new ShiftRegister2(9, 7);
        shifter.setSeed(array);


        for (int i = 0; i < 10; i++) {
            int j = shifter.generate(3);
            System.out.println(j);
        }
    }
}
