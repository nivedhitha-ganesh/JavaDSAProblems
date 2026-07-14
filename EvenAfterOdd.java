package LinkedList;

import java.util.Scanner;

//You have been given a singly linked list of integers along with an integer 'N'. Write a function to append the last 'N' nodes towards the front of the singly linked list and 
//returns the new head to the list. So the input will be the number of nodes that needs to be appended to the beginning - suppose 3 is input then last 3 nodes are taken and joined to the very beginning of list
public class AppendLastNNodes {
	public static Node<Integer> createLinkedList() {
		Node<Integer> node1=new Node<>(10);
		Node<Integer> node2=new Node<>(6);
		Node<Integer> node3=new Node<>(77);
		Node<Integer> node4=new Node<>(90);
		Node<Integer> node5=new Node<>(61);
		Node<Integer> node6=new Node<>(67);
		Node<Integer> node7=new Node<>(100);
		
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
	public static Node<Integer> appendNNode(Node<Integer> head, int num){
		Node<Integer> temp=head;
		Node<Integer> prev=null;
		Node<Integer> curr=null;
		int index=1; //because suppose num is 3 from 3rd node onward we dettach and attach to beginning so here it is not index starting from 0 based
		if(num==index)
		{
			return head;
		}
		while(temp.next!=null)
		{
			if(index==num-1)
			{
				prev=temp;
				curr=prev.next;
			}
			temp=temp.next;
			index++;
		}
		System.out.println("Previous node: "+prev.data);
		System.out.println("Last node of list: "+temp.data);
		System.out.println("Current node from which link is dettached: "+curr.data);
		prev.next=temp.next;
		temp.next=head;
		head=curr;
		return head;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Node<Integer> head=createLinkedList();
		System.out.println("Initial List: ");
		printAll(head);
		System.out.println("Enter the number of nodes to be appended: ");
		int num=sc.nextInt(); //this indicates the number of nodes that needs to be taken from end of list and placed in beginning
		Node<Integer> newHead=appendNNode(head, num);
		System.out.println("After appending last "+num+" noes to beginning of list");
		printAll(newHead);
		sc.close();
	}
}
//Input: 10 6 77 90 61 67 100 -1
//Output: 90 61 67 100 10 6 77 