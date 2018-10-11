package sort;

import java.util.Random;

public class MergeSort {
    public static void mergeSort(int[] a, int beg, int end) {
        if (beg >= end)
            return;
        int mid = (end - beg) / 2 + beg;
        mergeSort(a, beg, mid);
        mergeSort(a, mid + 1, end);
        merge(a, beg, mid, end);
    }

//    private static void merge(int[] a, int beg, int mid, int end) {
//        int[] temp = new int[end - beg + 1];
//        int ll = beg, hl = mid + 1;
//        for (int i = 0; i < temp.length; i++) {
//            if (ll > mid) {
//                temp[i] = a[hl];
//                hl++;
//            }else if (hl > end) {
//                temp[i] = a[ll];
//                ll++;
//            } else {
//                if (a[ll] > a[hl]) {
//                    temp[i] = a[hl];
//                    hl++;
//                } else {
//                    temp[i] = a[ll];
//                    ll++;
//                }
//            }
//        }
//        for (int i = 0; i < temp.length; i++) {
//            a[beg] = temp[i];
//            beg++;
//        }
//
//    }
    private static void merge(int[] a, int beg, int mid, int end) {
        int[] temp = new int[end - beg + 1];
        int ll = beg, rl = mid + 1, index = 0;
        while (ll <= mid && rl <= end)
            temp[index++] = a[ll] < a[rl] ? a[ll++] : a[rl++];
        for (; ll <= mid;)
            temp[index++] = a[ll++];
        for (; rl <= end;)
            temp[index++] = a[rl++];
        for (int i = 0; i < temp.length; i++)
            a[beg++] = temp[i];



    }

    public static void main(String[] args) {
        long beg = System.currentTimeMillis();
        Random random = new Random();
        int a[] = new int[10000000];
        for (int i = 0; i < a.length; i++)
            a[i] = random.nextInt() % 10;
        mergeSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length - 1; i++)
            if (a[i] > a[i + 1])
                System.out.println("wrong"); //检查排序是否出错
//        for (int i = 0; i < a.length; i++)
//            System.out.print(a[i] + " "); //打印出序列
        System.out.println("\n" + (System.currentTimeMillis() - beg)); //耗时
    }
}
