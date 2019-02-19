//Cracking the Coding Interview
//Chapter 1: Arrays and Strings
//Problem-1.1: Is Unique
//Description: Implement an algorithm to determine if a string 
//has all unique characters. What if you cannot use additional 
// data structure?

import java.util.HashSet;

class IsUnique{
	public static void main(String[] args){
		String s = "abc/2";
		String s2 = "abajsd";
		System.out.println("All unique chars? " + s + " - " + isUnique_3(s));
		System.out.println("All unique chars? " + s2 + " - " + isUnique_3(s2));
	}

	//Use a HashSet for characters
	//Time: O(N), Space: O(N)
	public static boolean isUnique_1(String s){
		HashSet<Character> set = new HashSet<>();

		for(int i = 0; i < s.length(); i++){
			if(set.contains(s.charAt(i))){
				return false;
			}else{
				set.add(s.charAt(i));
			}
		}
		return true;
	}

	//We have 128 uniqe characters 
	//Keep a counter
	//Time: O(N), Space: O(N)
	public static boolean isUnique_2(String s){

		//If the length of string is greater than 128
		//there must have some repeating characters
		if(s.length() > 128){
			return false;
		}
		int[] counter = new int[128];
		for(int i = 0; i < s.length(); i++){
			if(counter[s.charAt(i)] > 0){
				return false;
			}else{
				counter[s.charAt(i)]++;
			}
		}
		return true;
	}

	//If we do not want to use additional space
	//Time: O(N^2), Space: O(1)
	public static boolean isUnique_3(String s){
		for(int i = 0; i < s.length(); i++){
			for(int j = i + 1; j < s.length(); j++){
				if(s.charAt(i) == s.charAt(j)){
					return false;
				}
			}
		}
		return true;
	}
}
