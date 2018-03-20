//tutored by Josh Patton

public class PrimMachine {

    private int[][] graph;

    private int nodeNumber;
    private int[][] mstGraph;
    private boolean[] visited;
    private int numberVisited;

    public PrimMachine(int[][] graph) {
        this.graph = graph;
    }

    public int[][] findPrimMST() {

        nodeNumber = graph.length;
        mstGraph = new int[nodeNumber][nodeNumber];
        visited = new boolean[nodeNumber];
        numberVisited = 1;

        //not all nodes have been visisted
        while (numberVisited < nodeNumber) {
            findAndAddLWE();


        }

    }

    //finds and adds LWE to MST
    private void findAndAddLWE() {
        int lowestWeight = Integer.MAX_VALUE;
        int edge;
        
        //this loop iterates through the boolean array to check which vertex's have been visited
        for (int visitedNodeI = 0; visitedNodeI < nodeNumber; visitedNodeI++) {
            
            //if a node has been visited, continue to add the edges connected to it to a list
            if (visited[visitedNodeI]) {
                
                //add that list of all edges to an array, it will include the 0's and the existing edges
                int[] edges = graph[visitedNodeI];
                
                //iterate through this list, looking ONLY for edges leading to unvisited vertex's
                for (int edgeI = 0; edgeI < nodeNumber; edgeI++) {
                    
                    //if an edge leading to an unvisited edge is found...
                    if (!isEdgeVisited(edgeI)) {
                        
                        //and that edge is lower than the value held in lowestWeight, update value to lowestWeight
                        if(lowestWeight > edges[edgeI]){
                            lowestWeight = edges[edgeI];
                        }
                    }
                }
            }
        }
    }
    
    //returns true if the vertex has been visited
    private boolean isEdgeVisited(int edgeI) {
        return visited[edgeI];
    }
}




                        /*0  1  2  3  4  5  6  7  8
                        {0, N, O, 0, 0, 0, 0, 0, 0},
                        {N, 0, M, L, 0, 0, A, 0, 0},
                        {O, M, 0, K, J, 0, 0, 0, 0},
                        {0, L, K, 0, 0, I, B, C, 0},
                        {0, 0, J, 0, 0, H, 0, 0, G},
                        {0, 0, 0, I, H, 0, 0, P, F},
                        {0, A, 0, B, 0, 0, 0, D, 0},
                        {0, 0, 0, C, 0, P, D, 0, E},
                        {0, 0, 0, 0, G, F, 0, E, 0},*/
