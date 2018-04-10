import java.util.*;

public class NodeFunctions {


	public static Scanner reader = new Scanner(System.in);

	public static char parity(Node<Integer> chain) {
		int even = 0;
		int odd = 0;

		while(chain != null) {
			if(chain.value % 2 == 0)
				even++;
			else
				odd++;
			chain = chain.getNext();
		}
		if(even == odd)
			return 's';
		else if(even > odd)
			return 'z';
		else
			return 'e';
	}

	public static <T> Node<T> remove_object(Node<T> chain, T to_remove){
		while(chain != null && chain.getValue().equals(to_remove)) {
			chain = chain.getNext();
		}

		Node<T> pointer = chain;

		while(pointer != null) {
			while(pointer.getNext() != null && pointer.getNext().getValue().equals(to_remove)) {
				pointer.setNext(pointer.getNext().getNext());
			}
			pointer = pointer.getNext();
		}
		return chain;

	}

	public static <T> Node<T> no_repeats(Node<T> chain){
		Node<T> pointer = chain;
		Node<T> inner_pointer = pointer;

		while(pointer != null) {
			while(inner_pointer != null && inner_pointer.getNext() != null) {
				while(inner_pointer.getNext() != null && inner_pointer.getNext().getValue().equals(pointer.getValue())) {
					inner_pointer.setNext(inner_pointer.getNext().getNext());
				}
				inner_pointer = inner_pointer.getNext();
			}
			pointer = pointer.getNext();
			inner_pointer = pointer;
		}
		return chain;
	}

	public static Node<Integer> no_repeats_advanced(Node<Integer> chain){
		Node<Integer> pointer = chain;
		Node<Integer> inner_pointer = pointer;

		while(pointer != null) {
			if(pointer.getValue()%10 != pointer.getValue()/10) {
				while(inner_pointer != null && inner_pointer.getNext() != null) {
					while(inner_pointer.getNext() != null && inner_pointer.getNext().getValue().equals(pointer.getValue())) {
						inner_pointer.setNext(inner_pointer.getNext().getNext());
					}
					inner_pointer = inner_pointer.getNext();
				}
			}
			pointer = pointer.getNext();
			inner_pointer = pointer;
		}
		return chain;
	}

	public static Node<Integer> random_two_digit(int num_to_gen){
		Node<Integer> chain = new Node<Integer>(NodeFunctions.randominrange(10, 99));
		Node<Integer> pointer = chain;
		for(int i = 1; i< num_to_gen; i++) {
			pointer.setNext(new Node<Integer>(NodeFunctions.randominrange(10, 99)));
			pointer = pointer.getNext();
		}
		return NodeFunctions.no_repeats_advanced(chain);
	}

	public static boolean up_or_not(Node<Integer> chain){
		Node<Integer> pointer = chain;

		while(pointer.getNext() != null) {
			if(pointer.getValue() > pointer.getNext().getValue())
				return false;
			pointer = pointer.getNext();
		}
		return true;
	}

	public static void following_is_bigger(Node<Integer> chain) {
		Node<Integer> pointer = chain;

		while(pointer.getNext() != null) {
			if(pointer.getValue() > pointer.getNext().getValue()) {
				System.out.print(pointer.getValue()+ " ");
			}
			pointer = pointer.getNext();
		}
	}

	public static Node<Integer> start_with_n_go_for_m(int n, int m){
		Node<Integer> chain = new Node<Integer>(n);
		Node<Integer> pointer = chain;
		for(int i = n+1; i < n+m; i++) {
			pointer.setNext(new Node<Integer>(i));
			pointer = pointer.getNext();
		}
		return chain;
	}

	public static Node<Integer> reversed(){
		Node<Integer> chain = new Node<Integer>(reader.nextInt());	
		Node<Integer> current = new Node<Integer>(reader.nextInt(), chain);;
		while(current.getValue() != -999) {
			chain = current;
			current = new Node<Integer>(reader.nextInt(), chain);
		}
		return chain;

	}

	public Node<Integer> remove_highest_n(Node<Integer> chain, int n){
		//to-do: יש פונקציה שמוצאת מקסימום, קח את המקסימום ותמחק אותו בעזרת הפונקציה רמוב אובג'קט 
		return chain;
	}
	
	public int highest (Node<Integer> chain) {
		//to-do: למצוא את המקסימום ברשימה מקושרת
		int max = chain.getValue();
		return max; 
	}

	public static int times_in(Node<Character> chain, char c) {
		Node<Character> pointer = chain;
		int counter = 0;
		
		while(pointer != null) {
			if(pointer.getValue().equals(c))
				counter++;
			pointer = pointer.getNext();
		}
		return counter;
	}
	
	public static Node<Integer> add_at_index(Node<Integer> chain, int index_to_add_in) {
		Node<Integer> pointer = chain;
		
		while(pointer != null && index_to_add_in != 0) {
			pointer = pointer.getNext();
			index_to_add_in--;
		}
		
		pointer.setNext(new Node<Integer> (7, pointer.getNext()));
		return chain;
	}
	
	
	public static Node<Integer> fun_with_nodes (Node<Integer> chain1, Node<Integer> chain2){
		Node<Integer> chain1_pointer = chain1;
		Node<Integer> chain2_pointer = chain2;
		
		Node<Integer> mixed_chain = new Node<Integer>(chain1_pointer.getValue()*chain2_pointer.getValue());
		Node<Integer> mixed_chain_pointer = mixed_chain;
		
		int parity_of_location = 0;
		
		while(chain1_pointer.getNext() != null && chain2_pointer.getNext() != null) {
			chain1_pointer = chain1_pointer.getNext();
			chain2_pointer = chain2_pointer.getNext();
			
			if (parity_of_location == 1) {
				//Odd
				mixed_chain_pointer.setNext(new Node<Integer> (chain1_pointer.getValue()*chain2_pointer.getValue()));
				parity_of_location = 0;
			}
			else {
				//Even
				mixed_chain_pointer.setNext(new Node<Integer> (chain1_pointer.getValue()+chain2_pointer.getValue()));
				parity_of_location = 1;
			}
			mixed_chain_pointer = mixed_chain_pointer.getNext();
		}
		
		if(chain1_pointer.getNext() != null)
			mixed_chain_pointer.setNext(chain1_pointer.getNext());
		else
			mixed_chain_pointer.setNext(chain2_pointer.getNext());
		
		return mixed_chain;
	}
	
	public static Node<Integer> sortedNode(int x){
		System.out.println("Input num");
		int num = reader.nextInt();
		Node<Integer> temp = new Node<>();
		
		while(num != x) {
			if(temp.getValue() == null || num <= temp.getValue()) {
				Node<Integer> tempNum = new Node<Integer>(num);
				tempNum.setNext(temp);
				temp = tempNum;
			}
			else {
				Node<Integer> pointer = temp;
				while(pointer.getNext().getNext() != null && pointer.getNext().getValue() < num) {
					pointer = pointer.getNext();
				}
				pointer.setNext(new Node<Integer>(num, pointer.getNext()));
			}
			System.out.println("Input num");
			num = reader.nextInt();
		}
		
		return temp;
		
	}
	
	
	
	




	public static int randominrange(int min, int max)
	{
		int range = (max - min) + 1;     
		return (int)(Math.random() * range) + min;
	}
}
