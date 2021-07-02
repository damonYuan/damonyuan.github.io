package com.damonyuan.dijkstra;

import java.util.*;
import java.lang.*;

class DijkstraAlgorithm {
    private Graph graph;
    private final PriorityQueue<Vertex> q = new PriorityQueue();

    public DijkstraAlgorithm(Graph graph) {
        this.graph = graph;
    }

    public void getShortestPath(Vertex source, Vertex dest) {
        if (this.graph.getVertexes().contains(source) && this.graph.getVertexes().contains(dest)) {

           for (Vertex v : this.graph.getVertexes()) {
               if (!v.equals(source)) {
                   v.setDistance(-1);
                   v.setPre(null);
               } else {
                   v.setDistance(0);
                   v.setPre(null);
               }
               q.add(v);
           }

           while (!q.isEmpty()) {
               Vertex v = q.poll();
               ArrayList<Edge> edges = new ArrayList();
               for (Edge e : this.graph.getEdges()) {
                    if (e.getSource().equals(v) || e.getDestination().equals(v)) {
                        edges.add(e);
                    }
               }
               for (Edge e : edges) {
                    Vertex n;
                    if (e.getSource().equals(v)) {
                        n = e.getDestination();
                    } else {
                        n = e.getSource();
                    }
                    int tmp = v.getDistance() < 0 ? 0 : v.getDistance() + e.getWeight();
                    if (tmp < n.getDistance()) {
                        n.setDistance(tmp);
                        n.setPre(v);
                    }
               }
           }

           StringBuilder sb = new StringBuilder();
           Vertex tmp = dest;
           while (tmp.getPre() != null) {
               sb.append(tmp.getId() + " (" + tmp.getName() + ") <-");
               tmp = tmp.getPre();
           }
           if (!tmp.equals(source)) {
               throw new RuntimeException();
           }
           sb.append(tmp.getId() + " (" + tmp.getName() + ") \n");
           System.out.printf(sb.toString());
        }

        System.out.printf("source or destination is not contained in graph");
    }


}
