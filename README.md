# CS-520-Project-BFS-DFS


Pull the source code

Run the class App.java to input parameters source vertices start and target, and 1 for BFS and 0 for DFS

CompareSearchAlgorithm.java randomly selects 40 randomly selected source/ target vertices and runs BFS and DFS on them.

AppTest.java runs the test cases on the DFS and BFS algorithm for specific graphs

Usage:

mvn clean install to build the package

While running for DFS algorithm sometimes the algorithm may incur StackOverflow error as well, the reason being that the edges are very high in number between various vertices and hence it may cause the algorithm to loop continously for example maximum edges maybe 100000 (10000 vertices and 10 edges for each vertex) which is huge and may cause the StackOverFlow error, please run it again to get proper results.
 
