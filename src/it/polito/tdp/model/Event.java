package it.polito.tdp.model;



public class Event implements Comparable<Event>{
	public enum EventType { 
		ARRIVE, //un gruppo arriva al bar
		OUT   // un gruppo libera il tavolo
		} ;
		
		   //attributi dell evento
		private Gruppo gruppo ;
		private int time ;
		private EventType type ;
			
		public Event(Gruppo gruppo, int time, EventType type) {
			super();
			this.gruppo=gruppo;
			this.time = time;
			this.type = type ;
		}

		@Override
		public int compareTo(Event other) {
			return this.time-other.time;
		}

		public Gruppo getGruppo() {
			return gruppo;
		}

		public void setGruppo(Gruppo gruppo) {
			this.gruppo = gruppo;
		}

		public int getTime() {
			return time;
		}

		public void setTime(int time) {
			this.time = time;
		}

		public EventType getType() {
			return type;
		}

		public void setType(EventType type) {
			this.type = type;
		}

		@Override
		public String toString() {
			return "Event [gruppo=" + gruppo + ", time=" + time + ", type=" + type + "]";
		}
		
		
}
