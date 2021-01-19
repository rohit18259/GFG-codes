import java.util.*;

// Solution to Next Greater Frequency Element problem in gfg using HashMap ans Stack in java
// time complexity is O(n)


class Node{
	int data;
	int freq;
	Node(int data,int freq){
		this.data = data;
		this.freq = freq;
	}
	public String toString(){
		return "("+this.data+","+this.freq+")";
	}
}

public class NexGreatFreq{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		int[] outp = new int[n];
		Node[] nodearr = new Node[n];

		HashMap<Integer,Integer> map = new HashMap<>();
		Stack<Node> stack = new Stack<>();
		for (int i=0;i<n;i++){
			arr[i] = in.nextInt();
			if (map.containsKey(arr[i])){
				map.put(arr[i],map.get(arr[i])+1);
			}
			else{
				map.put(arr[i],1);
			}
		}
		for (int i=0;i<n;i++){
			nodearr[i] = new Node(arr[i],map.get(arr[i]));
		}

		for (int i=n-1;i>-1;i--){
			Node node = nodearr[i];
			while (!stack.empty()){
				if (node.freq<stack.peek().freq){
					outp[i] = stack.peek().data;
					break;
				}
				else{
					stack.pop();
				}
			}
			if (stack.empty()){
				outp[i] = -1;
			}
			stack.push(node);
		}
		System.out.println(Arrays.toString(outp));
	}
}