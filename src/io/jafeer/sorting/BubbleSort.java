package io.jafeer.sorting;

// Java program for implementation of Bubble Sort
class BubbleSort 
{ 
	void bubbleSort(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i = n-1; i > 0; i--) {
			for (int j = 0; j <i; j++) {
				if((arr[j] > arr[j + 1])) {
					printArray(arr);
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

		}
	} 

	/* Prints the array */
	void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i] + " "); 
		System.out.println(); 
	} 

	// Driver method to test above 
	public static void main(String args[]) 
	{ 
		BubbleSort ob = new BubbleSort(); 
		int arr[] = {3,1,4,2,5};
		ob.bubbleSort(arr); 
		System.out.println("Sorted array"); 
		ob.printArray(arr); 
	} 
} 
/* This code is contributed by Rajat Mishra */
