package com.array;

import java.util.Arrays;

public class FindMaxAndMin {

			public static void main(String[] args) {
					int arr[] = {4,-2,1,6,5}; // 
					minMax(arr);
					sortArr(arr);
			}
			
			private static void minMax(int arr[]) {
				//Arrays.sort(arr);
				System.out.println("Min Value= "+arr[0]);
				System.out.println("Max Value= "+arr[arr.length-1]);
			}
			
			private static void sortArr(int arr[]) {
				int[] sortArr = new int[arr.length];
				for(int i = 0 ; i<arr.length; i++) {
					for(int j=0; j<arr.length; j++) {
						if(arr[i]<arr[j]) {
							sortArr[i]=arr[i];
						}
					}
				}
				for(int i =0; i<sortArr.length;i++) {
					System.out.print(sortArr[i]);
				}
			}
			

}
