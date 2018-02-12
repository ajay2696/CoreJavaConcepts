package com.mine.practice.recursion;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {0,1,2,3,4,5};
		System.out.println("-----"+binarySearch(arr,0,arr.length,3));
	}
	
	public static int binarySearch(int[] arr,int left,int right,int numToFind) {
		System.out.println("---left---"+left+"---right---"+right);
		if(right>=left) {
			int middle=((right+left)/2);
			if(arr[middle]==numToFind) {
				return middle;
			}
			if(arr[middle] > numToFind) {
				return binarySearch(arr,left,middle-1,numToFind);
			} else {
				return binarySearch(arr,middle+1,right,numToFind);
			}
		}
		return -1;
	}

}
