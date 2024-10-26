package no.hvl.dat100.oppgave2;

import no.hvl.dat100.common.TODO;

public class Bilde extends Tekst {

	// TODO - objekt variable
    String url;
	
	public Bilde(int id, String bruker, String dato, String tekst, String url) {
        super(id, bruker, dato, tekst);
        this.url = url;
	}


	public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
        super(id, bruker, dato, likes, tekst);
        this.url = url;
	}
	
	public String getUrl() {
        return url;
	}

	public void setUrl(String url) {
        this.url = url;
	}

	@Override
	public String toString() {
        String idStr = Integer.toString(id) + "\n";
        String brukerStr = bruker + "\n";
        String datoStr = dato + "\n";
        String likesStr = Integer.toString(likes) + "\n";
        String tekstStr = tekst + "\n";
        String urlStr = url + "\n";

        return "BILDE\n" + idStr + brukerStr + datoStr + likesStr + tekstStr + urlStr;
	}

	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		
		throw new UnsupportedOperationException(TODO.method());
				
	}
}
