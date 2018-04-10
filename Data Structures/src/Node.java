public class Node<T> {

	T value;
	Node<T> next;

	//C'tors
	public Node(T value, Node<T> next) {
		this.value = value;
		this.next = next;
	}

	public Node(T value) {
		this.value = value;
	}

	public Node(Node<T> next) {
		this.next = next;
	}

	public Node() {
		
	}

	//Getters
	public T getValue() {
		return value;
	}

	public Node<T> getNext() {
		return next;
	}

	//Setters
	public void setValue(T value) {
		this.value = value;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public boolean isEmpty() {
		return this != null;
	}

	public String toString() {
		if(this.next != null)
			return this.value + " ---> " + this.next;
		else
			return ""+this.value;
	}

	public int num_of_sequances() {
		Node<T> pointer = this;
		int counter = 0;
		
		while(pointer.next != null) {
			if(pointer.getValue() == pointer.getNext().getValue()) {
				counter++;
				while(pointer.getValue() == pointer.getNext().getValue() && pointer.getNext().getNext() != null)
					pointer = pointer.getNext();
			}
			pointer = pointer.getNext();
		}
		return counter;
	}
	
	public void print_between(int start_index, int end_index) {
		Node<T> pointer = this;
		int num_of_items_to_print = end_index - start_index;
		String to_print = "";
		int start_index_in = start_index;
	
		while(start_index_in != 0) {
			pointer = pointer.getNext();
			start_index_in--;
		}
		
		while(num_of_items_to_print != 1) {
			to_print += pointer.getValue() + "---> ";
			num_of_items_to_print--;
			pointer = pointer.getNext();
		}
		to_print += ""+ pointer.getValue();
		System.out.println(to_print);
	}



}
