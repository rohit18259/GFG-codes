import java.util.*;

// A queue implemented using Arrays in java with all the given methods implemented in O(1) time complexity

public class AQueue{
	int end;int front;
	int[] arr;
	int maxsize; int size;
	AQueue(int maxsize){
		this.maxsize = maxsize;
		this.arr = new int[maxsize];
		this.front = 0; this.end = 0;
		this.size = 0;
	}
	public boolean isFull(){ // to get if queue if full
		return this.size==this.maxsize;
	}
	public boolean isEmpty(){ // to get if queue is empty
		return this.size==0;
	}
	public void enQueue(int x){ // to enqueue x into queue
		if (!isFull()){
			this.arr[this.end] = x;
			this.end++;
			this.end = this.end%this.maxsize;
			this.size++;
			return;
		}
		System.out.println("Queue is Full!");
	}
	public int deQueue(){ // to dequeue the queue
		if (isEmpty()){
			System.out.println("Queue is empty!");
			return -1;
		}
		int x = this.arr[this.front];
		this.front++;
		this.front = this.front%this.maxsize;
		this.size--;
		return x;
	}
	public int getSize(){ // to get current size of the queue
		return this.size;
	}
	public int getFront(){ // to get the element in front of the queue
		if (this.size==0){
			System.out.println("Queue is empty!");
			return -1;
		}
		return this.arr[this.front];
	}
	public int getRear(){ // to get the element at the rear of the queue
		if (this.size==0){
			System.out.println("Queue is empty!");
			return -1;
		}
		if (this.end==0){
			return this.arr[this.maxsize-1];
		}
		else{
			return this.arr[this.end-1];
		}
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		AQueue queue = new AQueue(5);
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
		}
	}
}