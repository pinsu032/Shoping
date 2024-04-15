package com.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CountFrequencyOfChar {

			public static void main(String[] args) {
					String str = "ujjawal";
					Map<Character, Integer> countOccurance = countOccurance(str);
					for(Entry<Character, Integer> entry : countOccurance.entrySet()) {
						System.out.println(entry.getKey()+" "+entry.getValue());
					}
			}
			
			private static Map<Character,Integer> countOccurance(String str){
				Map<Character,Integer> map = new HashMap<>();
						for(int i = 0 ; i<str.length();i++) {
							int count = 0;
							for(int j=0 ; j<str.length(); j++) {
								if(str.charAt(i) == str.charAt(j))
									count++;
							}
							map.put(str.charAt(i), count);
						}
					return map;
			}

}
