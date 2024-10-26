package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

	// TODO: objektvariable 

    Innlegg[] innleggtabell; 
    int nesteledig = 0;

	public Blogg() {
        innleggtabell = new Innlegg[20];
	}

	public Blogg(int lengde) {
        innleggtabell = new Innlegg[lengde];

	}

	public int getAntall() {
        return nesteledig;
	}
	
	public Innlegg[] getSamling() {
        return innleggtabell;
	}

    // ettersom det ikke er noe garanti på at innleggene er sortert etter id ser jeg ikke noe poeng i en avansert søkealgoritme
	public int finnInnlegg(Innlegg innlegg) {
        for (int i = 0; i < nesteledig; i++) {
            if (innleggtabell[i].erLik(innlegg)) return i;
        }
        return -1;

	}

	public boolean finnes(Innlegg innlegg) {
        return finnInnlegg(innlegg) >= 0;
	}

	public boolean ledigPlass() {
        return nesteledig < innleggtabell.length; 

	}
	
	public boolean leggTil(Innlegg innlegg) {
        if (ledigPlass()) { 
            innleggtabell[nesteledig] = innlegg;
            nesteledig++;
            return true;
        }
        return false;
	}
	
	public String toString() {
        String result = Integer.toString(nesteledig) + "\n";
        for (int i = 0; i < nesteledig; i++) {
            result += innleggtabell[i].toString();
        }
        return result;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
        int newSize = innleggtabell.length * 2;
        Innlegg[] newArr = new Innlegg[newSize];
        for (int i = 0; i < nesteledig; i++) {
            newArr[i] = innleggtabell[i];
        }
        innleggtabell = newArr;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
        if (finnes(innlegg)) return false;

        if (leggTil(innlegg)) return true;
    
        utvid();
        return leggTil(innlegg);
	}
	
	public boolean slett(Innlegg innlegg) {
        int innleggID = finnInnlegg(innlegg);

	    if (innleggID == -1) return false;

        for (int i = innleggID; i < nesteledig - 1; i++) {
            innleggtabell[i] = innleggtabell[i + 1];
        }
        nesteledig--;
        return true;

	}
	
    // Dette kunne sikkert fungert men Innlegg har ikke getText(). Kunne kanskje vært abstract klasse eller noe
//	public int[] search(String keyword) {
//        boolean[] containsKeyword = new boolean[innleggtabell.length];
//        int numResults = 0;
//
//        for (int i = 0; i < nesteledig; i++) {
//            Innlegg innlegg = innleggtabell[i];
//            
//            if (innlegg.getText().contains(keyword)) {
//                containsKeyword[i] = true;
//                numResults++;
//            }
//        }
//
//        int[] matchingIDs = new int[numResults];
//        int j = -1;
//        for (int i = 0; i < containsKeyword.length; i++) {
//            if (containsKeyword[i]) {
//                matchingIDs[j++] = i; 
//            }
//        }
//		
//		throw new UnsupportedOperationException(TODO.method());
//
//	}
}
