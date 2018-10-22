package at.ac.htlperg.operations;

import java.util.Scanner;

import at.ac.htlperg.main.Operation;

public class SearchOperation extends Operation {

	@Override
	public int[] doIt(int[] ar) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Welches Element möchtest du suchen? ");
		int searchforelement = sc.nextInt();
		boolean istVorhanden = false;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] == searchforelement) {
				System.out.println("Das Element ist an der " + i + "ten Stelle vorhanden!");
				istVorhanden = true;
			}

		}
		if (!istVorhanden) {
			System.out.println("Ist nicht Vorhanden!");

		}
		sc.close();
		return ar;
	}

}
