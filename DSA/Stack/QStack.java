import java.util.*;

// A Stack implemented using java Queue interface

public class QStack{
	Queue<Integer> q1;
	Queue<Integer> q2;
	int size;
	QStack(){
		this.q1 = new LinkedList<Integer>();
		this.q2 = new LinkedList<Integer>();
		this.size = 0;
	}
	public int peek(){ // peek method implemented in O(1) time
		if (this.q1.peek()==null){
			System.out.println("Stack Underflow!");
			return -1;
		}
		return  this.q1.peek();
	}

	public void push(int x){ // push method implemented in O(n) time
		this.q2.add(x);
		while (q1.peek()!=null){
			this.q2.add(q1.peek());
			q1.remove();
		}
		Queue<Integer> a = q1;
		Queue<Integer> b = q2;
		this.q1 = b; this.q2 = a;
		this.size++;
	}

	public int pop(){ // pop method implemented in O(1) time
		if (this.q1.peek()==null){
			System.out.println("Stack Underflow!");
			return -1;
		}
		int x = this.q1.peek();
		q1.remove();
		this.size--;
		return x;
	}

	public int getSize(){ // get size of the current stack in O(1) time
		return this.size;
	}

	public static void main(String[] args){
		QStack stack = new QStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());
		stack.push(5);
		System.out.println(stack.peek());
		System.out.println(stack.getSize());
	}
}