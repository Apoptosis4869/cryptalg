package com.apoptosis.encryption.enigma;

import java.util.HashMap;
import java.util.Map;

public class Plug {

private Map<Character,Character> alphaExchangeOffset;
	
	public Plug(char src,char dest){
		alphaExchangeOffset = new HashMap<Character,Character>();
		alphaExchangeOffset.put(src, dest);
	}
	
	public char getDestChar(char src){
		return alphaExchangeOffset.containsKey(src)?alphaExchangeOffset.get(src):src;
	}
}
