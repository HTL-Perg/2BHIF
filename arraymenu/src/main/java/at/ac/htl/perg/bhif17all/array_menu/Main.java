/**
 * 
 */
package at.ac.bhif17.arraymenuobject;

/**
 * 
 * The main class of the "Array Menu" software
 * 
 * @author 2Bhif
 *
 */
public class Main {
	/**
	 * Entry point of the program
	 */
	public static void main(String[] args) {
		ArrayMenu menu = new ArrayMenu();		//Create a new menu
		while (menu.running) {					//Show the input as long as the boolean running is true
			menu.showInputDialog();
		}
		menu.scanner.close();					//Close the menu scanner
	}

}
