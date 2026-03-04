package com.app.hw20;

public class Main {
    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        System.out.println("Vertexes added:");
        graph.print();

        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);
        System.out.println("Edges added:");
        graph.print();

        System.out.println("is vertex 2 present? " + graph.hasVertex(2));
        System.out.println("is vertex 5 present? " + graph.hasVertex(5));
        System.out.println("is edge 1 -> 2 present? " + graph.hasEdge(1, 2));
        System.out.println("is edge 2 -> 4 present? " + graph.hasEdge(2, 4));

        graph.removeEdge(1, 2);
        System.out.println("Remove edge 1 -> 2:");
        graph.print();

        graph.removeVertex(3);
        System.out.println("Remove vertex 3:");
        graph.print();

    }
}
