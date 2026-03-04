package com.app.hw20;

import java.util.*;

public class Graph {
    private final Map<Integer, Set<Integer>> graph = new HashMap<>();

    public void addVertex(int vertex) {
        graph.putIfAbsent(vertex, new HashSet<>());
    }

    public void addEdge(int source, int destination) {
        graph.putIfAbsent(source, new HashSet<>());
        graph.get(source).add(destination);
    }

    public void removeVertex(int vertex) {
        graph.remove(vertex);
        for (Set<Integer> values : graph.values()) {
            values.remove(vertex);
        }
    }

    public void removeEdge(int source, int destination) {
        if (graph.containsKey(source)) {
            graph.get(source).remove(destination);
        }
    }

    public boolean hasVertex(int vertex) {
        return graph.containsKey(vertex);
    }


    public boolean hasEdge(int source, int destination) {
        if (hasVertex(source)) {
            return graph.get(source).contains(destination);
        }
        return false;
    }

    public void print() {
        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
