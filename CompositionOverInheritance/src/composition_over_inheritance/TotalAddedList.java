// By Bryan Anders
// Inspired by Joshua Bloch's Effective Java Item #16

package composition_over_inheritance;

import java.util.Collection;
import java.util.List;

/* This class is a List equivilant of the InstrumentedSet shown on page
 * 84 of Effective Java Second Edition. It uses composition rather than
 * class inheritance to gain the functionality of any List without the 
 * downsides of inheriting from an implemented List class. Some of
 * these downsides are:
 * 1) Internal behavior of the super class may be unpredictable when
 *    called from a subclass.
 * 2) Overriding of super class can be difficult or even impossible if
 *    the original implementation relies on private fields in the
 *    superclass.
 * 3) Super classes can have their functionality expanded later in a way
 *    that could undermine the subclass. This includes the super class
 *    adding a new method that happens to have the same signature
 *    as a method previously implemented in the subclass. If the method
 *    is changed to be an override you only swap downsides.
 *
 * Composition should be preferred over inheritance when an "is a"
 * relationship does not hold for all use cases of a potential subclass. 
 * 
 * Downsides of this wrapper style of implementation are fewer.
 * 1) Wrapper classes can have problems with callbacks because
 *    the list which is passed in as a parameter to this
 *    class' constructor does not know about this wrapper.
 *    If the List is passed into a callback method, then the
 *    callback method does not know about this wrapper either. 
 * 2) There is a slight performance hit involved in using
 *    forwarding methods. */
public class TotalAddedList<E> extends ForwardingList<E> {

	/* Counts the total number of attempts to add elements 
	 * to the list regardless of whether they are later deleted. */
	private int totalAdded = 0;
	
	// The constructor simply allocates a ForwardingList
	public TotalAddedList(List<E> list) {
		super(list);
	}
	
	// Increments the number of elements the list add attempts
	@Override
	public boolean add(E e) throws UnsupportedOperationException,
								   ClassCastException,
								   NullPointerException,
								   IllegalArgumentException,
								   IndexOutOfBoundsException
	{
		totalAdded++;
		return super.add(e);
	}
	
	/* Increments the number of list add attempts 
	 * by the size of the collection then calls the 
	 * ForwardingList addAll(Collection<? extends E> c) method. */
	@Override
	public boolean addAll(Collection<? extends E> c) throws UnsupportedOperationException,
														  	ClassCastException,
														  	NullPointerException,
														  	IllegalArgumentException,
														  	IndexOutOfBoundsException
	{		
		totalAdded += c.size();
		return super.addAll(c);
	}

	// get the total number of elements added to the list
	public int getTotalAdded() { return totalAdded; }

}
