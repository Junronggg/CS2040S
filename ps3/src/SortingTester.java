import javax.print.attribute.standard.OrientationRequested;
import java.util.Arrays;
import java.util.Random;

public class SortingTester {
    public static boolean checkSort(ISort sorter, int size) {
        // TODO: implement this
        KeyValuePair[] array = new KeyValuePair[size];

        //random number generator
        Random r = new Random();

        //initialize array
        for (int i = 0; i < size; i++) {
            array[i] = new KeyValuePair(r.nextInt(), 1);
        }

        sorter.sort(array);
        //check is array is sorted
        for (int i = 0; i < size - 1; i++) {
            if (array[i].compareTo(array[i + 1]) == 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isStable(ISort sorter, int size) {
        // TODO: implement this
        if (size <= 1) {
            return true;
        }
        KeyValuePair[] sortedArray = new KeyValuePair[size];
        KeyValuePair[] copiedArray = new KeyValuePair[size];

        //random number generator
        Random r = new Random();
        int randomKey = r.nextInt();

        //initialize array
        for (int i = 0; i < size; i++) {
            int randomValue = r.nextInt();
            sortedArray[i] = new KeyValuePair(randomKey, randomValue);
            copiedArray[i] = new KeyValuePair(randomKey, randomValue);
            //copy the sortedArray to copied array
        }

        //sort sortedArray, while copied array remains the same
        sorter.sort(sortedArray);

        //check if value remains the same
        for (int i = 0; i < size; i++) {
            if (sortedArray[i].getValue() != copiedArray[i].getValue()) {
                return false;
            }
        }

        return true;
    }

    public static boolean isInPlaceSort(ISort sorter, int size) {
        KeyValuePair[] array = new KeyValuePair[size];

        Random r = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = new KeyValuePair(r.nextInt(), r.nextInt());
        }

        // Store the reference (memory location)
        KeyValuePair[] originalReference = array;

        // Sort the array
        sorter.sort(array);

        // If the reference is unchanged and the array is sorted, then it is in-place
        return array == originalReference;
    }

    public static double timeComplexity(ISort sorter, int size) {
        KeyValuePair[] array = new KeyValuePair[size];

        Random r = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = new KeyValuePair(r.nextInt(), r.nextInt());
        }

        // Sort the array
        double cost = sorter.sort(array);
        return cost;
    }

    public static void main(String[] args) {
        // TODO: implement this
        ISort[] sorters = new ISort[6];
        sorters[0] = new SorterA();
        sorters[1] = new SorterB();
        sorters[2] = new SorterC();
        sorters[3] = new SorterD();
        sorters[4] = new SorterE();
        sorters[5] = new SorterF();

        //test A/C/F
//        //TEST RANDOM CASE:
//        //CHECK A:
//        System.out.println("check time complexity of random array using A: ");
//        for (int i=1000; i<10000; i+=1000) {
//            System.out.print(timeComplexity(sorters[0], i) + "  ");
//        }
//        System.out.println();
//        System.out.println("check time complexity difference when n grows by 1000 using A: ");
//        for (int i=1000; i<10000; i+=1000) {
//            System.out.print((timeComplexity(sorters[0], i+1000) - timeComplexity(sorters[0], i))/1000000 + "  ");
//        }
//
//        System.out.println();
//        //CHECK C:
//        System.out.println("check time complexity of random array using C: ");
//        for (int i=1000; i<10000; i+=1000) {
//            System.out.print(timeComplexity(sorters[2], i) + "  ");
//        }
//        System.out.println();
//        System.out.println("check time complexity difference when n grows by 1000 using C: ");
//        for (int i=1000; i<10000; i+=1000) {
//            System.out.print((timeComplexity(sorters[2], i+1000) - timeComplexity(sorters[2], i))/100000000 + "  ");
//        }
//
//        System.out.println();
//        //CHECK F:
//        System.out.println("check time complexity of random array using F: ");
//        for (int i=1000; i<10000; i+=1000) {
//            System.out.print(timeComplexity(sorters[5], i) + "  ");
//        }
//        System.out.println();
//        System.out.println("check time complexity difference when n grows by 1000 using F: ");
//        for (int i=1000; i<10000; i+=1000) {
//            System.out.print((timeComplexity(sorters[5], i+1000) - timeComplexity(sorters[5], i))/10000000 + "  ");
//        }
//
//        System.out.println();

        //TEST SORTED CASE:
        //sorted
        //CHECK A:
//        System.out.println("check time complexity of sorted array using A");
//        for (int i=10000; i<30000; i+=3000) {
//            KeyValuePair[] array = new KeyValuePair[i];
//            Random r = new Random();
//            for (int j=0; j<i; j++) {
//                array[j]=new KeyValuePair(j, r.nextInt());
//            }
//            System.out.print(sorters[0].sort(array) + "  ");
//        }
//
//        System.out.println();
//
//        //CHECK C:
//        System.out.println("check time complexity of sorted array using C");
//        for (int i=10000; i<30000; i+=3000) {
//            KeyValuePair[] array = new KeyValuePair[i];
//            Random r = new Random();
//            for (int j=0; j<i; j++) {
//                array[j]=new KeyValuePair(j, r.nextInt());
//            }
//
//            System.out.print(sorters[2].sort(array) + "  ");
//        }
//
//        System.out.println();
//
//        //CHECK F:
//        System.out.println("check time complexity of sorted array using F");
//        for (int i=10000; i<30000; i+=3000) {
//            KeyValuePair[] array = new KeyValuePair[i];
//            Random r = new Random();
//            for (int j=0; j<i; j++) {
//                array[j]=new KeyValuePair(j, r.nextInt());
//            }
//
//            System.out.print(sorters[5].sort(array) + "  ");
//        }


//        for (int i=2000; i<30000; i+=1000) {
//            KeyValuePair[] array = new KeyValuePair[i];
//            Random r = new Random();
//            for (int j=0; j<i; j++) {
//                array[j]=new KeyValuePair(j, r.nextInt());
//            }
//
//            System.out.println(sorters[3].sort(array));
//        }

//        System.out.println("check time complexity of A");
//        System.out.println(checkSort(sorters[0], 1000));
        //System.out.println(isStable(sorters[0], 1000));
//        System.out.println(timeComplexity(sorters[0], 1000));
//        System.out.println(timeComplexity(sorters[0], 3000));
//        System.out.println(timeComplexity(sorters[0], 9000));
//        System.out.println(timeComplexity(sorters[0], 27000));

//        System.out.println("check time complexity of C");
//        System.out.println(checkSort(sorters[2], 1000));
        //System.out.println(isStable(sorters[2], 1000));
//        System.out.println(timeComplexity(sorters[2], 1000));
//        System.out.println(timeComplexity(sorters[2], 3000));
//        System.out.println(timeComplexity(sorters[2], 9000));
//        System.out.println(timeComplexity(sorters[2], 27000));

//        System.out.println("check time complexity of D");
//        System.out.println(checkSort(sorters[3], 1000));
        //System.out.println(isStable(sorters[3], 1000));
//        System.out.println(timeComplexity(sorters[3], 1000));
//        System.out.println(timeComplexity(sorters[3], 3000));
//        System.out.println(timeComplexity(sorters[3], 9000));
//        System.out.println(timeComplexity(sorters[3], 27000));
//
//

//        System.out.println("check time complexity of F");
//        System.out.println(checkSort(sorters[5], 1000));
        //System.out.println(isStable(sorters[3], 10000));
//        System.out.println(timeComplexity(sorters[5], 1000));
//        System.out.println(timeComplexity(sorters[5], 3000));
//        System.out.println(timeComplexity(sorters[5], 9000));
//        System.out.println(timeComplexity(sorters[5], 27000));
////

        //CHECK D/E
        //random
        //CHECK D:
//        System.out.println("check time complexity of random array using D: ");
//        for (int i=1000; i<10000; i+=1000) {
//            System.out.print(timeComplexity(sorters[3], i) + "  ");
//        }
//        System.out.println();
//        System.out.println("check time complexity difference when n grows by 1000 using D: ");
//        for (int i=1000; i<10000; i+=1000) {
//            System.out.print((timeComplexity(sorters[3], i+1000) - timeComplexity(sorters[3], i))/100000000 + "  ");
//        }
//
//        System.out.println();
//        //CHECK E:
//        System.out.println("check time complexity of random array using E");
//        for (int i=1000; i<10000; i+=1000) {
//            System.out.print(timeComplexity(sorters[4], i) + "  ");
//        }
//        System.out.println();
//        System.out.println("check time complexity difference when n grows by 1000 using E: ");
//        for (int i=1000; i<10000; i+=1000) {
//            System.out.print((timeComplexity(sorters[4], i+1000) - timeComplexity(sorters[4], i))/1000000 + "  ");
//        }

        //sorted
        //CHECK D:
//        System.out.println("check time complexity of sorted array using D");
//        for (int i=10000; i<30000; i+=3000) {
//            KeyValuePair[] array = new KeyValuePair[i];
//            Random r = new Random();
//            for (int j=0; j<i; j++) {
//                array[j]=new KeyValuePair(j, r.nextInt());
//            }
//            System.out.print(sorters[3].sort(array) + "  ");
//        }
//
//        System.out.println();
//
//        //CHECK E:
//        System.out.println("check time complexity of sorted array using E");
//        for (int i=10000; i<30000; i+=3000) {
//            KeyValuePair[] array = new KeyValuePair[i];
//            Random r = new Random();
//            for (int j=0; j<i; j++) {
//                array[j]=new KeyValuePair(j, r.nextInt());
//            }
//
//            System.out.print(sorters[4].sort(array) + "  ");
//            System.out.print(sorters[4].sort(array) + "  ");
//        }

        //FIND EVIL
//        for (int i = 100; i < 30000; i *= 5) {
//            for (int j = 0; j < 6; j++) {
//                if (checkSort(sorters[j], i) == false) {
//                    System.out.println("the "+ (j + 1) + " sorter is Dr.Evil");
//                }
//            }
//        }

        //FIND UNSTABLE
//        for (int i = 0; i < 6; i ++) {
//
//                System.out.println("the " + (i + 1) + " sorter is " + isStable(sorters[i], 1000));
//
//        }

        //DIFFERENTIATE C/F
        //construct nearly sorted arrays
        System.out.println("check time complexity of nearly sorted array using C");
        for (int i=1000; i< 30000; i+=1000) {
            KeyValuePair[] array = new KeyValuePair[i];
            Random r = new Random();
            for (int j=0; j<i; j++) {
                array[j]=new KeyValuePair(j, r.nextInt());
            }
            //swap array[50] and array[100]
            KeyValuePair temp = array[50];
            array[50]=array[100];
            array[100]=temp;

            System.out.print(sorters[2].sort(array) + "  ");
        }

        System.out.println();

        //CHECK C:
        System.out.println("check time complexity of random array using C: ");
        for (int i=1000; i<10000; i+=1000) {
            System.out.print(timeComplexity(sorters[2], i) + "  ");
        }

        System.out.println();
        System.out.println("check time complexity of nearly sorted array using F");
        for (int i=1000; i< 30000; i+=1000) {
            KeyValuePair[] array = new KeyValuePair[i];
            Random r = new Random();
            for (int j=0; j<i; j++) {
                array[j]=new KeyValuePair(j, r.nextInt());
            }
            //swap array[50] and array[100]
            KeyValuePair temp = array[50];
            array[50]=array[100];
            array[100]=temp;

            System.out.print(sorters[5].sort(array) + "  ");
        }

        System.out.println();

        System.out.println("check time complexity of random array using F: ");
        for (int i=1000; i<10000; i+=1000) {
            System.out.print(timeComplexity(sorters[5], i) + "  ");
        }

    }
}
