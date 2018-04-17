package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

public class Quadrato {

	int n;
	int magic;
	List<Integer> matrice;

	public Quadrato(int n) {
		this.n = n;
		this.magic = n * (n * n + 1) / 2;
		this.matrice = new ArrayList<Integer>();
	}

	public Quadrato(Quadrato q) {
		this.n = q.n;
		this.magic = q.magic;
		this.matrice = new ArrayList<Integer>(q.getMatrice());
	}
	
	private boolean checkRows() {
		//usiamo soluzione della foto es1
		for(int i = 0; i<n; i++) {
			int somma = 0 ;
			for(int j = 0; j<n; j++) {
				somma += matrice.get(i*n+j);
			}
			//controllo alla fine di ogni riga la somma sia uguale a magic
			if(somma != magic) {
				return false;
			}//altrimenti continuo con la seconda riga
		}
		return true;
	}
	
	private boolean checkColumns() {
		//come checkRows solo scambiando righe e colonne
		for(int j = 0; j<n; j++) {//ciclo sulle colonne
			int somma = 0 ;
			for(int i = 0; i<n; i++) {//ciclo sulle righe
				somma += matrice.get(i*n+j);
			}
			//controllo alla fine di ogni colonna la somma sia uguale a magic
			if(somma != magic) {
				return false;
			}//altrimenti continuo con la seconda riga
		}
		return true;

	}
	
	private boolean checkDiagonals() {
		//controllo diagonale principale e controllo diagonale secondaria
		return checkMainDiagonal() & checkSecondaryDiagonal();
	}
	
	private boolean checkSecondaryDiagonal() {
		//mi basta solo un ciclo for perché entrambi gli indici vengono incrementati di 1
		//foto es3
		int somma = 0;
		for(int i=0; i<n;i++) {
			somma+= this.matrice.get(i*n+n-1-i);
		}
		if(somma != magic) {
			return false;
		}
			return true;
	}

	private boolean checkMainDiagonal() {
		//mi basta solo un ciclo for perché entrambi gli indici vengono incrementati di 1
		//foto es3
		int somma = 0;
		for(int i=0; i<n;i++) {
			somma+= this.matrice.get(i*n+1);
		}
		if(somma != magic) {
			return false;
		}
			return true;
	}

	public boolean isValid() {
		// quadrato e' una soluzione valida
		return checkRows() & checkColumns() & checkDiagonals();
		//& perché tutte e 3 le funzioni devono ritornare true!
	}
	
	public boolean contains(int i) {
		return this.matrice.contains(i);
	}
	
	public void add(int i) {
		this.matrice.add(i);
	}
	
	public void remove(int i) {
		this.matrice.remove(Integer.valueOf(i));
	//this.matrice.remove(i) non funziona come voglio
	//perché la lista è fatta da Integer non int
	
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getMagic() {
		return magic;
	}

	public void setMagic(int magic) {
		this.magic = magic;
	}

	public List<Integer> getMatrice() {
		return matrice;
	}

	public void setMatrice(List<Integer> matrice) {
		this.matrice = matrice;
	}

	@Override
	public String toString() {
		return this.matrice.toString();
	}
	
}
