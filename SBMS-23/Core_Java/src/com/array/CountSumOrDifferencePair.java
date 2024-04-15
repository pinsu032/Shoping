package com.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountSumOrDifferencePair {

			public static void main(String[] args) {
					int[] arr = {2,3,1,5};  // n1 + n2=2  => n1 = 2 - n2  => n1 = 2-1=1
					int target = 2;
					
					int pair = countPair(arr, target);
					System.out.println("Total Pair::"+pair);
				
			}
	
			private static int countPair(int[] arr , int target) {
				int count = 0 ;
				Map<List<Integer>,Integer> map = new HashMap<>();
				List<Integer> list = null;
				
				for(int i = 0 ; i<arr.length; i++) {
					for(int j = 0 ; j<arr.length; j++) {
						if(arr[i]!=arr[j]) {
							if(arr[i] + arr[j] == target || arr[i] - arr[j] == target) {
							   list = new ArrayList<>();
							   list.add(arr[i]);
							   list.add(arr[j]);
							   Collections.sort(list);
							   count++;
							   map.put(list, count);
							   
							}
							else {
								continue;
							}
						}
					}
				}

				System.out.println(map);
				return map.size();
			}

}
