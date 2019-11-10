package ua.lviv.iot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GraphInit {

    private static List<String> listS = new ArrayList<>();
    private static Graph graph = new Graph();

    private static void topologicalSort() {

        List<String> order = new ArrayList<>();

        Map<String, Boolean> visited = new HashMap<>();
        for (Node node : graph.getNodes()) {
            visited.put(node.getName(), false);
        }

        for (Node node : graph.getNodes()) {
            if (!visited.get(node.getName())) {
                checkAndAdd(graph, node.getName(), visited, order);
            }
        }

        System.out.println(order);
    }

    private static void checkAndAdd(Graph graph, String name, Map<String, Boolean> visited, List<String> order) {

        visited.replace(name, true);

        for (String neighborName : graph.getNode(name).getNeighbors()) {
            if (!visited.get(neighborName)) {
                checkAndAdd(graph, neighborName, visited, order);
            }
        }

        order.add(name);
    }


    public static void main(String[] args) {
        init();
        topologicalSort();
        System.out.println();
    }

    private static void init() {

        readFromFile();

        Set<String> set = new HashSet();

        for (String list : listS) {
            set.add(list);
        }
        Iterator<String> itr = set.iterator();
        for (int i = 0; i < set.size(); i++) {
            graph.addNode(new Node(itr.next()));
        }
        System.out.println(graph);

        System.out.println("size = " + listS.size());

        for (int i = 0; i < listS.size() - 1; i += 2) {
            graph.getNode(listS.get(i)).addNeighbor(listS.get(i + 1));
        }

        System.out.println(graph);

    }

    private static void readFromFile() {
        try {
            FileReader reader = new FileReader("text.txt");
            BufferedReader br = new BufferedReader(reader);
            String st;
            while ((st = br.readLine()) != null) {
                for (String retval : st.split(" ")) {
                    listS.add(retval);
                }
            }
            System.out.println(" list =  " + listS);


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
