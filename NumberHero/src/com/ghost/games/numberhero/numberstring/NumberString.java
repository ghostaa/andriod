package com.ghost.games.numberhero.numberstring;

import java.util.Random;

/**
 * @author ÑÖ¶«Åô
 * @Title: main
 * @Description: TODO
 * @throws 2014-1-19ÏÂÎç06:52:41 
 */
public class NumberString {
	private int howManyDigits=4;
	private boolean isRepeat=false;
	private String[] allNumber = new String[]{"1","2","3","4","5","6","7","8","9"};
	private static Random randGen = null;
	private static char[] numbers = null;
	public String getNormalString() {
		String normalString;
		while (isExist(normalString=randomString(this.howManyDigits))) {
		}
		return normalString;


	}

	private static final String randomString(int length) {
	         if (length < 1) {
	             return null;
	         }
	         if (randGen == null) {
	                randGen = new Random();
	                numbers = ("123456789").toCharArray();
	         }
	         char [] randBuffer = new char[length];
	         for (int i=0; i<randBuffer.length; i++) {
	             randBuffer[i] = numbers[randGen.nextInt(9)];
	         }
	         return new String(randBuffer);
	}
	private boolean isExist(String tmp){
		boolean isOk = false;
		char [] tmpchar = tmp.toCharArray();
		for (int i = 0; i < tmpchar.length; i++) {
			for (int j = i+1; j < tmpchar.length; j++) {
				if(tmpchar[i] == tmpchar[j]){
					isOk = true;
					return isOk;
				}else{
					isOk = false;
				}
			}
		}
		return isOk;
	}
}


