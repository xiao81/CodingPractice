import com.sun.tools.javac.code.Attribute;

import java.util.Arrays;

/**
 * Created by xiaoxiao on 7/2/17.
 */
public class RangeAddition_370 {
    public static void main(String[] args) {
        RangeAddition_370 rangeAddition_370 = new RangeAddition_370();
        System.out.println(Arrays.toString(rangeAddition_370.getModifiedArray2(5,new int[][]{{1,  3,  2}, {2,  4,  3}, {0,  2, -2}})));

    }

    public int[] getModifiedArray(int length, int[][] updates) {
        int startIndex;
        int endIndex;
        int inc;
        int[] resultArr = new int[length];

        if (updates.length == 0) return resultArr;

        for (int i = 0; i < updates.length; i++) {
            startIndex = updates[i][0];
            endIndex = updates[i][1];
            inc = updates[i][2];
            for (int j = startIndex; j <= endIndex; j++) {
                resultArr[j] += inc;
            }
        }
        return resultArr;
    }

    //second method
    public int[] getModifiedArray2(int length, int[][] updates) {

        int[] resultArr = new int[length];

        if (updates.length == 0) return resultArr;

        for (int i = 0; i < updates.length; i++) {
            int startIndex;
            int endIndex;
            int inc;

            startIndex = updates[i][0];
            endIndex = updates[i][1];
            inc = updates[i][2];

            resultArr[startIndex] += inc;
            if (endIndex + 1 <= resultArr.length -1) resultArr[endIndex + 1] -= inc;
        }

        int sum = 0;
        for (int i = 0; i < resultArr.length; i++) {
            sum += resultArr[i];
            resultArr[i] = sum;
        }
        return resultArr;
    }
}
