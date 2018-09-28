package sort;

import java.util.Random;

public class SheelSort {

    public static void shellSort(int[] arrays) {
        for (int step = arrays.length / 2; step > 0; step /= 2) {
            for (int i = step; i < arrays.length; i++) {
                int j = i;
                int temp = arrays[j];
                while (j - step >= 0 && arrays[j - step] > temp) {
                    arrays[j] = arrays[j - step];
                    j = j - step;
                }
                arrays[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        long beg = System.currentTimeMillis();
        Random random = new Random();
        int a[] = new int[1000];
        for (int i = 0; i < a.length; i++)
            a[i] = random.nextInt();
        shellSort(a);
        for (int i = 0; i < a.length - 1; i++)
            if (a[i] > a[i + 1])
                System.out.println("wrong"); //检查排序是否出错
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " "); //打印出序列
        System.out.println("\n" + (System.currentTimeMillis() - beg)); //耗时
    }
}
