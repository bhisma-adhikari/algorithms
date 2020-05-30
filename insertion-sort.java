class Program {
    public static void main(String[] args) {
        int[] ary = { 5, 2, 4, 6, 1, 3 };
        int[] sortedAry = insertionSort(ary);
        printAry(sortedAry);
    }

    public static void printAry(int[] ary) {
        for (int i : ary) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] insertionSort(int[] ary) {
        for (int j = 1; j < ary.length; j++) {
            // System.out.print("j = " + j + " : ");
            // printAry(ary);

            int key = ary[j];
            int i = j - 1;
            while (i >= 0 && ary[i] > key) {
                ary[i + 1] = ary[i];
                i--;
            }
            ary[i + 1] = key;
        }
        return ary;
    }
}