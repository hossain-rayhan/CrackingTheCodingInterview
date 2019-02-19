//Cracking the Coding Interview
//Chapter 1: Arrays and Strings
//Problem-1.5: One Away
//Description: Given two strings write a function to check if they 
//are one edit (or zero) distance away

class OneAway{
	public static void main(String[] args){
		String s1 = "accd";
		String s2 = "bcdd";
		System.out.println(s1 + " and " + s2 + ": " + isEditDistanceOne(s1, s2));
	}

	public static boolean isEditDistanceOne(String s1, String s2){
		int l1 = s1.length();
		int l2 = s2.length();

		if(l1 == l2){
			return isOneReplaceDistance(s1, s2);
		}else if(l1 + 1 == l2){
			return isOneInsertDistance(s1, s2);
		}else if(l2 + 1 == l1){
			return isOneInsertDistance(s2, s1);
		}

		//if none of the above scenarios is correct
		return false;
	}
	
	public static boolean isOneReplaceDistance(String s1, String s2){
		boolean mismatchFound = false;
		//if more than one mismatch, return false
		for(int i = 0; i < s1.length(); i++){
			if(s1.charAt(i) != s2.charAt(i)){
				if(mismatchFound){
					return false;
				}
				mismatchFound = true;
			}
		}
		return true;
	}

	public static boolean isOneInsertDistance(String s1, String s2){
		int index1 = 0, index2 = 0;

		while(index1 < s1.length() && index2 < s2.length()){
			if(s1.charAt(index1) == s2.charAt(index2)){
				index1++;
				index2++;
			}else{
				if(index1 != index2){
					return false;
				}
				index2++;
			}
		}
		return true;
	}

}
