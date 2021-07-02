package solution;

import java.util.*;
import java.lang.*;

class Vertex {
    final int id;
    int key;
    boolean added  = false;
    Vertex pre = null;

    Vertex(int id) {
        this.id = id;
    }

    Vertex(int id, int key) {
        this.id = id;
        this.key = key;
    }
}