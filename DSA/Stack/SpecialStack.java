import java.util.*;

// A specialized stack data structure implemented in java using java Stack to get minimum value in the stack in O(1) time along with other methods

class Node{ // Node class to hold an element in the SpecialStack
	int data; // data is the value hold 
	int min;
	Node(int data,int min){
		this.data = data;
		this.min = min;
	}
}

public class SpecialStack{ // the Special Stack class
	Stack<Node> stack;
	SpecialStack(){
		this.stack = new Stack<>();
	}
	public int peek(){ // peek operation in O(1) time
		if (this.stack.empty()){
			System.out.println("Stack Underflow!");
			return -1;
		}
		else{
			return this.stack.peek().data;
		}
	}
	public void push(int x){ // push operation in O(1) time
		if (this.stack.empty()){
			this.stack.push(new Node(x,x));
		}
		else{
			Node node = this.stack.peek();
			if (x<node.min){
				this.stack.push(new Node(x,x));
			}
			else{
				this.stack.push(new Node(x,node.min));
			}
		}
	}
	public int pop(){ // pop operation in O(1) time
		if (this.stack.empty()){
			System.out.println("Stack Underflow!");
			return -1;
		}
		else{
			return this.stack.pop().data;
		}
	}
	public boolean isEmpty(){ // get if the special stack is empty in O(1) time
		return this.stack.empty();
	}
	public int getMin(){ // get the minimum value in stack in O(1) time
		if (this.stack.empty()){
			System.out.println("Stack Underflow!");
			return -1;
		}
		else{
			return this.stack.peek().min;
		}
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		SpecialStack stack = new SpecialStack();
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
			else if (s.equals("empty")){
				System.out.println(stack.isEmpty());
			}
			else if (s.equals("min")){
				System.out.println(stack.getMin());
			}
		}
	}
}