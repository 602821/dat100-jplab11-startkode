package no.hvl.dat100.jplab11.oppgave3;

import java.util.Arrays;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg() {
		innleggtabell = new Innlegg[20];
		nesteledig = 0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {
		
		int i = 0;
		while(i<getAntall()) {
			if(innleggtabell[i].erLik(innlegg)) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		
		return finnInnlegg(innlegg) == -1 ? false : true;
	}

	public boolean ledigPlass() {
		return nesteledig < innleggtabell.length;
	}
	
	public boolean leggTil(Innlegg innlegg) {

		if(ledigPlass() && !finnes(innlegg)) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		String result = getAntall()+"\n";
		for(int i = 0; i<nesteledig; i++) {
			result += innleggtabell[i].toString();
		}
		return result;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		
		Innlegg[] blogCopy = getSamling();
		int size = innleggtabell.length*2;
		innleggtabell = new Innlegg[size];
		nesteledig = 0;
		
		for(Innlegg innlegg : blogCopy) {
			leggTil(innlegg);			
		}
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		if(!leggTil(innlegg)) {
			utvid();
		}
		return leggTil(innlegg);
	}
	
	public boolean slett(Innlegg innlegg) {
		int index = finnInnlegg(innlegg);
		
		if(index > -1) {
			nesteledig--;
			
			for(int i = index; i<nesteledig; i++) {
				innleggtabell[i] = innleggtabell[i+1];
			}
			
			innleggtabell[nesteledig] = null;
			
			return true;
			
		} else {
			return false;
		}
	}
	
	public int[] search(String keyword) {

		String kw = keyword.toLowerCase();
		
		int[] result = new int[0];
		for(int i=0; i<nesteledig; i++) {
			if(innleggtabell[i].getTekst().contains(kw)) {
				result = Arrays.copyOf(result, result.length + 1);
				result[result.length-1] = innleggtabell[i].getId();
			}			
		}
		
		return result;

	}
}