
public class ArrayBag<T> implements BagInterface<T> {

	private T[] bag;
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
	
	private boolean initialized;
	
	public ArrayBag(int capacity){
		
		if(capacity < MAX_CAPACITY){
		bag = (T[])new Object[capacity];
		numberOfEntries = 0;
		initialized = true;
		} else{
			throw new IllegalStateException("Attempt to create a bag larger than " + MAX_CAPACITY);
		}
	}
	
	public ArrayBag(){
		this(DEFAULT_CAPACITY);
	}
	
	private void checkInitialization(){
		if(!initialized){
			throw new SecurityException("Array is not initialized");
		}
	}
	
	private boolean isArrayFull(){
		return numberOfEntries >= bag.length;
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
		checkInitialization();
		boolean result = false;
		if(!isArrayFull()){
			bag[numberOfEntries] = newEntry;
			numberOfEntries++;
			result = true;
		}
		return result;
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
		checkInitialization();
		@SuppressWarnings("unchecked")
		T[] output = (T[]) new Object[numberOfEntries];
		for(int i = 0; i<output.length; i++){
			output[i] = bag[i];
		}
		return output;
	}

}
