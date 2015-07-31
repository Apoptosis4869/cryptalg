package com.apoptosis.encryption.enigma;

import java.util.List;

/**
 * 
 * @author atpex_000
 *
 */
public class RotorSet {

	private Rotor rotor1;
	private Rotor rotor2;
	private Rotor rotor3;
	
	public RotorSet(char al1,char al2,char al3){
		rotor1 = new Rotor(al1);
		rotor2 = new Rotor(al2);
		rotor3 = new Rotor(al3);
	}
	
	public char encode(char c){
		return rotor3.getAlphabet(rotor2.getAlphabet(rotor1.getAlphabet(c)));
	}
}
