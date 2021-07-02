import java.util.*;
import java.lang.*;

public class Main {
    public static class DisjointSet {
        private int[] parent;

        private DisjointSet() {}

        public DisjointSet(int size) {
        	parent = new int[size];
        	for (int i = 0; i < size; i++) {
        		parent[i] = -1;
        	}
        }

        public int root(int x) {
        	return parent[x] < 0 ? x : root(parent[x]);
        }

        public boolean union(int x, int y) {
        	int rx = root(x);
        	int ry = root(y);
            // the weight for parent selection is the value
            // itself, in some other data structure, there
            // might be a weight value
        	if (rx < ry) {
        		parent[rx] = ry;
        		return true;
        	} else if (rx > ry) {
        		parent[ry] = rx;
        		return true;
        	} else {
        		return false;
        	}
        }
    }

    public static class Edge implements Comparable<Edge> {
        public int from;
        public int to;
        public int weight;

        private Edge() {}

        public Edge(int from, int to, int weight) {
        	this.from = from;
        	this.to = to;
        	this.weight = weight;
        }

    	@Override
    	public int compareTo(Edge other) {
    		if (this.weight > other.weight) {
    			return 1;
    		} else if (this.weight ==  other.weight) {
    			return 0;
    		} else {
    			return -1;
    		}
    	}

    	@Override
    	public String toString() {
    		return "node1: " + from + " to " + to + " with weight: " + weight;
    	}
    }

    public static ArrayList<Edge> kruskal(int n, ArrayList<Edge> edges) {
    	ArrayList<Edge> ret = new ArrayList<Edge>();
    	DisjointSet dsu = new DisjointSet(n);
    	Collections.sort(edges);
    	for (Edge e : edges) {
    		// false unless an edge's node1 and to is the same
            // in this situation, the edge's weight should be 0
            if (dsu.union(e.from, e.to)) {
    			ret.add(e);
    		}
    	}
    	return ret;
    }

    public static void main(String [] args) {
        ArrayList<Edge> edges = new ArrayList<Edge>();
        Edge edge = new Edge(0, 1, 1);
        edges.add(edge);
        edge = new Edge(1, 2, 2);
        edges.add(edge);
        edge = new Edge(2, 3, 9);
        edges.add(edge);
        edge = new Edge(3, 0, 7);
        edges.add(edge);
        edge = new Edge(0, 2, 2);
        edges.add(edge);
        edge = new Edge(1, 3, 6);
        edges.add(edge);

        System.out.println(kruskal(4, edges));
    }
}
