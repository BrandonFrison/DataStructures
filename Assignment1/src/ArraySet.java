import java.util.Arrays;

//Brandon Frison 300243731
public class ArraySet<T> implements SetInterface<T> {
	
	private T[] set;
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 3;
	private static final int MAXIMUM_CAPACITY = 1000;
	
	private boolean initialized;
	
	//default constructor no capacity chosen
	public ArraySet(){
		this(DEFAULT_CAPACITY);
	}
	
	public ArraySet(int startingCapacity){
		testCapacity(startingCapacity);
		
		@SuppressWarnings("unchecked")
		T[] temporarySet = (T[])new Object[startingCapacity];
		set = temporarySet;
		numberOfEntries = 0;
		initialized = true;
	}
		
	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return numberOfEntries == 0;
	}

	@Override
	public boolean add(T newEntry) {
		// TODO Auto-generated method stub
		checkInitialization();
		if(isArrayFull()){
			increaseCapacity();
		}
		set[numberOfEntries] = newEntry;
		numberOfEntries++;
		return true;
	}

	@Override
	public boolean remove(T anEntry) {
		// TODO Auto-generated method stub
		checkInitialization();
		int index = getElementIndex(anEntry);
		T result = removeEntry(index);
		return anEntry.equals(result);
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		checkInitialization();
		T result = removeEntry(numberOfEntries - 1);
		
		return result;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
				while(!isEmpty()){
					remove();
				}
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		checkInitialization();
		
		return getElementIndex(anEntry) > -1;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];
		for (int index = 0; index < numberOfEntries; index++){
			result[index] = set[index];
		}
		return result;
	}
	
	private int getElementIndex(T anEntry){
		int location = -1;
		boolean found = false;
		int currIndex = 0;
		
		while (!found && (currIndex < numberOfEntries)){
			if(anEntry.equals(set[currIndex])){
				found = true;
				location = currIndex;
			}
			currIndex++;
		}
		return location;
	}
	
	private T removeEntry(int index) {
		// TODO Auto-generated method stub
		T result = null;
		if(!isEmpty() && (index >= 0)){
			result = set[index];
			set[index] = set[numberOfEntries - 1];
			
			set[numberOfEntries - 1] = null;
			numberOfEntries--;
		}
		return result;
	}
	
	 private void checkInitialization()
	{
	    if (!initialized)
	    	throw new SecurityException ("Uninitialized object has been used to call an ArraySet method.");
	} 
	
	private boolean isArrayFull(){
		return numberOfEntries >= set.length;
	}
	
	private void increaseCapacity(){
		int newSize = 2 * set.length;
		testCapacity(newSize);
		set = Arrays.copyOf(set, newSize);
	}
	
	
	private void testCapacity(int capacity){
		if(capacity > MAXIMUM_CAPACITY){
			throw new IllegalStateException("Tried to create a set that exceeds max capacity of " + MAXIMUM_CAPACITY);
		}
	}

}
