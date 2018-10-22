package at.ac.htlperg.operations;
import java.util.Scanner;

import at.ac.htlperg.main.Operation;

public class InsertOperation extends Operation {
	static Scanner sc = new Scanner(System.in);
	
	@Override
	public int[] doIt(int[] ar) {
		int k = sc.nextInt();
		k--;
		ar = extendArr(ar);
		for (int i = ar.length-2; i >= k; i--) {
			int temp = ar[i];
			ar[i] = ar[i+1];
			ar[i+1] = temp;
		}
		System.out.print("Geben sie eine Zahl die eingefügt werden soll ein: ");
		ar[k] = sc.nextInt();
		return super.doIt(ar);
	}
	public int[] extendArr(int[] ar) {
		int[] temp = new int[ar.length];
		System.arraycopy(ar, 0, temp, 0, ar.length);
		ar = new int[ar.length + 1];
		System.arraycopy(temp, 0, ar, 0, temp.length);
		return ar;
	}

}
