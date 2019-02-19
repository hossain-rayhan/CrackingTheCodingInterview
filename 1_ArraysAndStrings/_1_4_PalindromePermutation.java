//Cracking the Coding Interview
//Chapter 1: Arrays and Strings
//Problem-1.4: Palindrome Permutation
//Description: Given a string write a function to check if it is 
//a permutation of a palindrome


//For simplicity, the string consists of only lowercase alphabets

class PalindromePermutation{
	public static void main(String[] args){
		String s = "accdd";
		System.out.println(s + ": " + isPalindromePermutation(s));
	}

	public static boolean isPalindromePermutation(String s){
		int[] counter = new int[26];
		for(int i = 0; i < s.length(); i++){
			counter[s.charAt(i) - 'a']++;
		}
		int oddCounter = 0;

		for(int i = 0; i < 26; i++){
			if(counter[i] % 2 == 1){
				oddCounter++;
				if(oddCounter > 1){
					return false;
				}
			}
		}
		return true;
	}

}
