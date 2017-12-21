// Kruskal Algorithm with 100 nodes & Time complexity is O(nlogn)

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
 
public class KruskalAlgorithm
{
    private List<Edge> edgeList;
    private int numofVertex ;
    public static final int HighestValue = 1000;
    private int AlreadyVisited[];
    private int Span_Tree[][];
 
    public KruskalAlgorithm(int numofVertex)
    {
        this.numofVertex = numofVertex;
        edgeList = new LinkedList<Edge>(); // linked list for edges
        AlreadyVisited = new int[this.numofVertex + 1]; // An array to store vertex visited
        Span_Tree = new int[numofVertex + 1][numofVertex + 1];// an array to store result
    }
 
    public void kruskalAlgorithm(int adjacentmatrix[][])
    {
        boolean Done = false;
        for (int StartPoint = 1; StartPoint <= numofVertex; StartPoint++)
        {
            for (int EndPoint = 1; EndPoint <= numofVertex; EndPoint++)
            {
                if (adjacentmatrix[StartPoint][EndPoint] != HighestValue && StartPoint != EndPoint)
                {
                    Edge edge = new Edge();
                    edge.StartPointvertex = StartPoint;
                    edge.EndPointvertex = EndPoint;
                    edge.weight = adjacentmatrix[StartPoint][EndPoint];
                    adjacentmatrix[EndPoint][StartPoint] = HighestValue;
                    edgeList.add(edge);
                }
            }
        }
        Collections.sort(edgeList, new EdgeComparator());
        VerifyLoop checkCycle = new VerifyLoop();
        for (Edge edge : edgeList)
        {
            Span_Tree[edge.StartPointvertex][edge.EndPointvertex] = edge.weight;
            Span_Tree[edge.EndPointvertex][edge.StartPointvertex] = edge.weight;
            if (checkCycle.verifyloop(Span_Tree, edge.StartPointvertex))
            {
                Span_Tree[edge.StartPointvertex][edge.EndPointvertex] = 0;
                Span_Tree[edge.EndPointvertex][edge.StartPointvertex] = 0;
                edge.weight = -1;
                continue;
            }
            AlreadyVisited[edge.StartPointvertex] = 1;
            AlreadyVisited[edge.EndPointvertex] = 1;
            for (int i = 0; i < AlreadyVisited.length; i++)
            {
                if (AlreadyVisited[i] == 0)
                {
                    Done = false;
                    break;
                } else
                {
                    Done = true;
                }
            }
            if (Done)
                break;
        }
        System.out.println("The span Tree using kruskal algorithm ");
        for (int i = 1; i <= numofVertex; i++)
            System.out.print("\t" + i);
        System.out.println();
        for (int StartPoint = 1; StartPoint <= numofVertex; StartPoint++)
        {
            System.out.print(StartPoint + "\t");
            for (int EndPoint = 1; EndPoint <= numofVertex; EndPoint++)
            {
                System.out.print(Span_Tree[StartPoint][EndPoint] + "\t");
            }
            System.out.println();
        }
    }
 
    public static void main(String... arg)
    {
       
        int number_of_vertices =100;
        
        int[][] Adjacent_Matrix = new int [101][101];
	    
	    for (int i=0; i<Adjacent_Matrix.length; i++) {
	        for (int j=0; j<Adjacent_Matrix[i].length; j++) {
	        	Adjacent_Matrix[i][j] = (int) (Math.random()*100);
	        }           
	    }
    	
 
      
        KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm(number_of_vertices);
        kruskalAlgorithm.kruskalAlgorithm(Adjacent_Matrix);
      
    }
}
 
class Edge
{
    int StartPointvertex;
    int EndPointvertex;
    int weight;
}
 
class EdgeComparator implements Comparator<Edge> // comparator function used to store edges
{
  
    public int compare(Edge edge1, Edge edge2)
    {
        if (edge1.weight < edge2.weight)
            return -1;
        if (edge1.weight > edge2.weight)
            return 1;
        return 0;
    }
}
 
class VerifyLoop
{
    private Stack<Integer> stack;
    private int adjacentmatrix[][];
 
    public VerifyLoop()
    {
        stack = new Stack<Integer>();
    }
 
    public boolean verifyloop(int Adjacent_Matrix[][], int StartPoint)
    {
        boolean loopdone = false;
        int number_of_nodes = Adjacent_Matrix[StartPoint].length - 1;
 
        adjacentmatrix = new int[number_of_nodes + 1][number_of_nodes + 1];
        for (int StartPointvertex = 1; StartPointvertex <= number_of_nodes; StartPointvertex++)
        {
            for (int EndPointvertex = 1; EndPointvertex <= number_of_nodes; EndPointvertex++)
            {
                adjacentmatrix[StartPointvertex][EndPointvertex] = Adjacent_Matrix[StartPointvertex][EndPointvertex];
            }
         }
 
         int AlreadyVisited[] = new int[number_of_nodes + 1];
         int element = StartPoint;
         int i = StartPoint;
         AlreadyVisited[StartPoint] = 1;
         stack.push(StartPoint);
 
         while (!stack.isEmpty())
         {
             element = stack.peek();
             i = element;
             while (i <= number_of_nodes)
             {
                 if (adjacentmatrix[element][i] >= 1 && AlreadyVisited[i] == 1)
                 {
                     if (stack.contains(i))
                     {
                         loopdone = true;
                         return loopdone;
                     }
                 }
                 if (adjacentmatrix[element][i] >= 1 && AlreadyVisited[i] == 0)
                 {
                     stack.push(i);
                     AlreadyVisited[i] = 1;
                     adjacentmatrix[element][i] = 0;
                     adjacentmatrix[i][element] = 0;
                     element = i;
                     i = 1;
                     continue;
                  }
                  i++;
             }
             stack.pop();
        }
        return loopdone;
    }
}

