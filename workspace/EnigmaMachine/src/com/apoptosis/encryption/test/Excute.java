package com.apoptosis.encryption.test;

import com.apoptosis.encryption.enigma.EncodeEnigma;
import com.apoptosis.encryption.enigma.Plugboard;
import com.apoptosis.encryption.enigma.RotorSet;

/**
 * 
 * @author atpex_000
 *
 */
public class Excute {

	public static void main(String[] args){
		RotorSet rotorSet = new RotorSet('A', 'B', 'C');
		char[] exch1 = {'P','A'};
		char[] exch2 = {'O','I'};
		char[] exch3 = {'H','E'};
		Plugboard plugboard = new Plugboard(exch1,exch2,exch3);
		EncodeEnigma ee = new EncodeEnigma(rotorSet);
		ee.setPlugboards(plugboard);
		
		System.out.println(ee.getEncodedString("PPPPHPPP"));
	}
}
