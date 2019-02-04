/** A test of the methods remove and clear, as defined in the class LinkedBag.
    Assumes the remaining methods are correct.
    NB: Version 3 of LinkedBag is the same as the final version. This driver tests only
    the additional methods. LinkedBagDemo tests all of the methods.
    @author Frank M. Carrano
    @author Timothy M. Henry
    @version 4.0
*/
public class LinkedBagDemo3
{
	public static void main(String[] args) 
	{
		BagInterface<String> aBag = new LinkedBag<>();
      
      // Removing a string from an empty bag:
      String[] testStrings1 = {"", "B"};
      testRemove(aBag, testStrings1);

      // adding strings
		String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};
		testAdd(aBag, contentsOfBag1);
		
      // removing strings
		String[] testStrings3 = {"", "B", "A", "C", "Z"};
      testRemove(aBag, testStrings3);

		System.out.println("\nClearing the bag:");
		aBag.clear();
      testIsEmpty(aBag, true);
		displayBag(aBag);
   } // end main
   
   // Tests the method add.
	private static void testAdd(BagInterface<String> aBag, String[] content)
	{
		System.out.print("Adding to the bag: ");
		for (int index = 0; index < content.length; index++)
		{
			aBag.add(content[index]);
         System.out.print(content[index] + " ");
		} // end for
      System.out.println();
      
		displayBag(aBag);
	} // end testAdd

   // Tests the method isEmpty.
   // correctResult indicates what isEmpty should return.   
	private static void testIsEmpty(BagInterface<String> aBag, boolean correctResult)
	{
      System.out.print("\nTesting the method isEmpty with ");
      if (correctResult)
         System.out.println("an empty bag:");
      else
         System.out.println("a bag that is not empty:");
      
      System.out.print("isEmpty finds the bag ");
      if (correctResult && aBag.isEmpty())
			System.out.println("empty: OK.");
		else if (correctResult)
			System.out.println("not empty, but it is empty: ERROR.");
		else if (!correctResult && aBag.isEmpty())
			System.out.println("empty, but it is not empty: ERROR.");
		else
			System.out.println("not empty: OK.");      
	} // end testIsEmpty

   // Tests the method getFrequencyOf.
	private static void testFrequency(BagInterface<String> aBag, String[] tests)
	{
 		System.out.println("\nTesting the method getFrequencyOf:");
      for (int index = 0; index < tests.length; index++)
         System.out.println("In this bag, the count of " + tests[index] + 
                            " is " + aBag.getFrequencyOf(tests[index]));
   } // end testFrequency
   
   // Tests the method contains.
	private static void testContains(BagInterface<String> aBag, String[] tests)
	{
 		System.out.println("\nTesting the method contains:");
      for (int index = 0; index < tests.length; index++)
         System.out.println("Does this bag contain " + tests[index] + 
                            "? " + aBag.contains(tests[index]));
   } // end testContains

   // Tests the two remove methods.
	private static void testRemove(BagInterface<String> aBag, String[] tests)
	{
      System.out.println("\nTesting the two remove methods:");
      for (int index = 0; index < tests.length; index++)
      {
         String aString = tests[index];
         if (aString.equals("") || (aString == null))
         {
            // test remove()
            System.out.println("\nRemoving a string from the bag:");
            String removedString = aBag.remove();
            System.out.println("remove() returns " + removedString);
         }
         else
         {
            // test remove(aString)
            System.out.println("\nRemoving \"" + aString + "\" from the bag:");
            boolean result = aBag.remove(aString);
            System.out.println("remove(\"" + aString + "\") returns " + result);
         } // end if
         
         displayBag(aBag);
      } // end for
	} // end testRemove
   
   // Tests the method toArray while displaying the bag.
	private static void displayBag(BagInterface<String> aBag)
	{
		System.out.println("The bag contains " + aBag.getCurrentSize() +
		                   " string(s), as follows:");		
		Object[] bagArray = aBag.toArray();
		for (int index = 0; index < bagArray.length; index++)
		{
			System.out.print(bagArray[index] + " ");
		} // end for
		
		System.out.println();
	} // end displayBag
} // end LinkedBagDemo3

/*
 Testing the two remove methods:
 
 Removing a string from the bag:
 remove() returns null
 The bag contains 0 string(s), as follows:
 
 
 Removing "B" from the bag:
 remove("B") returns false
 The bag contains 0 string(s), as follows:
 
 Adding to the bag: A A B A C A
 The bag contains 6 string(s), as follows:
 A C A B A A
 
 Testing the two remove methods:
 
 Removing a string from the bag:
 remove() returns A
 The bag contains 5 string(s), as follows:
 C A B A A
 
 Removing "B" from the bag:
 remove("B") returns true
 The bag contains 4 string(s), as follows:
 A C A A
 
 Removing "A" from the bag:
 remove("A") returns true
 The bag contains 3 string(s), as follows:
 C A A
 
 Removing "C" from the bag:
 remove("C") returns true
 The bag contains 2 string(s), as follows:
 A A
 
 Removing "Z" from the bag:
 remove("Z") returns false
 The bag contains 2 string(s), as follows:
 A A
 
 Clearing the bag:
 
 Testing the method isEmpty with an empty bag:
 isEmpty finds the bag empty: OK.
 The bag contains 0 string(s), as follows:

*/
