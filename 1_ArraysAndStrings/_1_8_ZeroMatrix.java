//Cracking the Coding Interview
//Chapter 1: Arrays and Strings
//Problem-1.8: ZeroMatrix
//Description: Write an algorithm such that if an element in an MxN 
//matrix is 0, its entire row and column are set to zero.

class ZeroMatrix{
	public static void main(String[] args){
		int[][]a = {{1, 2, 1, 8},
			    {9, 8, 7, 9},
			    {0, 2, 5, 1},
			    {1, 2, 3, 0}};

		System.out.println("Original Matrix:");
		printMatrix(a);

		zeroMatrix(a);
		System.out.println("After nullify:");
		printMatrix(a);
	}

	//Time Complexity O(NxN) as we need to check every element
	public static void zeroMatrix(int[][] a){
		boolean[] row = new boolean[a.length];
		boolean[] column = new boolean[a[0].length];

		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a[0].length; j++){
				if(a[i][j] == 0){
					row[i] = true;
					column[j] = true;
				}
			}
		}
		//check the row and make entire row zero
		for(int i = 0; i < row.length; i++){
			if(row[i]){
				nullifyRow(a, i);
			}
		}		
		//check the column and make entire column zero
		for(int i = 0; i < column.length; i++){
			if(column[i]){
				nullifyColumn(a, i);
			}
		}
	}

	public static void nullifyRow(int[][] a, int row){
		for(int c = 0; c < a[0].length; c++){
			a[row][c] = 0;
		}
	}

	public static void nullifyColumn(int[][] a, int column){
		for(int r = 0; r < a.length; r++){
			a[r][column] = 0;
		}
	}

	public static void printMatrix(int[][]a){
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a[0].length; j++){
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
