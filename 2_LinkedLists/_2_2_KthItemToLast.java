//Cracking the Coding Interview
//Chapter 2: LinkedLists
//Problem-2.2: Return Kth to Last
//Description: Write an algorithm to find the kth to last element of singly linked list.
//To run this code- put LinkedListNode.java and LinkedListHelper.java in the same folder

import java.util.HashMap;

class KthItemToLast{
	//we can also make the counter static
	//public static int counter = 0;
	public static void main(String[] args){
		LinkedListHelper helper = new LinkedListHelper();

		int[] arr = {40, 30, 5, 10, 50, 70, 20};
		LinkedListNode root = helper.createListFromArray(arr);
		helper.printLinkedList(root);	

		HashMap<String, Integer> map = new HashMap<>();
		map.put("index", 0);
		//LinkedListNode kthToLast = kthToLastRecursive(root, 5, map);
		LinkedListNode kthToLast = kthToLastIterative(root, 5);

		System.out.println(kthToLast.val);
	}

	//recursive; maintain a static counter
	public static LinkedListNode kthToLastRecursive(LinkedListNode root, int k, HashMap<String, Integer> counterMap){
		if(root == null)
			return null;

		LinkedListNode node = kthToLastRecursive(root.next, k, counterMap);
		//counter++;
		counterMap.put("index", counterMap.get("index") + 1);
		if(counterMap.get("index") == k){
			return root;
		}
			
		return node;
	}

	//Iterative- Two pointer- walker and runner
	public static LinkedListNode kthToLastIterative(LinkedListNode root, int k){
		LinkedListNode p1 = root, p2 = root;

		//move the first pointer k steps
		for(int i = 0; i < k; i++){
			if(p1 == null){
				//out of bounds
				return null;
			}
			p1 = p1.next;
		}

		while(p1 != null){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}
}
