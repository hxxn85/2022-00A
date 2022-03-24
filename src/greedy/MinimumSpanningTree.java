package greedy;

import java.util.ArrayList;
import java.util.Arrays;

class Vertex {
    String name;

    public Vertex(String name) {
        this.name = name;
    }
}

class Edge implements Comparable<Edge> {
    int weight;
    Vertex x;
    Vertex y;

    public Edge(int weight, Vertex x, Vertex y) {
        this.weight = weight;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return String.format("%d[%s, %s]", weight, x.name, y.name);
    }
}

public class MinimumSpanningTree {
    static class VertexFactory {
        static Vertex[] vertices(String... names) {
            Vertex[] vertex = new Vertex[names.length];
            for (int i=0; i<vertex.length; i++) {
                vertex[i] = new Vertex(names[i]);
            }
            return vertex;
        }
    }

    public ArrayList<Edge> findSpanningTree(Edge[] edge, Vertex[] vertex) {
        var spanningTree = new ArrayList<Edge>();

        // 오름차순 정렬
        Arrays.sort(edge);
        ArrayList<Edge> arr = new ArrayList<>(Arrays.asList(edge));

        while(spanningTree.size() < vertex.length - 1) {
            Edge e = arr.remove(0);
            if (isNotCyclic(e)) spanningTree.add(e);
        }

        return spanningTree;
    }

    private boolean isNotCyclic(Edge e) {
        return e.x != null;
    }

    public static void main(String[] args) {
        Vertex[] vertex = VertexFactory.vertices("a", "b","c","d","e","f");
        Vertex a = vertex[0];
        Vertex b = vertex[1];
        Vertex c = vertex[2];
        Vertex d = vertex[3];
        Vertex e = vertex[4];
        Vertex f = vertex[5];

        Edge[] edge = new Edge[10];
        edge[0] = new Edge(8, a, b);
        edge[1] = new Edge(4, a, e);
        edge[2] = new Edge(9, e, f);
        edge[3] = new Edge(1, f, c);
        edge[4] = new Edge(1, b, c);
        edge[5] = new Edge(2, a, d);
        edge[6] = new Edge(3, e, d);
        edge[7] = new Edge(7, d, f);
        edge[8] = new Edge(2, b, f);
        edge[9] = new Edge(4, d, b);

        MinimumSpanningTree mst = new MinimumSpanningTree();
        var spanningTree = mst.findSpanningTree(edge, vertex);
        System.out.println(spanningTree);


    }
}
