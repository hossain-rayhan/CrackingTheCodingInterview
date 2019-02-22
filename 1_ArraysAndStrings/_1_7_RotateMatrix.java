//Cracking the Coding Interview
//Chapter 1: Arrays and Strings
//Problem-1.7: Rotate Matrix
//Description: Given a NxN matrix rotate it by 90 degree

class RotateMatrix{
	public static void main(String[] args){
		char[][]a = {{'A', 'P', 'W', 'X', 'F'},
			    {'S', 'T', 'B', 'C', 'E'},
			    {'Y', 'Z', 'Q', 'K', 'J'},
			    {'D', 'G', 'H', 'I', 'L'},
			    {'M', 'N', 'O', 'S', 'U'}};

		System.out.println("Original Matrix:");
		printMatrix(a);

		rotateMatrix(a);
		System.out.println("After 90 degree rotation:");
		printMatrix(a);
	}

	//Time Complexity O(NxN) as we need to check every element
	public static void rotateMatrix(char[][] a){
		//rotate layer by layer
		for(int layer = 0; layer < (a.length/2); layer++){
			int start = layer;
			int end = (a.length - 1) - layer;

			for(int i = start; i < end; i++){
				//System.out.println("Start:" + start + " end: " + end + " i: " + i + " --------------");
				//printMatrix(a);
				int offset = i - start;
				char top = a[start][i];

				//top <- left
				a[start][i] = a[end-offset][start];

				//left <- bottom
				a[end-offset][start] = a[end][end-offset];

				//bottom <- right
				a[end][end-offset] = a[i][end];

				//right <- top
				a[i][end] = top;
			}
		}		
	}

	public static void printMatrix(char[][]a){
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a[0].length; j++){
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
