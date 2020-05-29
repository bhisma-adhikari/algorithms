import java.lang.Math;

class Program {
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

    public static void main(String[] args) {
        int[] ary = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        // int[] ary = { -2, -1, -3, -4, -1, -2, -1, -5, -4 };
        System.out.println(kadaneMaxSum(ary));
    }
}