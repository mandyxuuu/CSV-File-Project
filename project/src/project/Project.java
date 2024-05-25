package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Title: Project 1 & 2 & 3 & 4
 * 
 * Description: This is the main class to help the user to find certain information in the CSV file. 
 * 
 * @author Minliang Xu
 */

public class Project {

	public static void main(String[] args) throws Exception  {

		//creates a LinkedList (project1)
		MajorLinkedList unsortedList = new MajorLinkedList();

		//creates a LinkedList (project2)
		MajorOrderLinkedList sortedList = new MajorOrderLinkedList();
		
		//creates a hashtable(project3)
		MajorHashtable hashtable = new MajorHashtable();
		MajorLinkedList copyList = new MajorLinkedList();
		
		//creates a MajorTree (project4)
		MajorTree tree = new MajorTree();
		MajorOrderLinkedList copyListForTree = new 	MajorOrderLinkedList();
		

		//add a enterFileName while loop so the user can enter correct file name (base on project 1 feedback)
		boolean enterFileName = true;
		while (enterFileName) {

			//ask the user for the file name
			System.out.println("Please enter the file name: ");
			Scanner input = new Scanner(System.in);
			String fileName = input.nextLine();
			
		
			try {

				//reads CSV file
				Scanner fileScan = new Scanner(new File(fileName));

				//stores the headers in the array
				String[] headers =  fileScan.nextLine().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

				while(fileScan.hasNext()) {
					//major information split by comma and store into the array
					String[] split = fileScan.nextLine().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

					//check the split array has elements before store into major obejct
					if(split.length == 11) {
						Major majorInfo = new Major(split[0], split[1].replace("\"", ""), split[2].replace("\"", ""),split[3], split[4], 
								split[5], split[6], split[7], split[8], split[9], split[10]);
						
						unsortedList.addToRear(majorInfo);
						
						sortedList.addToRear(majorInfo);
						
						//for storing the hashtable
						copyList.addToRear(majorInfo);
						
						//for storing tree
						copyListForTree.addToRear(majorInfo);
						
					}
				}//end of while loop
		
				
				//ask the user to choose header
				System.out.println("Enter numbers (1 to 10) separated by comma to choose headers to find information:"
						+ "\n(1.Major Name, 2.Major Category, 3.Total Number, 4.Employed Number, 5.Full Time Employed per year, 6.unemployed, 7.unemployed rate 8.median,"
						+ "9.P25th, 10.P75th");

				String [] chooseHeader = input.nextLine().split(",");

				//called the insertSort method
				sortedList.insertSort(chooseHeader);
				
				//add major object to the tree
				while(!copyListForTree.isEmpty()) {
					tree.insertTree(chooseHeader, copyListForTree.removeFirst());
				}
		
				//add major object to the hashtable
				while(!copyList.isEmpty()) {
					hashtable.insert(chooseHeader,copyList.removeFirst());
				}
		
				boolean run = true;

				while(run) {

					System.out.println("Enter the information (separated by comma): ");
					//remove.tolowercase for project 3
					String [] userValue = input.nextLine().split(",");

					//outputs for UNSORTED List
					System.out.println("Here is the information from UNSORTED list: ");
					unsortedList.search(chooseHeader, userValue);
					System.out.println("Number of comparisons: " + unsortedList.getComparisons());
					System.out.println("Total comparisons: " + unsortedList.getTotalComparisons() + "\n");
					unsortedList.setComparisons(0);

					//outputs for SORTEDLIST
					System.out.println("Here is the information from SORTED list: ");
					sortedList.searchForOrderList(chooseHeader, userValue);
					System.out.println("Number of comparisons: " + sortedList.getComparisons());
					System.out.println("Total comparisons: " + sortedList.getTotalComparisons() + "\n");
					sortedList.setComparisons(0);
					
					//outputs for Hashtable
					System.out.println("Here is the information from  HASHTABLE: ");
					hashtable.searchForHash(chooseHeader, userValue);
					System.out.println("Number of comparisons: " + hashtable.getComparisons());
					System.out.println("Total comparisons: " + hashtable.getTotalComparisons() + "\n");
					hashtable.resetComparisons();
					
					//outputs for Tree
					System.out.println("Here is the information from  TREE: ");
					tree.searchTree(chooseHeader, userValue);
					System.out.println("Number of comparisons: " + tree.getComparisons());
					System.out.println("Total comparisons: " + tree.getTotalComparisons() + "\n");
					tree.setComparisons(0);

					System.out.println("________________________________________________________________________________________________________________\n");


					System.out.println("Do you still want to search the file? (Enter 'Y' for yes and 'N' for No): ");
					//updated from next() to nextLine() base on project 1 feedback
					char respond = input.nextLine().toUpperCase().charAt(0);

					//while loop will stop if the input is N
					if(respond == 'N') {
						run = false;
						enterFileName = false;
					}

				}//end of while loop

				fileScan.close();
			}
			catch(FileNotFoundException ex){

				System.out.println("File Not Found.");		
			}
		}//end of while loop for enter file name

	}
}

