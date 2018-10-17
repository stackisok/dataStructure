package graph;

public class AJMatrixWithoutWeight {
    protected int edgeNum;
    protected char[] point;
    protected int[][] edge;

    public AJMatrixWithoutWeight(int vexNums) {
        point = new char[vexNums];
        for (int i = 0; i < vexNums; i++)
            point[i] = (char)('a' + i);
        edge = new int[vexNums][vexNums];
    }

    public void addEdge(int a, int b) {
        edgeNum++;
        edge[a][b] = 1;
        edge[b][a] = 1;
    }

    private void addEdge(int a, int b, int weight) {
        edgeNum++;
        edge[a][b] = weight;
        edge[b][a] = weight;
    }
    public void delEdge(int a, int b) {
        edgeNum--;
        edge[a][b] = 0;
        edge[b][a] = 0;
    }
    public void printGraph() {
        for (int i = 0; i < point.length; i++) {
            System.out.print(point[i]);
            for (int j = 0; j < point.length; j++) {
                if (edge[i][j] == 1)
                    System.out.print(" --> " + point[j]);
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        AJMatrixWithoutWeight ajMatrixWithoutWeight = new AJMatrixWithoutWeight(4);
        ajMatrixWithoutWeight.addEdge(0, 1);
        ajMatrixWithoutWeight.addEdge(0, 2);
        ajMatrixWithoutWeight.addEdge(1, 2);
        ajMatrixWithoutWeight.addEdge(2, 3 );
        ajMatrixWithoutWeight.delEdge(2, 3 );
        System.out.println(ajMatrixWithoutWeight.edgeNum);
        ajMatrixWithoutWeight.printGraph();



    }

}
