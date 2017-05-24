package it.polito.tdp.model;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


import it.polito.tdp.model.Event.EventType;

public class Simulator {
	private List<Event> tracciaEventi=new ArrayList<Event>();

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
			tracciaEventi.add(e);
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
		int numeroPersone= g.getNumber();
		int migliorNumero=9999;
		Tavolo migliorTavolo=null;
		
		
		for(Tavolo t: tavoli){
			if(t.isOccupato()==false&&t.getNumeroPosti()>=numeroPersone&&numeroPersone>=t.getNumeroPosti()/2){
				if(t.getNumeroPosti()<migliorNumero){
					migliorTavolo=t;
					migliorNumero=t.getNumeroPosti();
				}
			}
		}
		if(migliorTavolo!=null){             //trovato un tavolo
				migliorTavolo.setOccupato(true);
				g.setTavolo(migliorTavolo);
				int duration = (int) ((Math.random()*10)*60)+60;
				Event newEvent = new Event(g, e.getTime()+duration, EventType.OUT);
				queue.add(newEvent);
				gruppiSoddisfatti++;
				gruppiTotali++;
		}
		else{                                   //tavoli tutti occupati
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
		t.setOccupato(false);
	}


	public int getGruppiSoddisfatti() {
		return gruppiSoddisfatti;
	}


	public int getGruppiInsoddisfatti() {
		return gruppiInsoddisfatti;
	}


	public int getGruppiTotali() {
		return gruppiTotali;
	}


	public List<Event> getTracciaEventi() {
	
		return this.tracciaEventi;
	}

	
}
