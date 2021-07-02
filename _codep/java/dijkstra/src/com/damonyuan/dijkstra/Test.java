package com.damonyuan.dijkstra;

import java.lang.*;
import java.util.*;

public class Test {
    public static void test() {
    	Vertex v1 = new Vertex("1", "A");
    	Vertex v2 = new Vertex("2", "B");
    	Vertex v3 = new Vertex("3", "C");
    	Vertex v4 = new Vertex("4", "D");
    	Vertex v5 = new Vertex("5", "E");
    	ArrayList<Vertex> vertexs = new ArrayList();
    	vertexs.add(v1);
    	vertexs.add(v2);
    	vertexs.add(v3);
    	vertexs.add(v4);
    	vertexs.add(v5);

    	Edge e1 = new Edge("1", v1, v2, 1);
    	Edge e2 = new Edge("2", v1, v3, 2);
    	Edge e3 = new Edge("3", v2, v3, 3);
    	Edge e4 = new Edge("4", v2, v4, 4);
    	Edge e5 = new Edge("5", v4, v5, 5);
    	Edge e6 = new Edge("6", v3, v5, 6);
    	ArrayList<Edge> edges = new ArrayList();
    	edges.add(e1);
    	edges.add(e2);
    	edges.add(e3);
    	edges.add(e4);
    	edges.add(e5);
    	edges.add(e6);

    	Graph g = new Graph(vertexs, edges);
    	DijkstraAlgorithm d = new DijkstraAlgorithm(g);

    	d.getShortestPath(v1, v5);
    }
}