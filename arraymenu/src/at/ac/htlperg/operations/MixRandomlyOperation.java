package at.ac.htlperg.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import at.ac.htlperg.main.Operation;

public class MixRandomlyOperation extends Operation {

	@Override
	public int[] doIt(int[] ar) {
		
		return ar;
	}

	
	
//	public int[] doIt(int[] ar) {
//		Random r = new Random();
//		List<Integer> ran = new ArrayList<>();
//		int ranNum = 0;
//		for(int i = 0; i < ar.length; i++) {
//			do {
//				ranNum = r.nextInt(ar.length);
//			}
//			while(ran.contains(ranNum));
//			ran.add(ranNum);
//		}
//		for(int i = 0; i < ar.length; i++) {
//			int tmp = ar[i];
//			int curIndex = ran.get(i);
//			ar[i] = ar[curIndex];
//			ar[curIndex] = tmp;
//		}
//		return ar;
//		}
	}
	

