// By Bryan Anders
// Inspired by Joshua Bloch's Effective Java Item #16

package composition_over_inheritance;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* This class serves as a forwarding class that can be reused
 * to 
 */
public class ForwardingList<E> implements List<E> {
	
	// The list that will actually store things
	private final List<E> internalList;
	
	
	public ForwardingList(List<E> list) {
		if(list == null) {
			throw new NullPointerException();
		}
		
		internalList = list;
	}
	
	/* All of the following overwrites simply call
	 * methods on the internal list; */
	
	@Override
	public boolean add(E e) throws UnsupportedOperationException,
									  ClassCastException,
									  NullPointerException,
									  IllegalArgumentException,
									  IndexOutOfBoundsException 
	{
		return internalList.add(e);
	}

	@Override
	public void add(int index, E e) throws UnsupportedOperationException,
											  ClassCastException,
											  NullPointerException,
											  IllegalArgumentException,
											  IndexOutOfBoundsException
	{
		internalList.add(index, e);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) throws UnsupportedOperationException,
														  	ClassCastException,
														  	NullPointerException,
														  	IllegalArgumentException,
														  	IndexOutOfBoundsException
	{
		return internalList.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) 
											throws UnsupportedOperationException,
									 	   		   ClassCastException,
									 	   		   NullPointerException,
									 	   		   IllegalArgumentException,
									 	   		   IndexOutOfBoundsException
	{
		return internalList.addAll(index, c);
	}

	@Override
	public void clear() throws UnsupportedOperationException {
		internalList.clear();
	}

	@Override
	public boolean contains(Object o) throws ClassCastException,
											 NullPointerException
	{
		return internalList.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) throws ClassCastException,
	 												   NullPointerException
	{
		return internalList.containsAll(c);
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		return internalList.get(index);
	}

	@Override
	public int indexOf(Object o) throws ClassCastException,
										NullPointerException
	{
		return internalList.indexOf(o);
	}

	@Override
	public boolean isEmpty() {
		return internalList.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		return internalList.iterator();
	}

	@Override
	public int lastIndexOf(Object o) throws ClassCastException,
									  	    NullPointerException
	{
		return internalList.lastIndexOf(o);
	}

	@Override
	public ListIterator<E> listIterator() {
		return internalList.listIterator();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return internalList.listIterator(index);
	}

	@Override
	public boolean remove(Object o) throws ClassCastException,
										   NullPointerException,
										   UnsupportedOperationException
	{
		return internalList.remove(o);
	}

	@Override
	public E remove(int index) throws UnsupportedOperationException,
	   								  IndexOutOfBoundsException
	{
		return internalList.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> c) throws UnsupportedOperationException,
													 ClassCastException,
													 NullPointerException
	{	
		return internalList.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) throws UnsupportedOperationException,
	 													ClassCastException,
	 													NullPointerException
	{
		return internalList.retainAll(c);
	}

	@Override
	public E set(int index, E e) throws UnsupportedOperationException,
										ClassCastException,
										NullPointerException,
										IllegalArgumentException,
										IndexOutOfBoundsException
	{
		return internalList.set(index, e);
	}

	@Override
	public int size() {
		return internalList.size();
	}

	@Override
	public List<E> subList(int from, int to) throws IndexOutOfBoundsException {
		return internalList.subList(from, to);
	}

	@Override
	public Object[] toArray() {
		return internalList.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) throws ArrayStoreException,
										 NullPointerException
	{
		return internalList.toArray(a);
	}

}
