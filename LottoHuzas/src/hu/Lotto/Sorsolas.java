package hu.Lotto;

// Feladat: 1. 100 lottósorsolás szimulálása

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sorsolas {
	private int maxElem;
	private int huzas;
	private List<Integer> szamok = new ArrayList<>(); // 5 szám tárolása, ismétlődések kiszűrése
	private List<Integer> lista = new ArrayList<>(); // eredmény lista (100*5 szám)
	
	public int getMaxElem() {
		return maxElem;
	}
	public void setMaxElem(int maxElem) {
		this.maxElem = maxElem;
	}
	public int getHuzas() {
		return huzas;
	}
	public void setHuzas(int huzas) {
		this.huzas = huzas;
	}
	public List<Integer> getSzamok() {
		return szamok;
	}
	public void setSzamok(List<Integer> szamok) {
		this.szamok = szamok;
	}
	public List<Integer> getLista() {
		return lista;
	}
	public void setLista(List<Integer> lista) {
		this.szamok = lista;
	}
	
	public void proc() {
		Random random = new Random();
		
		for(int i= 0; i<=maxElem; i++) {
			szamok.clear();
				for(int j=0; j<=huzas;j++) {
					int szam=random.nextInt(90);
						while (szamok.contains(szam)) {
							szam=random.nextInt(90);
					}
				szamok.add(szam);
				lista.add(szam);
			}
		}
	}
}
