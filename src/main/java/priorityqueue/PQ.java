package priorityqueue;

import java.util.Arrays;
import java.util.Random;

public class PQ {
    private int[] queue = new int[100];
    private int n;
    public void insert(int val) {
        queue[n++] = val;
        shiftUp(n - 1);

    }
    public int deleteMin() {
        swap(n - 1, 0);
        n--;
        sink(0);
        return queue[n];
    }

    private void sink(int i) {
        if (i * 2 + 1 < n) {
            int j = i * 2 + 1;
            if (j + 1 < n && queue[j + 1] < queue[j])
                j++;
            if (queue[j] < queue[i]) {
                swap(j, i);
                sink(j);
            }
        }
    }

    private void shiftUp(int n) {
        int temp = queue[n];
        if ((n - 1) / 2 >= 0 && queue[(n - 1) / 2] > temp) {
            swap((n - 1) / 2, n);
            shiftUp((n - 1) / 2);
        }
    }
    private void swap(int a, int b) {
        int temp = queue[a];
        queue[a] = queue[b];
        queue[b] = temp;
    }

    public static void main(String[] args) {
        PQ pq = new PQ();
        int[] a = new int[50];
        Random random = new Random();
        for (int i = 0;i < 50; i++)
            pq.insert(Math.abs(random.nextInt()) % 100);
        for (int i = 0;i < 50; i++)
            a[i] = pq.deleteMin();
        int[] b = new int[50];
        System.arraycopy(a, 0, b, 0, a.length);
        Arrays.sort(b);
        for (int i = 0;i < 50; i++) {
            if (a[i] != b[i])
                System.out.println("error");
        }

    }
}
