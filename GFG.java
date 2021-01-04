import java.util.*;
import java.lang.*;
import java.io.*;

class dsa{
    private int n;
    private int[] arr;
    dsa(int[] arr,int n){
        this.n = n;
        this.arr = arr;
    }
    public int[] getArr(){
        return this.arr;
    }
    public void rotateleft(int d){
        d = d%n;
        int[] arr1 = new int[this.n];
        int ind = 0;
        for (int i=0;i<this.n;i++){
            if (i-d<0){
                ind = i - d +this.n;
            }
            else{
                ind = i-d;
            }
            arr1[ind] = this.arr[i];
        }
        this.arr = arr1;
        
    }
    public void print(){
    	for (int i=0;i<this.n;i++){
    		System.out.print(this.arr[i]+" ");
    	}
    	System.out.println();
    }
}

class GFG {
    
    
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i=0;i<t;i++){
			int n = in.nextInt(); int d = in.nextInt();
			int[] arr = new int[n];
			for (int j=0;j<n;j++){
				arr[j] = in.nextInt();
			}
			dsa obj = new dsa(arr,n);
			obj.rotateleft(d);
			//System.out.println(Arrays.toString(arr));
			obj.print();
		}
	}
}