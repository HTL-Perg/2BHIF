package at.ac.htlperg.main;
import java.util.*;

import at.ac.htlperg.operations.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static ArrayMenu menu = new ArrayMenu();
	static int[] ar = new int[1];
	public static void main(String[] args) {
		start(ar);
		

	}

	private static void start(int[] array2) {
		//fillArr();
		int selectedFunction;
		do {
			selectedFunction = menu();
			processSelection(selectedFunction);
		
		}while(selectedFunction != 9);
		
		
		
		
		
		
	}

	private static void processSelection(int selectedFunction) {
		Operation operation = menu.operations[selectedFunction];
		ar = operation.doIt(ar);	
	}
	
	private static void search() {
		System.out.print("Welches Element möchtest du suchen? ");
		int searchforelement = sc.nextInt();
		boolean istVorhanden = false;
		for(int i = 0; i < ar.length; i++) {
			if(ar[i] == searchforelement) {
				System.out.println("Das Element ist an der "+i+"ten Stelle vorhanden!");
				istVorhanden = true;
			}
			
			
		}
		if(!istVorhanden) {
			System.out.println("Ist nicht Vorhanden!");
			
		}
		
	}
	
	/**Funktion Sortieren*/
	private static void sortAr() {
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
	}
	
	
	
	private static void mixRandomly() {
		Random r = new Random();
		List<Integer> ran = new ArrayList<>();
		int ranNum = 0;
		for(int i = 0; i < ar.length; i++) {
			do {
				ranNum = r.nextInt(ar.length);
			}
			while(ran.contains(ranNum));
			ran.add(ranNum);
		}
		for(int i = 0; i < ar.length; i++) {
			int tmp = ar[i];
			int curIndex = ran.get(i);
			ar[i] = ar[curIndex];
			ar[curIndex] = tmp;
		}
	}	
	
	
	
	

	

	private static int menu() {
//		System.out.println("(1) Anfügen\r\n" + 
//				"(2) Einfügen (an k.ter Stelle)\r\n" + 
//				"(3) Löschen (k.Stelle)\r\n" + 
//				"(4) Löschen (Element) \r\n" + 
//				"(5) Suchen (Element)\r\n" + 
//				"(6) Sortieren\r\n" + 
//				"(7) Zufällig mischen\r\n" + 
//				"(8) Ausgabe\r\n" + 
//				"(9) Beenden\r\n" + 
//				"");
//		System.out.print("Geben Sie eine Zahl ein: ");
		int j = 0;
		Operation append = new AppendOperation();
		append.name = "Anfügen";
		menu.operations[j++] = append;
		
		Operation insert = new InsertOperation();
		insert.name = "Einfügen";
		menu.operations[j++] = insert;
		
		/*Operation deletePos = new DeletePosOperation();
		deletePos.name = "Löschen";
		menu.operations[j++] = deletePos;*/
		
		Operation deleteElement = new DeleteElementOperation();
		deleteElement.name = "Element löschen";
		menu.operations[j++] = deleteElement;
		
		Operation search = new SearchOperation();
		search.name = "Element suchen";
		menu.operations[j++] = search;
		
		Operation sort = new SortOperation();
		sort.name = "Array sortieren";
		menu.operations[j++] = sort;
		
		Operation mix = new MixRandomlyOperation();
		mix.name = "Array zufällig mischen";
		menu.operations[j++] = mix;
		
		/*Operation print = new PrintOperation();
		print.name = "Array ausgeben";
		menu.operations[j++] = print;
		
		Operation exit = new ExitOperation();
		search.exit = "Programm beenden";
		menu.operations[j++] = exit;*/
		
		
		for(int i = 0; i < j; i++) {
			System.out.println("(" + i + ") " + menu.operations[i].name);
		}
		boolean correctInput = false;
		int input = 0;
		do {
			input = sc.nextInt();
			if (input > 0 && input < 10) {
				correctInput = true;
			}else {
				System.err.print("Falsche Eingabe!!! Geben Sie eine Zahl zwischen 1 und 9 ein!");
			}
		} while(!correctInput);
		return input;
	}

	/*private static void fillArr() {
		Random r = new Random();
		for (int i = 0; i < ar.length; i++) {
			ar[i] = r.nextInt(10);
		}
	}*/

	

	
	

	private static void print() {
		for(int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + " ");
		}
		System.out.println();
	}

	

	
}
