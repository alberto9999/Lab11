package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

public class Model {


private List<Event> infoEventi;
private String infoSimulazione;


public String simula(){
	List<Tavolo>tavoli=new ArrayList<Tavolo>();
	creaTavoli(tavoli);
	
	Simulator sim = new Simulator(tavoli) ;
	
	for(int i=0; i<2000; i++) {
		Gruppo g = new Gruppo("group_1"+String.valueOf(i),(int) (Math.random()*10)+1, Math.random()) ;
		sim.addGruppo(g,i*(int)(Math.random()*10)+1);  // un gruppo ogni 1-10 minuti
	}
	
	sim.run();
	infoEventi=new ArrayList<Event>(sim.getTracciaEventi());
	
	infoSimulazione="CLIENTI TOTALI: "+sim.getGruppiTotali()+"\n";
	infoSimulazione+="CLIENTI SODDISFATTI: "+sim.getGruppiSoddisfatti()+"\n";
	infoSimulazione+="CLIENTI INSODDISFATTI: "+sim.getGruppiInsoddisfatti()+"\n";
	
	return infoSimulazione; 
	
}

private void creaTavoli(List<Tavolo> tavoli) {
		tavoli.add(new Tavolo(10));
		tavoli.add(new Tavolo(10));
		tavoli.add(new Tavolo(8));
		tavoli.add(new Tavolo(8));
		tavoli.add(new Tavolo(8));
		tavoli.add(new Tavolo(8));
		tavoli.add(new Tavolo(6));
		tavoli.add(new Tavolo(6));
		tavoli.add(new Tavolo(6));
		tavoli.add(new Tavolo(6));
		tavoli.add(new Tavolo(4));
		tavoli.add(new Tavolo(4));
		tavoli.add(new Tavolo(4));
		tavoli.add(new Tavolo(4));
		tavoli.add(new Tavolo(4));	
}
public List<Event> getInfoEventi(){
	return this.infoEventi;
	
	
}
	

	
}
