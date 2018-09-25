package sort;

import java.util.Random;

public class QuickSort {

    public static void sort(int[] a, int l, int r) {
        if (a == null || a.length == 1 || l >= r)
            return;
        int left = l, right = r, key = a[left];
        while (left < right) {
            while (a[right] >= key && left < right) right--;
            swap(a, left, right);
            while (a[left] <= key && left < right) left++;
            swap(a, left, right);
        }
        sort(a,l, left - 1);
        sort(a,right + 1, r);

    }
    public static void swap(int[] a, int p1, int p2) {
        int temp = a[p1];
        a[p1] = a[p2];
        a[p2] = temp;
    }
    public static void main(String[] args) {
        long beg = System.currentTimeMillis();
        Random random = new Random();
        int a[] = new int[1000];
        for (int i = 0; i < a.length; i++)
            a[i] = random.nextInt();
        sort(a, 0, a.length - 1);
        for (int i = 0; i < a.length - 1; i++)
            if (a[i] > a[i + 1])
                System.out.println("wrong"); //检查排序是否出错
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " "); //打印出序列
        System.out.println("\n" + (System.currentTimeMillis() - beg)); //耗时
    }
}
