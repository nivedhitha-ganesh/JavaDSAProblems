package LinkedList;

import java.util.Scanner;

public class LinkedListUse {
	
	public static Node<Integer> createLinkedList() {
		Node<Integer> node1=new Node<>(2);
		Node<Integer> node2=new Node<>(4);
		Node<Integer> node3=new Node<>(6);
		Node<Integer> node4=new Node<>(8);
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		
		return node1;
		
	}
	//Attaches given node to end of list - head is given as param because we need the start of the list to iterate through till the last node which we require to attach node to end
	public static void appendAtLast(int value, Node<Integer> head)
	{
		Node<Integer> newNode = new Node<>(value); //new node with value and address needs to be created first
		System.out.println("Node to be added: "+newNode.data+" "+newNode.next);
		Node<Integer> temp=head;
		while(temp.next!=null) //temp!=null will point to the temp with null value which means the after the while loop runs completely the temp variable will have value of null - which we dont want
		//so we need the temp to point to LAST NODE containing a value so that to this we can attach the newNode to be appended 
		{
			temp=temp.next;
		}
		//System.out.println("Last node: "+temp.data); //the last node's value is being logged and checked
		temp.next=newNode; //already when newNode to be appended at end is created it by default its next value points to null once the newNode object is created
		//so only the temp's next value that is the last node must be pointing to newNode
	}
	
	public static Node<Integer> append(int value, Node<Integer> head, int pos){
		Node<Integer> newNode = new Node<>(value);
		Node<Integer> temp=head;
		Node<Integer> prev=head;
		int index=0; //to iterate through the linked list and keep track of position where node needs to be inserted
		if(pos==0)
		{
			newNode.next=temp; //first connection is made from newNode to first node - temp contains the head value and if position is 0 first it comes to this if block only so temp value will be the head value
			head=newNode; //then the head points to new Node to break earlier connection
		}
		else {
			while(index<pos-1) //iteration till pos-1 and then '<' symbol because we need temp value not temp.next value that is being declared in next line
			{
				temp=temp.next; //temp is the current node being iterated to
				index++;
			}
			if(temp==null) //if node position is pointing to last node - then node needs to be appended at end
			{
				appendAtLast(value, head);
				return head;
			}
			System.out.println("Node at pos-1 index:" +temp.data);
			prev=temp; //prev stores value at pos-1 i.e the node after which the given node needs to be attached
			newNode.next=temp.next;
			prev.next=newNode;
		}
		
		return head;
	}
	public static void printAll(Node<Integer> head) {
		Node<Integer> temp=head;
		while(temp!=null)
		{
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.println(temp);
	}
	//Print Ith node
	public static void printNodeAtPosition(int pos, int len, Node<Integer> head) {
		Node<Integer> temp=head;
		int index=0;
		while(index!=pos && index<len) {
			temp=temp.next;
			index++;
		}
		System.out.println("Node at position "+pos+" is "+temp.data);
	}
	public static int findLength(Node<Integer> head) {
		Node<Integer> temp=head;
		int len=0;
		if(head==null)
			return 0;
		else {
			while(temp!=null)
			{
				temp=temp.next;
				len++;
			}
//			System.out.println(len);
		}
		return len;
	}
	
	public static Node<Integer> deleteNode(Node<Integer> head, int pos)
	{
		Node<Integer> temp=head;
		Node<Integer> prev=head;
		int index=0;
		if(pos==0 && head!=null)
		{
			head=temp.next;
			return head;
		}else {
			while(index<pos-1) //iterate till position-1 - node before position to be deleted
			{
				temp=temp.next;
				index++;
			}
			//System.out.println(index+" "+temp.data);
			if(temp.next!=null) { //to handle deletion of last node as well
				prev=temp;
				prev.next=temp.next.next; //to reach out to next node - leave one node and then the next node it can directly connect to lose connection with middle node
				
			}
		}
		
		return head;
	}	
	
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		Node<Integer> head=createLinkedList();
		System.out.print("Initial List: ");
		printAll(head);
		appendAtLast(7,head);
		System.out.println("Node after appending at end: ");
		printAll(head);
		System.out.println("Enter the position at which you want to append the node - ");
		int pos=sc.nextInt();
		Node<Integer> newHead=append(15,head,pos); //this fn attaches given node to any position in the linked list
		System.out.println("List after Node appended at position "+pos);
		printAll(newHead);
		System.out.println("Length of list is: ");
		System.out.println(findLength(newHead));
		appendAtLast(16,newHead);
		System.out.println("Node after appending at end: ");
		printAll(newHead);
		int len=findLength(newHead);
		System.out.println("Enter the ith node you want to print: ");
		pos=sc.nextInt();
		printNodeAtPosition(pos,len,newHead); //prints node at position i and if position that is i is greater than the length of list then dont print anything
		printAll(newHead);
		System.out.println("Enter position of node you want to delete ");
		pos=sc.nextInt();
		Node<Integer> newList=deleteNode(newHead, pos);
		System.out.println("List after deletion of node");
		printAll(newList);
		
		sc.close();
//		Node newNode=new Node(2);
//		System.out.println(newNode); //newNode is an object reference storing address
//		// output: LinkedList.Node@1d251891 --> linkedlist is the package name and node is the class name out of which the node object is created. 'node' is the object of 'Node' class
//		System.out.print(newNode.data+"->");
//		System.out.println(newNode.next);
	}

}

//Linked lists are used in situations where the size is altered dynamically. Best suited data structure to provide dynamic memory allocation because 
//linked lists make insertion and deletion of nodes easier because elements can be added to any position without having to resize the entire structure or move it since this is not index based and the nodes are placed at random locations in memory (not contiguous)
//Also linked lists are not contiguous in memory they are created and stored randomly wherein they are linked with each other by storing the address of the next node
//Arraylists use arrays only deep down so contiguous blocks of memory need to be allocated whereas for linked list only the address of the head(start of the linked list - node) needs to be known to store the entire list

//Every node in linked list will store the address of the next node using the next variable declared in this code
//This is how they are connected with each other in a chain like manner
//By default when a reference of a class is created (object) its default value will be assigned as null
//The data type is given as generic so that if a list of suppose string values need to be made then it can easily be modified
//Also the type of next will be the same as the node created at first so that the connections can be made

//Node n1; this is different from Node n1=new Node();
//n1 carries the reference to the node that is it stores the address only
//new keyword is where the actual node is created that is an object of the class is created and assigned values using constructor
//So Node n1; --> means reference/address of the node 
//So using this concept the connection is made from node1 to node2. 
//The next of node2 should point to address of node1 for the connection to be made and this is done by node1.next=node2;
//because the n2 contains address reference only of node2 making it easy to point to the node2


//One thumb rule for Linked Lists is : MAKE BEFORE YOU BREAK 
//When suppose appending a value make sure that a connection is made first and then a connection is broken so that it is not lost and the chain is made properly especially when a node needs to be added in between two nodes
//then first the node to be attached must be attached to node3 suppose and then the node1 can be attached to node2 (node to be added) so that the connection between node1 and node3 is not lost at the very beginning