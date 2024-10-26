package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
        String fullPath = mappe + "/" + filnavn;

        try (PrintWriter writer = new PrintWriter(fullPath)) {
            writer.println(samling.toString());
            writer.close();

            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
	}
}
