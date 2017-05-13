import java.util.Scanner;
import java.util.Random;

public class assigment1 {
	public static void matrixMultiplication(int n){
		int matrixOne[][] = new int[n][n];				/*Creating Matrix nxn*/
		int matrixTwo[][] = new int[n][n];
		int multiplicationMatrix[][] = new int[n][n];
		int i,j,k, sum =0;
		Random randomNumber = new Random();		/*Generate Random Number */

		for(i=0;i<n;i++)		/*MatrixOne generated Element*/
			for(j=0;j<n;j++){
				matrixOne[i][j] = randomNumber.nextInt(10);
				matrixTwo[i][j] = randomNumber.nextInt(10);
			}
		long startTime = System.currentTimeMillis();
		for(i=0;i<n;i++){
			for(j=0;j<n;j++){
				for(k=0;k<n;k++){
					sum = sum + (matrixOne[i][k] * matrixTwo[k][j]);		/* Matrices multipling*/
				}
				multiplicationMatrix[i][j] = sum;
				sum =0;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time : " + (endTime - startTime) + "ms");
	}
	public static void bubbleSort(int n){
		int bubbleArray[] = new int[n];
		Random randomNumber = new Random();		/*Generate Random Number */
		int i,j,swap;

		for(i=0;i<n;i++)					/* Array generated element*/
			bubbleArray[i] = randomNumber.nextInt(1000);
		long startTime = System.currentTimeMillis();

		for(i=0;i<(n-1);i++){
			for(j=0;j<(n-i-1);j++){
				if(bubbleArray[j] > bubbleArray[j+1]){
					swap = bubbleArray[j];								/* Sorting array*/
					bubbleArray[j] = bubbleArray[j+1];
					bubbleArray[j+1] = swap;
				}
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time : " + (endTime - startTime) + "ms");
		System.out.println("\n");
	}
	public static void binarySearch(int n){
		int binaryArray[] = new int[n];
		Random randomNumber = new Random();						/*Generate Random Number */
		int i,first=0,last=(n-1),middle=(first + last)/2;

		for(i=0;i<n;i++)
			binaryArray[i]= randomNumber.nextInt(n);			/*Generated Array Element*/

		for(i=0;i<(n-1);i++){
			for(j=0;j<(n-i-1);j++){
				if(binaryArray[j] > binaryArray[j+1]){
					swap = binaryArray[j];								/* Sorting array with Bubble Sort*/
					binaryArray[j] = binaryArray[j+1];
					binaryArray[j+1] = swap;
				}
			}
		}

		System.out.println("Enter value that is finding");
		Scanner findingNumber = new Scanner(System.in);
		int searchNumber = findingNumber.nextInt();

		long startTime = System.currentTimeMillis();
			while(first <= last){
				if(binaryArray[middle] < searchNumber){				/*Finding Search Element*/
					first = middle +1;
				}
				else if( binaryArray[middle] == searchNumber){
					System.out.println(searchNumber +" founded. Position is" + (middle +1) + ".\n" );
					break;
				}
				else{
					last = middle -1;
				}
				middle = (first + last )/2;
			}
			if(first > last){
				System.out.println("\n");
			}

		long endTime = System.currentTimeMillis();
		System.out.println("Time : " + (endTime - startTime) + "ms\n");
	}
	public static void findingMaxElement(int n){
		int maxElementArray[] = new int[n];
		Random randomNumber = new Random();		/*Generate Random Number */
		int i,maxElement;

		for(i=0;i<n;i++)
			maxElementArray[i] = randomNumber.nextInt(1000);		/*Generate Array Element*/
		long startTime = System.currentTimeMillis();
		maxElement = maxElementArray[0];

		for(i=0;i<n;i++){											/*Finding Maximum element on array*/
			if(maxElementArray[i] > maxElement){
				maxElement = maxElementArray[i];
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time : " + (endTime - startTime) + "ms");
	}
	public static void mergeSort(int[] mergeArray,int size){
		int i , leftSize, rightSize, mid;

		if(size <2)											/*Ýf size is less than two , return array don't split.*/
			return;
		mid = (size/2) ;
		leftSize = mid ;									/* Find mid , left size of left array and right size of array*/
		rightSize = size - mid;
		int leftMergeArray[] = new int[leftSize];
		int rightMergeArray[] = new int[rightSize];

		for(i=0;i<mid;i++)
			leftMergeArray[i] = mergeArray[i];						/* Create Left Merge Array*/
		for(i=mid;i<size;i++)
			rightMergeArray[i - mid] = mergeArray[i];				/* Create Right Merge Array*/

		mergeSort(leftMergeArray,leftSize);
		mergeSort(rightMergeArray,rightSize);					/*Splits Merge Array*/
		merge(leftMergeArray,rightMergeArray,mergeArray);


	}
	public static int[] merge(int[] leftMergeArray,int[] rightMergeArray,int[] mergeArray){
		int i=0,j=0,k=0;
		int leftMergeSize = leftMergeArray.length;
		int rightMergeSize = rightMergeArray.length;

		while(i < leftMergeSize && j < rightMergeSize){
			if(leftMergeArray[i] <= rightMergeArray[j]){			/*Compares tow sequences and moves the small number to merge sorted array */
				mergeArray[k] = leftMergeArray[i];
				i++;
				k++;
			}
			else if(leftMergeArray[i] > rightMergeArray[j]){
				mergeArray[k] = rightMergeArray[j];
				j++;
				k++;
			}
		}
		while(i < leftMergeSize){							/*If elements remain in right Merge Array , moves in left merge array to merge sorted array */
			mergeArray[k] = leftMergeArray[i];
			k++;
			i++;
		}
		while(j < rightMergeSize){							/*If elements remain in left Merge Array , moves in right merge array to merge sorted array */
			mergeArray[k] = rightMergeArray[j];
			j++;
			k++;
		}
		return mergeArray;
	}

	public static void main(String[] args){
		System.out.println(
				  "1.Matrix Multiplication\n"
				+ "2.Finding Maximum Elemant\n"
				+ "3.Bubble Sort\n"							/*Functions Menu*/
				+ "4.Merge Sort\n"
				+ "5.Binary Search\n"
				+ "6.Exit\n");
		int i,selected,size;
		Random randomNumber = new Random();
		while(true){
			System.out.println("Select anyone\n");
			Scanner input = new Scanner(System.in);					/*Choisen Function*/
			selected = input.nextInt();
			if(selected == 1){   									 /* Matrix Multiplication*/
				System.out.println("Give Size\n");
				Scanner sizeUser = new Scanner(System.in);			/*Giving Size*/
				size = sizeUser.nextInt();
				matrixMultiplication(size);							/*Go Matrix Mul. Function*/
			}
			else if(selected == 2){									/* Finding Maximum Elemant*/
				System.out.println("Give Size\n");
				Scanner sizeUser = new Scanner(System.in);			/*Giving Size*/
				size = sizeUser.nextInt();
				findingMaxElement(size);							/*Go Find Max  Function*/
			}
			else if(selected == 3){									/* Bubble Sort Algorithm*/
				System.out.println("Give Size\n");
				Scanner sizeUser = new Scanner(System.in);			/*Giving Size*/
				size = sizeUser.nextInt();
				bubbleSort(size);									/*Go Bubble Sort Function*/
			}
			else if(selected == 4){									/* Merge Sort Algorithm*/
				System.out.println("Give Size\n");
				Scanner sizeUser = new Scanner(System.in);			/*Giving Size*/
				size = sizeUser.nextInt();
				int mergeArray[] = new int[size];					/*Create array for merge and generated element*/
				for(i=0;i<size;i++)
					mergeArray[i]= randomNumber.nextInt(1000);
				long startTime = System.currentTimeMillis();
				mergeSort(mergeArray,size);							/*Go Merge Sort Function*/
				long endTime = System.currentTimeMillis();
				System.out.println("Time : " + (endTime - startTime) + "ms\n");

			}
			else if(selected == 5){									/*Binary Search Algoritm*/
				System.out.println("Give Size\n");
				Scanner sizeUser = new Scanner(System.in);			/*Giving Size*/
				size = sizeUser.nextInt();
				binarySearch(size);									/*Go Binary Search Function*/
			}
			else if(selected == 6){									/*Exit*/
				System.out.println("Exit!");
				break;
			}
		}
	}
}
