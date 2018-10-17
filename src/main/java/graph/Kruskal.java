package graph;

import java.util.*;

public class Kruskal {
    static class Edge implements Comparable<Edge> {
        int a; //端点a
        int b; //端点b
        int w; //长度

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.w == o.w) return 0;
            if (this.w > o.w) return 1;
            return -1;

        }
    }

    private void checkCircle() {

    }

    public static void findTree(int[] v, Edge[] e) {
        Arrays.sort(e);
        List<Set<Integer>> trees = new ArrayList<>();
        for (int i = 0; i < v.length; i++) {
            HashSet<Integer> hashSet = new HashSet();
            hashSet.add(v[i]);
            trees.add(hashSet);
        }
        boolean isContinue = true;
        for (Edge edge : e) {
            if (isContinue) {
                int a = edge.a;
                int b = edge.b;
                Set aSet = null;
                Set bSet = null;
                for (Set item : trees) {
                    if (item.contains(a)) {
                        aSet = item;
                    }
                    if (item.contains(b)) {
                        bSet = item;
                    }
                }
                if (aSet == bSet) {
                    continue;
                }
                aSet.addAll(bSet);
                System.out.println(a + "-- >" + b + " " + edge.w);
                trees.remove(bSet);
                if (trees.size() == 1)
                    System.out.println("success");
            }
        }


    }

    public static void main(String[] args) {
        int[] V = {1, 2, 3, 4, 5, 6};
        Edge[] E = new Edge[10];
        E[0] = new Edge(1, 2, 6);
        E[1] = new Edge(1, 3, 1);
        E[2] = new Edge(1, 4, 5);
        E[3] = new Edge(2, 3, 5);
        E[4] = new Edge(2, 5, 3);
        E[5] = new Edge(3, 4, 5);
        E[6] = new Edge(3, 5, 6);
        E[7] = new Edge(3, 6, 4);
        E[8] = new Edge(4, 6, 2);
        E[9] = new Edge(5, 6, 6);
        findTree(V, E);


    }
}
