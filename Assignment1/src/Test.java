/**
   Chapter 2, Project3.
   Testing class
  
*/
public class Test
{
	public static void main(String[] args)
	{
		String[] contents = {"A", "B", "C", "D", "A", "C", "B", "B"};

		SetInterface<String> aSet = new ArraySet<>();

		for (String s : contents) {
			aSet.add(s);
		}
		displaySet(aSet);

		SetInterface<String> set1 = new ArraySet<>();
		SetInterface<String> set2 = new ArraySet<>();
		
		// Initial capacity is 3
		System.out.println("Set 1 initial state ");
		displaySet(set1);

		set1.add("A");
		set1.add("A");
		set1.add("B");
		set1.add("A");
		set1.add("C");
		set1.add("A");

		System.out.println("Set 1 after adding elements is ");
		displaySet(set1);

		set1.add("V");
		set1.add("V");
		set1.add("T");
		set1.add("U");
		set1.add("V");
		set1.add("W");
		set1.add("X");
		set1.add("Y");
		set1.add("Z");

		System.out.println("Set 1 after adding and resizing is ");
		displaySet(set1);

		set2.add("A");
		set2.add("B");
		set2.add("B");
		set2.add("A");
		set2.add("C");
		set2.add("C");
		set2.add("D");
		set2.add("E");
		set2.add("F");
		set2.add("G");
		set2.add("H");

		System.out.println("Set 2 after adding and resizing is ");
		displaySet(set2);

		System.out.println("Set 1 contains A: " + set1.contains("A"));
		System.out.println("Set 1 contains E: " + set1.contains("E"));

		set1.remove("B");
		System.out.println("After removing B from set 1, it contains");
		displaySet(set1);

		System.out.println("After removing " + set1.remove()
				+ " from set 1, it contains");
		displaySet(set1);
	} // end main


	// Displays a set.
	private static void displaySet(SetInterface<String> aSet)
	{
		System.out.print("The set contains " + aSet.getCurrentSize()
				+ " string(s), as follows:\t");
		
		Object[] setArray = aSet.toArray();
		for (int index = 0; index < setArray.length; index++)
		{
			System.out.print(setArray[index] + " ");
		} // end for

		System.out.println();
	} // end displaySet

} // end Project3