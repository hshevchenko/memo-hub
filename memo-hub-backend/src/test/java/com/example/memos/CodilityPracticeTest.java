package com.example.memos;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;



public class CodilityPracticeTest {
	static final String IMPOSSIBLE = "IMPOSSIBLE";
	
	
	public void testMatrixResolver() {
		Assert.assertEquals("1010,1010", resolveMatrix(2, 2,new int[] {2,0,2,0}));
		Assert.assertEquals("11100,10001", resolveMatrix(3, 2,new int[] {2,1,1,0,1}));
		Assert.assertEquals(IMPOSSIBLE, resolveMatrix(0, 2,new int[] {2,0,2,0}));
		Assert.assertEquals(IMPOSSIBLE, resolveMatrix(2, 3,new int[] {0,0,1,1,2}));
	}
	
	private String resolveMatrix(int U, int L, int C[]) {
		int u = 0, l = 0;
		
		StringBuilder sb1 = new StringBuilder(); //u
		StringBuilder sb2 = new StringBuilder(); //l
		for(Integer c: C) {						
			if(c == 0) {				
				sb1.append("0");
				sb2.append("0");
			}
			else if(c == 2){
				if (u >= U || l >= L){
					return IMPOSSIBLE;
				}
				else {
					sb1.append("1");
					sb2.append("1");
					u++;l++;
				}
			}
			else if(c == 1) {
				if (u >= U && l >= L){
					return IMPOSSIBLE;
				}
				else {
					if(u < U) {
						sb1.append("1");
						u++;
						sb2.append("0");
					}
					else {
						sb2.append("1");
						sb1.append("0");
						l++;
					}
				}
			}
		}
		String retVal = sb1.append(",").append(sb2.toString()).toString();
		//System.out.println(retVal);
		return retVal;
	}
	
	
	public void testSheepShade() {
		Assert.assertEquals(5, getSheepShade(new int[] {0,0,10,10}, new int[] {0,10,0,10}));
	}
	
	private int getSheepShade(int[] X, int[] Y) {
		
		return 0;
	}
	
	@Test
	public void testBinaryGap() {
		Assert.assertEquals(2,countBinaryGap(9));
		Assert.assertEquals(4,countBinaryGap(529));
		Assert.assertEquals(1,countBinaryGap(20));
		Assert.assertEquals(0,countBinaryGap(15));
		Assert.assertEquals(0,countBinaryGap(32));
	}
	
	
	private int countBinaryGap(int decimal) {
		int maxGap = 0, gap = 0;
		boolean countZeros = false;
		
		while (decimal > 0) {
			int remainder = decimal % 2;
			if(remainder > 0) {
				//1
				countZeros = true;
				if(gap > 0) {					
					if(gap > maxGap) {
						maxGap=gap;
					}
					gap=0;
				}
			}
			else {
				if(countZeros) {
					gap++;
				}
			}
			
			decimal = decimal/2;
		}
		
		return maxGap > gap ? maxGap : gap;
	}
	
	@Test
	public void testUnpairedArrayElement() {
		Assert.assertEquals(7, getUnpairedArrayElement(new int[] {9,3,9,3,9,7,9}));
		Assert.assertEquals(3, getUnpairedArrayElement(new int[] {9,3,9,3,9,7,9,7,3}));
		Assert.assertEquals(1, getUnpairedArrayElement(new int[] {1,3,9,3,9}));
		Assert.assertEquals(9, getUnpairedArrayElement(new int[] {9,3,9,3,9}));
		
	}
	
	private int getUnpairedArrayElement(int[] A) {
		Map<Integer,Integer> map=new HashMap<>();
				
		for(int a: A) {
			Integer occurances = map.get(a) != null ?  map.get(a) : 0;
			map.put(a, ++occurances);			
		}
		
		return map.entrySet().stream().filter( s -> s.getValue() % 2 != 0).findFirst().get().getKey();
	}
}


