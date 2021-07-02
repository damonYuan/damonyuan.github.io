package solution;

import java.util.*;
import java.lang.*;

class Edge {
    final Vertex node1;
    final Vertex node2;
    final int weight;

    Edge(Vertex node1, Vertex node2, int weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    Vertex getPeer(Vertex v) {
        if (v.id != node1.id && v.id != node2.id) {
            return null;
        } else if (v.id == node1.id) {
            return node2;
        } else {
            return node1;
        }
    }

    @Override
    public String toString() {
        return String.format("node 1: %d - node 2: %d - weight: %d", node1.id, node2.id, weight);
    }
}