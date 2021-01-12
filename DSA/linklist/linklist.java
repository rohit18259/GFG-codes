import java.util.*;

class Node{ // Node of a link list
	int data;
	Node next;
	Node (){
		this.next = null;
	}
	Node(int data){
		this.data = data;
		this.next = null;
	}
}

public class linklist{ // linklist class
	Node head;
	Node tail;
	public void append(int data){ // to append data to end of linklist
		if (head==null){
			Node node = new Node(data);
			this.head = node;
			this.tail = node;
		}
		else{
			Node node = new Node(data);
			this.tail.next = node;
			this.tail = node;
		}
	}
	
	public void append(Node node){ // to append node to end of linklist
		if (head==null){
			this.head = node;
			this.tail = node;
		}
		else{
			this.tail.next = node;
			this.tail = node;
		}
	}

	public void delete(int index){ // to delete the node at position index
		Node cur = head;
		if (index==0){
			this.head = this.head.next;
			if (this.head==null){
				this.tail=null;
			}
		}
		else if (head.next!=null){
			for (int i=0;i<index-1;i++){
				cur = cur.next;
			}
			cur.next = cur.next.next;
			if (cur.next==null){
				this.tail = cur;
			}
		}
	}
	public int getSize(){ // get length of linklist
		Node cur = this.head;
		int length = 0;
		while (cur!=null){
			cur = cur.next;
			length++;
		}
		return length;
	}

	public int getNth(int n){ // get Nth element of linklist from front
		Node cur = this.head;
		int i = 0;
		while (i<n){
			cur = cur.next;
			i++;
		}
		return cur.data;
	}
	public int getNthEnd(int n){ // get Nth element of linklist from end
		Node cur = this.head;
		Node end = cur;
		int count = 0;
		while (count<n){
			end = end.next;
			count++;
		}
		while (end.next!=null){
			end = end.next;
			cur = cur.next;
		}
		return cur.data;
	}
	public int getMiddle(){ // get middle element of linklist
		Node slow = this.head;
		Node fast = this.head;
		while (fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.data;
	}

	public int getCount(int value){ // get the number of times value appears in linklist
		int count = 0;
		Node cur = this.head;
		while (cur!=null){
			if (cur.data==value){
				count++;
			}
			cur = cur.next;
		}
		return count;
	}

	public int getLengthLoop(){ // get the length of the loop in linklist
		if (detectLoop()==false){
			return 0;
		}
		Node slow = this.head;
		Node fast = this.head;
		int count = 0;
		while (true){
			slow = slow.next;
			fast = fast.next.next;
			count++;
			if (count>0 && slow==fast){
				break;
			}
		}
		count = 0;
		while (true){
			slow = slow.next;
			fast = fast.next.next;
			count++;
			if (slow==fast){
				break;
			}
		}
		return count;
	}

	public boolean detectLoop(){ // detect if there is a loop in linklist
		Node slow = this.head;
		Node fast = this.head;
		int count = 0;
		while (fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
			count++;
			if (count>0 && slow==fast){
				return true;
			}
		}
		return false;
	}

	public void removeduplicate(){ // works for sorted linklist // removes duplicate elements in linklist
		Node cur = this.head;
		while (cur!=null){
			if (cur.next==null){
				cur = cur.next;
			}
			else if (cur.next.next==null){
				if (cur.data == cur.next.data){
					cur.next = cur.next.next;
					this.tail = cur;
				}
				else{
					cur = cur.next;
				}
			}
			else{
				if (cur.data == cur.next.data){
					cur.next = cur.next.next;
				}
				else{
					cur = cur.next;
				}
			}
		}
	}
	public void swap(int x,int y){ // swap nodes at xth and yth position in linklist
		if (x==y){
			return;
		}
		Node cur1 = this.head;
		Node cur2 = this.head;
		boolean flag1 = false;
		boolean flag2 = false;
		while (cur1!=null && cur2!=null){
			if (cur1.data==x){
				flag1 = true;
			}
			else{
				cur1 = cur1.next;
			}
			if (cur2.data==y){
				flag2 = true;
			}
			else{
				cur2 = cur2.next;
			}
			if (flag1==true && flag2==true){
				break;
			}
		}
		if (flag1==false || flag2==false){
			return;
		}
		else{
			int a = cur1.data;
			int b = cur2.data;
			cur1.data = b;
			cur2.data = a;
		}
	}

	public void pairSwipe(){ // pairwise swap all nodes of linklist
		Node cur1 = this.head;
		Node cur2 = cur1.next;
		while (cur1!=null && cur2!=null){
			int a = cur1.data;
			int b = cur2.data;
			cur1.data = b;
			cur2.data = a;
			cur1 = cur2.next;
			if (cur1==null){
				break;
			}
			else if (cur1.next==null){
				break;
			}
			else{
				cur2 = cur2.next.next;
			}
		}
	}

	public static linklist intersection(linklist l1,linklist l2){// find the common elements in two sorted linklist
		Node cur1 = l1.head;
		Node cur2 = l2.head;
		linklist l = new linklist();
		while (cur1!=null && cur2!=null){
			if (cur1.data==cur2.data){
				l.append(cur1.data);
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			else if (cur1.data<cur2.data){
				cur1 = cur1.next;
			}
			else{
				cur2 = cur2.next;
			}
		}
		return l;
	}

	public static Node getIntersection(linklist l1,linklist l2){ // get intersection node of two linklist
		Node cur1 = l1.head;
		Node cur2 = l2.head;
		int n1 = 0;
		int n2 = 0;
		while (cur1!=null){
			n1++;
			cur1 = cur1.next;
		}
		while (cur2!=null){
			n2++;
			cur2 = cur2.next;
		}
		int count = 0;
		cur1 = l1.head;
		cur2 = l2.head;
		if (n1<n2){
			while (count<n2-n1){
				cur2 = cur2.next;
				count++;
			}
		}
		else if (n2<n1){
			while (count<n1-n2){
				cur1 = cur1.next;
				count++;
			}
		}
		while (cur1!=cur2){
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}

	public linklist merge(linklist l1,linklist l2){ // works for sorted linklist // merge two sorted linklist
		linklist l = new linklist();
		Node cur1 = l1.head;
		Node cur2 = l2.head;
		while (cur1!=null && cur2!=null){
			if (cur1.data<=cur2.data){
				l.append(cur1.data);
				cur1 = cur1.next;
			}
			else{
				l.append(cur2.data);
				cur2 = cur2.next;
			}
		}
		if (cur1==null){
			if (cur2!=null){
				while (cur2!=null){
					l.append(cur2.data);
					cur2 = cur2.next;
				}
			}
		}
		else{
			while (cur1!=null){
				l.append(cur1.data);
				cur1 = cur1.next;
			}
		}
		return l;
	}

	public linklist mergeSort(linklist l,int n){ // mergesort a linklist
		if (n<=1){
			return l;
		}
		else{
			linklist l1 = new linklist();
			linklist l2 = new linklist();
			int mid = (n-1)/2;
			int count = 0;
			Node cur = l.head;
			while (count<mid){
				l1.append(cur.data);
				cur = cur.next;
				count++;
			}
			l1.append(cur.data);
			cur = cur.next;
			while (cur!=null){
				l2.append(cur.data);
				cur = cur.next;
			}
			linklist l3 = mergeSort(l1,mid+1);
			linklist l4 = mergeSort(l2,n-mid-1);
			return merge(l3,l4);
		}
	}

	public linklist sort(){ // calls mergesort on the linklist
		Node cur = this.head;
		int n = 0;
		while (cur!=null){
			n++;
			cur = cur.next;
		}
		return mergeSort(this,n);
	}

	public static linklist maxSum(linklist l1,linklist l2){ // works for the two sorted linklist // Construct a MaxSum linklist out of the two linklist with some common nodes
		Node cur1 = l1.head;
		Node cur2 = l2.head;
		int sum1 = 0; int sum2 = 0;
		int sum = 0;
		linklist l = new linklist();
		Node prev1 = l1.head;
		Node prev2 = l2.head;
		while (cur1!=null && cur2!=null){
			if (cur1.data>cur2.data){
				sum2 += cur2.data;
				cur2 = cur2.next;
			}
			else if (cur1.data<cur2.data){
				sum1 += cur1.data;
				cur1 = cur1.next;
			}
			else{
				sum1 += cur1.data;
				sum2 += cur2.data;
				if (sum1>sum2){
					sum += sum1;
					while (prev1!=cur1){
						l.append(prev1.data);
						prev1 = prev1.next;
					}
					l.append(prev1.data);
				}
				else{
					sum += sum2;
					while (prev2!=cur2){
						l.append(prev2.data);
						prev2 = prev2.next;
					}
					l.append(prev2.data);
				}

				prev1 = cur1.next;
				prev2 = cur2.next;
				cur1 = cur1.next;
				cur2 = cur2.next;
				sum1 = 0; sum2 = 0;
			}
		}
		if (cur1!=null){
			while (cur1!=null){
				l.append(cur1.data);
				sum1 += cur1.data;
				cur1 = cur1.next;
			}
		}
		else if (cur2!=null){
			while (cur2!=null){
				l.append(cur2.data);
				sum2 += cur2.data;
				cur2 = cur2.next;
			}
		}
		if (sum1>sum2){
			sum += sum1;
		}
		else{
			sum += sum2;
		}
		System.out.println(sum);
		return l;
	}

	public void print(){ // print the linklist in one line
		Node cur = head;
		while (cur!=null){
			System.out.print(cur.data+" ");
			cur = cur.next;
		}
		System.out.println();
	}


	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		linklist l = new linklist();
		int n = in.nextInt();
		for (int i=0;i<n;i++){
			l.append(in.nextInt());
		}
		l.print();
	}
}
