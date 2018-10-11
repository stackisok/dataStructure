package sort;

import java.util.Random;

public class RadixSort {

    public static void radixSort(int[] a) {
        int[][] radix =  new int[10][a.length];
        int[] nums = null;
        int maxDigit = 0, max = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i] > max) max = a[i];
        maxDigit = (int) Math.pow(10,String.valueOf(max).length() - 1);
        int i = 1;
        while (i <= maxDigit) {
            nums = new int[10];
            for (int j = 0; j < a.length; j++) {
                int digit = (a[j] / i) % 10;
                radix[digit][nums[digit]++] = a[j];
            }
            int index = 0;
            for (int j = 0; j < 10; j++) {
                if (nums[j] != 0) {
                    for (int z = 0; z < nums[j]; z++) {
                        a[index++] = radix[j][z];
                    }
                }
            }
            i *= 10;
        }
    }

    public static void main(String[] args) {
        long beg = System.currentTimeMillis();
        Random random = new Random();
        int a[] = new int[100000000];
        for (int i = 0; i < a.length; i++)
            a[i] = Math.abs(random.nextInt()) % 10;
        radixSort(a);
        for (int i = 0; i < a.length - 1; i++)
            if (a[i] > a[i + 1])
                System.out.println("wrong"); //检查排序是否出错
//        for (int i = 0; i < a.length; i++)
//            System.out.print(a[i] + " "); //打印出序列
        System.out.println("\n" + (System.currentTimeMillis() - beg)); //耗时


    }


}
