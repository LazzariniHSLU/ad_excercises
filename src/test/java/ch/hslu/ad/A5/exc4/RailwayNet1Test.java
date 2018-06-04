package ch.hslu.ad.A5.exc4;

import org.junit.Test;

import static org.junit.Assert.*;

public class RailwayNet1Test {

    @Test
    public void addStation() {
        RailwayNet1 net = new RailwayNet1();
        assertTrue(net.addNode("Rotkreuz"));
        assertEquals(net.getNumberOfNodes(), 1);
    }

    @Test
    public void addEdge() {
        RailwayNet1 net = new RailwayNet1(new String[]{"Rotkreuz", "Zug", "Luzern"});
        assertTrue(net.addEdge("Rotkreuz", "Zug", 15));
        assertTrue(net.addEdge("Rotkreuz", "Luzern", 16));
        assertEquals(2, net.getNumberOfEdges());

    }

    @Test
    public void getWeight() {
        RailwayNet1 net = new RailwayNet1(new String[]{"Rotkreuz", "Zug", "Luzern"});
        assertTrue(net.addEdge("Rotkreuz", "Zug", 15));
        assertTrue(net.addEdge("Rotkreuz", "Luzern", 16));
        System.out.println(net.toString());
        assertEquals(16, net.getWeight("Rotkreuz", "Luzern"));
    }

    @Test
    public void isDirect() {
        RailwayNet1 net = new RailwayNet1(new String[]{"Rotkreuz", "Zug", "Luzern"});
        assertTrue(net.addEdge("Rotkreuz", "Zug", 15));
        assertTrue(net.addEdge("Rotkreuz", "Luzern", 16));
        assertEquals(false, net.isDirect("Zug", "Luzern"));
    }

    @Test
    public void removeNode() {
        RailwayNet1 net = new RailwayNet1(new String[]{"Rotkreuz", "Zug", "Luzern"});
        net.addEdge("Rotkreuz", "Zug", 15);
        net.addEdge("Rotkreuz", "Luzern", 16);
        System.out.println(net.toString());
        assertTrue(net.removeNode("Zug"));
        assertEquals(2, net.getNumberOfNodes());
        assertEquals(1, net.getNumberOfEdges());
        System.out.println(net.toString());

    }
}