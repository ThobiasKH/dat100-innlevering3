package no.hvl.dat100.oppgave1;

import no.hvl.dat100.common.TODO;

public abstract class Innlegg {
	
	// TODO - deklarering av objektvariable
	
    protected int id;
    protected String bruker;
    protected String dato;
    protected int likes;

    public Innlegg() {

    }
	
	public Innlegg(int id, String bruker, String dato) {

		// TODO 
		//throw new UnsupportedOperationException(TODO.constructor("Innlegg"));
        //

        this.id = id;
        this.bruker = bruker;
        this.dato = dato;
	}

	public Innlegg(int id, String bruker, String dato, int likes) {

		// TODO - START
		
		//throw new UnsupportedOperationException(TODO.constructor("Innlegg"));
        this.id = id;
        this.bruker = bruker;
        this.dato = dato;
        this.likes = likes;
	}
	
	public String getBruker() {
		
		//throw new UnsupportedOperationException(TODO.method());
        return bruker;

	}

	public void setBruker(String bruker) {
        this.bruker = bruker;
	}

	public String getDato() {
		
        return dato;
	}

	public void setDato(String dato) {
        this.dato = dato;
	}

	public int getId() {
        return id;
	}

	public int getLikes() {
        return likes;
	}
	
	public void doLike () {
        likes++;
	}
	
	public boolean erLik(Innlegg innlegg) {
        return this.id == innlegg.id;
	}
	
	@Override
	public String toString() {	
        String idStr = Integer.toString(id) + "\n";
        String brukerStr = bruker + "\n";
        String datoStr = dato + "\n";
        String likesStr = Integer.toString(likes) + "\n";

        return idStr + brukerStr + datoStr + likesStr;
	}
	
	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		
		throw new UnsupportedOperationException(TODO.method());
				
	}
}
