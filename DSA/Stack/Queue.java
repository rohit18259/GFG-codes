import java.util.*;

// A Queue implemented using two java Stacks

public class Queue{ // the Queue class
	Stack<Integer> stack1;
	Stack<Integer> stack2;
	int size;
	Queue(){
		this.stack1 = new Stack<>();
		this.stack2 = new Stack<>();
		this.size = 0;
	}

	public void enQueue(int x){ // to enqueue in the queue in O(1) time
		this.stack1.push(x);
		this.size++;
	}

	public int deQueue(){ // to dequeue from the queue in O(n) time
		if (this.stack2.empty()){
			while (!this.stack1.empty()){
				this.stack2.push(this.stack1.pop());
			}
			if (!this.stack2.empty()){
				this.size--;
				return this.stack2.pop();
			}
			else{
				System.out.println("Queue underflow!");
				return -1;
			}
		}
		else{
			this.size--;
			return this.stack2.pop();
		}
	}

	public int getSize(){ // get the size of the queue in O(1) time
		return this.size;
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Queue queue = new Queue();
		int q = in.nextInt();
		for (int i=0;i<q;i++){
			String s = in.next();
			if (s.equals("enqueue")){
				queue.enQueue(in.nextInt());
			}
			else if (s.equals("dequeue")){
				System.out.println(queue.deQueue());
			}
			else if (s.equals("size")){
				System.out.println(queue.getSize());
			}
		} 
	}
}