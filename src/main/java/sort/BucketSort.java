package sort;

import java.util.Random;

public class BucketSort {

    public static void bucketSort(int[] a) {
        int max = -1;
        for (int i : a) {

            if (i > max) {
                max = i;
            }
        }
        int[] bucket = new int[max + 1];
        for (int i : a) {
            bucket[i]++;
        }
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] != 0) {
                for (int j = 0; j < bucket[i]; j++)
                    a[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        long beg = System.currentTimeMillis();
        Random random = new Random();
        int a[] = new int[100000000];
        for (int i = 0; i < a.length; i++)
            a[i] = Math.abs(random.nextInt() % 1000);
        bucketSort(a);
        for (int i = 0; i < a.length - 1; i++)
            if (a[i] > a[i + 1])
                System.out.println("wrong"); //检查排序是否出错
//        for (int i = 0; i < a.length; i++)
//            System.out.print(a[i] + " "); //打印出序列
        System.out.println("\n" + (System.currentTimeMillis() - beg)); //耗时

    }
}
