package project;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <p>Title: MajorLinkedList.java</p>
 *
 * <p>Description: It's a subclass of LinkedList CLass. </p>
 *
 * @author Minliang Xu
 */

public class MajorLinkedList extends LinkedList<Major> implements Iterable<Major> {


	/**
	 * default constructor --
	 * creates an empty list.
	 */
	public MajorLinkedList()
	{
		super();


	}

	protected int comparisons  = 0;
	protected int totalComparisons = 0;

	public int getComparisons() {
		return comparisons;
	}

	public int getTotalComparisons() {
		return totalComparisons;
	}
	
	public void setComparisons(int num) {
		comparisons = num;
	}

	/*
	 * Search
	 * This method is to search certian information from the MajorLinkedList
	 * @param HeadersArray - headers chose from the users
	 * @param userValue - values that user enter
	 */

	public void search(String[]headerArray, String[]userValue) {

		Integer compareValue = null;
		
		//to track if the userValued has been found
		boolean found = false;
		
		MajorLinkedListIterator iterator = new MajorLinkedListIterator();

		boolean fullStop = false;

		//user iterator to loop the list
		while(iterator.hasNext() && !fullStop) {
			
			//user iterator to loop the list
			Major majorIterator1 = iterator.next();

			//because the user can put multiple values, we search the value one by one
			//if first value has been found or not found, tempStop will be true and search for second value

			boolean tempStop = false;

			//loop will stop base on how many headers that the user choose
			for(int i = 0; i < headerArray.length && !tempStop ; i++) {

				//increment comparisons and total comparisons
				comparisons++;

				totalComparisons++;
	
				
				switch(headerArray[i].trim()) {
				case "1":

					compareValue = majorIterator1.compareName(userValue[i].trim());

					break;

				case "2":
					compareValue = majorIterator1.compareCategory(userValue[i].trim());

					break;

				case "3":
					compareValue = majorIterator1.compareTotal(Integer.parseInt(userValue[i].trim()));

					break;

				case "4":
					compareValue = majorIterator1.compareEmployed(Integer.parseInt(userValue[i].trim()));


					break;

				case "5":
					compareValue = majorIterator1.compareFullTime(Integer.parseInt(userValue[i].trim()));


					break;

				case "6":
					compareValue = majorIterator1.compareUnemployed(Integer.parseInt(userValue[i].trim()));

					break;

				case "7":
					compareValue = majorIterator1.compareUnemployedRate(Double.parseDouble(userValue[i].trim()));

					break;

				case "8":

					compareValue = majorIterator1.compareMedian(Integer.parseInt(userValue[i].trim()));

					break;

				case "9":

					compareValue = majorIterator1.compareP25(Integer.parseInt(userValue[i].trim()));

					break;

				case "10":
					compareValue = majorIterator1.compareP75(Float.parseFloat(userValue[i].trim()));

					break;

				default:
					fullStop = true;
					tempStop = true;
					break;

				}//end of swtich
				   // If any comparison doesn't match, set tempStop to true to continue with the next iteration
	            if (compareValue != 0) {
	                tempStop = true;
	            }
	            
			}//end for headerArray loop


			//once search is sucessfully
			if(!fullStop && !tempStop) {
				// found the value from the CSC file
				found = true;
				System.out.println(majorIterator1.toString());
				break;

			}

		}//end of while loop
		
		//if can't find the file base on the userValue
		if(found == false){
			System.out.println("Based on the input, there is NO MATCH.");
		}

	}//end of search method


	/*
	 * compareHeaders 
	 * This method to compare the values of the headers, base on the user choose
	 * @param HeadersArray - headers chose from the users
	 * @param m1 - first Majors object passed to this method
	 * @param m2 - second Majors object passed to this method
	 * @return the number of comparison between m1 and m2
	 */
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


	public Iterator<Major> iterator(){
		return new MajorLinkedListIterator();
	}

	class MajorLinkedListIterator implements Iterator<Major>{

		//instance variable
		private Node<Major>current;
		private Node<Major>prev1;
		private Node<Major>prev2;



		public MajorLinkedListIterator() {
			current = first;
		}

		/**
		 * Next - find next element in the literation
		 * @return next element in the iteration
		 */
		public Major next() {
			if(current == null) {
				throw new NoSuchElementException();
			}
			Major temp = current.getItem();
			prev2 = prev1;
			prev1 = current;
			current = current.getNext();
			return temp;
		}
		/*
		 * hasNext
		 * this method is to check if iteration has more elements or not.
		 * @return true if the iteration has more elements
		 */
		public boolean hasNext() {
			return current != null;
		}

	}//end of iterator


}
