package LinkedList;

public class EvenAfterOdd {
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
	public static Node<Integer> evenAfterOdd(Node<Integer> head)
	{
		Node<Integer> temp=head;
		Node<Integer> oddH=null;
		Node<Integer> oddT=null;
		Node<Integer> evenH=null;
		Node<Integer> evenT=null;
		while(temp!=null)
		{
			if(temp.data%2!=0)
			{
				if(oddH==null) //odd list is empty and we must attach first odd node to list
				{
					oddH=temp;
					oddT=temp; //tail also points to same element as there only 1 element for now
				}
				else {
					oddT.next=temp;
					oddT=temp;
				}
			}else { //when element is even
				if(evenH==null) //even list is empty and we must attach first even node to list
				{
					evenH=temp;
					evenT=temp; 
				}
				else {
					evenT.next=temp; //here the next even node is found and the tail address needs to point to the current even element (temp)
					evenT=temp; //also new tail must be updated as now after attaching this node becomes new tail - only at end of list we can attach so eahc time this needs to be updated
				}
				
			}
			
			
			temp=temp.next;
		}
		evenT.next=null;
		oddT.next=null;
		System.out.println("Odd elements: ");
		printAll(oddH);
		System.out.println("Even elements: ");
		printAll(evenH);
		oddT.next=evenH;
		return oddH;
	}
	public static void main(String[] args) {
		Node<Integer> head=createLinkedList();
		System.out.println("Initial List");
		printAll(head);
		Node<Integer> oddStart=evenAfterOdd(head);
		System.out.println("List after placing all even elements after odd elements: ");
		printAll(oddStart);
	}
}
