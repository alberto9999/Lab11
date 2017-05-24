package it.polito.tdp.model;

public class Gruppo {
private String id;
private int number;
private Tavolo tavolo;
private double tolleranza;


public Gruppo(String id,int number,double tolleranza){
	this.id=id;
	this.number=number; 
	this.tolleranza=tolleranza;
}


public String getId() {
	return id;
}



public int getNumber() {
	return number;
}


public Tavolo getTavolo() {
	return tavolo;
}


public void setTavolo(Tavolo tavolo) {
	this.tavolo = tavolo;
}


public double getTolleranza() {
	return tolleranza;
}


public void setTolleranza(double tolleranza) {
	this.tolleranza = tolleranza;
}






}
