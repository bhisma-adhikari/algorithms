import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {

        int[] ary = { 5, 2, 4, 6, 1, 3 };
        Utils.printAry(mergeSort(ary));
    }

    /**
     * Merge 2 sorted arrays
     * 
     * @param ary1
     * @param ary2
     * @return
     */
    public static int[] merge(int[] ary1, int[] ary2) {
        int l1 = ary1.length;
        int l2 = ary2.length;
        int l3 = l1 + l2;

        int[] ary1new = new int[l1 + 1];
        int[] ary2new = new int[l2 + 1];

        for (int i = 0; i < l1; i++) {
            ary1new[i] = ary1[i];
        }
        ary1new[l1] = Integer.MAX_VALUE;

        for (int i = 0; i < l2; i++) {
            ary2new[i] = ary2[i];
        }
        ary2new[l2] = Integer.MAX_VALUE;

        int[] ary = new int[l3];

        int i = 0;
        int j = 0;
        for (int k = 0; k < l3; k++) {

            if (ary1new[i] <= ary2new[j]) {
                ary[k] = ary1new[i];
                i++;
            } else {
                ary[k] = ary2new[j];
                j++;
            }
        }
        return ary;
    }

    public static int[] mergeSort(int[] ary) {
        // base case
        if (ary.length == 1) {
            return ary;
        }

        int sepIndex = ary.length / 2;
        int[] aryLeft = Arrays.copyOfRange(ary, 0, sepIndex); // lower index inclusive, upper index exclusive
        int[] aryRight = Arrays.copyOfRange(ary, sepIndex, ary.length);

        aryLeft = mergeSort(aryLeft);
        aryRight = mergeSort(aryRight);

        return merge(aryLeft, aryRight);
    }
}