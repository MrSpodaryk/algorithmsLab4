package ua.lviv.iot;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private String name;
    private List<String> neighbors;

    public Node(String name) {
        this.name = name;
        this.neighbors = new ArrayList();
    }

    public void addNeighbor(String e) {
        this.neighbors.add(e);
    }

    public String getName() {
        return name;
    }

    public List<String> getNeighbors() {
        return neighbors;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name=" + name +
                ", neighbors=" + neighbors +
                "}" + "\n";
    }
}
