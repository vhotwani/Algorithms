// Dijkstra algorithm using adjacent matrix
// time complexity :   matrix representation is O(V^2)
// O(ELogV) for adjacency list representation 
class ShortestPathdijkstra
	{
	  
	    static final int N=100;
	    int Min_Distance(int Distance[], Boolean CheckArray[]) // function to find node with Lowest value 
	    {
	       
	        int Lowest = Integer.MAX_VALUE, Lowest_index=-1;
	 
	        for (int v = 0; v <N; v++)
	            if (CheckArray[v] == false && Distance[v] <= Lowest)
	            {
	                Lowest = Distance[v];
	                Lowest_index = v;
	            }
	 
	        return Lowest_index;
	    }
	 
	    
	    void printSolution(int Distance[], int n) // function to print result
	    {
	        System.out.println("shortest path");
	        for (int i = 0; i <N; i++)
	            System.out.println(i+"     "+Distance[i]);
	    }
	 
	    
	    void dijkstra(int AdjacentMatrix[][], int src) // function that implement dijkstra algorithm for a AdjacentMatrixrepresented by adjacent atrix
	    {
	        int Distance[] = new int[N]; // the array to store output
	 
	       
	        Boolean CheckArray[] = new Boolean[N]; // CheckArray[i] will be true if node is included in Distance array
	 
	       // all Distances zero
	        for (int i = 0; i <N; i++)
	        {
	            Distance[i] = Integer.MAX_VALUE;
	            CheckArray[i] = false;
	        }
	 
	       // initialize source vertex to itself as zero
	        Distance[src] = 0;
	 
	        // Find shortest path for all vertices
	        for (int count = 0; count <N-1; count++)
	        {
	            // Choose the Lowest Distance vertex from the set of vertices
	            
	            int u = Min_Distance(Distance, CheckArray);
	 
	           
	            CheckArray[u] = true; // mark the chose vertex
	 
	           
	            for (int v = 0; v <N; v++) // update the distance checking from checkarray
	 
	              
	                if (!CheckArray[v] && AdjacentMatrix[u][v]!=0 &&
	                        Distance[u] != Integer.MAX_VALUE &&
	                        Distance[u]+AdjacentMatrix[u][v] < Distance[v])
	                    Distance[v] = Distance[u] + AdjacentMatrix[u][v];
	        }
	 
	       // print the solution
	        printSolution(Distance,N);
	    }
	 
	    // Main Method
	    public static void main (String[] args)
	    {  
            int[][] AdjacentMatrix= new int [100][100];
		    
		    for (int i=0; i< AdjacentMatrix.length; i++) {
		        for (int j=0; j< AdjacentMatrix[i].length; j++) {
		        	 AdjacentMatrix[i][j] = (int) (Math.random()*100);
		        }           
		    }
	    	
	    
		    ShortestPathdijkstra t = new ShortestPathdijkstra();
	        t.dijkstra( AdjacentMatrix, 0);
	    }
	}

