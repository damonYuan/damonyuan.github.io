package solution;

import java.lang.*;
import java.util.*;

class Graph {
    final ArrayList<Vertex> vertices;
    final ArrayList<Edge> edges;

    Graph(int[][] g) {
        int num = g.length;
        this.vertices = new ArrayList<Vertex>();
        this.edges = new ArrayList<Edge>();
        for (int i = 0; i < num; i++) {
            Vertex v = new Vertex(i, Integer.MAX_VALUE);
            this.vertices.add(v);
        }
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (g[i][j] != 0) {
                    Edge e = new Edge(this.vertices.get(i), this.vertices.get(j), g[i][j]);
                    this.edges.add(e);
                }
            }
        }
    }

    Edge getEdge(int id1, int id2) {
        for (int i = 0; i < this.edges.size(); i++) {
            if (this.edges.get(i).node1.id == id1 && this.edges.get(i).node2.id == id2) {
                return this.edges.get(i);
            }
            if (this.edges.get(i).node2.id == id1 && this.edges.get(i).node1.id == id2) {
                return this.edges.get(i);
            }
        }
        return null;
    }

    Edge getEdge(Vertex node1, Vertex node2) {
        for (int i = 0; i < this.edges.size(); i++) {
            if (this.edges.get(i).node1.id == node1.id && this.edges.get(i).node2.id == node2.id) {
                return this.edges.get(i);
            }
            if (this.edges.get(i).node2.id == node1.id && this.edges.get(i).node1.id == node2.id) {
                return this.edges.get(i);
            }
        }
        return null;
    }

    Vertex getMin() {
        int min = Integer.MAX_VALUE;
        Vertex tmp = null;
        for (Vertex v : this.vertices) {
            if (v.added == false && (tmp == null || v.key < tmp.key)) {
                tmp = v;
            }
        }
        return tmp;
    }

    Set<Edge> getAdjacent(Vertex v) {
        Set<Edge> adj = new HashSet<Edge>();
        for (Edge e : this.edges) {
            if (e.node1.id == v.id || e.node2.id == v.id) {
                adj.add(e);
            }
        }
        return adj;
    }
}