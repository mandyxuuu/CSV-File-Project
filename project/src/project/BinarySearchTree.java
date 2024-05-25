package project;

/**
 * <p>Title: BinarySearchTree.java</p>
 *
 * <p>Description: Represents a binary search tree class.</p>
 *
 * @author Minliang Xu
 */
public class BinarySearchTree<T>
{
	//instance variables
	protected BTreeNode<T> root;

	/**
	 * Creates an empty binary search tree. 
	 */
	public BinarySearchTree()
	{
		root = null;
	}

	/**
	 * Creates a binary search tree containing one node.
	 * @param item a reference to the item that will be stored in
	 * the root of this tree
	 */ 
	public BinarySearchTree (T item)
	{
		root = new BTreeNode<T>(item);
	}

	/**
	 * isEmpty method - determines if the tree is empty
	 * @return true if the tree is empty; false otherwise
	 */
	public boolean isEmpty()
	{
		return root == null;
	}

	/**
	 * add - adds the new item to the binary search tree
	 * @param item a reference to the item to be added to this tree
	 */
	public void add(T newItem)
	{
		root = addNode(root, newItem);
	}

	/**
	 * addNode - inserts the new item into its appropriate location
	 * within the tree.
	 * @param current a reference to the current node
	 * @param item a reference to the item to be added to this tree
	 * @return the reference to the new node created to store the new item
	 */
	@SuppressWarnings("unchecked")
	private BTreeNode<T> addNode(BTreeNode<T> current, T item)
	{
		if (current == null)
			current = new BTreeNode<T>(item);
		else if (((Comparable<T>) item).compareTo(current.getItem()) < 0)
			current.setLeft(addNode(current.getLeft(), item));
		else
			current.setRight(addNode(current.getRight(), item));
		return current;
	}

	/**
	 * printInOrder - inOrder print traversal of the BinarySearchTree
	 */
	public void printInOrder() 
	{
		printNodesInOrder(root);
	}

	/**
	 * printNodesInOrder - recursive search through the binary tree to print nodes inorder
	 * within the tree.
	 * @param current a reference to the current node 
	 */
	private void printNodesInOrder(BTreeNode<T> current) 
	{
		if(current != null) {
			printNodesInOrder(current.getLeft());
			System.out.print(current.getItem() + " ");
			printNodesInOrder(current.getRight());
		}
	}

	/**
	 * printPreOrder - preOrder print traversal of the BinarySearchTree
	 */
	public void printPreOrder() 
	{
		printNodesPreOrder(root);
	}

	/**
	 * printNodesPreOrder - recursive search through the binary tree to print nodes preorder
	 * within the tree.
	 * @param current a reference to the current node 
	 */
	private void printNodesPreOrder(BTreeNode<T> current) 
	{
		if(current != null) {
			System.out.print(current.getItem() + " ");
			printNodesPreOrder(current.getLeft());
			printNodesPreOrder(current.getRight());
		}
	}


	/**
	 * printPostOrder - postOrder print traversal of the BinarySearchTree
	 */
	public void printPostOrder() 
	{
		printNodesPostOrder(root);
	}

	/**
	 * printNodesPostOrder - recursive search through the binary tree to print nodes postorder
	 * within the tree.
	 * @param current a reference to the current node 
	 */
	private void printNodesPostOrder(BTreeNode<T> current) 
	{
		if(current != null) {
			printNodesPostOrder(current.getLeft());
			printNodesPostOrder(current.getRight());
			System.out.print(current.getItem() + " ");
		}
	}

	/**
	 * contains - accepts a reference to an item to search for
	 * @param - item, item to search for
	 * @return - true or false depending if item is found
	 */
	public boolean contains(T item) throws Exception{
		if(root == null){
			throw new EmptyBTreeException("BinarySearchTree is empty!");
		}
		return containsItem(root, item);
	}

	/**
	 * containsItem - accepts a reference to an item to search for
	 * @param - current, address of root node
	 * @param item a reference to the item to be added to this tree
	 * @return - true or false depending if item is found
	 */
	@SuppressWarnings("unchecked")
	private boolean containsItem(BTreeNode<T> current, T item){
		if(current == null) {
			return false;
		}
		if(current.getItem().equals(item)) {
			return true; 
		}
		else {
			if(((Comparable<T>)item).compareTo(current.getItem()) < 0)  
				return this.containsItem(current.getLeft(), item);
			else
				return this.containsItem(current.getRight(), item);	
		}
	}

	/**
	 * findMin - searches through the BST using findMinNode to return the minimum value within the BST
	 * @return
	 * @throws Exception
	 */
	public T findMin() throws Exception{
		if(root == null)
			throw new EmptyBTreeException("BinarySearchTree is empty!");
		return findMinNode(root).getItem();
	}

	/**
	 * findMinNode - searches through the BST to find the minimum value node within the BST
	 * @param current, address of the node
	 * @return - the minimum value node
	 */
	private BTreeNode<T> findMinNode(BTreeNode<T> current) {
		if(current.getLeft() == null)
			return current;
		else
			return findMinNode(current.getLeft());
	}

	/**
	 * removeMin - removes the lowest value 
	 * @throws Exception
	 */
	public void removeMin() throws Exception{
		if(root == null) 
			throw new EmptyBTreeException("BinarySearchTree is empty!");
		root = removeMinNode(root);
	}

	/**
	 * removeMinNode - searches through the BinarySaerchTree and removes the lowest value node
	 * @param current
	 * @return current representing the node to remove
	 */
	public BTreeNode<T> removeMinNode(BTreeNode<T> current){
		if(current.getLeft() == null) {
			return current.getRight();
		}
		current.setLeft(removeMinNode(current.getLeft()));
		return current;
	}

	/**
	 * removeMinIteratively - removes the smallest item in the binary search tree iteratively.
	 *
	 * @throws EmptyBTreeException if the tree is empty.
	 */
	public void removeMinIteratively() throws EmptyBTreeException {
		if(root == null) {
			throw new EmptyBTreeException("BinarySearchTree is empty!");
		}
		if(root.getLeft() == null) {
			root = root.getRight();
		} else {
			BTreeNode<T> current = root;
			while(current.getLeft() != null && current.getLeft().getLeft() != null) {
				current = current.getLeft();
			}
			current.setLeft(current.getLeft().getRight());
		}
	}

}


