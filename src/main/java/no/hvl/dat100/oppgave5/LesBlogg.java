package no.hvl.dat100.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.*;
import no.hvl.dat100.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static final String TEKST = "TEKST";
	private static final String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
        //Dette er for linux. 
        //tror windows er noe sånn her File file = new File(mappe + "\" + filenavn);
        //eller new File(mappe + "\\" + filnavn)
        File file = new File(mappe + "/" + filnavn);

		try (Scanner scanner = new Scanner(file)) {
			int numInnlegg = Integer.parseInt(scanner.nextLine());
			Blogg blogg = new Blogg(numInnlegg);

			for (int i = 0; i < numInnlegg; i++) {
				if (!scanner.hasNextLine()) throw new IOException("Filleser sluttet uforventet");

				String type = scanner.nextLine();
				if (TEKST.equals(type)) {
					blogg.leggTil(parseTekst(scanner));

				} else if (BILDE.equals(type)) {
					blogg.leggTil(parseBilde(scanner));

				} else {
					throw new IOException("Ukjent innleggstype: " + type);
				}
			}
			return blogg;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static Tekst parseTekst(Scanner scanner) throws IOException {
		try {
			int id = Integer.parseInt(scanner.nextLine());
			String bruker = scanner.nextLine();
			String dato = scanner.nextLine();
			int likes = Integer.parseInt(scanner.nextLine());
			String tekst = scanner.nextLine();
			return new Tekst(id, bruker, dato, likes, tekst);
		} catch (Exception e) {
			throw new IOException("Kan ikke lese inn data fra TEKST innlegg", e);
		}
	}

	private static Bilde parseBilde(Scanner scanner) throws IOException {
		try {
			int id = Integer.parseInt(scanner.nextLine());
			String bruker = scanner.nextLine();
			String dato = scanner.nextLine();
			int likes = Integer.parseInt(scanner.nextLine());
			String tekst = scanner.nextLine();
			String url = scanner.nextLine();
			return new Bilde(id, bruker, dato, likes, tekst, url);
		} catch (Exception e) {
			throw new IOException("Kan ikke lese inn data fra BILDE innlegg", e);
		}
	}
}
