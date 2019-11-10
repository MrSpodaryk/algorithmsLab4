package ua.lviv.iot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MainTest {

    private static List<String> listS = new ArrayList<>();
    private static Graph graph = new Graph();
    private Main m = new Main();

    @BeforeEach
    void setUp() {
        try {
            FileReader reader = new FileReader("text.txt");
            BufferedReader br = new BufferedReader(reader);
            String st;
            while ((st = br.readLine()) != null) {
                for (String retval : st.split(" ")) {
                    listS.add(retval);
                }
            }
            //System.out.println(" list =  " + listS);


        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Set<String> set = new HashSet();

        for (String list : listS) {
            set.add(list);
        }
        Iterator<String> itr = set.iterator();
        for (int i = 0; i < set.size(); i++) {
            graph.addNode(new Node(itr.next()));
        }
        //System.out.println(graph);

        //System.out.println("size = " + listS.size());

        for (int i = 0; i < listS.size() - 1; i += 2) {
            graph.getNode(listS.get(i)).addNeighbor(listS.get(i + 1));
        }
    }

    @Test
    void topologicalSortTest() {
        List<String> l = m.topologicalSort(graph);
        Assertions.assertEquals(8, l.size());
        Assertions.assertEquals("birthcertificate", l.get(0));
        Assertions.assertEquals("nationalpassport", l.get(1));
        Assertions.assertEquals("bankstatement", l.get(2));
        Assertions.assertEquals("militarycertificate", l.get(3));
        Assertions.assertEquals("visa", l.get(7));
    }

}
