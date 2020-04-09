package com.poker.implemetation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

import com.poker.templates.Figura;
import com.poker.templates.Kolor;
import com.poker.templates.Uklad;

public class SprawdzenieUkladu {

	private static ArrayList<Karta> ukladKart;

	public static Uklad sprawdzUklad(ArrayList<Karta> ukladKart) {
		SprawdzenieUkladu.ukladKart = ukladKart;

		
		if (czyPokerKrolewski()) {
			return Uklad.POKER_KROLEWSKI;
		} else if (czyPoker()) {
			return Uklad.POKER;
		} else if (czyKareta()) {
			return Uklad.KARETA;
		} else if (czyFull()) {
			return Uklad.FULL;
		} else if (czyStrit() && !czyKolor()) {
			return Uklad.STRIT;
		} else if (czyTrojka()) {
			return Uklad.TROJKA;
		} else if (czyDwiePary()) {
			return Uklad.DWIE_PARY;
		} else if (czyJednaPara()) {
			return Uklad.PARA;
		} else if (czyKolor()) {
			return Uklad.KOLOR;
		} else
			return Uklad.WYSOKA_KARTA;
	}

	private static boolean czyKolor() {
		Set<Kolor> zbiorKolorow = new TreeSet<Kolor>();

		ukladKart.forEach(e -> zbiorKolorow.add(e.getKolor()));

		return zbiorKolorow.size() == 1;
	}

	private static boolean czyJednaPara() {
		Set<Figura> zbiorFigur = new TreeSet<Figura>();

		ukladKart.forEach(e -> zbiorFigur.add(e.getFigura()));

		if (czyKolor())
			return false;

		return zbiorFigur.size() == 4;
	}

	private static boolean czyDwiePary() {
		long iloscParOutput = 0;
		List<Figura> listaFigur = new ArrayList<Figura>();

		ukladKart.forEach(e -> listaFigur.add(e.getFigura()));

		long as = listaFigur.stream().filter(c -> c == Figura.AS).count();
		long dwa = listaFigur.stream().filter(c -> c == Figura.DWOJKA).count();
		long trzy = listaFigur.stream().filter(c -> c == Figura.TROJKA).count();
		long cztery = listaFigur.stream().filter(c -> c == Figura.CZWÓRKA).count();
		long piec = listaFigur.stream().filter(c -> c == Figura.PIATKA).count();
		long szesc = listaFigur.stream().filter(c -> c == Figura.SZOSTKA).count();
		long siedem = listaFigur.stream().filter(c -> c == Figura.SIODEMKA).count();
		long osiem = listaFigur.stream().filter(c -> c == Figura.OSEMKA).count();
		long dziewiec = listaFigur.stream().filter(c -> c == Figura.DZIEWIATKA).count();
		long dziesiec = listaFigur.stream().filter(c -> c == Figura.DZIESIATKA).count();
		long walet = listaFigur.stream().filter(c -> c == Figura.WALET).count();
		long dama = listaFigur.stream().filter(c -> c == Figura.DAMA).count();
		long krol = listaFigur.stream().filter(c -> c == Figura.KROL).count();

		List<Long> iloscParList = new ArrayList<>();
		iloscParList.add(as);
		iloscParList.add(dwa);
		iloscParList.add(trzy);
		iloscParList.add(cztery);
		iloscParList.add(piec);
		iloscParList.add(szesc);
		iloscParList.add(siedem);
		iloscParList.add(osiem);
		iloscParList.add(dziewiec);
		iloscParList.add(dziesiec);
		iloscParList.add(walet);
		iloscParList.add(dama);
		iloscParList.add(krol);

		// Pierwszy sposób (d³u¿szy) -> zliczanie wyst¹pieñ w ArrayList
		Long searched = 2L;
		iloscParOutput = IntStream.range(0, iloscParList.size()).filter(i -> searched.equals(iloscParList.get(i)))
				.count();

		if (czyKolor())
			return false;

		return iloscParOutput == 2;
	}

	private static boolean czyTrojka() {
		long iloscParOutput = 0;
		List<Figura> listaFigur = new ArrayList<Figura>();

		ukladKart.forEach(e -> listaFigur.add(e.getFigura()));

		long as = listaFigur.stream().filter(c -> c == Figura.AS).count();
		long dwa = listaFigur.stream().filter(c -> c == Figura.DWOJKA).count();
		long trzy = listaFigur.stream().filter(c -> c == Figura.TROJKA).count();
		long cztery = listaFigur.stream().filter(c -> c == Figura.CZWÓRKA).count();
		long piec = listaFigur.stream().filter(c -> c == Figura.PIATKA).count();
		long szesc = listaFigur.stream().filter(c -> c == Figura.SZOSTKA).count();
		long siedem = listaFigur.stream().filter(c -> c == Figura.SIODEMKA).count();
		long osiem = listaFigur.stream().filter(c -> c == Figura.OSEMKA).count();
		long dziewiec = listaFigur.stream().filter(c -> c == Figura.DZIEWIATKA).count();
		long dziesiec = listaFigur.stream().filter(c -> c == Figura.DZIESIATKA).count();
		long walet = listaFigur.stream().filter(c -> c == Figura.WALET).count();
		long dama = listaFigur.stream().filter(c -> c == Figura.DAMA).count();
		long krol = listaFigur.stream().filter(c -> c == Figura.KROL).count();

		List<Long> iloscParList = new ArrayList<>();
		iloscParList.add(as);
		iloscParList.add(dwa);
		iloscParList.add(trzy);
		iloscParList.add(cztery);
		iloscParList.add(piec);
		iloscParList.add(szesc);
		iloscParList.add(siedem);
		iloscParList.add(osiem);
		iloscParList.add(dziewiec);
		iloscParList.add(dziesiec);
		iloscParList.add(walet);
		iloscParList.add(dama);
		iloscParList.add(krol);

		// Drugi sposób (krótszy) -> zliczanie wyst¹pieñ w ArrayList
		Long searched = 3L;
		iloscParOutput = iloscParList.stream().filter(e -> searched.equals(e)).count();

		if (czyKolor())
			return false;

		return iloscParOutput == 1;
	}

	private static boolean czyStrit() {
		List<Integer> uklad = new LinkedList<>();
		int min;
		if (ukladKart.size() < 5)
			return false;
		ukladKart.forEach(it -> uklad.add(it.getFigura().ordinal()));
		Collections.sort(uklad);

		min = uklad.get(0);

		if (uklad.get(4) == 12) {
			for (int i = 1; i < uklad.size() - 1; i++) {
				if ((min - uklad.get(i) + i) != 0) {
					return false;
				}
			}
		} else {
			for (int i = 1; i < uklad.size(); i++) {
				if ((min - uklad.get(i) + i) != 0) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean czyFull() {
		long iloscTrojekOutput = 0;
		long iloscDwojekOutput = 0;
		List<Figura> listaFigur = new ArrayList<Figura>();

		ukladKart.forEach(e -> listaFigur.add(e.getFigura()));

		long as = listaFigur.stream().filter(c -> c == Figura.AS).count();
		long dwa = listaFigur.stream().filter(c -> c == Figura.DWOJKA).count();
		long trzy = listaFigur.stream().filter(c -> c == Figura.TROJKA).count();
		long cztery = listaFigur.stream().filter(c -> c == Figura.CZWÓRKA).count();
		long piec = listaFigur.stream().filter(c -> c == Figura.PIATKA).count();
		long szesc = listaFigur.stream().filter(c -> c == Figura.SZOSTKA).count();
		long siedem = listaFigur.stream().filter(c -> c == Figura.SIODEMKA).count();
		long osiem = listaFigur.stream().filter(c -> c == Figura.OSEMKA).count();
		long dziewiec = listaFigur.stream().filter(c -> c == Figura.DZIEWIATKA).count();
		long dziesiec = listaFigur.stream().filter(c -> c == Figura.DZIESIATKA).count();
		long walet = listaFigur.stream().filter(c -> c == Figura.WALET).count();
		long dama = listaFigur.stream().filter(c -> c == Figura.DAMA).count();
		long krol = listaFigur.stream().filter(c -> c == Figura.KROL).count();

		List<Long> iloscParList = new ArrayList<>();
		iloscParList.add(as);
		iloscParList.add(dwa);
		iloscParList.add(trzy);
		iloscParList.add(cztery);
		iloscParList.add(piec);
		iloscParList.add(szesc);
		iloscParList.add(siedem);
		iloscParList.add(osiem);
		iloscParList.add(dziewiec);
		iloscParList.add(dziesiec);
		iloscParList.add(walet);
		iloscParList.add(dama);
		iloscParList.add(krol);

		Long searchedThree = 3L;
		Long searchedPair = 2L;

		iloscTrojekOutput = iloscParList.stream().filter(e -> searchedThree.equals(e)).count();
		iloscDwojekOutput = iloscParList.stream().filter(e -> searchedPair.equals(e)).count();
		if (czyKolor())
			return false;

		return iloscTrojekOutput == 1 && iloscDwojekOutput == 1;
	}

	private static boolean czyKareta() {
		long iloscParOutput = 0;
		List<Figura> listaFigur = new ArrayList<Figura>();

		ukladKart.forEach(e -> listaFigur.add(e.getFigura()));

		long as = listaFigur.stream().filter(c -> c == Figura.AS).count();
		long dwa = listaFigur.stream().filter(c -> c == Figura.DWOJKA).count();
		long trzy = listaFigur.stream().filter(c -> c == Figura.TROJKA).count();
		long cztery = listaFigur.stream().filter(c -> c == Figura.CZWÓRKA).count();
		long piec = listaFigur.stream().filter(c -> c == Figura.PIATKA).count();
		long szesc = listaFigur.stream().filter(c -> c == Figura.SZOSTKA).count();
		long siedem = listaFigur.stream().filter(c -> c == Figura.SIODEMKA).count();
		long osiem = listaFigur.stream().filter(c -> c == Figura.OSEMKA).count();
		long dziewiec = listaFigur.stream().filter(c -> c == Figura.DZIEWIATKA).count();
		long dziesiec = listaFigur.stream().filter(c -> c == Figura.DZIESIATKA).count();
		long walet = listaFigur.stream().filter(c -> c == Figura.WALET).count();
		long dama = listaFigur.stream().filter(c -> c == Figura.DAMA).count();
		long krol = listaFigur.stream().filter(c -> c == Figura.KROL).count();

		List<Long> iloscParList = new ArrayList<>();
		iloscParList.add(as);
		iloscParList.add(dwa);
		iloscParList.add(trzy);
		iloscParList.add(cztery);
		iloscParList.add(piec);
		iloscParList.add(szesc);
		iloscParList.add(siedem);
		iloscParList.add(osiem);
		iloscParList.add(dziewiec);
		iloscParList.add(dziesiec);
		iloscParList.add(walet);
		iloscParList.add(dama);
		iloscParList.add(krol);

		Long searched = 4L;
		iloscParOutput = iloscParList.stream().filter(e -> searched.equals(e)).count();

		if (czyKolor())
			return false;

		return iloscParOutput == 1;
	}

	
	private static boolean czyPoker() {
		return czyKolor() && czyStrit() && !czyPokerKrolewski();
	}
	
	
	private static boolean czyPokerKrolewski() {
		List<Figura> listaFigur = new ArrayList<Figura>();

		ukladKart.forEach(e -> listaFigur.add(e.getFigura()));

		long dziesiec = listaFigur.stream().filter(c -> c == Figura.DZIESIATKA).count();
		long walet = listaFigur.stream().filter(c -> c == Figura.WALET).count();
		long dama = listaFigur.stream().filter(c -> c == Figura.DAMA).count();
		long krol = listaFigur.stream().filter(c -> c == Figura.KROL).count();
		long as = listaFigur.stream().filter(c -> c == Figura.AS).count();
		
		List<Long> iloscParList = new ArrayList<>();
		
		iloscParList.add(dziesiec);
		iloscParList.add(walet);
		iloscParList.add(dama);
		iloscParList.add(krol);
		iloscParList.add(as);
		
		Long searched = 1L;
		long iloscKartPasujacych = iloscParList.stream().filter(e -> searched.equals(e)).count();

		return iloscKartPasujacych == 5 && czyKolor();
	}
}
