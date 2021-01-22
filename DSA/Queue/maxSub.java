import java.util.*;

// this code is used to find Maximum of all subarrays of size k within an array using a Special structure Queue
// the time complexity of this code is O(n) for average case and O(k*n) for worst case

class Node{
	int data;
	int max;
	Node(int data,int max){
		this.data = data;
		this.max = max;
	}
}

class MaxQ{ // Special Queue class implemented using two stacks. The two stacks can find the maximum value in them in O(1) time
	Stack<Node> stack1;
	Stack<Node> stack2;
	MaxQ(){
		this.stack1 = new Stack<>();
		this.stack2 = new Stack<>();
	}
	public void enQueue(int x){ // enqueue x into the queue
		if (this.stack1.empty()){
			stack1.push(new Node(x,x));
		}
		else{
			Node node = stack1.peek();
			if (node.max>x){
				stack1.push(new Node(x,node.max));
			}
			else{
				stack1.push(new Node(x,x));
			}
		}
	}
	public int deQueue(){ // dequeue from the queue
		if (this.stack2.empty()){
			while (!this.stack1.empty()){
				Node node = this.stack1.pop();
				if (this.stack2.empty()){
					this.stack2.push(new Node(node.data,node.data));
				}
				else{
					this.stack2.push(new Node(node.data,Math.max(node.data,this.stack2.peek().max)));
				}
			}
			return this.stack2.pop().data;
		}
		return this.stack2.pop().data;
	}
	public int getMax(){ // get the maximum value in the queue in O(1) time
		if (this.stack1.empty()){
			return this.stack2.peek().max;
		}
		else if (this.stack2.empty()){
			return this.stack1.peek().max;
		}
		return Math.max(this.stack1.peek().max,this.stack2.peek().max);
	}
	public int getSize(){
		return this.stack1.size() + this.stack2.size();
	}
}

public class maxSub{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		MaxQ queue = new MaxQ();
		int n = in.nextInt(); int k = in.nextInt();
		for (int i=0;i<n;i++){
			int x = in.nextInt();
			if (queue.getSize()<k){
				queue.enQueue(x);
			}
			else{
				queue.deQueue();
				queue.enQueue(x);
			}
			if (queue.getSize()==k){
				System.out.println(queue.getMax());
			}
		}
	}
}