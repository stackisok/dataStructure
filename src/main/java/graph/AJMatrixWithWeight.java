package graph;

public class AJMatrixWithWeight {
    protected int edgeNum;
    protected char[] point;
    protected int[][] edge;
    private static int INF = Integer.MAX_VALUE;

    public AJMatrixWithWeight(int vexNums) {
        point = new char[vexNums];
        for (int i = 0; i < vexNums; i++)
            point[i] = (char)('a' + i);
        edge = new int[vexNums][vexNums];
        for (int i = 0; i < point.length; i++)
            for (int j = 0; j < point.length; j++){
                if (i == j)
                    edge[i][j] = 0;
                else
                    edge[i][j] = INF;
            }

    }

    public void addEdge(int a, int b, int weight) {
        edgeNum++;
        edge[a][b] = weight;
        edge[b][a] = weight;
    }

    public void delEdge(int a, int b) {
        edgeNum--;
        edge[a][b] = INF;
        edge[b][a] = INF;
    }

    public void printGraph() {
        for (int i = 0; i < point.length; i++) {
            System.out.print(point[i]);
            for (int j = 0; j < point.length; j++) {
                if (edge[i][j] != INF)
                    System.out.print(" --> " + point[j] + ":" + edge[i][j]);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        AJMatrixWithWeight ajMatrixWithoutWeight = new AJMatrixWithWeight(4);
        ajMatrixWithoutWeight.addEdge(0, 1, 50);
        ajMatrixWithoutWeight.addEdge(0, 2, 100);
        ajMatrixWithoutWeight.addEdge(1, 2,300);
        ajMatrixWithoutWeight.addEdge(2, 3, 4);
        ajMatrixWithoutWeight.delEdge(2, 3);
        System.out.println(ajMatrixWithoutWeight.edgeNum);
        ajMatrixWithoutWeight.printGraph();



    }
}
