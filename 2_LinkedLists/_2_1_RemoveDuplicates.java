//Cracking the Coding Interview
//Chapter 2: LinkedLists
//Problem-2.1: Remove Dus
//Description: Write a code to remove duplicates from an unsorted linked list.
//To run this code- put LinkedListNode.java and LinkedListHelper.java in the same folder

import java.util.HashSet;

class RemoveDuplicates{
	public static void main(String[] args){
		LinkedListHelper helper = new LinkedListHelper();

		int[] arr = {12, 10, 2, 12, 5, 7, 2};
		LinkedListNode root = helper.createListFromArray(arr);
		helper.printLinkedList(root);	

		LinkedListNode r = removeDuplicate_2(root);
		helper.printLinkedList(r);
	}

	//method-1: using some buffer- HashSet
	//Time O(N), Space O(N)
	public static LinkedListNode removeDuplicate_1(LinkedListNode root){
		LinkedListNode runner = root, previous = null;
		HashSet<Integer> set = new HashSet<Integer>();

		while(runner != null){
			if(set.contains(runner.val)){
				previous.next = runner.next;
			}else{
				set.add(runner.val);
				previous = runner;
			}
			runner = runner.next;
		}
		return root;
	}

	//method-2: using no buffer
	//Time O(N^2), Space O(1)
	public static LinkedListNode removeDuplicate_2(LinkedListNode root){
		LinkedListNode current = root;
		while(current != null){
			LinkedListNode runner = current;
			while(runner.next != null){
				if(runner.next.val == current.val){
					runner.next = runner.next.next;
				}else{
					runner = runner.next;
				}
			}
			current = current.next;
		}
		return root;
	}
}
