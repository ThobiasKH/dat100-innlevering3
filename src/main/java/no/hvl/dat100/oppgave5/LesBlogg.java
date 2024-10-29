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

// meget lite fornøgd med denne
public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
        try {
            // Dette er for unix baserte system. 
            // tror windows er noe sånn her File file = new File(mappe + "\" + filenavn);
            // eller new File(mappe + "\\" + filnavn)
            File file = new File(mappe + "/" + filnavn);

            Scanner scanner = new Scanner(file);

            int numInnlegg = Integer.parseInt(scanner.nextLine());
            Blogg blogg = new Blogg(numInnlegg);

            // her stoler vi veldig på at formatet holder seg, men jaja
            for (int i = 0; i < numInnlegg; i++) {
                int numAttributes;
                if (!scanner.hasNextLine()) throw new IOException();
                String type = scanner.nextLine();
                // disgusting stuff right here
                int failSafe = 0;
                String failSafeStr = "allGood";
                if (type.equals("TEKST")) {
                    blogg.leggTil(
                        new Tekst(
                            scanner.hasNextLine() ? Integer.parseInt(scanner.nextLine()) : failSafe++,
                            scanner.hasNextLine() ? scanner.nextLine() : (failSafeStr += "FAIL"),
                            scanner.hasNextLine() ? scanner.nextLine() : (failSafeStr += "FAIL"),
                            scanner.hasNextLine() ? Integer.parseInt(scanner.nextLine()) : failSafe++,
                            scanner.hasNextLine() ? scanner.nextLine() : (failSafeStr += "FAIL")
                        )
                    );
                    continue;
                } 
                if (type.equals("BILDE")) {
                        blogg.leggTil(
                        new Bilde(
                            scanner.hasNextLine() ? Integer.parseInt(scanner.nextLine()) : failSafe++,
                            scanner.hasNextLine() ? scanner.nextLine() : (failSafeStr += "FAIL"),
                            scanner.hasNextLine() ? scanner.nextLine() : (failSafeStr += "FAIL"),
                            scanner.hasNextLine() ? Integer.parseInt(scanner.nextLine()) : failSafe++,
                            scanner.hasNextLine() ? scanner.nextLine() : (failSafeStr += "FAIL"),
                            scanner.hasNextLine() ? scanner.nextLine() : (failSafeStr += "FAIL")
                        )
                    );
                    continue;
                }
                
                if (failSafe != 0 || !failSafeStr.equals("allGood")) throw new IOException();
                
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
}
