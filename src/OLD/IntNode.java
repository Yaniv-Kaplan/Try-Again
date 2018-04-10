package OLD;

public class IntNode {
	int value;
	IntNode next;
	
	
	public IntNode(int value, IntNode next) {
		this.value = value;
		this.next = next;
	}
	
	public IntNode(int value) {
		this.value = value;
	}
	
	public IntNode(IntNode next) {
		this.next = next;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public IntNode getNext() {
		return next;
	}
	public void setNext(IntNode next) {
		this.next = next;
	}
	
	public String toString() {
		return this.value +","+ this.next;
	}
}
