package com.graph.utility;

import com.graph.app.App;

public class CompareSearchAlgorithm {

    public static void main(String[] args) {
        App app = new App();
        app.createGraph();
        int min=0, max = app.getMAX_LIMIT()-1;
        for (int i = 0; i < 40; i++) {
            int s = min + (int)(Math.random() * (max - min));
            int t = min + (int)(Math.random() * (max - min));
            System.out.println("source = " + s + " target = " + t);
            app.DFS(s, t, app.getAdjacencyList(), app.getMAX_LIMIT());
            app.BFS(s, t, app.getAdjacencyList(), app.getMAX_LIMIT());
            System.out.println();
        }
    }
}
