package sort;

import java.util.Random;

public class SelectionSort {

    public static void swap(int[] a, int s1, int s2) {
        int temp = a[s1];
        a[s1] = a[s2];
        a[s2] = temp;
    }
    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = Integer.MAX_VALUE;
            int pos = -1;
            for (int j = i; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    pos = j;
                }
            }
            swap(a, i, pos);
        }
    }
    public static void main(String[] args) {
        long beg = System.currentTimeMillis();
        Random random = new Random();
        int a[] = new int[1000];
        for (int i = 0; i < a.length; i++)
            a[i] = random.nextInt();
        selectionSort(a);
        for (int i = 0; i < a.length - 1; i++)
            if (a[i] > a[i + 1])
                System.out.println("wrong"); //检查排序是否出错
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " "); //打印出序列
        System.out.println("\n" + (System.currentTimeMillis() - beg)); //耗时
    }
}
