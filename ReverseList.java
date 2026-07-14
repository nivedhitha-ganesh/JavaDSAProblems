package LinkedList;

import java.util.Scanner;

public class RemoveDuplicates {
	public static Node<Integer> createLinkedList() {
		Node<Integer> node1=new Node<>(1);
		Node<Integer> node2=new Node<>(2);
		Node<Integer> node3=new Node<>(3);
		Node<Integer> node4=new Node<>(3);
//		Node<Integer> node5=new Node<>(3);
//		Node<Integer> node6=new Node<>(3);
//		Node<Integer> node7=new Node<>(4);
//		Node<Integer> node8=new Node<>(4);
//		Node<Integer> node9=new Node<>(4);
//		Node<Integer> node10=new Node<>(5);
//		Node<Integer> node11=new Node<>(5);
//		Node<Integer> node12=new Node<>(6);
//		Node<Integer> node13=new Node<>(7);
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
//		node4.next=node5;
//		
//		node5.next=node6;
//		node6.next=node7;
//		node7.next=node8;
//		node8.next=node9;
//		
//		node9.next=node10;
//		node10.next=node11;
//		node11.next=node12;
//		node12.next=node13;
//		
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
	public static Node<Integer> removeduplicates(Node<Integer> head){
		Node<Integer> curr=head;
//		System.out.println(temp.next.data);
		while(curr.next!=null) {
			if(curr.data==curr.next.data)
			{
				curr.next=curr.next.next;
			}
			else {
				curr=curr.next;
			}
		}
		return head;
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Node<Integer> head=createLinkedList();
		System.out.println("Initial list");
		printAll(head);
		Node<Integer> newHead=removeduplicates(head);
		System.out.println("After removing duplicates");
		printAll(newHead);
		sc.close();
	}
}

//Input 1 2 3 3 3 3 4 4 4 5 5 7 
