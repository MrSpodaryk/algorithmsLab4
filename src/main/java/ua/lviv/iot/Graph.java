package ua.lviv.iot;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<Node> nodes;

    public Graph() {
        this.nodes = new ArrayList();
    }

    public Graph(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(Node e) {
        this.nodes.add(e);
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public Node getNode(String name) {
        for (Node node:this.getNodes()) {
            if (node.getName().equals(name)) {
                return node;
            }
        }
        return null;
    }

    public int getSize() {
        return this.nodes.size();
    }

    @Override
    public String toString() {
        return "Graph{" +
                "nodes=" + nodes +
                "}";
    }
}
