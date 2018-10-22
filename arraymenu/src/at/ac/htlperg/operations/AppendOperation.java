package at.ac.htlperg.operations;

import java.util.Scanner;

import at.ac.htlperg.main.Operation;

public class AppendOperation extends Operation {
	
	@Override
	public int[] doIt(int[] ar) {
		ar = extendArr(ar);
		Scanner sc = new Scanner(System.in);
		System.out.print("Geben sie eine eine Zahl die Angefügt werden soll ein:");
		int eingabe = sc.nextInt();	
		ar[ar.length - 1] = eingabe;
		sc.close();
		return ar;
	}
}
