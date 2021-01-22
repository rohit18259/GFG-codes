import java.util.*;

// a LinkList implementation of queue in java with all the given methods implemented in O(1) time complexity

class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}

public class LQueue{
	Node front;
	Node rear;
	int size;
	LQueue(){
		this.front = null;
		this.rear = null;
		this.size = 0;
	}
	public boolean isEmpty(){ // to get if queue is empty
		return this.front==null;
	}
	public void enQueue(int x){ // to enqueue x into queue
		Node node = new Node(x);
		if (isEmpty()){
			this.front = node; this.rear = node;
			this.size++;
			return;
		}
		this.rear.next = node;
		this.rear = node;
		this.size++;
	}
	public int deQueue(){ // to dequeue the queue
		if (isEmpty()){
			System.out.println("Queue is Empty!");
			return -1;
		}
		int x = this.front.data;
		this.front = this.front.next;
		if (this.front==null){
			this.rear = null;
		}
		this.size--;
		return x;
	}
	public int getSize(){ // to get current size of the queue
		return this.size;
	}
	public int getFront(){ // to get the element in front of the queue
		if (isEmpty()){
			System.out.println("Queue is Empty!");
			return -1;
		}
		return this.front.data;
	}
	public int getRear(){ // to get the element at the rear of the queue
		if (isEmpty()){
			System.out.println("Queue is Empty!");
			return -1;
		}
		return this.rear.data;
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		LQueue queue = new LQueue();
		int q = in.nextInt();
		for (int i=0;i<q;i++){
			String s = in.next();
			if (s.equals("add")){
				queue.enQueue(in.nextInt());
			}
			else if (s.equals("del")){
				System.out.println(queue.deQueue());
			}
			else if (s.equals("front")){
				System.out.println(queue.getFront());
			}
			else if (s.equals("rear")){
				System.out.println(queue.getRear());
			}
			else if (s.equals("size")){
				System.out.println(queue.getSize());
			}
		}
	}

}