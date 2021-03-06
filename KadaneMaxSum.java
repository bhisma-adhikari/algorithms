import java.lang.Math;

public class KadaneMaxSum {
    public static void main(String[] args) {
        int[] ary = { -2, -1, -3, 0, 4, -1, 2, 1, 0, -5, 4 };
        // int[] ary = { -2, -1, -3, -4, -1, -2, -1, -5, -4 };
        // System.out.println(kadaneMaxSum(ary));
        System.out.println(kadaneMaxSumWithIndex(ary));
    }

    /**
     * 
     * @param ary
     * @return Maximum possible sum of any subarray
     */
    public static double kadaneMaxSum(int[] ary) {
        double localMax = Double.NEGATIVE_INFINITY;
        double globalMax = Double.NEGATIVE_INFINITY;

        for (int i = 0; i < ary.length; i++) {
            localMax = Math.max(ary[i], localMax + ary[i]);
            // System.out.println(localMax);
            if (localMax > globalMax) {
                globalMax = localMax;
            }
        }
        return globalMax;
    }

    public static Ans kadaneMaxSumWithIndex(int[] ary) throws RuntimeException {

        // special cases
        if (ary.length == 0) {
            throw new RuntimeException("Too short array");
        } else if (ary.length == 1) {
            return new Ans(ary[0], 0, 0);
        }

        // general case
        int runningSum = ary[0]; // sum upto previous index
        int maxSum = ary[0]; // current max sum

        int indexFrom = 0;
        int indexTo = 0;

        for (int i = 1; i < ary.length; i++) {

            if (runningSum >= 0) {
                runningSum += ary[i];
            } else {
                runningSum = ary[i];
                indexFrom = i;
            }

            // >= is used instead of > to ensure indexTo gets updated appropriately
            if (runningSum >= maxSum) {
                maxSum = runningSum;
                indexTo = i;
            }
        }

        return new Ans(maxSum, indexFrom, indexTo);
    }

}

class Ans {
    public int sum;
    public int indexFrom;
    public int indexTo;

    public Ans(int sum, int indexFrom, int indexTo) {
        this.sum = sum;
        this.indexFrom = indexFrom;
        this.indexTo = indexTo;
    }

    @Override
    public String toString() {
        return "sum : " + sum + "\nindexFrom : " + indexFrom + "\nindexTo : " + indexTo;
    }
}