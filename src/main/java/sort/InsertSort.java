package sort;

import java.util.Random;

public class InsertSort {
    public static void insertSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int element = a[i];
            for (int j = 0; j < i; j++) {
                if (a[j] > element) {
                    System.arraycopy(a, j, a, j + 1, i - j);
                    a[j] = element;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        long beg = System.currentTimeMillis();
        Random random = new Random();
        int a[] = new int[1000];
        for (int i = 0; i < a.length; i++)
            a[i] = random.nextInt();
        insertSort(a);
        for (int i = 0; i < a.length - 1; i++)
            if (a[i] > a[i + 1])
                System.out.println("wrong"); //检查排序是否出错
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " "); //打印出序列
        System.out.println("\n" + (System.currentTimeMillis() - beg)); //耗时
    }
}
