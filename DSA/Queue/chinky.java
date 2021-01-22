import java.util.*;

// Solution to Chinky and diamonds problem on gfg using Priority Queue

class comparator implements Comparator<Integer>{
	public int compare(Integer a,Integer b){
		if (b>a){
			return 1;
		}
		if (b<a){
			return -1;
		}
		return 0;
	}
}
 
public class chinky{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int q=0;q<t;q++){
			int n = in.nextInt();
			int k = in.nextInt();
			PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new comparator());
			for (int i=0;i<n;i++){
				queue.add(in.nextInt());
			}
			long count = 0l;
			for (int i=0;i<k;i++){
				int val = queue.poll();
				count += (long)val;
				queue.add(val/2);
			}
			System.out.println(count);
		}
	}
}
