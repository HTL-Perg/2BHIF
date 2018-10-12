package at.ac.htl.perg.bhif17all.array_menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * A menu where the user can edit an array
 * 
 * Customer: Christian Aberger
 * 
 * @author Julian Hofstadler, Jonathan Hocheneder
 *
 */
public class ArrayMenu {
	/**
	 * The array with the menu
	 */
	double[] array = { 4, 7, 2, 8, 3, 8, 5, 1, 9, 10, 15 };
	/**
	 * Determines if the program is running
	 */
	boolean running = true;
	/**
	 * The scanner to take the input from
	 */
	Scanner scanner = new Scanner(System.in);

	/**
	 * Show an input dialog where the user can edit the array
	 */
	void showInputDialog() {
		printSelectionInfo(); // Print the options the user has
		System.out.printf("Choose a number from 1-9%n");
		try { // Try to get a numeric input
			int input = scanner.nextInt();
			switch (input) { // Switch trough the options the user has chosen
			case 1:
				array = append(array); // Set the array to a clone with an appended value
				break;
			case 2:
				array = insert(array); // Set the array to a clone with an inserted value
				break;
			case 3:
				array = delete1(array); // Set the array to a clone with a deleted index
				break;
			case 4:
				array = delete2(array); // Set the array to a clone with a deleted values
				break;
			case 5:
				search(array); // Search an element
				break;
			case 6:
				array = sort(array); // Sort the array
				break;
			case 7:
				array = randommix(array); // Set the array to a randomly mixed version
				break;
			case 8:
				output(array); // Print the array
				break;
			case 9:
				running = false; // Terminate the program
				System.err.println("Shutting down!!!");
				break;
			default:
				System.err.println("Error invalid input!");
				break;
			}

		} catch (InputMismatchException e) { // And shut down if its not a number
			System.err.println("Invalid input! Please restart the program!");
			running = false;
		}
	}

	/**
	 * Prints the options the user can select
	 */
	private void printSelectionInfo() {
	
		ArrayMenuOperation[] operation =  new ArrayMenuOperation [9];
		int i = 0;
		
		operation[i++] = new AppendOperation();
		
		ArrayMenuOperation insert = new ArrayMenuOperation();
		insert.name = "Insert";
		operation[i++] = insert;
		
		ArrayMenuOperation deleteAnIndex = new ArrayMenuOperation();
		deleteAnIndex.name = "deleteAnIndex";
		operation[i++] = deleteAnIndex;
		
		ArrayMenuOperation deleteAnElement = new ArrayMenuOperation();
		deleteAnElement.name = "deleteAnElement";
		operation[i++] = deleteAnElement;
		/*
		ArrayMenuOperation append = new ArrayMenuOperation();
		append.name = "Append";
		operation[i++] = "Seatch an Element";
		ArrayMenuOperation append = new ArrayMenuOperation();
		append.name = "Append";
		operation[i++] = "Sort";
		ArrayMenuOperation append = new ArrayMenuOperation();
		append.name = "Append";
		operation[i++] = "Random mix";
		ArrayMenuOperation append = new ArrayMenuOperation();
		append.name = "Append";
		operation[i++] = "Print Array";
		ArrayMenuOperation append = new ArrayMenuOperation();
		append.name = "Append";
		operation[i++] = "Terminate";
		*/
 	
		for (int j = 0; j < i; j++) {
			ArrayMenuOperation op = operation[j];
			System.out.println("(" + (j+1) +")" + " " + op.name);
		}
	
	}

	/**
	 * Prints the array
	 * 
	 * @param array - The array to print
	 */
	private void output(double[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	/**
	 * Sorts the array
	 * 
	 * @param array The Array to Sort
	 * @return The sorted Array
	 */
	private double[] sort(double[] array) {
		// If length <= 1 return the array
		if (array.length <= 1) {
			return array;
		} else {
			// Recursive merge 2 Halfs of the Array
			return merge(sort(Arrays.copyOfRange(array, 0, array.length / 2)),
					sort(Arrays.copyOfRange(array, array.length / 2, array.length)));
		}
	}

	private double[] randommix(double[] ar) {

		double temp[] = new double[ar.length]; // Temporary array
		double usedLocations[] = new double[ar.length]; // auxiliary array
		usedLocations = fillArray(usedLocations, -1); // Fills the auxiliary array with -1
		int currentLocation = -1; // Saves the current location
		boolean LocationOKAY = false; // Check if the place was used

		for (int i = 0; i < ar.length; i++) { // Run through the array once
			for (int j = 0; j < 1;) { // Runs until a possible position has been found
				LocationOKAY = true; // Assumed that the position is ok
				currentLocation = (int) (Math.random() * ar.length); // Creates a random spot
				for (int k = 0; k < usedLocations.length; k++) {
					if (usedLocations[k] == currentLocation) { // Searches the array if the location has already been
																// used
						LocationOKAY = false;
					}
				}
				if (LocationOKAY == true) {
					j++;
				}
			}

			temp[i] = ar[currentLocation];
			usedLocations[i] = currentLocation;
		}

		return temp;

	}

	private static double[] fillArray(double[] usedLocations, double numToFill) {

		for (int i = 0; i < usedLocations.length; i++) { // Array is filled with a certain number
			usedLocations[i] = numToFill;
		}

		return usedLocations;

	}

	private void search(double[] ar) {
		System.out.println("Which number do you want to search?");
		double numToFind = scanner.nextInt(); // Input from keyboard
		int place = -1; // the saved location
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] == numToFind) { // Check if the number was found in the array
				place = i + 1; // memory location
			}
		}
		if (place == -1) { // The number wasn't found
			System.err.println("The number wasn't found!");
		} else { // The number was found
			System.out.println("The number is on the " + place + ". location");
		}
	}

	private double[] delete2(double[] array) {
		return null;
	}

	private double[] delete1(double[] array) {
		System.err.println("Not working!");
		// TODO: Fix delete1
		if (array.length == 0 || array.length < 0) {
			System.out.print("The Array is too short. It has to be over 0!");
		}
		double[] arrayWithDeletedObject = new double[array.length - 1]; // creates new int Array with one space less

		System.out.println("Enter the index you want to delete");
		int input = scanner.nextInt();

		for (int i = 0; i < array.length - 1; i++) {
			if (i < input) {
				arrayWithDeletedObject[i] = array[i];
			} else {
				if (i >= input) {
					arrayWithDeletedObject[i] = array[i++];
				} else {
					System.err.println("An unknown error ocurred");
				}
			}
		}

		return arrayWithDeletedObject;
	}

	private double[] insert(double[] array) {
		System.out.println("Choose the location:");
		int location = scanner.nextInt();
		System.out.println("Choose the Insert-Number:");
		double numToInsert = scanner.nextDouble();
		
		if (location > array.length) {						//If the location is bigger than the array length
			System.out.println("Not a valid location!");	//then the originally array is being returned
			return array;
		} else {
			double[] newArr = new double[array.length + 1];	//Copy of the handed array
			int j = 0;										//Second counter for the array with a smaller length

			for (int i = 0; i < newArr.length; i++) {		
				if (i == location) {						//If i equals the handed location then
					newArr[i] = numToInsert;				//Insert the number 'numToInsert' into the location 'location'
				} else {
					newArr[i] = array[j];					//Else, the array 'array' is copied to the new array 'newArr'
					j++;
				}
			}
			return newArr;
		}
	}

	private double[] append(double[] array) {

		double[] array2 = new double[1]; // A second array was created with space for one number.

		for (int y = 0; y < array2.length; y++) {
			System.out.println("Which number do you want to add?");
			array2[y] = scanner.nextInt(); // The one number what will be added to the array is given by the user.
		}

		double[] arraycombined = new double[array.length + array2.length]; // The third array is the first and second
																			// array combined.

		for (int i = 0; i < arraycombined.length; i++) { // The combined array getting filled with the numbers of both
															// arrays.
			if (i < array.length) {
				arraycombined[i] = array[i];
			} else {
				arraycombined[i] = array2[i - array.length];

			}
		}
		for (int k = 0; k < arraycombined.length; k++) {
			System.out.print(arraycombined[k] + " ");
		}
		System.out.println();
		return arraycombined;
	}

	/*
	 * Merges 2 Arrays in Correct order
	 * 
	 * @param first First Array
	 * 
	 * @param second Second Array
	 * 
	 * @return The 2 Arrays merged in correct order
	 */
	private static double[] merge(double[] first, double[] second) {
		// Using Lists because arrays are gack
		List<Double> merged = new ArrayList<>();
		List<Double> firstList = toList(first);
		List<Double> secondList = toList(second);

		// Merge the 2 Arrays together
		while (!firstList.isEmpty() && !secondList.isEmpty()) {
			if (firstList.get(0) <= secondList.get(0)) {
				merged.add(firstList.remove(0));
			} else {
				merged.add(secondList.remove(0));
			}
		}

		// Add remaining Elements from the Arrays
		while (!firstList.isEmpty()) {
			merged.add(firstList.remove(0));
		}

		while (!secondList.isEmpty()) {
			merged.add(secondList.remove(0));
		}

		return toArray(merged);
	}

	private static double[] toArray(List<Double> list) {
		int len = list.size();
		double[] array = new double[len];

		for (int i = 0; i < len; i++) {
			array[i] = list.get(i);
		}

		return array;
	}

	private static List<Double> toList(double[] array) {
		List<Double> list = new ArrayList<>();

		for (double d : array) {
			list.add(d);
		}

		return list;
	}

}
