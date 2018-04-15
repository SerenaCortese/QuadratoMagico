package it.polito.tdp.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		
		//voglio una lista di soluzioni(quadrati)=> TUTTE LE SOLUZIONI
		List<Quadrato> quadrati = model.findMagicSquare(3);
										//3 è la dimensione del quadrato
	}

}
