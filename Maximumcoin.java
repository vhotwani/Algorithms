
/// Algorithm to find maximum coins robot can pick 
// The random array generates random matrix from value {0,1} i.e : 0 means no coin and 1 means coin
// If size of array needs to change change input parameter for randomarray function also change A

import java.util.Random;

public class Maximumcoin {
	static final int A = 6; // array is of 6 length

	public static int maxcoins(int[][] InputMatrix) {

        int N = InputMatrix.length;
        int M = InputMatrix[0].length;
        int[][] ResultMatrix = new int [N][M];

        ResultMatrix[0][0] = InputMatrix[0][0];
        for (int column = 1; column < M; column++) {
            ResultMatrix[0][column] = ResultMatrix[0][column - 1] + InputMatrix[0][column];
        }
// Recurrence relation for Maximum money robot can collect
        for (int row = 1; row < N; row++) {
            ResultMatrix[row][0] = ResultMatrix[row - 1][0] + InputMatrix[row][0];
            for (int column = 1; column < M; column++) {
                ResultMatrix[row][column] = Math.max(ResultMatrix[row - 1][column], ResultMatrix[row][column - 1]) + InputMatrix[row][column];
            }
        }

       
        System.out.println("ResultMatrix[][]");
        System.out.println("-------------");
        for (int row = 0; row < 6; row++) {
            for (int column = 0; column < 6; column++) {
                System.out.print(ResultMatrix[row][column] + "  ");
            }
            System.out.println();
        }

        return ResultMatrix[N - 1][M - 1];
    }

    public static void main(String[] args) {
    	  
        int [][]InputMatrix =  RandomArray(6);
        System.out.println("InputMatrix[][]");
        printMatrix(InputMatrix );
        System.out.println("Maximum number of coins robot picks  :- "+maxcoins(InputMatrix));
        
    }
    public static void printMatrix(int[][] Matrix) {
  		System.out.print("\n\t");
  		for (int j = 0; j < A; j++) {
  			System.out.print(j + "\t");
  		}
  		System.out.println();
  		for (int j = 0; j < 35; j++) {
  			System.out.print("-");
  		}
  		System.out.println();
  		for (int i = 0; i < A; i++) {
  			System.out.print(i + " |\t");
  			for (int j = 0; j < A; j++) {
  				System.out.print(Matrix[i][j]);
  				System.out.print("\t");
  			}
  			System.out.println("\n");
  		}
  		System.out.println("\n");
  	}
      
      
      private static int[][] RandomArray(int n) {
  	    int [][] randomMatrix = new int [n][n];
  	    int []a= new int[]{0, 1};
          Random rnd= new Random();
  	    
  	    for (int i=0; i<randomMatrix.length; i++) {
  	        for (int j=0; j<randomMatrix[i].length; j++) {
  	        	randomMatrix[i][j] = a[rnd.nextInt(a.length)];
  	        }           
  	    }	 
  	    return randomMatrix;
  	}

}