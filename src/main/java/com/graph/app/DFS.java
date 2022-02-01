package com.graph.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DFS {

    // A function used by DFS
    public void DFSUtil(int s, int t, int par, List<List<Integer>> adjacencyList, boolean visited[], int parent[]) {

        // Mark the current node as visited and print it

        if(visited[s])
            return;

        visited[s] = true;

        parent[s] = par;

        if(s==t)
            return;

        if(parent[t] != -1)
            return;

        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> i = adjacencyList.get(s).listIterator();

        while (i.hasNext()) {

            int n = i.next();

            if (!visited[n]) {

                DFSUtil(n, t, s, adjacencyList, visited, parent);

                if(n==t) {

                    return;
                }
            }
        }
    }

    /** The function to do DFS traversal
     * It uses recursive
     * DFSUtil()
     * **/
    public List<Integer> DFS(int s, int t, List<List<Integer>> adjacencyList, int v) {

        // Mark all the vertices as
        // not visited(set as
        // false by default in java)

        boolean visited[] = new boolean[v];

        int parent[]=new int[v];

        for(int i=0;i<v;i++){

            visited[i]=false;

            parent[i]=-1;
        }

        long start = System.currentTimeMillis();

        // Call the recursive helper
        // function to print DFS
        // traversal
        DFSUtil(s, t, -1, adjacencyList, visited, parent);

        int vertex = t;

        ArrayList<Integer> arr=new ArrayList<>();

        while(vertex!=-1){

            arr.add(vertex);

            vertex=parent[vertex];
        }

        if(arr.size() == 0){

            System.out.println(" No path exists from source to destination ");
        }

        for(int i=arr.size()-1;i>=0;i--){

            System.out.print(arr.get(i) + " ");
        }

        System.out.println();

        long end = System.currentTimeMillis();

        System.out.println("DFS takes " + (end - start) + " ms");

        return arr;
    }
}
