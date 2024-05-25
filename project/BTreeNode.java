package project;

/**
 * <p>Title: BTreeNode.java</p>
 *
 * <p>Description: Defines a binary tree node class capable of 
 * storing an object reference and a reference to the left and right
 * subtrees. Accessors and mutators are defined for all instance variables.</p>
 */
public class BTreeNode<T>
{
	private T data;
	private BTreeNode<T> left, right;

	/**
	 * default constructor --
	 * creates an empty node; the left and right subtrees are empty.
	 */
	public BTreeNode()
	{
		data = null;
		left = right = null;
	}

	/**
	 * parameterized constructor --
	 * creates a node storing the new item; the left and right subtrees 
	 * are empty.
	 */
	public BTreeNode(T newItem)
	{
		data = newItem;
		left = right = null;
	}

	/**
	 * getItem --
	 * returns the item stored in this node
	 * @return a reference to the item in this node
	 */
	public T getItem()
	{
		return data;
	}

	/**
	 * getLeft --
	 * returns the left subtree of this node
	 * @return a reference to the left subtree
	 */
	public BTreeNode<T> getLeft()
	{
		return left;
	}

	/**
	 * getRight --
	 * returns the right subtree of this node
	 * @return a reference to the right subtree
	 */
	public BTreeNode<T> getRight()
	{
		return right;
	}

	/**
	 * setItem --
	 * stores a new item in this node
	 * @param newItem a reference to the new item to be stored
	 */
	public void setItem(T newItem)
	{
		data = newItem;
	}

	/**
	 * setLeft --
	 * stores a new value as the left subtree
	 * @param child a reference to the left subtree to be stored
	 */
	public void setLeft(BTreeNode<T> child)
	{
		left = child;
	}

	/**
	 * setRight --
	 * stores a new value as the right subtree
	 * @param child a reference to the right subtree to be stored
	 */
	public void setRight(BTreeNode<T> child)
	{
		right = child;
	}
}

