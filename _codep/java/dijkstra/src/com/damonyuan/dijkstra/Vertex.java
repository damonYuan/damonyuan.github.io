package com.damonyuan.dijkstra;

import java.lang.*;

class Vertex implements Comparable<Vertex> {
    final private String id;
    final private String name;
    private int distance;
    private Vertex pre;

    public Vertex(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setPre(Vertex pre) {
        this.pre = pre;
    }

    public Vertex getPre() {
        return this.pre;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if(getClass() != obj.getClass()) {
            return false;
        }
        Vertex other = (Vertex) obj;
        if (id == null && other.id != null) {
            return false;
        } else if (!id.equals(other.id)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Vertex v) {
        if (this.getDistance() < 0 && v.getDistance() < 0) {
            return 0;
        }
        if (this.getDistance() < 0) {
            return -1;
        }
        if (v.getDistance() < 0) {
            return 1;
        }
        if (this.getDistance() < v.getDistance()) {
            return 1;
        } else if (this.getDistance() > v.getDistance()) {
            return -1;
        } else {
            return 0;
        }
    }
}    


