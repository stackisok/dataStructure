package sort;

import java.util.Random;

public class HeapSort {

    public static void heapSort(int[] a) {
        buildHeap(a);
        for (int i = a.length; i > 0; i--) {
            swap(a, 0, i - 1);
            sink(a, 0, i - 1);
        }

    }
    public static void buildHeap(int[] a) {
        for (int i = 0; i < a.length; i++)
            shiftUp(a, i);
    }

    private static void shiftUp(int[] a, int i) {
        while ((i - 1) / 2 >= 0 && a[(i - 1) / 2] < a[i]) {
            swap(a,(i - 1) / 2, i);
            i = (i - 1) / 2;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private static void sink(int[] a, int i, int size) {
        while (i * 2 + 1 < size) {
            int j = i * 2 + 1;
            if (j + 1 < size && a[j + 1] > a[j])
                j = j + 1;
            if (a[j] <= a[i]) {
                break;
            }
            swap(a, j, i);
            i = j;
        }

    }
    public static void main(String[] args) {
        long beg = System.currentTimeMillis();
        Random random = new Random();
        int a[] = new int[100];
        for (int i = 0; i < a.length; i++)
            a[i] = Math.abs( random.nextInt() % 100);
        heapSort(a);
        for (int i = 0; i < a.length - 1; i++)
            if (a[i] > a[i + 1])
                System.out.println("wrong"); //检查排序是否出错
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " "); //打印出序列
        System.out.println("\n" + (System.currentTimeMillis() - beg)); //耗时
    }
}
