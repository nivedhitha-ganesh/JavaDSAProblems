package LinkedList;

//when there is a list then the kth node from the end needs to be returned and this is done by the two pointer method because we dont want to traverse the entire list and make it o(n) complexity 
//fast and slow pointer method is used in order to do this
public class KNodeFromEnd {
	public static Node<Integer> createLinkedList() {
		Node<Integer> node1=new Node<>(1);
		Node<Integer> node2=new Node<>(11);
		Node<Integer> node3=new Node<>(3);
		Node<Integer> node4=new Node<>(6);
		Node<Integer> node5=new Node<>(8);
		Node<Integer> node6=new Node<>(0);
		Node<Integer> node7=new Node<>(9);
		
		//I/p 1 11 3 6 8 0 9
		//o/p 1 11 3 9 6 8 0
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		node6.next=node7;
		
		return node1;
		
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
	public static Node<Integer> KthNodeFromEnd(Node<Integer> head, int k)
	{
		if(k<=0)
			return null;
		Node<Integer> fast=head;
		Node<Integer> slow=head;
		
		for(int i=0;i<k;i++)
		{
			
		}
		return null;
	}
	public static void main(String[] args) {
		Node<Integer> head=createLinkedList();
		System.out.println("Initial List");
		printAll(head);
		Node<Integer> node=KthNodeFromEnd(head,4);
		if(node==null)
			System.out.println("Could not find node in list");
		else
			System.out.println(node.data);
	}

}
