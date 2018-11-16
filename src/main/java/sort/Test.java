package sort;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int nums = 100000;
        int a[] = new int[nums];
        int b[] = new int[nums];
        int c[] = new int[nums];

        Random random = new Random();
        for (int i = 0; i < a.length; i++)
            a[i] = Math.abs(random.nextInt()) % 100000;

        System.arraycopy(a, 0, b, 0,a.length);

        long beg = System.currentTimeMillis();
        MergeSort.mergeSort(b,0, b.length - 1);
        System.out.println("\n MergeSort" + (System.currentTimeMillis() - beg)); //耗时
        for (int i = 0; i < b.length - 1; i++)
            if (b[i] > b[i + 1])
                System.out.println("wrong"); //检查排序是否出错

        System.arraycopy(a, 0, c, 0, a.length);
        beg = System.currentTimeMillis();
        SheelSort.shellSort(c);
        System.out.println("\nSheelSort" + (System.currentTimeMillis() - beg)); //耗时
        validData(b, c);


        System.arraycopy(a, 0, c, 0, a.length);
        beg = System.currentTimeMillis();
        RadixSort.radixSort(c);
        System.out.println("\nRadixSort" + (System.currentTimeMillis() - beg)); //耗时
        validData(b, c);


        System.arraycopy(a, 0, c, 0, a.length);
        beg = System.currentTimeMillis();
        QuickSort.sort(c,0,c.length - 1);
        System.out.println("\nQuickSort" + (System.currentTimeMillis() - beg)); //耗时
        validData(b, c);

        System.arraycopy(a, 0, c, 0, a.length);
        beg = System.currentTimeMillis();
        BucketSort.bucketSort(c);
        System.out.println("\nBucketSort" + (System.currentTimeMillis() - beg)); //耗时
        validData(b, c);

        System.arraycopy(a, 0, c, 0, a.length);
        beg = System.currentTimeMillis();
        InsertSort.insertSort(c);
        System.out.println("\nInsertSort" + (System.currentTimeMillis() - beg)); //耗时
        validData(b, c);

        System.arraycopy(a, 0, c, 0, a.length);
        beg = System.currentTimeMillis();
        SelectionSort.selectionSort(c);
        System.out.println("\nSelectionSort" + (System.currentTimeMillis() - beg)); //耗时
        validData(b, c);

        System.arraycopy(a, 0, c, 0, a.length);
        beg = System.currentTimeMillis();
        BubbleSort.bubbleSort(c);
        System.out.println("\nBubbleSort" + (System.currentTimeMillis() - beg)); //耗时
        validData(b, c);

    }
    private static void validData(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i])
                System.out.println("Compare wrong");
        }
    }
}
