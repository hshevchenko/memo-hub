package com.example.memos;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ProdigyCodingPrep {
	
	@Test
	public void testNestedString() {		
		
		assertEquals(1, test("{[()()]}"));
		assertEquals(0, test("([)()]"));
	}
	
	private int test(String string) {
		Map<Character, Integer> startBrackets = initStartBracketCounter();
		Map<Character, Integer> endBrackets = initEndBracketCounter();
		
		for(Character ch: string.toCharArray()) {
			if(isStartBracket(ch)) {				
				Integer startCount = startBrackets.get(ch);
				startBrackets.put(ch, ++startCount);
			}
			else if(isEndBracket(ch)) {
				Integer startCount = startBrackets.get(getStartByEnd(ch));
				Integer endCount = endBrackets.get(ch) + 1;
				if(startCount < endCount) {
					return 0;
				}
				else {
					endBrackets.put(ch, endCount);
				}
			}
		}
		
		return 1;
	}
	
	private Map<Character, Integer> initStartBracketCounter(){
        Map<Character, Integer> retVal = new HashMap<>();   
        retVal.put('(', 0);
        retVal.put('{', 0);
        retVal.put('[', 0);
        return retVal;
    }
	
	private Map<Character, Integer> initEndBracketCounter(){
        Map<Character, Integer> retVal = new HashMap<>();   
        retVal.put(')', 0);
        retVal.put('}', 0);
        retVal.put(']', 0);
        return retVal;
    }
	
	private Boolean isStartBracket(Character str) {
		return '(' == str || '{' == str || '[' == str;
	}
	
	private Boolean isEndBracket(Character str) {
		return ')' == str || '}' == str || ']' == str;
	}
	
	private Character getStartByEnd(Character end) {
		Character start = 0;
		switch(end) {
			case ')': start= '('; break;
			case '}': start= '{'; break;
			case ']': start= '['; break;
		}
		
		return start;
	}
}
