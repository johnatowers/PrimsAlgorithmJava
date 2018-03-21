
public class main {
    public static void main(String[] args) {
        int[][] graph1 = {
                /*{0, 3, 21, 5, 0, 0},
                {3, 0, 6, 1, 0, 0},
                {21, 6, 0, 8, 0, 0},
                {5, 1, 8, 0, 1, 23},
                {0, 0, 0, 1, 0, 4},
                {0, 0, 0, 23, 4, 0},*/
                {0,5,3,7,1,0,0,0},
                {5,0,6,8,0,0,0,0},
                {3,6,0,2,9,5,6,0},
                {7,8,2,0,0,0,1,3},
                {1,0,9,0,0,4,0,0},
                {0,0,5,0,4,0,0,6},
                {0,0,6,1,0,0,0,0},
                {0,0,0,3,0,6,0,0}
        };

        //create a new instance of PrimMachine, and feed it the graph to be analyzed
        PrimMachine try1 = new PrimMachine(graph1);

        //analyze the graph
        try1.findPrimMST();

        //print the results
        try1.printMST();
    }
}
