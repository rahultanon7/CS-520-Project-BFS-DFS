package com.graph.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BFS {


    // prints BFS traversal from a given source s
    public List<Integer> BFS(int s, int t, List<List<Integer> > adjacencyList, int v) {

        // Mark all the vertices as not visited(By default
        // set as false)

        long start = System.currentTimeMillis();

        boolean visited[] = new boolean[v];

        int parent[]=new int[v];

        for(int i=0;i<v;i++){

            visited[i]=false;

            parent[i]=-1;
        }

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s]=true;

        parent[s]=-1;

        queue.add(s);

        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            //System.out.print(s+" ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adjacencyList.get(s).listIterator();

            int n=-1;

            while (i.hasNext())
            {

                n = i.next();

                if (!visited[n])
                {

                    visited[n] = true;
                    parent[n]=s;
                    if(n==t)
                    {
                        break;
                    }
                    queue.add(n);
                }
            }
            if(n==t)
            {

                break;
            }
        }

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

        System.out.println("BFS takes " + (end - start) + "ms");

        return arr;
    }
}
