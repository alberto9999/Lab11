package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

public class Model {

	
	
	
	
public Object simula(){
	List<Tavolo>tavoli=new ArrayList<Tavolo>();
	creaTavoli(tavoli);
	
	Simulator sim = new Simulator(tavoli) ;
	
	for(int i=0; i<2000; i++) {
		Gruppo g = new Gruppo("group_1"+String.valueOf(i),(int) ((0.1+Math.random())*10), Math.random()) ;
		sim.addGruppo(g,(int) (10*Math.random()+1));  // un gruppo ogni 1-10 minuti
	}
	
//	sim.run();
	
	
	
	
	
	
	return null;
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
	
	
	
}
