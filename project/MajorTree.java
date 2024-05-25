package project;

/**
 * <p>Title: MajorTree.java</p>
 *
 * <p>Description: It's a subclass of BinarySearchTree CLass. </p>
 *
 * @author Minliang Xu
 */

public class MajorTree extends BinarySearchTree <Major>{
	public static int comparisons  = 0;
	public static int totalComparisons = 0;

	public int getComparisons() {
		return comparisons;
	}

	public int getTotalComparisons() {
		return totalComparisons;
	}

	public void setComparisons(int num) {
		comparisons = num;
	}


	public void searchTree(String[]headerArray, String[]userValue) throws Exception  {
		if(root == null){
			throw new EmptyBTreeException("BinarySearchTree is empty!");
		}
		else {

			
			BTreeNode<Major> currentTreeNode = root;
			Major currentMajor = currentTreeNode.getItem();
			

			// Create the temporary Major object, to calculate the hash value
			Major tempMajor = new Major();

			// Assign user-provided values based on the selected headers
			for (int i = 0; i < headerArray.length; i++) {
				switch (headerArray[i].trim()) {
				case "1":
					tempMajor.setMajorName(userValue[i].trim());
					break;
				case "2":
					tempMajor.setMajorCategory(userValue[i].trim());
					break;
				case "3":
					tempMajor.setNumTotal(Integer.parseInt(userValue[i].trim()));
					break;
				case "4":
					tempMajor.setNumEmployed(Integer.parseInt(userValue[i].trim()));
					break;
				case "5":
					tempMajor.setNumFullTime(Integer.parseInt(userValue[i].trim()));
					break;
				case"6":
					tempMajor.setNumUnemployed(Integer.parseInt(userValue[i].trim()));
					break;
				case"7":
					tempMajor.setUnemployedRate(Double.parseDouble(userValue[i].trim()));
					break;
				case"8":

					tempMajor.setMedian(Integer.parseInt(userValue[i].trim()));
					break;
				case"9":
					tempMajor.setP25(Integer.parseInt(userValue[i].trim()));
					break;
				case"10":

					tempMajor.setP75(Float.parseFloat(userValue[i].trim()));
					break;
				default:

					break;
				}
			}
			
			boolean found = false;
			while(currentMajor!= null && !found) {
				//calculating comparisons and total comparisons
				comparisons++;
				totalComparisons++;
				
				if(this.compareHeaders(headerArray, tempMajor, currentMajor) > 0) {
					
					//tempMajor is bigger, go to right side of the tree
					//update both curretTreeNode and currentMajor
					
					if (currentTreeNode.getRight() != null) {
					    currentTreeNode = currentTreeNode.getRight();
					    currentMajor = currentTreeNode.getItem();
					} else {
					    currentMajor = null;
					}

				}else if(this.compareHeaders(headerArray, tempMajor, currentMajor) < 0) {
					
					//tempMajor is smaller, go to left side of the tree
					//update both curretTreeNode and currentMajor
					if (currentTreeNode.getLeft() != null) {
					    currentTreeNode = currentTreeNode.getLeft();
					    currentMajor = currentTreeNode.getItem();
					} else {
					    currentMajor = null;
					}

				}else {
					//once found the item in the tree, print out the match data
					System.out.println(currentMajor.toString());
					found = true;
				
				}
			}
			
			if(currentMajor == null) {
				System.out.println("Based on the input, there is NO MATCH.");
			}
		}//end of else 
	}//end of search method


	public void insertTree(String[]headerArray, Major major) {
		root = insertRecursively(headerArray, root, major);
	}

	// Recursive method to insert a new node
	private BTreeNode<Major> insertRecursively(String[]headerArray, BTreeNode<Major> current, Major major) {
		// Base case: if current is null, return a new node
		if (current == null) {
			return new BTreeNode<Major>(major);
		}

		// Compare the majors using the header array
		int comparison = compareHeaders(headerArray, major, current.getItem());

		// If comparison is less than 0, insert in the left subtree
		if (comparison < 0) {
			current.setLeft(insertRecursively(headerArray, current.getLeft(), major));
		}
		// If comparison is greater than or equal to 0, insert in the right subtree
		else {
			current.setRight(insertRecursively(headerArray, current.getRight(), major));
		}

		return current;
	}



	public int compareHeaders(String[] headerArray, Major m1, Major m2) {

		int compareValue = 0;

		boolean stopSearch = false;
		//boolean invalidHeaderPrinted = false;

		for (int i = 0; i < headerArray.length && !stopSearch; i++) {
			switch(headerArray[i]) {

			//when the two objects has the same information, it will go to the second header to search
			case"1":
				if(m1.compareName(m2.getMajorName())!= 0) {
					compareValue = m1.compareName(m2.getMajorName());
					stopSearch = true;
				}
				break;

			case"2":
				if(m1.compareCategory(m2.getMajorCategory())!= 0) {
					compareValue = m1.compareCategory(m2.getMajorCategory());
					stopSearch = true;
				}
				break;

			case"3":
				if(m1.compareTotal(m2.getNumTotal())!= 0) {
					compareValue = m1.compareTotal(m2.getNumTotal());
					stopSearch = true;
				}
				break;

			case"4":
				if(m1.compareEmployed(m2.getNumEmployed())!= 0) {
					compareValue = m1.compareEmployed(m2.getNumEmployed());
					stopSearch = true;
				}
				break;

			case"5":
				if(m1.compareFullTime(m2.getNumFullTime())!= 0) {
					compareValue = m1.compareFullTime(m2.getNumFullTime());
					stopSearch = true;
				}	

				break;

			case"6":
				if(m1.compareUnemployed(m2.getNumUnemployed())!= 0) {
					compareValue = m1.compareUnemployed(m2.getNumUnemployed());
					stopSearch = true;
				}	
				break;

			case"7":
				if(m1.compareUnemployedRate(m2.getUnemployedRate())!= 0) {
					compareValue = m1.compareUnemployedRate(m2.getUnemployedRate());;
					stopSearch = true;
				}	
				break;

			case"8":
				if(m1.compareMedian(m2.getMedian())!= 0) {
					compareValue = m1.compareMedian(m2.getMedian());
					stopSearch = true;

				}
				break;

			case"9":
				if(m1.compareP25(m2.getP25())!= 0) {
					compareValue = m1.compareP25(m2.getP25());
					stopSearch = true;
				}	
				break;

			case"10":
				if(m1.compareP75(m2.getP75())!= 0) {
					compareValue = m1.compareP75(m2.getP75());
					stopSearch = true;
				}
				break;
			default:

				stopSearch = true;

				break;
			}//end of switch

		}//end of forloop
		return compareValue;
	}// end compareHeader method




}
