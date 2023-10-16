package hi.file;

// Feladat: 3. beolvasott szöveg kiírása konzolra visszafelé

import java.util.Collections;

public class Megjelenit {
	private Beolvas beolvas;
	
	public Megjelenit(Beolvas beolvas) {
		this.beolvas=beolvas;
	}
	public Beolvas getBeolvas() {
		return beolvas;
	}
	public void setBeolvas(Beolvas beolvas) {
		this.beolvas = beolvas;
	}
	
	public void proc() {
		Collections.reverse(beolvas.getKarakter());
		System.out.println(beolvas.getKarakter().toString());	
	}
}
