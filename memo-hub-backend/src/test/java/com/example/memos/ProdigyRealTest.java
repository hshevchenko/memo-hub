package com.example.memos;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ProdigyRealTest {
	private static final Character[] sorted = new Character[] {'A','K','Q','J','T','9','8','7','6','5','4','3','2'};
	
	
	@Test
	public void testTask1() {
		assertEquals(4, solution("23A84Q", "K2Q25J"));
		assertEquals(0, solution("000", "000"));
	}
	
	public int solution(String A, String B) {
		int retVal = 0;
		if(A != null && B != null && A.length() == B.length()){
		   Map<Character, Integer> sortedDeck = getSortedDeck();
           char[] alecDeck = A.toUpperCase().toCharArray(),
            	  bobDeck = B.toUpperCase().toCharArray();
            
           for(int i=0; i<alecDeck.length; i++) {
            	Character alecCard = alecDeck[i],
            			  bobCard = bobDeck[i];
            	System.out.println(sortedDeck.get(alecCard));
            	if(sortedDeck.get(alecCard) != null && 
            		sortedDeck.get(bobCard)!=null && 
            		sortedDeck.get(alecCard) < sortedDeck.get(bobCard)) {
            		retVal++;
            	}
            } 
		}
		
		return retVal;
    }
	
	private static Map<Character, Integer> getSortedDeck(){
		Map<Character, Integer> map = new HashMap<>();		
		for(int i=0; i<sorted.length; i++) {
			map.put(sorted[i], i);
		}
		return map;
	}
	
	private static int getCardValue(Character card) {
		int cardValue = getSortedDeck();
		return cardValue != null ? cardValue : -1;
	}

}
 