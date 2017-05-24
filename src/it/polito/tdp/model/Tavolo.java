package it.polito.tdp.model;

public class Tavolo {

	private int numeroPosti;
	private boolean occupato;
	
	public Tavolo(int numeroPosti){
		this.numeroPosti=numeroPosti;
		this.occupato=false;
	}

	public int getNumeroPosti() {
		return numeroPosti;
	}



	public boolean isOccupato() {
		return occupato;
	}

	public void setOccupato(boolean occupato) {
		this.occupato = occupato;
	}
	
}
