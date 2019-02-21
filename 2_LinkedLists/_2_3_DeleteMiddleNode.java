//Cracking the Coding Interview
//Chapter 2: LinkedLists
//Problem-2.3: Delete Middle Node
//Description: Delete a given node from a linked list which is not the first or last node
//You are not given access to the head node of the linked list
//To run this code- put LinkedListNode.java and LinkedListHelper.java in the same folder

class DeleteMiddleNode{
	public static void main(String[] args){
		LinkedListHelper helper = new LinkedListHelper();

		int[] arr = {40, 30, 5, 10, 50, 70, 20};
		LinkedListNode root = helper.createListFromArray(arr);
		helper.printLinkedList(root);

		//we will delete the 2nd node which is 20
		LinkedListNode nodeToDelete = root.next;
		deleteMiddle(nodeToDelete);
		
		System.out.println("After deleting the 2nd node:");
		helper.printLinkedList(root);
	}
	
	public static void deleteMiddle(LinkedListNode node){
		if(node == null || node.next == null){
			//not a middle node
			return;
		}
	
		LinkedListNode next = node.next;
		node.val = next.val;
		node.next = next.next;
	}
}
