package project;


/**
 * <p>Title: LinkedList.java</p>
 *
 * <p>Description: Represents a linked implementation of a list. The front of
 * the list is referenced by first and the back of the list is referenced by last. 
 * This class will be extended to create a specific kind of list.</p>
 *
 * @author Minliang Xu
 */
public class LinkedList<E>
{
	protected int count;
	protected Node<E> first, last;

	/**
	 * default constructor --
	 * Creates an empty list.
	 */
	public LinkedList()
	{
		count = 0;
		first = last = null;
	}

	/**
	 * size --
	 * returns a count of the number of items in the list.
	 * @return the number of items currently in the list
	 */
	public int size()
	{
		return count;
	}

	/**
	 * isEmpty --
	 * determines whether or not the list is empty.
	 * @return true if this list is empty; false otherwise
	 */
	public boolean isEmpty()
	{
		return count == 0;
	}

	/**
	 * first --
	 * returns a reference to the item at the front of the list. The item
	 * is not removed from the list.
	 * @return a reference to the first item in the list
	 * @throws EmptyListException if the list is empty
	 */
	public E first()
	{
		if (isEmpty())
			throw new EmptyListException("List is empty!");

		return first.getItem();
	}

	/**
	 * last -- 
	 * returns a reference to the item at the end of the list. The item
	 * is not removed from the list.
	 * @return a reference to the last item in the list
	 * @throws EmptyListException if the list is empty
	 */
	public E last()
	{
		if (isEmpty())
			throw new EmptyListException("List is empty!");

		return last.getItem();
	}

	/**
	 * addToFront -- 
	 * adds a new item to the beginning of the list.
	 * @param item a reference to the item to add to the list
	 */
	public void addToFront(E item)
	{
		first = new Node<E>(item, first);
		if (last == null)
			last = first;
		count++;
	}


	/**
	 * addToRear -- 
	 * adds a new item to the end of the list.
	 * @param item a reference to the item to add to the list
	 */
	public void addToRear(E item)
	{
		Node<E> aNode = new Node<E>(item, null);
		if(isEmpty()) {
			last = first = aNode;
		}
		else {
			last.setNext(aNode);
			last = aNode;
		}
		count++;

	}

	/**
	 * addAfter --
	 * adds the new item after the specified target.
	 * @param item a reference to the new item to be added
	 * @param target a reference to the item to be located in the list
	 * @throws ElementNotFoundException if the target is not found in the list
	 */
	public void addAfter (E item, E target)
	{
		Node<E> current = first;
		Node<E> aNode = new Node<E>(item);

		while (current != null && !current.getItem().equals(target)) {
			current = current.getNext();

		}
		if (current == null) {
			throw new ElementNotFoundException("Element doesn't exist in this list.");
		}
		aNode.setNext(current.getNext());
		current.setNext(aNode);
		count++;

	}

	/**
	 * contains --
	 * returns true if the list contains the specified target.
	 * @param target a reference to the item to be located
	 * @return true if the target is found; false otherwise
	 */
	public boolean contains (E target)
	{
		if (isEmpty())
			throw new EmptyListException("List is empty!");

		boolean found = false;

		Node<E> current = first;

		while (current != null && !found)
		{
			if (target.equals(current.getItem()))
				found = true;
			else
				current = current.getNext();
		}

		return found;
	}
	

	/**
	 * removeFirst -- 
	 * removes and returns the first item in the list.
	 * @return a reference to what was the first item in the list
	 * @throws EmptyListException if the list is empty
	 */
	public E removeFirst()
	{
		if(isEmpty())
			throw new EmptyListException("List is empty!");

		Node<E> current = first;
		if(count == 1) {
			first = last = null;
		}
		else {
			first = first.getNext();
		}
		count--;
		return current.getItem();	

	}	


	/**
	 * toString --
	 * returns a string representation of the list.
	 * @return a reference to a String containing the items in the list
	 */
	public String toString()
	{
		Node<E> current = first;
		String result = new String();

		while (current != null)
		{
			result = result + current.getItem().toString() + "\n";
			current = current.getNext();
		}

		return result;
	}


}