package hu.Lotto;

// Feladat: 3. Eredmény kiírása konzolra

public class Eredmeny {
	private int n;
	private Kivalasztas kivalasztas;
	
	public Eredmeny(Kivalasztas kivalasztas) {
		this.kivalasztas=kivalasztas;
	}
	public Eredmeny() {
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	
	public void proc() {
		System.out.println("A "+n+" leggyakoribb elem: ");
		System.out.println(kivalasztas.getEredmeny());
			}
	}
