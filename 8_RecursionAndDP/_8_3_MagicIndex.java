//Cracking the Coding Interview
//Chapter 8: Recursion and Dynamic Programming
//Problem-8.3: Magic Index
//Description: In a given sorted array with distinct values, find the magic index 
//where arr[i] = i; the index and the value is same.
//Follow up: What if the values are not distinct

import java.util.Arrays;

class MagicIndex{
	public static void main(String[] args){
		int[] arr = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};//all distinct
		int[] arr2 = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 12};

		System.out.println(Arrays.toString(arr2));
		int index = magicIndexFollowUp(arr2, 0, arr2.length - 1);
		System.out.println("Magic Index: " + index);
	}

	//use the concept of binary search- all distinct values
	public static int magicIndex(int[] arr, int start, int end){
		if(end < start){
			return -1;
		}
		int mid = (start + end)/2;
		if(arr[mid] == mid){
			return mid;
		}else if(arr[mid] > mid){
			return magicIndex(arr, start, mid - 1);
		}else{
			return magicIndex(arr, mid + 1, end);
		}
	}

	//values are not distinct
	public static int magicIndexFollowUp(int[] arr, int start, int end){
		if(end < start){
			return -1;
		}

		int midIndex = (start + end)/2;
		int midValue = arr[midIndex];

		if(midIndex == midValue){
			return midIndex;
		}

		//search left
		int leftIndex = Math.min(midIndex-1, midValue);
		int left = magicIndexFollowUp(arr, start, leftIndex);
		if(left >= 0){
			return left;
		}

		//search right
		int rightIndex = Math.max(midIndex+1, midValue);
		int right = magicIndexFollowUp(arr, rightIndex, end);
		
		return right;
	
	}
}


