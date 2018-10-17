package graph;

public class Prim {
    int[][] matrix= { {INF,7,4,INF,INF,INF},  //INF代表两点之间不可达
                        {7,INF,6,2,INF,4},
                        {4,6,INF,INF,9,8},
                        {INF,2,INF,INF,INF,7},
                        {INF,INF,9,INF,INF,1},
                        {INF,4,8,7,1,INF}
    };
    private static int INF = Integer.MAX_VALUE;


    public void prim(int vex) {
        boolean[] reach = new boolean[matrix.length];
        reach[vex] = true;
        int[] beg = new int[matrix.length];
        int[] dest = new int[matrix.length];
        for (int i = 0; i < dest.length; i++) {
            dest[i] = matrix[vex][i];
            beg[i] = vex;
        }

        boolean exit = false;

        int sum = 0;
        while (!exit) {
            exit = true;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < dest.length; i++) {
                if (reach[i] == false && dest[i] < min) {
                    min = dest[i];
                    vex = i;
                    exit = false;
                }
            }
            reach[vex] = true;
            if (min != Integer.MAX_VALUE) {
                sum += min;
                System.out.println(min + " " + beg[vex] + " " + vex);
            }
            for (int i = 0; i < dest.length; i++) {

                if (reach[i] == false && matrix[vex][i] < dest[i]) {
                    beg[i] = vex;
                    dest[i] = matrix[vex][i];
                }
            }

        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        new Prim().prim(0);
    }


}
