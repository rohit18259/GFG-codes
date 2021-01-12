import java.util.*;

class Node{ // Node of doubly-linklist
	int data;
	Node next;
	Node prev;
	Node(int data){
		this.data = data;
	}
	Node(){

	}
}

public class dlinklist{// doubly-linklist class
	Node head;
	Node tail;
	public void append(int data){ // append data to end of doubly-linklist in O(1) time
		if (this.head==null){
			Node node = new Node(data);
			this.head = node;
			this.tail = node;
		}
		else{
			Node node = new Node(data);
			this.tail.next = node;
			node.prev = this.tail;
			this.tail = node;	
		}
	}
	public void append(Node node){ // append node to end of doubly-linklist in O(1) time
		if (this.head==null){
			this.head = node;
			this.tail = node;
		}
		else{
			this.tail.next = node;
			node.prev = this.tail;
			this.tail = node;
		}
	}

	public void push(int data){ // push data to the beginning of doubly-linklist in O(1) time
		if (this.head==null){
			Node node = new Node(data);
			this.head = node;
			this.tail = node;
		}
		else{
			Node node = new Node(data);
			node.next = this.head;
			this.head.prev = node;
			this.head = node;
		}
	}

	public void push(Node node){ // push node to the beginning of doubly-linklist in O(1) time
		if (this.head==null){
			this.head = node;
			this.tail = node;
		}
		else{
			node.next = this.head;
			this.head.prev = node;
			this.head = node;
		}
	}

	public void deleteAt(int index){ // delete element at position index from the beginning in O(n) time
		if (index<0){
			System.out.println("Wrong indexing!");
			return;
		}
		Node cur = this.head;
		int count = 0;
		while (count<index){
			if (cur==null){
				System.out.println("Wrong indexing!");
				return;
			}
			cur = cur.next;
			count++;
		}
		if (cur==null){
			System.out.println("Wrong indexing!");
			return;
		}
		else if (cur.prev==null){
			this.head = cur.next;
			if (this.head==null){
				this.tail = null;
			}
			else{
				this.head.prev = null;
			}
		}
		else if (cur.next==null){
			this.tail = cur.prev;
			if (this.tail==null){
				this.head = null;
			}
			else{
				this.tail.next = null;
			}
		}
		else{
			Node prev = cur.prev;
			Node nex = cur.next;
			prev.next = nex;
			nex.prev = prev;
		}
	}

	public void findPairs(int x){// works for sorted doubly-linklist // find pairs with sum x in the sorted doubly-linklist in in O(n) time
		Node front = this.head;
		Node end = this.tail;
		while (front!=end){
			if (front.next==end){
				if (front.data+end.data==x){
					System.out.println("("+front.data+","+end.data+")");
				}
				break;
			}
			if (front.data+end.data==x){
				System.out.println("("+front.data+","+end.data+")");
				front = front.next;
				end = end.prev;
			}
			else if (front.data+end.data>x){
				end = end.prev;
			}
			else{
				front = front.next;
			}
		}
	}

	public void insertAt(int index,int data){ // insert data at position index from beginning of doubly-linklist in O(n) time
		if (index<0){
			System.out.println("Wrong indexing!");
			return;
		}
		int count = 0;
		Node cur = this.head;
		Node node = new Node(data);
		while (count<index){
			if (cur==null){
				System.out.println("Wrong indexing!");
				return;
			}
			cur = cur.next;
			count++;
		}
		if (cur==null){
			if (this.head==null){
				this.head = node;
				this.tail = node;
			}
			else{
				this.tail.next = node;
				node.prev = this.tail;
				this.tail = node;
			}
		}
		else if (cur.prev==null){
			cur.prev = node;
			node.next = cur;
			this.head = node;
		}
		else{
			Node prev = cur.prev;
			prev.next = node;
			node.prev = prev;
			node.next = cur;
			cur.prev = node;
		}
	}

	public void reverse(){ // reverse the doubly-linklist in O(n) time
		if (this.head==null || this.head.next==null){
			return;
		}
		Node cur = this.head;
		Node prev = cur.prev;
		Node nex = cur.next;
		while (cur!=null){
			cur.next = prev;
			cur.prev = nex;
			if (nex==null){
				break;
			}
			prev = cur;
			cur = nex;
			nex = nex.next;
		}
		Node n1 = this.head;
		Node n2 = this.tail;
		this.head = n2;
		this.tail = n1;
	}

	public void print(){ // print the doubly-linklist in one line in O(n) time
		Node cur = this.head;
		while (cur!=null){
			System.out.print(cur.data+" ");
			cur = cur.next;
		}
		System.out.println();
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		dlinklist l = new dlinklist();
		int n = in.nextInt();
		for (int i=0;i<n;i++){
			l.append(in.nextInt());
		}
		l.print();
	}

}