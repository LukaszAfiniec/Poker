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
public class PokerTest {
	
	
	private ArrayList<Karta> ukladKart;
	private Uklad odpowiedz;
	private static int numerTestu;
	
	public PokerTest(List<Karta> ukladKart, Uklad odpowiedz) {
		super();
		this.ukladKart = new ArrayList<Karta>(ukladKart);
		this.odpowiedz = odpowiedz;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> tests() {
		
		Object[][] tests = {
				{Arrays.asList(new Object[] { 
						new Karta(Figura.DWOJKA, Kolor.Kier),
						new Karta(Figura.TROJKA, Kolor.Kier),
						new Karta(Figura.CZWÓRKA, Kolor.Kier),
						new Karta(Figura.PIATKA, Kolor.Kier),
						new Karta(Figura.SZOSTKA, Kolor.Kier)
						}), Uklad.POKER
				},
				{Arrays.asList(new Object[] { 
						new Karta(Figura.OSEMKA, Kolor.Trefl),
						new Karta(Figura.DZIEWIATKA, Kolor.Trefl),
						new Karta(Figura.DZIESIATKA, Kolor.Trefl),
						new Karta(Figura.WALET, Kolor.Trefl),
						new Karta(Figura.DAMA, Kolor.Trefl)
						}), Uklad.POKER
				},
				
				{Arrays.asList(new Object[] { 
						new Karta(Figura.AS, Kolor.Pik),
						new Karta(Figura.DWOJKA, Kolor.Pik),
						new Karta(Figura.TROJKA, Kolor.Pik),
						new Karta(Figura.CZWÓRKA, Kolor.Pik),
						new Karta(Figura.PIATKA, Kolor.Pik)
						}), Uklad.POKER
				},
				{Arrays.asList(new Object[] { 
						new Karta(Figura.DZIEWIATKA, Kolor.Karo),
						new Karta(Figura.DZIESIATKA, Kolor.Karo),
						new Karta(Figura.WALET, Kolor.Karo),
						new Karta(Figura.DAMA, Kolor.Karo),
						new Karta(Figura.KROL, Kolor.Karo)
						}), Uklad.POKER
				},
				{Arrays.asList(new Object[] { 
						new Karta(Figura.CZWÓRKA, Kolor.Kier),
						new Karta(Figura.PIATKA, Kolor.Kier),
						new Karta(Figura.SZOSTKA, Kolor.Kier),
						new Karta(Figura.SIODEMKA, Kolor.Kier),
						new Karta(Figura.OSEMKA, Kolor.Kier)
						}), Uklad.POKER
				},
			
				
		};
		return Arrays.asList(tests);
	}
	
	@Test
	public void testSparametryzowany() {
		System.out.println("Numer Testu: " + ++numerTestu + ". PokerTest");
		assertTrue(SprawdzenieUkladu.sprawdzUklad(ukladKart) == odpowiedz);
	}
}