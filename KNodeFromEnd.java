package LinkedList;
import java.util.*;


public class FindNode {
	
	public static Node<Integer> createLinkedList() {
		Node<Integer> node1=new Node<>(2);
		Node<Integer> node2=new Node<>(4);
		Node<Integer> node3=new Node<>(6);
		Node<Integer> node4=new Node<>(8);
		Node<Integer> node5=new Node<>(15);
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		
		return node1;
		
	}
	//You have been given a singly linked list of integers. Write a function that returns the index/position of integer data denoted by 'N' (if it exists). Return -1 otherwise.
	public static int findNode(Node<Integer> head, int n)
	{
		Node<Integer> temp=head;
		int index=0;
		while(temp!=null)
		{
			if(temp.data==n)
			{
				return index;
			}
			temp=temp.next;
			index++;
		}
		return -1;
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
	public static void main(String[] args)
	{
		Node<Integer> head=createLinkedList();
		printAll(head);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value of node to be found:");
		int value=sc.nextInt();
		int position=findNode(head, value); //position is the variable that is the position of the node found at given index
		System.out.println("Value/Node is found at position "+position);
		sc.close();
	}
}
