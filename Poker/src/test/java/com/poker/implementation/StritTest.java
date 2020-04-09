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
public class StritTest {
	
	
	private ArrayList<Karta> ukladKart;
	private Uklad odpowiedz;
	private static int numerTestu;
	
	public StritTest(List<Karta> ukladKart, Uklad odpowiedz) {
		super();
		this.ukladKart = new ArrayList<Karta>(ukladKart);
		this.odpowiedz = odpowiedz;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> tests() {
		
		Object[][] tests = {
				{Arrays.asList(new Object[] { 
						new Karta(Figura.DWOJKA, Kolor.Karo),
						new Karta(Figura.TROJKA, Kolor.Kier),
						new Karta(Figura.CZWÓRKA, Kolor.Kier),
						new Karta(Figura.PIATKA, Kolor.Kier),
						new Karta(Figura.SZOSTKA, Kolor.Kier)
						}), Uklad.STRIT
				},
				{Arrays.asList(new Object[] { 
						new Karta(Figura.DZIEWIATKA, Kolor.Trefl),
						new Karta(Figura.DZIESIATKA, Kolor.Kier),
						new Karta(Figura.WALET, Kolor.Trefl),
						new Karta(Figura.DAMA, Kolor.Karo),
						new Karta(Figura.KROL, Kolor.Kier)
						}), Uklad.STRIT
				},
				
				{Arrays.asList(new Object[] { 
						new Karta(Figura.AS, Kolor.Kier),
						new Karta(Figura.DWOJKA, Kolor.Kier),
						new Karta(Figura.TROJKA, Kolor.Kier),
						new Karta(Figura.CZWÓRKA, Kolor.Trefl),
						new Karta(Figura.PIATKA, Kolor.Pik)
						}), Uklad.STRIT
				},
				{Arrays.asList(new Object[] { 
						new Karta(Figura.DZIESIATKA, Kolor.Karo),
						new Karta(Figura.WALET, Kolor.Trefl),
						new Karta(Figura.DAMA, Kolor.Karo),
						new Karta(Figura.KROL, Kolor.Pik),
						new Karta(Figura.AS, Kolor.Karo)
						}), Uklad.STRIT
				},
				{Arrays.asList(new Object[] { 
						new Karta(Figura.CZWÓRKA, Kolor.Trefl),
						new Karta(Figura.PIATKA, Kolor.Pik),
						new Karta(Figura.SZOSTKA, Kolor.Karo),
						new Karta(Figura.SIODEMKA, Kolor.Trefl),
						new Karta(Figura.OSEMKA, Kolor.Kier)
						}), Uklad.STRIT
				},
			
				
		};
		return Arrays.asList(tests);
	}
	
	@Test
	public void testSparametryzowany() {
		System.out.println("Numer Testu: " + ++numerTestu + ". StritTest");
		assertTrue(SprawdzenieUkladu.sprawdzUklad(ukladKart) == odpowiedz);
	}
}
