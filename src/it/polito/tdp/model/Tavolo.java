package it.polito.tdp.model;

public class Tavolo {

	private int numeroPosti;
	private Gruppo gruppoSeduto;   //tengo traccia del gruppo seduto e vedo se è libero 
	
	public Tavolo(int numeroPosti){
		this.numeroPosti=numeroPosti;
	}

	public int getNumeroPosti() {
		return numeroPosti;
	}

	public void setNumeroPosti(int numeroPosti) {
		this.numeroPosti = numeroPosti;
	}

	public Gruppo getGruppoSeduto() {
		return gruppoSeduto;
	}

	public void setGruppoSeduto(Gruppo gruppoSeduto) {
		this.gruppoSeduto = gruppoSeduto;
	}
	
}
