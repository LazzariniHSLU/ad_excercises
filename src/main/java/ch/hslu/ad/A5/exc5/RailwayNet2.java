package ch.hslu.ad.A5.exc5;

import java.util.HashMap;
import java.util.Map;


public class RailwayNet2 {
    private final Map<String, Map<String, Integer>> adjaList;

    public RailwayNet2() {
        adjaList = new HashMap<>();
    }

    public RailwayNet2(final String... nodes){
        adjaList = new HashMap<>();
        for(String node : nodes){
           this.addNode(node);
        }
    }

    public boolean isNodeInGraph(final String node) {
        return adjaList.containsKey(node);
    }

    public boolean addNode(final String node) {
        if (!isNodeInGraph(node)) {
            adjaList.put(node, new HashMap<>());
            return true;
        } else {
            return false;
        }
    }

    public boolean addEdge(final String from, final String to, final int weight) {
        if (isNodeInGraph(from) || isNodeInGraph(to)) {
            adjaList.get(from).put(to, weight);
            adjaList.get(to).put(from, weight);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeNode(final String node) {
        if (!isNodeInGraph(node)) {
            return false;
        } else {
            adjaList.remove(node);
            for(Map.Entry<String, Map<String, Integer>> entry : adjaList.entrySet()){
                if(entry.getValue().containsKey(node)){
                    adjaList.get(entry.getKey()).remove(node);
                }
            }
            return true;
        }
    }

    public boolean removeEdge(final String from, final String to) {
        if (!isNodeInGraph(from) || !isNodeInGraph(to)) {
            return false;
        } else {
            adjaList.get(from).remove(to);
            adjaList.get(to).remove(from);
        }
        return true;
    }

    public int getWeight(final String from, final String to){
        if(isNodeInGraph(from) && isNodeInGraph(to)) {
            return adjaList.get(from).get(to);
        }
        else {
            return 0;
        }
    }

    public boolean isDirect(final String from, final String to){
        if (isNodeInGraph(from) && isNodeInGraph(to)){
            return adjaList.get(from).containsKey(to);
        }
        else {
            return false;
        }
    }

    public int getNumberOfNodes() {
        return adjaList.size();
    }

    public int getNumberOfEdges() {
        int counter = 0;
        for (Map.Entry<String, Map<String, Integer>> entry : adjaList.entrySet()) {
            counter += entry.getValue().size();
        }
        return counter;
    }

    public Map<String, Integer> getAllAdjaNodes(final String node) {
        if (isNodeInGraph(node)) {
            return adjaList.get(node);
        } else {
            return new HashMap<>();
        }
    }
}
