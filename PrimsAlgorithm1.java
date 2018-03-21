//tutored by Josh Patton
import java.io.*;
import java.util.Arrays;

public class PrimMachine {


    private int[][] graph;

    //used for calculations requiring array lengths
    private int nodeNumber;

    //the newly constructed 2d array
    private int[][] mstGraph;

    //used to track whcih nodes have been visited
    private boolean[] visited;

    //used to keep track of how many nodes have been visited
    private int numberVisited;

    //constructor
    public PrimMachine(int[][] graph) {
        this.graph = graph;
    }

    //main function, it adds the lowest weight edges to the MST
    public int[][] findPrimMST() {

        nodeNumber = graph.length;

        //initialize all values of the mst to 0
        mstGraph = new int[nodeNumber][nodeNumber];
        for (int i = 0; i < nodeNumber; i++) {
            for (int j = 0; j < nodeNumber; j++)
                mstGraph[i][j] = 0;
        }

        visited = new boolean[nodeNumber];

        //mark node 0 as visited, and set the number visited to 1
        visited[0] = true;
        numberVisited = 1;

        //while not all nodes have been visited...
        while (numberVisited < nodeNumber) {

            //add a least-weighted edge
            findAndAddLWE(mstGraph);
            numberVisited++;


        }
        return mstGraph;
    }

    //finds and adds LWE to MST
    private int[][] findAndAddLWE(int[][] mstGraph) {
        int lowestWeight = Integer.MAX_VALUE;
        int lowestWeightRow = 0;
        int lowestWeightColumn = 0;

        //this loop iterates through the boolean array to check which vertex's have been visited
        for (int visitedNodeI = 0; visitedNodeI < nodeNumber; visitedNodeI++) {

            //if a node has been visited, continue to add the edges connected to it to a list
            if (visited[visitedNodeI]) {

                //add that list of all edges to an array, it will include the 0's and the existing edges
                int[] edges = graph[visitedNodeI];

                //iterate through this list, looking ONLY for edges leading to unvisited vertex's
                for (int edgeI = 0; edgeI < nodeNumber; edgeI++) {

                    //if an edge leading to an unvisited vertex is found...
                    if (!isEdgeVisited(edgeI)) {

                        //and that edge is lower than the value held in lowestWeight, update value to lowestWeight
                        if (lowestWeight > edges[edgeI]) {
                            if (edges[edgeI] != 0) {

                                //the edge with lowest weights value
                                lowestWeight = edges[edgeI];

                                //the lowest weights row in graph
                                lowestWeightRow = visitedNodeI;

                                //the lowest weights column in graph
                                lowestWeightColumn = edgeI;
                            }
                        }
                    }
                }
            }

        }

        //the values in the mst graph must be updated twice since the graph is symmetrical
        mstGraph[lowestWeightRow][lowestWeightColumn] = lowestWeight;
        mstGraph[lowestWeightColumn][lowestWeightRow] = lowestWeight;

        visited[lowestWeightColumn] = true;
        return mstGraph;
    }

    //returns true if the vertex has been visited
    private boolean isEdgeVisited(int edgeI) {
        return visited[edgeI];
    }


    void printMST() {
        System.out.println(Arrays.deepToString(mstGraph).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));

        }

    }
