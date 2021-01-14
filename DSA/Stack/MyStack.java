import java.util.*;

class Node{ // a Node in a linkedlist stack
	int data;
	Node next;
	Node(){
		this.next = null;
	}
	Node(int data){
		this.data = data;
		this.next = null;
	}
}

class AStack{ // Array based stack class
	int maxSize;
	int[] arr;
	int top;
	AStack(int maxSize){
		this.maxSize = maxSize;
		this.arr = new int[maxSize];
		this.top = -1;
	}
	public void push(int val){ // to push val on top of stack in O(1) time
		if (this.top>=this.maxSize-1){
			System.out.println("Stack Overflow");
		}
		else{
			this.top = this.top + 1;
			this.arr[this.top] = val;
		}
	}

	public int peek(){ // to get the element on top of the stack in O(1) time
		if (top<0){
			System.out.println("Stack Underflow");
			return -1;
		}
		else{
			return this.arr[top];
		}
	}

	public int pop(){ // to remove the top element of the stack in O(1) time
		if (top<0){
			System.out.println("Stack Underflow");
			return -1;
		}
		else{
			int x = this.arr[top];
			this.top = this.top - 1;
			return x;
		}
	}

	public int getSize(){ // to get the length (number of elements in stack) of the stack in O(1) time
		return this.top+1;
	}

	public boolean isEmpty(){ // to find if stack is empty or not in O(1) time
		if (top<0){
			return true;
		}
		else{
			return false;
		}
	}
}


class LStack{ // link-list based stack class
	int size;
	Node head;
	Node tail;
	LStack(){
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	public void push(int val){ // to push val on top of stack in O(1) time
		if (this.head==null){
			Node node = new Node(val);
			this.head = node;
			this.tail = node;
		}
		else{
			Node node = new Node(val);
			node.next = this.head;
			this.head = node;
		}
		this.size++;
	}

	public int peek(){ // to get the element on top of the stack in O(1) time
		if (this.head==null){
			System.out.println("Stack Underflow");
			return -1;
		}
		else{
			return this.head.data;
		}
	}

	public int pop(){ // to remove the top element of the stack in O(1) time
		if (this.head==null){
			System.out.println("Stack Underflow");
			return -1;
		}
		else{
			int x = this.head.data;
			this.head = this.head.next;
			if (this.head==null){
				this.tail = null;
			}
			this.size--;
			return x;
		}
	}

	public int getSize(){ // to get the length (number of elements in stack) of the stack in O(1) time
		return this.size;
	}

	public boolean isEmpty(){ // to find if stack is empty or not in O(1) time
		if (this.size==0){
			return true;
		}
		else{
			return false;
		}
	}
}


public class MyStack{ // driver class

	public static void main(String[] args){
		AStack stack1 = new AStack(1000);
		stack1.push(1);
		stack1.push(2);
		System.out.println(stack1.getSize());
		System.out.println(stack1.peek());

		LStack stack2 = new LStack();
		stack2.push(5);
		stack2.push(7);
		System.out.println(stack2.getSize());
		System.out.println(stack2.peek());
	}
}