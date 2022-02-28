package com.graph.app;

import java.util.*;

/***
 * Create a Random Graph Using
 * Random Edge Generation in Java
 **/
public class App {

    private static final int MAX_LIMIT = 10001; // sets the maximum limit on the number of vertices
    private final Random random = new Random(); // used to generate the random vertices
    private List<List<Integer>> adjacencyList; // used to store the graph data structure
    public List<List<Integer>> getAdjacencyList() {
        return adjacencyList;
    }

    public int getMAX_LIMIT() {
        return MAX_LIMIT;
    }

    /**
     * Creates a graph with vertices 1 to MAX_LIMIT
     * */
    public void createGraph() {
        int vertices = MAX_LIMIT;
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 1; i <= vertices; i++)
            adjacencyList.add(new ArrayList<>());
        for (int i = 1; i <= vertices; i++) {
            int max = 10;
            int min = 1;
            int range = max - min + 1;
            int edges = (int) (Math.random() * range) + min;
            for(int j=0; j<edges; j++) {
                int nextNode  = random.nextInt(MAX_LIMIT-1)+1;
                addEdge(i, nextNode);
            }
        }
    }

    public void addEdge(int v, int w) {
        adjacencyList.get(v).add(w); // adds an edge between vertices v and w
    }

    /**
     * recursively goes through the graph and visits each node using DFS algorithm and storing parents of each vertex
     * along with visited array
     * */
    public void DFSUtil(int s, int t, int par, List<List<Integer>> adjacencyList, boolean visited[], int parent[]) {
        if(visited[s])
            return;
        visited[s] = true;
        parent[s] = par;
        if(s==t)
            return;
        if(parent[t] != -1)
            return;
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

    public List<Integer> DFS(int s, int t, List<List<Integer>> adjacencyList, int v) {
        boolean visited[] = new boolean[v]; // visited array to store the number of elements which are already visited while doing BFS algo
        int parent[]=new int[v]; // parent array to store the parent of each of the vertex while travelling using DFS
        for(int i=0;i<v;i++){
            visited[i]=false;
            parent[i]=-1;
        }
        long start = System.currentTimeMillis();
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

    /**
     * Iterates the graph in BFS algorithm to visit from parent to child vertex
     * */
    public List<Integer> BFS(int s, int t, List<List<Integer>> adjacencyList, int v) {
        long start = System.currentTimeMillis();
        boolean visited[] = new boolean[v];
        int parent[]=new int[v];
        for(int i=0;i<v;i++) {
            visited[i]=false;
            parent[i]=-1;
        }
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s]=true;
        parent[s]=-1;
        queue.add(s);
        while (queue.size() != 0) {
            s = queue.poll();
            Iterator<Integer> i = adjacencyList.get(s).listIterator();
            int n=-1;
            while (i.hasNext()) {
                n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    parent[n]=s;
                    if(n==t) {
                        break;
                    }
                    queue.add(n);
                }
            }
            if(n==t) {
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
        App randomGraph = new App(); // creates an instance of random graph
        randomGraph.createGraph();
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
        if(src < 1 || src > MAX_LIMIT-1) {
            System.out.println("Invalid option selected");
            System.exit(0);
        }
        System.out.println("Enter the target vertex from 1 and 10000 inclusive");
        int target = sc.nextInt();
        if(target < 1 || target > MAX_LIMIT-1){
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
