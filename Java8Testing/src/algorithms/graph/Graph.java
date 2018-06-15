package algorithms.graph;

import java.util.LinkedList;


// A user define class to represent a graph.
// A graph is an array of adjacency lists.
// Size of array will be V (number of vertices 
// in graph)
public class Graph
{
    int V;
    public static LinkedList<Integer> adjListArray[];
     
    // constructor 
    Graph(int V)
    {
        this.V = V;
         
        // define the size of array as 
        // number of vertices
        adjListArray = new LinkedList[V];
         
        // Create a new list for each vertex
        // such that adjacent nodes can be stored
        for(int i = 0; i < V ; i++){
            adjListArray[i] = new LinkedList<>();
        }
    }
}