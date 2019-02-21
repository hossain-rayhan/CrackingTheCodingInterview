//Cracking the Coding Interview
//Chapter 2: LinkedLists
//Problem-2.8: Loop Detection
//Description: Given a circular linked list, implement an algorithm that returns the 
//node at the beginning of the loop
//To run this code- put LinkedListNode.java and LinkedListHelper.java in the same folder

class LoopDetection{
	public static void main(String[] args){
		LinkedListHelper helper = new LinkedListHelper();

		int[] arr = {40, 30, 5, 10, 50, 70, 20};
		LinkedListNode head = helper.createListFromArray(arr);
		helper.printLinkedList(head);

		//Make a loop at node 5
		LinkedListNode loopStartNode = head.next.next;
		LinkedListNode n = head;
		while(n.next != null){
			n = n.next;
		}		
		n.next = loopStartNode;

		//Find the loopStartNode using our implemented method
		LinkedListNode loopStart = detectLoop(head);
		System.out.println("Loop Start: " + loopStart.val);
	}

	public static LinkedListNode detectLoop(LinkedListNode head){
		LinkedListNode slow = head;
		LinkedListNode fast = head;

		//Find meeting point. This will be LOOP_SIZE - k steps into the linked list
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow){
				break; //Collision Detected
			}
		}

		if(fast == null || fast.next.next == null){
			return null; //Exception, no cycle 
		}

		//Move slow to the head. Keep fast at the meeting point.
		//Each are k steps from the loop start. If they meet at same pace, they must 
		//meet at loop start
		slow = head;
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}

		return slow; // or return the fast, both are same- loop start
	}
}
