//Cracking the Coding Interview
//Chapter 1: Arrays and Strings
//Problem-1.2: Check Permutation
//Description: Given two strings, write a method to decide if one is a permutation
//of the other


class CheckPermutation{
	public static void main(String[] args){
		String s1 = "abcd";
		String s2 = "ddab";
		System.out.println("Is permutation?: " + permutation(s1, s2));
	}

	public static boolean permutation(String s1, String s2){
		//to be a permutation the lengths need to be equal
		if(s1.length() != s2.length()){
			return false;
		}

		//We are considering 128 ASCII characters
		int[] counterS1 = new int[128];

		for(int i = 0; i < s1.length(); i++){
			counterS1[s1.charAt(i)]++;
		}

		for(int i = 0; i < s2.length(); i++){
			counterS1[s2.charAt(i)]--;
			if(counterS1[s2.charAt(i)] < 0){
				return false;
			}
		}
		return true;
	}

}
