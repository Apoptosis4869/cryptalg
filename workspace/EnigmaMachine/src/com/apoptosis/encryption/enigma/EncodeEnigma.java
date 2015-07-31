package com.apoptosis.encryption.enigma;

import java.util.List;

/**
 * 
 * @author atpex_000
 *
 */
public class EncodeEnigma {

	private RotorSet rotorSet;
	
	private Plugboard plugboard;
	
	public EncodeEnigma(RotorSet rotorSet){
		
		this.rotorSet = rotorSet;
	}
	
	public void setPlugboards(Plugboard plugboard){
		this.plugboard = plugboard;
	}
	
	public String getEncodedString(String src){
		StringBuffer destString = new StringBuffer();
		for(int i = 0;i < src.length();i++){
			char c = src.charAt(i);
			destString.append(plugboard.getDestChar(rotorSet.encode(c)));
		}
		return destString.toString();
	}
}
