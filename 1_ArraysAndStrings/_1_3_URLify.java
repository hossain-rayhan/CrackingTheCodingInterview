//Cracking the Coding Interview
//Chapter 1: Arrays and Strings
//Problem-1.3: URLify
//Description: Write a method to replace all spaces in a URL string 
// with '%20'

import java.util.Arrays;

class URLify{
	public static void main(String[] args){
		String s = "Mr John Smith    ";
		System.out.println("Actual String: " + s);
		urlify(s.toCharArray(), 13);
	}

	public static void urlify(char[] s, int actualLength){
		int index = s.length - 1;
		for(int i = actualLength - 1; i >= 0; i--){
			if(s[i] != ' '){
				s[index--] = s[i];
			}else{
				s[index--] = '0';
				s[index--] = '2';
				s[index--] = '%';
			}
		}
		System.out.println("Url: " + new String(s));
	}

}
