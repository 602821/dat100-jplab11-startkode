package no.hvl.dat100.jplab11.oppgave4;


import java.io.IOException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		
		try {
			PrintWriter writer = new PrintWriter(mappe + filnavn);
			writer.write(samling.toString());
			writer.close();
			return true;
		} catch (IOException e) {
		      e.printStackTrace();
		      return false;
		}

	}
}
