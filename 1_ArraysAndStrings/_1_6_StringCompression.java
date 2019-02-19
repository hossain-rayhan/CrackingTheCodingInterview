//Cracking the Coding Interview
//Chapter 1: Arrays and Strings
//Problem-1.6: String Compression
//Description: Compress a string using count of repeated characters
//aabbbbbbaa should be: a2b6a2

class StringCompression{
	public static void main(String[] args){
		String s = "aabbbbbbkk";
		System.out.println("Original: " + s + " , Compressed: " + compress(s));
	}

	public static String compress(String s){
		StringBuilder sb = new StringBuilder();
		int consecutiveCounter = 0;

		for(int i = 0; i < s.length(); i++){
			consecutiveCounter++;

			//check if the next char does not match
			if(i+1 >= s.length() || s.charAt(i+1) != s.charAt(i)){
				sb.append(s.charAt(i));
				sb.append(consecutiveCounter);
				consecutiveCounter = 0;
			}
		}
		return sb.length() < s.length()? sb.toString() : s;
	}
}
