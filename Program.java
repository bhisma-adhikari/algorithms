import java.util.concurrent.TimeUnit;

public class Program {
    public static void main(String[] args) {
        // test();
        task();
    }

    public static void test() {

        long t1 = System.currentTimeMillis(); 

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {} 

        long t2 = System.currentTimeMillis(); 

        System.out.println(t2 - t1);

    }

    public static void task() {
        int SIZE = 10000;
        int[] ary = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            ary[i] = SIZE - i;
        }
        long t1 = System.currentTimeMillis(); 
        InsertionSort.insertionSort(ary);
        long t2 = System.currentTimeMillis(); 

        int[] aryMs = MergeSort.mergeSort(ary);
        long t3 = System.currentTimeMillis(); 

        Utils.printAry(aryMs);

        System.out.println("time taken insertion-sort = " + (t2 - t1));
        System.out.println("time taken merge-sort = " + (t3 - t2));


        
        

    }
}