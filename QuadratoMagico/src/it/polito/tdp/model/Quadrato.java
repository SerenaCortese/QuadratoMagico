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
		
	}
	
	private boolean checkColumns() {
		
	}
	
	private boolean checkDiagonals() {
		
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
}
