package at.ac.htlperg.operations;

import java.util.Arrays;
import java.util.*;
import at.ac.htlperg.main.Operation;

public class SortOperation extends Operation {

	@Override
	public int[] doIt(int[] ar) {
		Scanner sc = new Scanner(System.in);
		/**Hilfsvariablen werden angelegt*/
		int select = 0;
		int turn = 0;
		
		/**Array wird vorwaerts sortiert*/
		Arrays.sort(ar);
		
		/**Vorwaerts oder Rueckwaerts sortieren*/
		System.out.print("Wollen Sie den Array vorwaerts(1) oder rueckwerts(2) sortieren: ");
		while (select < 1 || select > 2) { /**Eingabe wird geprueft*/
			select = sc.nextInt();
			if(select < 1 || select > 2) {
				System.out.println("Geben Sie eine 1 oder eine 2 ein!");
			}
		}
		
		/**Array wird rueckwaerts sortiert*/
		if(select == 2) {	
			for (int i = 0; i < ar.length / 2; i++) {
				turn = ar[i];
				ar[i] = ar[ar.length - i - 1];
				ar[ar.length - i - 1] = turn;
			}
		}
		sc.close();
		return super.doIt(ar);
	}

}
