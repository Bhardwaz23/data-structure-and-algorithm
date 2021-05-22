package com.practice.algoexpert.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author nishant.bhardwaz
 * 
 *         <br>
 *         <br>
 *         <img src="./doc-files/GroupAnagrams.png" />
 *
 */
public class GroupAnagrams_7 {

	public static void main(String[] args) {
		List<List<String>> result = groupAnagrams(new ArrayList<String>(Arrays.asList("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp")));
		
		for(List<String> anagrams : result) {
			System.out.print("[\t");
			for(String a: anagrams) {
				System.out.print(a+"\t");
			}
			System.out.print("]");
			System.out.println();
		}

	}
	
	public static List<List<String>> groupAnagrams(List<String> words) {
		
		    Map<String, List<String>> anagrams = new HashMap<String, List<String>>();
		
		    
		
		    for(String word: words){
		
		      char[] charArray = word.toCharArray();
		
		      Arrays.sort(charArray);
		
		      String sortedWord = new String(charArray);
		
		      
		
		      if(anagrams.containsKey(sortedWord)){
		
		        anagrams.get(sortedWord).add(word);
		
		      }else{
		
		       anagrams.put(sortedWord, new ArrayList<String>(Arrays.asList(word)));
		
		      }
		
		    }
		
		    return new ArrayList<List<String>>(anagrams.values());
		
		  }

}
