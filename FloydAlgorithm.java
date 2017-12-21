
// Floyds algorithm for a graph Represented by Adjacent matrix 
// Time Complexity o(n^3) for adjacent matrix
public class FloydAlgorithm {
	

		
		static final int A = 100;

		public static void main(String[] args) {
			int[][] AdjacentMatrix = RandomArray(100);
		
			System.out.println("AdjacentMatrix.");
			printMatrix(AdjacentMatrix);
			System.out.println("Shortest Path   Matrix.");
			printMatrix(FlyodAlgorithm(AdjacentMatrix));
			
			
			
		}

		public static int[][] FlyodAlgorithm(int[][] AdjacentMatrix) {
			for (int k = 0; k < A; k++) {
				for (int i = 0; i < A; i++) {
					for (int j = 0; j < A; j++) {
						// recurrence relation of algorithm
						AdjacentMatrix[i][j] = Math.min(AdjacentMatrix[i][j], AdjacentMatrix[i][k] + AdjacentMatrix[k][j]);
					}
				}
			}
			return AdjacentMatrix;
		}

		
            // method used to print matrix 
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
		// function to create adjacent matrix that represents graph 
		private static int[][] RandomArray(int n) {
		    int[][] randomMatrix = new int [n][n];
		    
		    for (int i=0; i<randomMatrix.length; i++) {
		        for (int j=0; j<randomMatrix[i].length; j++) {
		        	randomMatrix[i][j] = (int) (Math.random()*100);
		        }           
		    }	 
		    return randomMatrix;
		}

}

