package LinkedList;

public class FindMidNode {
	public static Node<Integer> createLinkedList() {
		Node<Integer> node1=new Node<>(1);
		Node<Integer> node2=new Node<>(2);
		Node<Integer> node3=new Node<>(3);
		Node<Integer> node4=new Node<>(4);
		Node<Integer> node5=new Node<>(5);
		Node<Integer> node6=new Node<>(6);
		//Node<Integer> node7=new Node<>(7);
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		//node6.next=node7;
		
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
	public static Node<Integer> findMidNode(Node<Integer> head){
		Node<Integer> slow=head;
		Node<Integer> fast=head;
		//1->2->3->4->5->6->7
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		//System.out.println(slow.data);
		return slow;
	}
	public static void main(String[] args) {
		Node<Integer> head=createLinkedList();
		System.out.println("Initial list");
		printAll(head);
		Node<Integer> mid=findMidNode(head);//the catch is that length of list is not known and since its not given we use slow and fast pointers to find mid node
		System.out.print("Middle node: ");
		System.out.print(mid.data);
	}

}
