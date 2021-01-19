import java.util.*;

// Solution to Next Greater Element problem on gfg using Stacks in java
// time complexity is O(n)

public class NexGreater{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		int n = in.nextInt();
		int[] arr = new int[n];
		int[] outp = new int[n];
		for (int i=0;i<n;i++){
			arr[i] = in.nextInt();
		}
		for (int i=n-1;i>-1;i--){
			int data = arr[i];
			while (!stack.empty()){
				if (data<stack.peek()){
					outp[i] = stack.peek();
					break;
				}
				else{
					stack.pop();
				}
			}
			if (stack.empty()){
				outp[i] = -1;
			}
			stack.push(data);
		}
		System.out.println(Arrays.toString(outp));
	}
}