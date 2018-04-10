import java.util.*;

public class StackFunctions {

	public static Scanner reader = new Scanner(System.in);

	/**
	 * Function which counts the number of apperances of an integer in a given stack
	 * @param s The stack in which we want to count the apperances of x
	 * @param x The integer which we want to know how many times is in stack s
	 * @return The number of apperances of x in the given stack.
	 */
	public static int numberOfAppearances(Stack<Integer> s, int x) {
		Stack<Integer> temp = new Stack<Integer>();
		int counter = 0;

		while(! s.isEmpty()) {
			temp.push(s.pop());
			if(temp.top() == x)
				counter++;
		}
		while(! temp.isEmpty()) {
			s.push(temp.pop());
		}

		return counter;
	}

	/**
	 * Build a sorted stack from user input
	 * @param x The integer on which the function will stop recieving input from user
	 * @return sorted stack
	 */
	public static Stack<Integer> sortedStack(int x) {
		Node<Integer> sortedNode = NodeFunctions.sortedNode(x);
		Stack<Integer> sortedStack  = new Stack<Integer>();

		System.out.println("Inputs are: " + sortedNode.toString());

		while(sortedNode.getValue() != null) {
			sortedStack.push(sortedNode.getValue());
			sortedNode = sortedNode.getNext();
		}

		return sortedStack;
	}

	/**
	 * Is the stack sorted? if so, in which direction?
	 * @param s The stack that we want to check 
	 * @return Sort type if sorted or "not sorted" otherwise
	 */
	public static String sortType(Stack<Integer> s){
		Stack<Integer> temp = new Stack<Integer>();

		temp.push(s.pop());
		while(!s.isEmpty() && (int)(s.top()) <= (int)(temp.top())) {
			temp.push(s.pop());
		}
		if (s.isEmpty()) {
			pourBtoA(s, temp);
			return "Sorted: Biggest at top";
		}
		else {
			pourBtoA(s, temp);
			temp.push(s.pop());
			while(!s.isEmpty() && (int)(s.top()) >= (int)(temp.top())) {
				temp.push(s.pop());
			}
			if (s.isEmpty()) {
				pourBtoA(s, temp);
				return "Sorted: Biggest at base";
			}
		}
		return "Not Sorted";
	}

	public static <T> boolean similar(Stack<T> s1, Stack<T> s2) {
		Stack<T> temp = new Stack<T>();
		Stack<T> temp2 = new Stack<T>();
		
		while(!s1.isEmpty()) {
			temp.push(s1.pop());
			while(!s2.isEmpty()) {
				if(temp.top().equals(s2.top())){
					temp.pop();
					s2.pop();
					break;
				}
				temp2.push(s2.pop());
			}
			pourBtoA(s2, temp2);
		}
		if(s2.isEmpty()) {
			return true;
		}
		return false;
	}

	public static Stack<Integer> splitedStack(Stack<Integer> s, int splitAt){
	    Stack<Integer> temp = new Stack<Integer>();
	    Stack<Integer> toReturn = new Stack<Integer>();
	    int max;

	    while(!s.isEmpty()){
	        max = s.top();
            while(!s.isEmpty() && s.top() != splitAt ){
                temp.push(s.pop());

                if(temp.top() > max){
                    max = temp.top();
                }
            }
            if(!s.isEmpty())
                temp.push(s.pop());
            System.out.println("Max is: " + max);
            toReturn.push(max);

        }
        pourBtoA(s, temp);
	    System.out.println(s);
        System.out.println(toReturn);

        return toReturn;
    }

    public static boolean contains(Stack<Integer> s, int num){
		Stack<Integer> temp = new Stack<Integer>();
        String numStr = Integer.toString(num);
        String stackString = "";
		while(!s.isEmpty()){
		    temp.push(s.pop());
            stackString += Integer.toString(temp.top());
        }
        pourBtoA(s, temp);
		System.out.println("OLD.Stack is: " + stackString);
		System.out.println("Reversed: " + new StringBuilder(stackString).reverse().toString());
		if(stackString.contains(numStr) || stackString.contains(new StringBuilder(numStr).reverse().toString()))
		    return true;
		return false;
	}

	public static int longest(Stack<Integer> s){
	    Stack<Integer> temp = new Stack<Integer>();
	    int counter = 1;
	    int previousCounter = 1;

        temp.push(s.pop());

	    while(!s.isEmpty()){
	        if(s.top() + 1 == temp.top())
	            counter++;
	        else{
                if(counter > previousCounter)
                    previousCounter = counter;
                counter = 1;
            }
	            temp.push(s.pop());
        }

        pourBtoA(temp, s);
	    if(counter > previousCounter)
	        return counter;
        return previousCounter;
    }


	/**
	 * Places elements from B in an opposite order to their appearance(in b), into a.
	 * @param a A stack
	 * @param b A stack
	 */
	public static <T> void pourBtoA (Stack<T> a, Stack<T> b) {
		while(!b.isEmpty()) {
			a.push(b.pop());
		}
	}

	/**
	 * Build a stack from user Input
	 * @param x when do I stop 
	 * @return a stack
	 */
	public static Stack<Integer> inputUntilX(int x){
		int num = reader.nextInt();
		Stack<Integer> temp = new Stack<>();

		while(num != x) {
			temp.push(num);
			num = reader.nextInt();
		}

		return temp;

	}
}
