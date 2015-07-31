package com.apoptosis.encryption.enigma;

import java.util.Map;

/**
 * 
 * @author atpex_000
 *
 */
public class Plugboard {

	private Plug plug1;
	private Plug plug2;
	private Plug plug3;
	
	public Plugboard(char[] offset1,char[] offset2,char[] offset3){
		plug1 = new Plug(offset1[0],offset1[1]);
		plug2 = new Plug(offset2[0],offset2[1]);
		plug3 = new Plug(offset3[0],offset3[1]);
		
	}
	
	public char getDestChar(char src){
		if(src != plug1.getDestChar(src)){
			return plug1.getDestChar(src);
		}else if(src != plug2.getDestChar(src)){
			return plug2.getDestChar(src);
		}else if(src != plug3.getDestChar(src)){
			return plug3.getDestChar(src);
		}
		
		return src;
	}
}
