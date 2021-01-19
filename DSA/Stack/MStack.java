import java.util.*;

class Node{ // a node to contain element and next, prev pointer in the stack
	int data;
	Node next;
	Node prev;
	Node(int data){
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

public class MStack{ // A custom stack made with operations on middle element as well as other methods in O(1) time
	Node head;
	Node tail;
	Node mid;
	int size;
	MStack(){
		this.size = 0;
	}
	public void push(int x){ // to push x on top of stack in O(1) time
		Node node = new Node(x);
		if (this.size==0){
			this.head = node;
			this.tail = node;
			this.mid = node;
		}
		else{
			if (this.size%2!=0){
				this.tail.next = node;
				node.prev = tail;
				this.tail = node;
			}
			else{
				this.tail.next = node;
				node.prev = tail;
				this.tail = node;
				this.mid = this.mid.next;
			}
		}
		this.size++;
	}
	public int pop(){ // to pop element from top of stack in O(1) time
		int val = -1;
		if (this.size==0){
			System.out.println("Stack Underflow!");
			return -1;
		}
		if (this.size%2!=0){
			val = this.tail.data;
			this.mid = this.mid.prev;
			this.tail = this.tail.prev;
			if (this.tail==null){
				this.head = null;
			}
			else{
				this.tail.next = null;
			}
		}
		else{
			val = this.tail.data;
			this.tail = this.tail.prev;
			this.tail.next = null;
		}
		this.size--;
		return val;
	}
	public int peek(){ // to peek from stack in O(1) time
		if (this.tail==null){
			System.out.println("Stack Underflow!");
			return -1;
		}
		return this.tail.data;
	}
	public int getMid(){ // to peek middle element in stack in O(1) time
		if (this.mid==null){
			System.out.println("Stack Underflow!");
			return -1;
		}
		return this.mid.data;
	}
	public void delMid(){ // to delete middle element in stack in O(1) time
		if (this.mid==null){
			System.out.println("Stack Underflow!");
			return;
		}
		else if (this.size%2==0){
			if (this.size==2){
				this.head = this.head.next;
				this.head.prev = null;
				this.mid = this.head;
				this.tail = this.head;
			}
			else{
				Node pre = this.mid.prev;
				this.mid = this.mid.next;
				pre.next = this.mid;
				this.mid.prev = pre;
			}
			this.size--;
		}
	}
	public int getSize(){ // to get the size of the current stack in O(1) time
		return this.size;
	}
	public void print(){ // to print the whole stack in a line
		Node node = this.head;
		while (node!=null){
			System.out.print(node.data+" ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args){
		MStack stack = new MStack();
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int i=0;i<q;i++){
			String s = in.next();
			if (s.equals("push")){
				stack.push(in.nextInt());
			}
			else if (s.equals("pop")){
				System.out.println(stack.pop());
			}
			else if (s.equals("peek")){
				System.out.println(stack.peek());
			}
			else if (s.equals("size")){
				System.out.println(stack.getSize());
			}
			else if (s.equals("mid")){
				System.out.println(stack.getMid());
			}
			else if (s.equals("delmid")){
				stack.delMid();
			}
			else if (s.equals("print")){
				stack.print();
			}
		}
	}
}