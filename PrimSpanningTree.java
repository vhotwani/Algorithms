// Prim's Algorithm for InputMatrix with 100 nodes 
// Time Complexity O(N^2) for adjacent matrix 


class PrimSpanningTree
{
       private static final int N=100; // number of nodes
 
   // find the vertex in checkarray that have min distance
    int MinValue(int Min_Value[], Boolean CheckArray[])
    {
        // Initialize minimum value
        int min = Integer.MAX_VALUE, min_index=-1;
 
        for (int v = 0; v <N; v++)
            if (CheckArray[v] == false && Min_Value[v] < min)
            {
                min = Min_Value[v];
                min_index = v;
            }
 
        return min_index;
    }
 
    // function to print solution
    void printsolution(int Root[], int n, int InputMatrix[][])
    {
        System.out.println("Edge   Weight");
        for (int i = 1; i < N; i++)
            System.out.println(Root[i]+" - "+ i+"    "+
                               InputMatrix[i][Root[i]]);
    }
 
   // Function that implements Prim Algorithm for a graph representing using adjacent matrix
    void PrimAlgorithm(int InputMatrix[][])
    {
        // array to store result
        int Root[] = new int[N];
 
        // to represent min weight edge
        int Min_Value[] = new int [N];
 
        // to store values not checked 
        Boolean CheckArray[] = new Boolean[N];
 
        // all min values are infinite
        for (int i = 0; i <N; i++)
        {
            Min_Value[i] = Integer.MAX_VALUE;
            CheckArray[i] = false;
        }
 
       
        Min_Value[0] = 0;    
                        
        Root[0] = -1; // initialize first node as root
 
      // creating Minimum spanning tree
        for (int count = 0; count <N-1; count++)
        {
           // first chose min value vertex
            int u = MinValue(Min_Value, CheckArray);
 
           // add it to checkarray
            CheckArray[u] = true;
               // now check for adjacent nodes 
            for (int v = 0; v <N; v++)
 
               
                // CheckArray[v] is false for vertices not yet included in MST
                // Update the Min_Value only if InputMatrix[u][v] is lesser than Min_Value[v]
                if (InputMatrix[u][v]!=0 && CheckArray[v] == false &&
                    InputMatrix[u][v] <  Min_Value[v])
                {
                    Root[v]  = u;
                    Min_Value[v] = InputMatrix[u][v];
                }
        }
 
        // print the constructed tree
        printsolution(Root,N, InputMatrix);
    }
 
    public static void main (String[] args)
    {
        
    	PrimSpanningTree s = new PrimSpanningTree();
        // creating matrix to represent graph 
        int[][] InputMatrix = new int [100][100];
	    
	    for (int i=0; i<InputMatrix.length; i++) {
	        for (int j=0; j<InputMatrix[i].length; j++) {
	        	InputMatrix[i][j] = (int) (Math.random()*10);
	        }           
	    }
    	
 
        // Print the solution
        s.PrimAlgorithm(InputMatrix);
    }
}