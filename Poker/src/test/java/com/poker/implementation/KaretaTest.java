package com.poker.implementation;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.poker.implemetation.Karta;
import com.poker.implemetation.SprawdzenieUkladu;
import com.poker.templates.Figura;
import com.poker.templates.Kolor;
import com.poker.templates.Uklad;

@RunWith(Parameterized.class)
public class KaretaTest {
	
	
	private ArrayList<Karta> ukladKart;
	private Uklad odpowiedz;
	private static int numerTestu;
	
	public KaretaTest(List<Karta> ukladKart, Uklad odpowiedz) {
		super();
		this.ukladKart = new ArrayList<Karta>(ukladKart);
		this.odpowiedz = odpowiedz;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> tests() {
		
		Object[][] tests = {
				{Arrays.asList(new Object[] { 
						new Karta(Figura.KROL, Kolor.Trefl),
						new Karta(Figura.KROL, Kolor.Kier),
						new Karta(Figura.KROL, Kolor.Pik),
						new Karta(Figura.KROL, Kolor.Kier),
						new Karta(Figura.AS, Kolor.Karo)
						}), Uklad.KARETA
				},
				{Arrays.asList(new Object[] { 
						new Karta(Figura.CZW�RKA, Kolor.Kier),
						new Karta(Figura.WALET, Kolor.Kier),
						new Karta(Figura.WALET, Kolor.Trefl),
						new Karta(Figura.WALET, Kolor.Karo),
						new Karta(Figura.WALET, Kolor.Kier)
						}), Uklad.KARETA
				},
				{Arrays.asList(new Object[] { 
						new Karta(Figura.DAMA, Kolor.Kier),
						new Karta(Figura.DWOJKA, Kolor.Kier),
						new Karta(Figura.DAMA, Kolor.Kier),
						new Karta(Figura.DAMA, Kolor.Trefl),
						new Karta(Figura.DAMA, Kolor.Pik)
						}), Uklad.KARETA
				},
				{Arrays.asList(new Object[] { 
						new Karta(Figura.DWOJKA, Kolor.Karo),
						new Karta(Figura.DWOJKA, Kolor.Trefl),
						new Karta(Figura.WALET, Kolor.Karo),
						new Karta(Figura.DWOJKA, Kolor.Pik),
						new Karta(Figura.DWOJKA, Kolor.Karo)
						}), Uklad.KARETA
				},
				{Arrays.asList(new Object[] { 
						new Karta(Figura.AS, Kolor.Karo),
						new Karta(Figura.AS, Kolor.Pik),
						new Karta(Figura.AS, Kolor.Trefl),
						new Karta(Figura.PIATKA, Kolor.Trefl),
						new Karta(Figura.AS, Kolor.Karo)
						}), Uklad.KARETA
				},
				
		};
		return Arrays.asList(tests);
	}
	
	@Test
	public void testSparametryzowany() {
		System.out.println("Numer Testu: " + ++numerTestu + " KaretaTest");
		assertTrue(SprawdzenieUkladu.sprawdzUklad(ukladKart) == odpowiedz);
	}
}
