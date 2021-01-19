import java.util.*;

// Solution to The Stock Span Problem in gfg using Stacks in java
// time complexity is O(n)

class Node{
	int data;
	int span;
	Node(int data,int span){
		this.data = data;
		this.span = span;
	}
}

public class StockSpan{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Stack<Node> stack = new Stack<>();
		int n = in.nextInt();
		for (int i=0;i<n;i++){
			int data = in.nextInt();
			Node node = new Node(data,1);
			while (!stack.empty()){
				Node top = stack.peek();
				if (top.data>node.data){
					break;
				}
				else{
					node.span += top.span;
					stack.pop();
				}
			}
			stack.push(node);
			System.out.print(node.span+" ");
		}
		System.out.println();
	}
}