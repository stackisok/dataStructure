package graph;

public class Dijkstra {

    AJMatrixWithWeight ajMatrixWithWeight;

    public Dijkstra(AJMatrixWithWeight ajMatrixWithWeight) {
        this.ajMatrixWithWeight = ajMatrixWithWeight;
    }

    public void dijkstra(int vs) {
        int length = ajMatrixWithWeight.point.length;
        boolean[] flag = new boolean[length];
        int[] prev = new int[length];
        int[] dist = new int[length];
        System.arraycopy(ajMatrixWithWeight.edge[vs], 0, prev, 0, length);
        flag[vs] = true;


        for (int j = 0; j < ajMatrixWithWeight.point.length; j++) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < ajMatrixWithWeight.point.length; i++) {
                if (prev[i] < min && flag[i] == false) {
                    min = prev[i];
                    vs = i;
                }
            }
            flag[vs] = true;
            for (int i = 0; i < ajMatrixWithWeight.point.length; i++) {
                if (flag[i] == false && ajMatrixWithWeight.edge[vs][i] != Integer.MAX_VALUE && ajMatrixWithWeight.edge[vs][i] + prev[vs] < prev[i]) {
                    prev[i] = ajMatrixWithWeight.edge[vs][i] + prev[vs];
                }
            }
        }
        for (int item : prev)
            System.out.print(item + " ");


    }

    public static void main(String[] args) {
        AJMatrixWithWeight ajMatrixWithoutWeight = new AJMatrixWithWeight(4);
        ajMatrixWithoutWeight.addEdge(0, 1, 50);
        ajMatrixWithoutWeight.addEdge(0, 2, 80);
        ajMatrixWithoutWeight.addEdge(1, 2,40);
        ajMatrixWithoutWeight.addEdge(2, 3, 4);
        ajMatrixWithoutWeight.addEdge(0, 3, 85);
        System.out.println(ajMatrixWithoutWeight.edgeNum);
        ajMatrixWithoutWeight.printGraph();
        Dijkstra dijkstra = new Dijkstra(ajMatrixWithoutWeight);
        dijkstra.dijkstra(0);
    }
}
