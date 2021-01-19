import java.util.*;

// two stacks implemented in an array with efficient use of space and all operations in O(1) time

public class TwoStacks{ // the TwoStack class
	int[] arr;
	int maxsize;
	int top1; int top2;
	int size;
	TwoStacks(int maxsize){
		this.maxsize = maxsize;
		this.arr = new int[maxsize];
		this.top1 = 0; this.top2 = maxsize-1;
		this.size = 0;
	}
	public void push1(int x){ // to push x into first stack
		if (this.top1<=this.top2){
			this.arr[top1] = x;
			this.top1++;
			this.size++;
		}
		else{
			System.out.println("Stack Overflow!");
		}
	}
	public void push2(int x){ // to push x into second stack
		if (this.top1<=this.top2){
			this.arr[top2] = x;
			this.top2--;
			this.size++;
		}
		else{
			System.out.println("Stack Overflow!");
		}
	}
	public int pop1(){ // to pop from the first stack
		if (this.top1>0){
			int x = this.arr[top1-1];
			this.top1--;
			this.size--;
			return x;
		}
		else{
			System.out.println("Stack1 Underflow!");
			return -1;
		}
	}
	public int pop2(){ // to pop from the second stack
		if (this.top2<this.maxsize-1){
			int x = this.arr[top2+1];
			this.top2++;
			this.size--;
			return x;
		}
		else{
			System.out.println("Stack2 Underflow!");
			return -1;
		}
	}
	public int peek1(){ // to peek from first stack
		if (this.top1>0){
			return this.arr[top1-1];
		}
		else{
			System.out.println("Stack1 Underflow!");
			return -1;
		}
	}
	public int peek2(){ // to peek from second stack
		if (this.top2<this.maxsize-1){
			return this.arr[top2+1];
		}
		else{
			System.out.println("Stack2 Underflow!");
			return -1;
		}
	}
	public int getSize(){ // to get the total size of both the stacks
		return this.size;
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		TwoStacks stack = new TwoStacks(1000);
		int q = in.nextInt();
		for (int i=0;i<q;i++){
			String s = in.next();
			if (s.equals("push1")){
				stack.push1(in.nextInt());
			}
			else if (s.equals("push2")){
				stack.push2(in.nextInt());
			}
			else if (s.equals("pop1")){
				System.out.println(stack.pop1());
			}
			else if (s.equals("pop2")){
				System.out.println(stack.pop2());
			}

			else if (s.equals("peek1")){
				System.out.println(stack.peek1());
			}
			else if (s.equals("peek2")){
				System.out.println(stack.peek2());
			}
			else if (s.equals("size")){
				System.out.println(stack.getSize());
			}
		}
	}
}