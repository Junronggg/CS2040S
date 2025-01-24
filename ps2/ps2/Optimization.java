import java.sql.SQLOutput;

/**
 * The Optimization class contains a static routine to find the maximum in an array that changes direction at most once.
 */
public class Optimization {

    /**
     * A set of test cases.
     */
    static int[][] testCases = {
            {1, 3, 5, 7, 9, 11, 10, 8, 6, 4}, //increase, decrease
            {67, 65, 43, 42, 23, 17, 9, 100}, //decrease, increase
            {4, -100, -80, 15, 20, 25, 30}, //decrease, increase
            {2, 3, 4, 5, 6, 7, 8, 100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83}
    };

    /**
     * Returns the maximum item in the specified array of integers which changes direction at most once.
     *
     * @param dataArray an array of integers which changes direction at most once.
     * @return the maximum item in data Array
     */
    public static int searchMax(int[] dataArray) {
        // TODO: Implement this

        if (dataArray.length==0) {
            return 0;
        } else if (dataArray.length==1) {
            return dataArray[0];
        } else {
            //if the array is increasing then decreasing:
            if (dataArray[0]<dataArray[1]) {
                int begin=0;
                int end=dataArray.length-1;
                while (begin<end) {
                    int mid= (end+begin)/2;
                    if (dataArray[mid]<dataArray[mid+1]) {
                        begin=mid+1;
                        //System.out.println(begin);
                    } else {
                        end=mid;
                        //System.out.println(end);
                    }
                }
                return dataArray[begin];
            } else {
                return dataArray[0]<dataArray[dataArray.length-1] ? dataArray[dataArray.length-1]
                                                                  : dataArray[0];
            }


        }
    }

    /**
     * A routine to test the searchMax routine.
     */
    public static void main(String[] args) {
        for (int[] testCase : testCases) {
            System.out.println(searchMax(testCase));
        }
    }
}
