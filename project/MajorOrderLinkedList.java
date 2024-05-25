package project;
/**
 * <p>Title: MajorOrderLinkedList.java</p>
 *
 * <p>Description: It's a subclass of MajorLinkedList CLass. </p>
 *
 * @author Minliang Xu
 */
public class MajorOrderLinkedList extends MajorLinkedList{
	/**
	 * default constructor --
	 * creates an empty list.
	 */
	public MajorOrderLinkedList()
	{
		super();

	}

	/*
	 * searchForOrderList
	 * This method is to search certian information only for MajorOrderlist 
	 * @param HeadersArray - headers chose from the users
	 * @param userValue - values that user enter
	 */


	public void searchForOrderList(String[]headerArray, String[]userValue) {

		Integer compareValue = null;

		//to track if the userValued has been found
		boolean found = false;

		MajorLinkedListIterator iterator = new MajorLinkedListIterator();

		boolean fullStop = false;

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

				//each value in the list compares to user's value
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

				//if the value in the list is smaller than the user's value, go to next value and keep searching
				if(compareValue  < 0) {
					tempStop = true;
				}
				//otherwise the list goes too far, will terminate searching
				else if  (compareValue > 0){

					tempStop = true;
					fullStop = true;
				}
			}//end for headerArray loop
			
			// If the comparison results are not equal, set tempStop to true
            if (compareValue != 0) {
                tempStop = true;
            }

			//once it's fully stop and compareValue is 0 means the value in the list match the value that user enter
			if(!fullStop && !tempStop && compareValue == 0) {
				// found the value from the CSC file
				found = true;
				System.out.println(majorIterator1.toString());
				break;

			}
			
			 // If the compareValue is greater than 0, it means the list has gone too far, and we need to terminate the search
	        if (compareValue != null && compareValue > 0) {
	            fullStop = true;
	        }

		}//end of LIST iterator while loop

		//if can't find the file base on the userValue
		if(!found){
			System.out.println("Based on the input, there is NO MATCH.");
		}

	}//end of search method



	/**
	 * insertSort - this method will sort the MajorsLinkedlist by orders
	 * @param headerArray - the string Array, which is the specific headers that user chose
	 */
	public void insertSort(String [] headerArray) {
		Node<Major> current = first;
		Node<Major> sorted = null;

		while (current != null) {
			totalComparisons++;
			Node<Major> next = current.getNext();
			if (sorted == null || this.compareHeaders(headerArray, sorted.getItem(), current.getItem()) >= 0) {
				current.setNext(sorted);
				sorted = current;
			} else  {
				Node<Major> search = sorted;
				while (search.getNext() != null && this.compareHeaders(headerArray,search.getNext().getItem(), current.getItem() ) < 0) {
					search = search.getNext();

				}
				current.setNext(search.getNext());
				search.setNext(current);
			}
			current = next;
		}

		first = sorted;
	}

}
