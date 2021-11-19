package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
		
		Blogg blogg = new Blogg();
		Scanner scanner;
		String blogType;
		try {
			scanner = new Scanner(new File(mappe+filnavn));
			
			if(scanner.hasNextLine()) {
				
				int size = Integer.parseInt(scanner.nextLine());
				blogg = new Blogg(size);
				
				while(scanner.hasNextLine()) {
					
					blogType = scanner.nextLine();
					
					int id = Integer.parseInt(scanner.nextLine());
					String bruker = scanner.nextLine();
					String dato = scanner.nextLine();
					int likes = Integer.parseInt(scanner.nextLine());
					String tekst = scanner.nextLine();
					
					if(blogType.equals(TEKST)) {
						
						blogg.leggTil(new Tekst(id, bruker, dato, likes, tekst));
						
					} else if(blogType.equals(BILDE)) {
						
						String url = scanner.nextLine();
						blogg.leggTil(new Bilde(id, bruker, dato, likes, tekst, url));
						
					}
					
				}
				scanner.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return blogg;	
	}
}
