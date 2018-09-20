package search;

import java.util.HashMap;
import java.util.Random;

public class BinarySearch {
    //
    public static int normal(int[] sequence, int val) {
        int length = sequence.length;
        int mid = 0;
        int left = 0, right = length - 1;
        while (left <= right) {
           mid = (left + right) / 2;
           if (sequence[mid] > val) {
               right = mid - 1;
           } else  if (sequence[mid] < val) {
               left = mid + 1;
           } else {
               return mid;
           }
        }
        return -1;
    }

    public static int getFirst(int[] sequence, int val) {
        int length = sequence.length;
        int mid = 0;
        int left = 0, right = length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (sequence[mid] >= val) {
                right = mid - 1;
            } else  if (sequence[mid] < val) {
                left = mid + 1;
            }
        }
        if (left < sequence.length && sequence[left] == val)
            return left;
        return -1;
    }
    public static int getLast(int[] sequence, int val) {
        int length = sequence.length;
        int mid = 0;
        int left = 0, right = length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (sequence[mid] > val) {
                right = mid - 1;
            } else  if (sequence[mid] <= val) {
                left = mid + 1;
            }
        }
        if (right >=0 && sequence[right] == val)
            return right;

        return -1;
    }
    public static int getLastEquOrFirstLess(int[] sequence, int val) {
        int length = sequence.length;
        int mid = 0;
        int left = 0, right = length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (sequence[mid] > val) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
    public static int getLastLess(int[] sequence, int val) {
        int length = sequence.length;
        int mid = 0;
        int left = 0, right = length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (sequence[mid] >= val) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static int getFirstOrGT(int[] sequence, int val) {
        int length = sequence.length;
        int mid = 0;
        int left = 0, right = length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (sequence[mid] < val) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static int getFirstGT(int[] sequence, int val) {
        int length = sequence.length;
        int mid = 0;
        int left = 0, right = length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (sequence[mid] <= val) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
//        int[] sequence = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}; //normal
        int[] sequence = {1, 2, 3, 3, 5, 5, 5, 8, 9, 10, 11};
        System.out.println(getFirst(sequence, 12));
        System.out.println(getLast(sequence, 0));
        System.out.println(getLastEquOrFirstLess(sequence, 0));
        System.out.println(getLastLess(sequence, 1));
        System.out.println(getFirstOrGT(sequence, 4));
        System.out.println(getFirstGT(sequence, 10));
        HashMap<Object, Object> map = new HashMap<>();
        map.put("11", "s");
        Random random = new Random(3);
        System.out.println(random.nextInt());
    }
}
