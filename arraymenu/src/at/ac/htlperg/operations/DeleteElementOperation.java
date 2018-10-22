package at.ac.htlperg.operations;

import java.util.Scanner;

import at.ac.htlperg.main.Operation;

public class DeleteElementOperation extends Operation {
	@Override
	public int[] doIt(int[] ar) {
		Scanner sc = new Scanner(System.in);
		int element = sc.nextInt();
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
		
		sc.close();
		return ar;
	}

}
