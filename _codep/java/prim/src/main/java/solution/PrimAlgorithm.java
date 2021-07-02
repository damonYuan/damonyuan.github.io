package solution;

import java.lang.*;
import java.util.*;

class PrimAlgorithm {
    Graph g;
    Set<Edge> mst;

    PrimAlgorithm(int[][] g) {
        this.g = new Graph(g);
        this.mst = new HashSet<Edge>();
    }

    public Set<Edge> primMST() {
        Vertex root = this.g.vertices.get(0);
        root.key = 0;

        for (int i = 0; i < this.g.vertices.size(); i++) {
            Vertex v = this.g.getMin();
            v.added = true;

            Set<Edge> edges = this.g.getAdjacent(v);
            int minKey = Integer.MAX_VALUE;
            for (Edge e : edges) {
                Vertex peer = e.getPeer(v);
                if (!peer.added && peer.key > e.weight) {
                    peer.key = e.weight;
                    peer.pre = v;
                }
            }
        }

        for (int i = 0; i < this.g.vertices.size(); i++) {
            Vertex v = this.g.vertices.get(i);
            if (v.pre != null) {
                this.mst.add(this.g.getEdge(v, v.pre));
            }
        }

        return this.mst;
    }
}