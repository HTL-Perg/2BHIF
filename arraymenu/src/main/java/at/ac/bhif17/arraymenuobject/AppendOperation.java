package at.ac.bhif17.arraymenuobject;

public class AppendOperation extends ArrayMenuOperation {

	public AppendOperation() {
		name = "Append";
		
	}

	@Override
	public double[] execute(double[] array) {
		
		double[] array2 = new double[1]; // A second array was created with space for one number.

		for (int y = 0; y < array2.length; y++) {
			System.out.println("Which number do you want to add?");
			array2[y] = scanner.nextInt(); // The one number what will be added to the array is given by the user.
		}

		double[] arraycombined = new double[array.length + array2.length]; // The third array is the first and second
																			// array combined.

		for (int i = 0; i < arraycombined.length; i++) { // The combined array getting filled with the numbers of both
															// arrays.
			if (i < array.length) {
				arraycombined[i] = array[i];
			} else {
				arraycombined[i] = array2[i - array.length];

			}
		}
		for (int k = 0; k < arraycombined.length; k++) {
			System.out.print(arraycombined[k] + " ");
		}
		System.out.println();
		return arraycombined;
	}
				
}
