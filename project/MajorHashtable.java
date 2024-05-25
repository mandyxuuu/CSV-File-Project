package project;

/**
 * Title: The Hash Table class
 * 
 * Descrption: This class implements a HashTable.
 * 
 * @author Minliang Xu
 *
 */

public class MajorHashtable{

	//instance variables
	private MajorLinkedList[]table;
	private int tableSize;
	private int numElements;
	private int totalComparisons = 0;
	private int comparisons = 0;

	//default constructor
	public MajorHashtable() {
		tableSize = 3;
		table = new MajorLinkedList[tableSize];
		for(int i = 0; i < tableSize; i++) {
			table[i] = new MajorLinkedList();
		}
		numElements = 0;
	}
	public int element() {
		return numElements;
	}
	public int size()
	{
		return tableSize;
	}

	public int getComparisons() {
		return comparisons;
	}

	public int getTotalComparisons() {
		return totalComparisons;
	}

	public void setComparisons(int num) {
		comparisons = num;
	}
	
	public void resetComparisons() {
		for(int i = 0; i < tableSize;i++) {
			table[i].setComparisons(0);
		}
		
	}

	//method that calculate the sum of ascii codes
	private int sumAsciiValues(String str) {
		int sum = 0;
		//loop each character of the string that pass into this method
		for (char c : str.toCharArray()) {
			sum += (int)c;
		}
		return sum;
	}

	//this method calculate the index of the hash table
	private int hash(String[] headerArray, Major major) {
		
		int key = 0;
		for (String header : headerArray) {
			switch (header) {
			case "1":
				key += sumAsciiValues(major.getMajorName());
				break;
			case "2":
				key += sumAsciiValues(major.getMajorCategory());
				break;
			case "3":
				key += major.getNumTotal();
				break;
			case "4":
				key += major.getNumEmployed();
				break;
			case "5":
				key += major.getNumFullTime();
				break;
			case "6":
				key += major.getNumUnemployed();
				break;
			case "7":
				key += sumAsciiValues(Double.toString(major.getUnemployedRate()));
				break;
			case "8":
				key += major.getMedian();
				break;
			case "9":
				key += major.getP25();
				break;
			case "10":
				key += sumAsciiValues(Float.toString(major.getP75()));
				break;
			}
		}
		return key % tableSize;
	}

	//insert method
	public void insert(String [] headerArray, Major major) {
		int index = hash(headerArray, major);
		table[index].addToRear(major);
		numElements++;
		if(numElements == tableSize) {
			resize(headerArray);
		}
	}

	//resize method will double the size of the hash table, and also reorganize the data
	private void resize(String[]headerArray) {
		int oldSize = tableSize;
		tableSize = oldSize*2;
		MajorLinkedList[]newTable = new MajorLinkedList[tableSize];

		//add linkedlist to the new table array
		for (int i = 0; i < tableSize; i++) {
			newTable[i] = new MajorLinkedList();
		}
		// Rehash all existing elements to the new table
		for (int i = 0; i < oldSize; i++) {
			if (table[i] != null) {
				// Iterate through each element in the list at table[i]
				for (Major major : table[i]) {
					// Calculate new hash code based on the new table size
					int newIndex = hash(headerArray, major);
					// Add to the new table
					newTable[newIndex].addToRear(major);
				}
			}
		}
		table = newTable;
	}//end of resize method

	public void searchForHash(String[] headerArray, String[] userValue) {
	
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
		int hashValue = hash(headerArray, tempMajor);

		// Check if the list at the hash index is empty or not
		if (!table[hashValue].isEmpty()) {
			table[hashValue].search(headerArray, userValue);
			//updates the comparisons and total comparisons for the hash table
			comparisons = table[hashValue].getComparisons();
			
		}
		else {
			comparisons = 0;
			System.out.println("Based on the input, there is NO MATCH.");
		}
		totalComparisons += comparisons;
		
	}//end of search method

	public String toString() {
		String str = new String();
		for(int i = 0; i < table.length; i++) {
			str = str + "\nIndex " + i + " : " + table[i];
		}
		return str;
	}

}
