package LinkedList;

//check to whether the list given is a 'Palindrome' or not.
public class PallindromList {
	public static Node<Integer> createLinkedList() {
		Node<Integer> node1=new Node<>(10);
		Node<Integer> node2=new Node<>(6);
		Node<Integer> node3=new Node<>(77);
		Node<Integer> node4=new Node<>(90);
		Node<Integer> node5=new Node<>(77);
		Node<Integer> node6=new Node<>(6);
		Node<Integer> node7=new Node<>(10);
		
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
	//for finding the mid value this function is used to first find the length of list
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
	public static boolean pallindromeList(Node<Integer> head)
	{
		
		if(head==null)
			return true;
		//Finding the mid value and then reverse list after that mid value and then compare values of both lists with different points to prove that either it is a pallindrome or not
		int length = findLength(head); //finding length of the list
		int mid = (length%2==0) ? length/2 : (length/2) + 1;
		//System.out.println(mid);
		Node<Integer> current=head;
		for(int i=1;i<mid;i++)
		{
			current=current.next;
		}
		//System.out.println(current.data+" "+current.next.data);
		//here current.next is passed because we want elements AFTER the mid element to be reversed (if u notice mid element is always unique which need not be compared) the elements after mid element is reversed and compared with first half till mid
		Node<Integer> revHead=reverseList(current.next); //this contains the reversed list from the element after the mid element and then if the elements of this list and the first half are same/equal then it is a pallindrome
		System.out.println("Reversed List");
		printAll(revHead);
		while(head!=null && revHead!=null) //here the condition is that both must not be null so when EITHER ONE REACHES NULL THEN IT COMES OUT OF LOOP AND usually the code is such that revHead only becomes null always (because its till mid only) 
		//this means that all the elements of reversed list (second half) have been iterated to reach null so it doesnt satify condition that BOTH must not be null so returns true for pallindrome
		{
			if(head.data!=revHead.data)
				return false;
			head=head.next;
			revHead=revHead.next;
		}
		return true;
		
		//1->2->3->2->1  mid=3 curr.next=2 head= 1 revHead= 1
		//
	}
	public static Node<Integer> reverseList(Node<Integer> head)
	{
		//we take three pointers that point to the current node in iteration, the previous node to current and the next node to current
		//The reason being that so reversing a list we need to reverse the connections in the list. And this is donw in an iterative manner - so at the end the last node will be prev -- the pointer pointing to the last node will be prev 
		//so that is the new head that needs to be returned
		Node<Integer> prevNode=null;
		Node<Integer> nextNode=null;
		Node<Integer> curr=head;
		while(curr!=null)
		{
			//we know that 3 pointers set so first the nextnode value is pointing to null which must be set to the actual nextNode value which will be curr.next value
			//to reverse the current/first node's connection we take curr.next and point to prev. Then prevNode must first store the value of curr and then the curr is moved to next node to repeat same process for the next node
			//curr=nextNode will loose the connection/curr will loose its value so first it gets stored in prev and then changed to next node
			//we shift all the three by one each time reversing connections
			nextNode=curr.next;
			curr.next=prevNode;
			prevNode=curr;
			curr=nextNode;
			//1->2->3->4->null
		}
		return prevNode;
	}
	 public static void main(String[] args) {
		Node<Integer> head=createLinkedList();
		System.out.println("Initial list");
		printAll(head);
		boolean flag=pallindromeList(head);
//		Node<Integer> revHead=reverseList(head);
//		printAll(revHead);
//		boolean flag=pallindromeList(head,revHead);
		if(flag)
			System.out.println("List is a pallindrome list");
		else
			System.out.println("List is NOT a pallindrome");
		//System.out.println(tail.data);
	}

}
//Input 1 : 0 2 3 2 5
//Output 1: not pallindrome

//Input 2: 10->6->77->90->77->6->10
//Output 2: Pallindrome
