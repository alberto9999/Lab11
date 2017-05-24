package it.polito.tdp.model;


import java.util.List;
import java.util.PriorityQueue;


import it.polito.tdp.model.Event.EventType;

public class Simulator {

	// Simulation parameters
		private List<Tavolo>tavoli;
		
		// World model

		// Measures of Interest
		private int gruppiSoddisfatti = 0;
		private int gruppiInsoddisfatti=0;
		private int gruppiTotali = 0;

		// Event queue
		private PriorityQueue<Event> queue;

		public Simulator(List<Tavolo> tavoli) {
			this.tavoli=tavoli;
			
			this.queue = new PriorityQueue<>();
		}


	public void addGruppo(Gruppo gruppo, int time) {
		Event e = new Event(gruppo, time, EventType.ARRIVE) ;
		queue.add(e) ;
	}
	
	public void run() {
		while (!queue.isEmpty()) {
			Event e = queue.poll();
			//System.out.println(e);
			switch (e.getType()) {
			case ARRIVE:
				processArriveEvent(e);
				break;
			case OUT:
				processOutEvent(e);
				break;
			
			}
		}
	}



	private void processArriveEvent(Event e) {
		Gruppo g= e.getGruppo();
		int duration = (int) ((Math.random()*10)*120);
		int numeroPersone= g.getNumber();
		boolean servito=false;
		
		
		for(Tavolo t: tavoli){
			if(t.getGruppoSeduto()==null&&t.getNumeroPosti()>=numeroPersone){
				servito=true;
				t.setGruppoSeduto(g);
				Event newEvent = new Event(g, e.getTime()+duration, EventType.OUT);
				queue.add(newEvent);
				gruppiSoddisfatti++;
				gruppiTotali++;
				break;
			}
		}
		if(servito==false){
			double tolleranza= g.getTolleranza();
			double random= Math.random();         // esprimo la probabilita in funzione della tolleranza
			if(random>tolleranza){
              gruppiInsoddisfatti++;
				gruppiTotali++;                   //insoddisfatti
			}
			else{		
				gruppiSoddisfatti++;              //soddisfatti al bancone
				gruppiTotali++;
			}
		
			
		}
		
		
		
	}
	private void processOutEvent(Event e) {
		Tavolo t= e.getGruppo().getTavolo();
		t.setGruppoSeduto(null);	
	}

	
}
