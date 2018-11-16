package sort;

import java.util.Random;

public class BubbleSort {
    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j+1])
                    swap(a, j, j + 1);

            }
        }


    }

    private static void swap(int[] a, int j, int i) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(String[] args) {
        long beg = System.currentTimeMillis();
        Random random = new Random();
        int a[] = new int[10000];
        for (int i = 0; i < a.length; i++)
            a[i] = Math.abs(random.nextInt() % 1000);
        bubbleSort(a);
        for (int i = 0; i < a.length - 1; i++)
            if (a[i] > a[i + 1])
                System.out.println("wrong"); //检查排序是否出错
//        for (int i = 0; i < a.length; i++)
//            System.out.print(a[i] + " "); //打印出序列
        System.out.println("\n" + (System.currentTimeMillis() - beg)); //耗时

    }
}
