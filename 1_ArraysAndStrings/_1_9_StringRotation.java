//Cracking the Coding Interview
//Chapter 1: Arrays and Strings
//Problem-1.9: String Rotation
//Description: Given two string s1 and s2, write code to check if s2 is a rotation 
// of s1 using only one call to isSubstring(). [casaba is rotation of abacas]

class StringRotation{
	public static void main(String[] args){
		String s1 = "abacds";
		String s2 = "casaba";
		System.out.println(s1 + " and " + s2 + ": " + isRotation(s1, s2));
	}

	public static boolean isRotation(String s1, String s2){
		if(s1 == null || s1.length() == 0)
			return false;
		if(s2 == null || s2.length() == 0)
			return false;
		if(s1.length() != s2.length())
			return false;

		//if s2 is a rotation of s1, s2 must be a substring of s1s1
		String s1s1 = s1 + s1;
		//checking if s2 is a substring of s1s1
		if(s1s1.contains(s2)){
			return true;
		}
		return false;
	}
}
