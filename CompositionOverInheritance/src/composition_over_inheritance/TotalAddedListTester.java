// By Bryan Anders

package composition_over_inheritance;

import java.util.ArrayList;
import java.util.Collection;

/* A short list of tests designed to test the added functionality 
 * of the TotalAddedList rather than an exhaustive test of all 
 * methods and possible exception handling in the Forwarding List. */
public class TotalAddedListTester {

	private static TotalAddedList<Integer> list = 
				new TotalAddedList<Integer>(new ArrayList<Integer>()); 
	
	public static void main(String[] args) {
		System.out.println("Performing Added List Tests");
		
		// Add an integer to the list
		addTest(Integer.MAX_VALUE);
		
		// Add a collection to the list
		Collection<Integer> collection = new ArrayList<Integer>();
		collection.add(0);
		collection.add(1);
		
		addAllTest(collection);
		
		// Delete the same integer twice
		removeTest(Integer.MAX_VALUE);
		removeTest(Integer.MAX_VALUE);
	}
	
	// Adds an integer to the list then checks how
	// many attempted element adds have occurred
	private static void addTest(int value) {
		System.out.println("---------------------------");
		System.out.println("Add Test: ");
		System.out.println("Adding " + value);
		
		// Add the integer and check the result
		try {
			if(list.add(value)) {
				System.out.println("Success: Added " + value);
			} else {
				System.out.println("Error: Failed to add " + value);
			}
		} catch(Exception e) { // single catch for simplicity on this example
			System.err.println("Error in add test.\n" + e.getMessage());
		}
		System.out.printf("The list contains %d items.\n", list.getTotalAdded());
		System.out.println("---------------------------");
	}
	
	// Adds the elements of a collection to the list then
	// checks how many attempted element adds have occurred
	private static void addAllTest(Collection<Integer> collection) {
		System.out.println("---------------------------");
		System.out.println("Add All Test: ");
		
		// Add the integer and check the result
		try {
			if(list.addAll(collection)) {
				System.out.println("Success: The list changed");
			} else {
				System.out.println("Error: The list did not change");
			}
		} catch(Exception e) { // single catch for simplicity on this example
			System.err.println("Error in add all test.\n" + e.getMessage());
		}
		System.out.printf("The list contains %d items.\n", list.getTotalAdded());		
		System.out.println("---------------------------");
	}
	
	// removes an integer from the list then checks the number
	// of attempted element adds to ensure it has not changed.
	private static void removeTest(Integer value) {
		System.out.println("---------------------------");
		System.out.println("Delete Test: ");
		System.out.println("Deleting " + value);
		
		// Add the integer and check the result
		try{
			if(list.remove(value)) {
				System.out.println("Success: Removed " + value);
			} else {
				System.out.println("Error: Could not remove " + value);
			}
		} catch(Exception e) { // single catch for simplicity on this example
			System.err.println("Error in remove test.\n" + e.getMessage());
		}
		System.out.printf("The list contains %d items.\n", list.getTotalAdded());
		System.out.println("---------------------------");
	}
	
}
