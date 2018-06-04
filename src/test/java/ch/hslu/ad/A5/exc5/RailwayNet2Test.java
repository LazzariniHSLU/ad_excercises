package ch.hslu.ad.A5.exc5;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class RailwayNet2Test {

    @Test
    public void addNode() {
        RailwayNet2 net = new RailwayNet2();
        assertTrue(net.addNode("Rotkreuz"));
        assertEquals(net.getNumberOfNodes(), 1);
    }

    @Test
    public void addEdge() {
        RailwayNet2 net = new RailwayNet2("Rotkreuz", "Luzern", "Zug");
        assertTrue(net.addEdge("Rotkreuz", "Zug", 12));
        assertTrue(net.addEdge("Rotkreuz", "Luzern", 16));
        assertEquals(4, net.getNumberOfEdges());
    }

    @Test
    public void removeNode() {
        RailwayNet2 net = new RailwayNet2("Rotkreuz", "Luzern", "Zug");
        assertTrue(net.addEdge("Rotkreuz", "Zug", 12));
        assertTrue(net.addEdge("Rotkreuz", "Luzern", 16));
        assertTrue(net.removeNode("Zug"));
        assertEquals(2, net.getNumberOfEdges());
    }

    @Test
    public void removeEdge() {
        RailwayNet2 net = new RailwayNet2("Rotkreuz", "Luzern", "Zug");
        assertTrue(net.addEdge("Rotkreuz", "Zug", 12));
        assertTrue(net.addEdge("Rotkreuz", "Luzern", 16));
        assertTrue(net.removeEdge("Rotkreuz", "Zug"));
        assertEquals(2, net.getNumberOfEdges());
    }

    @Test
    public void getWeight() {
        RailwayNet2 net = new RailwayNet2("Rotkreuz", "Luzern", "Zug");
        assertTrue(net.addEdge("Rotkreuz", "Zug", 12));
        assertTrue(net.addEdge("Rotkreuz", "Luzern", 16));
        assertEquals(16, net.getWeight("Luzern", "Rotkreuz"));
    }

    @Test
    public void isDirect() {
        RailwayNet2 net = new RailwayNet2("Rotkreuz", "Luzern", "Zug");
        assertTrue(net.addEdge("Rotkreuz", "Zug", 12));
        assertTrue(net.addEdge("Rotkreuz", "Luzern", 16));
        assertTrue(net.isDirect("Zug", "Rotkreuz"));
    }

    @Test
    public void isDirectFalse() {
        RailwayNet2 net = new RailwayNet2("Rotkreuz", "Luzern", "Zug");
        assertTrue(net.addEdge("Rotkreuz", "Zug", 12));
        assertTrue(net.addEdge("Rotkreuz", "Luzern", 16));
        assertFalse(net.isDirect("Zug", "Luzern"));
    }

    @Test
    public void getAllAdjaNodes() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("Zug", 12);
        expected.put("Luzern", 16);
        RailwayNet2 net = new RailwayNet2("Rotkreuz", "Luzern", "Zug");
        assertTrue(net.addEdge("Rotkreuz", "Zug", 12));
        assertTrue(net.addEdge("Rotkreuz", "Luzern", 16));
        assertEquals(expected, net.getAllAdjaNodes("Rotkreuz"));
    }
}