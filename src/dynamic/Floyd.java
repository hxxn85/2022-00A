package dynamic;

public class Floyd {

    private static final int INF = Integer.MAX_VALUE / 2;

    private static void printAdj(int[][] adj) {
        for (int[] row : adj) {
            for (int col : row) {
                if(col >= INF/2) System.out.print("😀\t");
                else System.out.printf("%d\t", col);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] adj = {
                {0, 4, 2, 5, INF},
                {INF, 0, 1, INF, 4},
                {1, 3, 0, 1, 2},
                {-2, INF, INF, 0, 2},
                {INF, -3, 3, 1, 0}
        };

        int n = adj.length;

        printAdj(adj);

        for (int k = 0; k < n; k++) {
            System.out.printf("%d-th iter\n", k+1);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
            printAdj(adj);
        }
    }
}
