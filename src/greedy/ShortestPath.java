package greedy;

public class ShortestPath {
    // 아는것
    private int[][] graph;  // 인접행렬 (adjcent matrix)
    private static final int INF = Integer.MAX_VALUE / 2;

    public ShortestPath(int[][] graph) {
        this.graph = graph;
    }

    // 하는것
    public int[] find(int x) {
        boolean[] visited = new boolean[graph.length];
        visited[x] = true;

        for (int i = 0; i < graph.length; i++) {
            int vmin = selectLayout(x, visited);
            update(x, vmin);
        }

        return graph[x];
    }

    private void update(int x, int vmin) {
        for (int i = 0; i < graph.length; i++) {
            graph[x][i] = Math.min(graph[x][i], graph[x][vmin] + graph[vmin][i]);
            graph[i][x] = graph[x][i];
        }
    }

    private int selectLayout(int x, boolean[] visited) {
        int min = INF;
        int idx = 0;

        for(int i=0; i<graph.length; i++) {
            if (graph[x][i] < min && visited[i] == false) {
                min = graph[x][i];
                idx = i;
                visited[idx] = true;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 7, INF, INF, 3, 10, INF},
                {7, 0, 4, 10, 2, 6, INF},
                {INF, 4, 0, 2, INF, INF, INF},
                {INF, 10, 2, 0, 11, 9, 4},
                {3, 2, INF, 11, 0, INF, 5},
                {10, 6, INF, 9, INF, 0, INF},
                {INF, INF, INF, 4, 5, INF, 0}
        };

        ShortestPath sp = new ShortestPath(graph);
        int[] distance = sp.find(0);
        for (int i : distance) {
            System.out.printf("%d, ", i);
        }
        System.out.println();
    }
}
