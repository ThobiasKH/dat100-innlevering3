package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

        // Dette er for unix baserte system. 
        // tror windows er noe sånn her File file = new File(mappe + "\" + filenavn);
        // eller new File(mappe + "\\" + filnavn)
        try (PrintWriter writer = new PrintWriter(mappe + "/" + filnavn)) {
            writer.println(samling.toString());
            writer.close();

            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
	}
}
