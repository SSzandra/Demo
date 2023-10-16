package hu.Lotto;

// Feladat: 2. a három leggyakoribb szám kiválasztása

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Kivalasztas {
	private int n;
	private List<Integer> eredmeny = new ArrayList<>();
	private Sorsolas sorsolas;
	
	public Kivalasztas(Sorsolas sorsolas) {
		this.sorsolas=sorsolas;
	}
	public Kivalasztas() {
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public List<Integer> getEredmeny() {
		return eredmeny;
	}
	public void setEredmeny(List<Integer> eredmeny) {
		this.eredmeny = eredmeny;
	}
	public Sorsolas getSorsolas() {
		return sorsolas;
	}
	public void setSorsolas(Sorsolas sorsolas) {
		this.sorsolas = sorsolas;
	}
	
	public void proc() {
		HashMap<Integer, Integer> elementCountMap = new HashMap<Integer, Integer>(); //HashMap létrehozása
		for (int i : sorsolas.getLista()) { // Lista bejárása
			if (elementCountMap.containsKey(i)) {
				elementCountMap.put(i, elementCountMap.get(i)+1);
				// Ha a számot már tartalmazza a Map, akkor a számlálóját növeljük
			}
			else {
				elementCountMap.put(i, 1);
				// Ha a számot még nem tartalmazza a Map, belerakjuk 1 értékű számlálóval
			}	
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->
			elementCountMap.get(b) -
			elementCountMap.get(a));
			// PriorityQueue létrehozása és csökkenő sorrend beállítása
		pq.addAll(elementCountMap.keySet()); // a Map elemeinek áttöltése
		for(int i=0;i<n&&!pq.isEmpty();i++) {
			eredmeny.add(pq.poll()); // a pq legfelső  n db. elemének hozzáadása a listához
				}
	}
}
