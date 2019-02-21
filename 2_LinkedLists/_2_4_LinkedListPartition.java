//Cracking the Coding Interview
//Chapter 2: LinkedLists
//Problem-2.4: Partition
//Description: Write code to partition a linked list around a value x, such that all 
//nodes less than x come before all nodes greater than or equal to x.
//To run this code- put LinkedListNode.java and LinkedListHelper.java in the same folder

class LinkedListPartition{
	public static void main(String[] args){
		LinkedListHelper helper = new LinkedListHelper();

		int[] arr = {40, 30, 5, 10, 50, 70, 20};
		LinkedListNode head = helper.createListFromArray(arr);
		helper.printLinkedList(head);
	
		LinkedListNode newHead = partition(head, 30);	
		System.out.println("After partition using 30");
		helper.printLinkedList(newHead);
	}
	
	public static LinkedListNode partition(LinkedListNode start, int value){
		LinkedListNode beforeStart = null, beforeEnd = null;
		LinkedListNode afterStart = null, afterEnd = null;

		while(start != null){
			LinkedListNode next = start.next;
			start.next = null;
			if(start.val < value){
				//insert start into end of before list
				if(beforeStart == null){
					beforeStart = start;
					beforeEnd = beforeStart;
				}else{
					beforeEnd.next = start;
					beforeEnd = start;
				}
			}else{
				//insert start into end of after list
				if(afterStart == null){
					afterStart = start;
					afterEnd = afterStart;
				}else{
					afterEnd.next = start;
					afterEnd = start;
				}
			}
			start = next;
		}

		if(beforeStart == null){
			return afterStart;
		}
		//merge before and after list
		beforeEnd.next = afterStart;
		return beforeStart;
	}	
}
