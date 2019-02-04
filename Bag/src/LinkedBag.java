
public class LinkedBag<T> implements BagInterface<T> {

	private Node firstNode;
	private int numberOfEntities;
	
	public LinkedBag(){
		firstNode = null;
		numberOfEntities = 0;
	}
	
	
	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean add(T newEntry) {
		// TODO Auto-generated method stub
		Node newNode = new Node(newEntry);
		newNode.next = firstNode;
		firstNode = newNode;
		numberOfEntities++;
		return true;
	}
	

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		T[] output = (T[]) new Object[numberOfEntities];
		
		int index = 0;
		Node current = firstNode;
		while(current != null && index <= numberOfEntities){
			output[index] = current.data;
			current = current.next;
			index++;
		}
		return output;
	}
	
	private class Node {
		private T data;
		private Node next;
		
		private Node(T _data, Node _next){
			
		}
	}
}
