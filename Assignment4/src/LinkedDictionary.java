//Brandon Frison
import java.util.Iterator;

public class LinkedDictionary<K, V> implements DictionaryInterface<K, V>{

	private Node firstNode;
	private int numberOfEntries;
	
	public LinkedDictionary(){
		firstNode = null;
		numberOfEntries = 0;
	}
	
	
	@Override
	public V add(K key, V value) {
		// TODO Auto-generated method stub
		V result = null;
		Node currentNode = firstNode;
		
		if(currentNode != null && key.equals(currentNode.getKey())){
			result = (V) currentNode.getValue();
			currentNode.setValue(value);
		}
		else
		{
			Node newNode = new Node(key, value);
			if(currentNode == null){
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			}
			else{
				firstNode.setNextNode(newNode);
			}
		numberOfEntries++;	
		}
		
		return result;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		
		Node currentNode = firstNode;
		Node previousNode = firstNode;
		
		while(currentNode.key != key){
			if(currentNode.getNextNode() == null){
				return null;
			}
			else{
				previousNode = currentNode;
				currentNode = currentNode.getNextNode();
			}
		}
		
		if(currentNode == firstNode){
			currentNode = currentNode.getNextNode();
			numberOfEntries--;
		}
		else{
			previousNode.next = currentNode.getNextNode();
			numberOfEntries--;
		}
		
		return (V)currentNode;
	}

	@Override
	public V getValue(K key) {
		// TODO Auto-generated method stub
		Node currentNode = firstNode;
		
		if(!isEmpty()){
			while(currentNode.key != key){
				if(currentNode.getNextNode() == null){
					return null;
				}
				else
					return (V)currentNode.value;
			}
		}
		return null;
		
	}

	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		Node currentNode = firstNode;
		
		if(!isEmpty()){
			while(currentNode.key != key){
				if(currentNode.getNextNode() == null){
					return false;
				}
				else
					return true;
			}
		}
		return false;
	}

	@Override
	public Iterator getKeyIterator() {
		// TODO Auto-generated method stub
		return new KeyIterator();
	}

	@Override
	public Iterator getValueIterator() {
		// TODO Auto-generated method stub
		return new ValueIterator();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return firstNode.equals(null);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return numberOfEntries;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		Node currentNode = firstNode;
		Node previousNode = firstNode;
		
		while(firstNode.getNextNode() != null){
			
				previousNode = currentNode;
				currentNode = currentNode.getNextNode();
				previousNode.next = currentNode.getNextNode();
		}
		firstNode = null;
		numberOfEntries = 0;
	}

	private class KeyIterator implements Iterator<K> {
		
		private Node nextNode;
		private KeyIterator(){
			nextNode = firstNode;
		}
		
		public boolean hasNext(){
			return nextNode != null;
		}
		
		public K next(){
			K result;
			if(hasNext()){
				result = (K) nextNode.getKey();
				nextNode = nextNode.getNextNode();
			}
			else
				return null;
			
			return result;
		}
		
	}
	
	private class ValueIterator implements Iterator<V> {
		
		private Node nextNode;
		private ValueIterator(){
			nextNode = firstNode;
		}
		
		public boolean hasNext(){
			return nextNode != null;
		}
		
		public V next(){
			V result;
			if(hasNext()){
				result = (V) nextNode.getValue();
				nextNode = nextNode.getNextNode();
			}
			else
				return null;
			
			return result;
		}
		
	}
	
	private class Node<K, V>
	{
      private K    key; // key of pair
      private V	   value; // value of pair
      private Node next; // Link to next node

      private Node(K keyPortion, V valuePortion)
      {
         this(keyPortion, valuePortion, null);
      } // end constructor

      private Node(K keyPortion, V valuePortion, Node linkPortion)
      {
         key = keyPortion;
         value = valuePortion;
         next = linkPortion;	
      } // end constructor

      private K getKey()
      {
         return key;
      } 

      private void setKey(K newKey)
      {
         key = newKey;
      } 
      
      private V getValue()
      {
    	  return value;
      }
      
      private void setValue(V newValue)
      {
    	  value = newValue;
      }
      
      

      private Node getNextNode()
      {
         return next;
      } // end getNextNode

      private void setNextNode(Node nextNode)
      {
         next = nextNode;
      } // end setNextNode
	} // end Node
	
}
