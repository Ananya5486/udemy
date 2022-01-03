package com.udemey.in28minutes.spring.basics.springin5steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {
	@Autowired	
	private SortAlgorithm algorithm;
	
	//constructor injection
	/*
	 * public BinarySearchImpl(SortAlgorithm algorithm) { super(); this.algorithm =
	 * algorithm; }
	 */
	//setter injection
	
	public void setAlgorithm(SortAlgorithm algorithm) {
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
