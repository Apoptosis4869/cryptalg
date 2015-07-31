package com.apoptosis.encryption.enigma;

/**
 * 
 * @author atpex_000
 *
 */
public class Rotor {

	private int offset;
	
	public Rotor(char alphabet){
		int index = Constants.alphabets.indexOf(alphabet);
		offset = index - Constants.alphabets.indexOf('A');
	}
	
	public char getAlphabet(char inputChar){
		int index = Constants.alphabets.indexOf(inputChar);
		int newIndex = index + offset;
		if(newIndex > 25){
			newIndex = newIndex%25;
		}
		return Constants.alphabets.charAt(newIndex);
	}
}
