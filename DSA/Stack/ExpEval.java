import java.util.*;

// This code is used to evaluate an arithematic expression suing stacks in O(n) time. It can take the operators +, -, *, /.
// The string input can only take numbers and the mentioned operators above. There must be atleast one space between each operand or operators.
// eg:- 10 + 2 * 6  is a valid input but  10+2* 6 is not a valid input. 

public class ExpEval{
	public static boolean isOperator(String c){
		if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/") || c.equals("(") || c.equals(")")){
			return true;
		}
		return false;
	}

	public static int getPrec(String c){
		if (c.equals("-")){
			return 0;
		}
		if (c.equals("+")){
			return 1;
		}
		if (c.equals("/")){
			return 2;
		}
		if (c.equals("*")){
			return 3;
		}
		return -1;
	}

	public static String evaluate(String a,String b,String ope){
		if (ope.equals("+")){
			return Double.toString(Double.parseDouble(a) + Double.parseDouble(b));
		}
		else if (ope.equals("-")){
			return Double.toString(Double.parseDouble(a) - Double.parseDouble(b));
		}
		else if (ope.equals("*")){
			return Double.toString(Double.parseDouble(a) * Double.parseDouble(b));
		}
		else if (ope.equals("/")){
			return Double.toString(Double.parseDouble(a)/Double.parseDouble(b));
		}
		return "bla";
	}

	public static double inTopost(String[] exp){
		double val = 0d;
		Stack<String> stack = new Stack<>();
		Stack<String> poststack = new Stack<>();
		String s = ""; 
		for (int i=0;i<exp.length;i++){
			String c = exp[i];
			if (!isOperator(c)){
				poststack.push(c);
			}
			else{
				if (stack.empty() || stack.peek().equals("(") || getPrec(c)>getPrec(stack.peek())){
					stack.push(c);
				}
				else if (c.equals("(")){
					stack.push(c);
				}
				else if (c.equals(")")){
					while (!stack.peek().equals("(")){
						poststack.push(stack.pop());
					}
					stack.pop();
				}
				else if (getPrec(c)<=getPrec(stack.peek())){
					while (!stack.empty() && !stack.peek().equals("(") && getPrec(stack.peek())>= getPrec(c)){
						poststack.push(stack.pop());
					}
					stack.push(c);
				}
			}
			if (isOperator(poststack.peek())){
				String ope = poststack.pop();
				String b = poststack.pop();
				String a = poststack.pop();
				poststack.push(evaluate(a,b,ope));
			}
		}
		while (!stack.empty()){
			poststack.push(stack.pop());
			if (isOperator(poststack.peek())){
				String ope = poststack.pop();
				String b = poststack.pop();
				String a = poststack.pop();
				poststack.push(evaluate(a,b,ope));
			}
		}
		return Double.parseDouble(poststack.peek());
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String[] arr = in.nextLine().split("\\s+",-1);
		System.out.println(inTopost(arr));
	}
}