package at.ac.htlperg.main;
import java.util.*;

public class ArrayMenu {
	int[] ar = new int[1];
	public Operation[] operations = new Operation[9];
	static Scanner sc = new Scanner(System.in);
	public void append() {
		
	}
	
	
	
	public void insert(int k) {
		k--;
		//extendArr();
		for (int i = ar.length-2; i >= k; i--) {
			int temp = ar[i];
			ar[i] = ar[i+1];
			ar[i+1] = temp;
		}
		System.out.print("Geben sie eine Zahl die eingefügt werden soll ein: ");
		ar[k] = sc.nextInt();
	}
	
	public void startDeletion() {
		System.out.println("Geben Sie eine Stelle ein, die Sie loeschen wollen"); 
		int pos;
		boolean check = false;
		do {
			pos = sc.nextInt();
			if(pos >= 0 && pos < ar.length) {
				check = true;
			}else {
				System.out.println("Geben Sie eine korrekte Stelle ein!");
			}
		}while(check == false);
		/**Löschaufruf**/	
		loeschen(pos-1);
	}
	
	 void loeschen(int pos) {
		/**Anlegen temporärer Speicher**/
		int[] temparray = new int[ar.length-1];
		int j = 0;
		
		/**Löschvorgang**/
		for(int i = 0; i < ar.length; i++) {
			if(i != pos) {
				temparray[j] = ar[i];
				j++;
			}
		}
		ar = temparray;
	}
	 
	public void delete(int element) {
			/** Diese Methode entfernt alle Stellen eines Elements */
			int[] temp = new int[ar.length];
			int newLength = 0;
			for (int i = 0; i < ar.length; i++) {
				if(ar[i]!=element) {
					temp[newLength]=ar[i];
					newLength++;
						
				}
					
			}
			ar= new int[newLength];
			System.arraycopy(temp, 0, ar, 0, ar.length);
			
		}
}
