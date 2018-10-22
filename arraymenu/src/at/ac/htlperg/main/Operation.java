package at.ac.htlperg.main;

public class Operation {
	public String name;
	
	public int[] doIt(int[] ar) {
		
		return ar;
	}
	public int[] extendArr(int[] ar) {
		int[] temp = new int[ar.length];
		System.arraycopy(ar, 0, temp, 0, ar.length);
		ar = new int[ar.length + 1];
		System.arraycopy(temp, 0, ar, 0, temp.length);
		return ar;
	}
}

	
 