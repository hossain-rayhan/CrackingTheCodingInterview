//Cracking the Coding Interview
//Chapter 8: Recursion and Dynamic Programming
//Problem-8.9: Parens
//Description: Implement an algorithm to print all valid combinations of n
//pairs of parentheses

import java.util.ArrayList;

class Paren{
	public static void main(String[] args){
		int n = 2;
		System.out.println("Generate parentheses pairs for n = " + n);
		ArrayList<String> parens = generateParens(n);
		for(String s : parens){
			System.out.println(s);
		}	
	}

	public static ArrayList<String> generateParens(int count){
		char[] str = new char[count*2];
		ArrayList<String> list = new ArrayList<>();
		addParen(list, count, count, str, 0);

		return list;
	}

	public static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index){
		if(leftRem < 0 || rightRem < leftRem){
			return; //invalid state
		}
		if(leftRem == 0 && rightRem == 0){
			list.add(String.copyValueOf(str)); // out of left and right parentheses
		}else{
			str[index] = '('; //add left and recurse
			addParen(list, leftRem-1, rightRem, str, index + 1);

			str[index] = ')'; //add right and recurse
			addParen(list, leftRem, rightRem-1, str, index + 1);
		}
	}

}


