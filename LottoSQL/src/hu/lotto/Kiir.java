package hu.lotto;

// Feladat: az eredmény megjelentése konzolon

public class Kiir {
	private int n;
	private Kivalaszt kivalaszt;
	
	public Kiir(Kivalaszt kivalaszt) {
		this.kivalaszt=kivalaszt;
	}
	public Kiir() {
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public void proc() {
		System.out.println("A "+n+" leggyakoribb elem: ");
		System.out.println(kivalaszt.getEredmeny());
			}

}
