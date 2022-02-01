package com.graph.app;

import java.util.*;

/***
 * Create a Random Graph Using
 * Random Edge Generation in Java
 **/
public class App {

    // Set a maximum limit to the vertices
    private final int MAX_LIMIT = 10001;

    // A Random instance to generate random values
    private final Random random = new Random();

    // An adjacency list to represent a graph
    private List<List<Integer>> adjacencyList;


    public List<List<Integer>> getAdjacencyList() {

        return adjacencyList;
    }

    public int getMAX_LIMIT() {

        return MAX_LIMIT;
    }

    public void createGraph() {

        // Set a maximum limit for the
        // number of vertices say 20
        // Number of vertices
        int vertices = MAX_LIMIT;
        // p is the probability that there
        // is an edge between any two vertices
        // say, 0.4 is the probability that there
        // is an edge between any two vertices
        // Print the probability p
        //System.out.println(
        //       "The probability that there is an edge"
        //                + " between any two vertices is : ");

        // Creating an adjacency list
        // representation for the random graph
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 1; i <= vertices; i++)
            adjacencyList.add(new ArrayList<>());

        // A for loop to randomly generate edges
        for (int i = 1; i < vertices; i++) {

            // edgeProbability is a random number
            // between 0.0 and 1.0
            // If the randomly chosen number
            // edgeProbability is less than
            // the probability of an edge p,
            // say, edgeProbability = 0.2 which is less
            // than p = 0.4, then add an edge between the
            // vertex i and the vertex j

            int max = 10;
            int min = 1;
            int range = max - min + 1;

            int edges = (int) (Math.random() * range) + min;

            for(int j=0; j<edges; j++) {

                // generating integer
                int nextNode  = random.nextInt(10000)+1;

                addEdge(i, nextNode);
            }
        }
    }

    // Method to add edges between given vertices
    public void addEdge(int v, int w) {

        // Note: it is a directed graph
        // Add w to v's adjacency list
        adjacencyList.get(v).add(w);
    }

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

    // The function to do DFS traversal
    // It uses recursive
    // DFSUtil()
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

       System.out.println("DFS Path Length = " + arr.size());

       System.out.println("DFS Path is as follows");

        for(int i=arr.size()-1;i>=0;i--) {

            System.out.print(arr.get(i) + "->");
        }

        System.out.println();

        long end = System.currentTimeMillis();

        System.out.println("DFS takes " + (end - start) + "ms");

        return arr;
    }

    // prints BFS traversal from a given source s
    public List<Integer> BFS(int s, int t, List<List<Integer>> adjacencyList, int v) {

        // Mark all the vertices as not visited(By default
        // set as false)

        long start = System.currentTimeMillis();

        boolean visited[] = new boolean[v];

        int parent[]=new int[v];

        for(int i=0;i<v;i++) {

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

                    if(n==t) {

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

        System.out.println("BFS Path Length = " + arr.size());

        System.out.println("BFS Path is as follows");

        for(int i=arr.size()-1;i>=0;i--) {

            System.out.print(arr.get(i) + "->");
        }

        System.out.println();

        long end = System.currentTimeMillis();

        System.out.println("BFS takes " + (end - start) + "ms");

        return arr;
    }

    public static void main(String[] args) {

        // Create a GFGRandomGraph object
        App randomGraph = new App();

        randomGraph.createGraph();

        // Print the graph
        System.out.println("The generated random graph :");

        for (int i = 0; i < randomGraph.adjacencyList.size(); i++) {

            System.out.print(i + " -> { ");

            List<Integer> list = randomGraph.adjacencyList.get(i);

            if (list.isEmpty()) {

                System.out.print(" No adjacent vertices ");
            }
            else {

                int size = list.size();

                for (int j = 0; j < size; j++) {

                    System.out.print(list.get(j));

                    if (j < size - 1)

                        System.out.print(" , ");
                }
            }

            System.out.println("}");
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the source vertex from 1 and 10000 inclusive");

        int src = sc.nextInt();

        if(src < 1 || src > 10000) {

            System.out.println("Invalid option selected");

            System.exit(0);
        }

        System.out.println("Enter the target vertex from 1 and 10000 inclusive");

        int target = sc.nextInt();

        if(target<1 || target>10000){

            System.out.println("Invalid option selected");

            System.exit(0);
        }

        System.out.println("Enter 1 for BFS and 0 for DFS");

        int algorithm = sc.nextInt();

        if(algorithm == 1){

            randomGraph.BFS(src, target, randomGraph.getAdjacencyList(), randomGraph.getMAX_LIMIT());
        }
        else if(algorithm == 0){

            randomGraph.DFS(src, target, randomGraph.getAdjacencyList(), randomGraph.getMAX_LIMIT());
        }
        else{

            System.out.println("Invalid option selected");

            System.exit(0);
        }
    }
}
