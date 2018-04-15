package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

public class Model {

	List<Quadrato> soluzione;

	public List<Quadrato> findMagicSquare(int n) {

		soluzione = new ArrayList<Quadrato>();
		//ogni volta che viene chiamato questo metodo genero una soluzione diversa
		//perché avrò problema diverso

		int step = 0;
		Quadrato parziale = new Quadrato(n);

		recursive(step, parziale, n);

		return soluzione;
	}

	private void recursive(int step, Quadrato parziale, int dim) {
		
		System.out.println(parziale);
		
		if (step >= dim*dim) {
			// soluzione completa
			if (parziale.isValid()) {
				// devo salvare la soluzione completa
				soluzione.add(new Quadrato(parziale));
			}				//non salvo parziale perché andando avanti col metodo ricorsivo
							//questa cambierebbe => meglio una DEEPCOPY così da fotografare la sol parziale corrente
		}
		
		for (int i = 1; i <= dim*dim; i++) {
			if (! parziale.contains(i)) {
				parziale.add(i);
				recursive(step +1, parziale, dim);
				parziale.remove(i);
		//add e remove non sono metodi della lista ma metodi in Quadrato
		//il filtro if() o contiene add e remove o non li contiene entrambi
			}
		}
		
	}
}
