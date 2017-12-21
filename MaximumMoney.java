
/// Algorithm to find maximum amount of money robot can pick.
// The random array generates random matrix from value { 0.5, 1, 2, 5}
// If size of array needs to change change input parameter for randomarray function also change A

import java.util.Random;

public class MaximumMoney {
	static final int A = 6; // array is of 6 length
// function that implements algorithm to calculate max money robot can collect
	public static double maxmoney(double[][] InputMatrix) {
        int N = InputMatrix.length;
        int M = InputMatrix[0].length;
        double[][] ResultMatrix = new double[N][M];

        ResultMatrix[0][0] = InputMatrix[0][0];
        for (int j = 1; j < M; j++) {
            ResultMatrix[0][j] = ResultMatrix[0][j - 1] + InputMatrix[0][j];
        }
// Recurrence relation for Maximum money robot can collect
        for (int i = 1;i < N;i++) {
            ResultMatrix[i][0] = ResultMatrix[i - 1][0] + InputMatrix[i][0];
            for (int j = 1; j < M; j++) {
                ResultMatrix[i][j] = Math.max(ResultMatrix[i - 1][j], ResultMatrix[i][j - 1]) + InputMatrix[i][j];
            }
        }

        System.out.println("ResultMatrix[][]");
        System.out.println("-------------");
        for (int i = 0;i < 6;i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(ResultMatrix[i][j] + "  ");
            }
            System.out.println();
        }

        return ResultMatrix[N - 1][M - 1];
    }

    public static void main(String[] args) {
    	  
        double[][]InputMatrix =  RandomArray(6);
        System.out.println("InputMatrix[][]");
        printMatrix(InputMatrix );
        System.out.println("Maximum Money Value robot collects : "+maxmoney(InputMatrix));
        
    }
    public static void printMatrix(double[][] Matrix) {
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
      
      
      private static double[][] RandomArray(int n) {
  	    double[][] randomMatrix = new double [n][n];
  	    double[]a= new double[]{0.5,1,2,5};
          Random rnd= new Random();
  	    
  	    for (int i=0; i<randomMatrix.length; i++) {
  	        for (int j=0; j<randomMatrix[i].length; j++) {
  	        	randomMatrix[i][j] = a[rnd.nextInt(a.length)];
  	        }           
  	    }	 
  	    return randomMatrix;
  	}

}
