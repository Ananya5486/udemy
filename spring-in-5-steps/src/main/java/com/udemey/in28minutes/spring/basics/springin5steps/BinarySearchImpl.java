package com.udemey.in28minutes.spring.basics.springin5steps;

public class BinarySearchImpl {
	
	private SortAlgorithm algorithm;
	
	public BinarySearchImpl(SortAlgorithm algorithm) {
		super();
		this.algorithm = algorithm;
	}

	//Sorting Array
	public int binarySearch(int[] numbers,int numberToSearch) {
//		BubbleSort bubbleSort=new BubbleSort();
		int[] sortedArray=algorithm.sort(numbers);
		
		//search the element
		return 1;
	}

}
