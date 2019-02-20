import java.util.Arrays;

class LinkedListHelper{
	public static void main(String[] args){
		LinkedListHelper helper = new LinkedListHelper();
		int[] arr = {11, 32, 24, 35, 21, 55};
		LinkedListNode root = helper.createListFromArray(arr);

		helper.printLinkedList(root);
	}

	public LinkedListNode createListFromArray(int[] arr){
		System.out.println("The array to create list:");
		System.out.println(Arrays.toString(arr));

		if(arr.length <= 0)
			return null;
		LinkedListNode root = new LinkedListNode(arr[0]);
		LinkedListNode current = root;

		for(int i = 1; i < arr.length; i++){
			LinkedListNode newNode = new LinkedListNode(arr[i]);
			current.next = newNode;
			current = current.next;
		}
		return root;
	}

	public void printLinkedList(LinkedListNode root){
		System.out.println("Printing the Linked list:");
		while(root != null){
			System.out.print(root.val + " -> ");
			root = root.next;
		}
		System.out.println("null");
	}
}

