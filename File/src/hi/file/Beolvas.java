package hi.file;

// Feladat: 2. file beolvasása

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Beolvas {
	private String szoveg;
	private List<Character> karakter = new ArrayList<>();
	
	public String getSzoveg() {
		return szoveg;
	}
	public void setSzoveg(String szoveg) {
		this.szoveg = szoveg;
	}
	public List<Character> getKarakter() {
		return karakter;
	}
	public void setKarakter(List<Character> karakter) {
		this.karakter = karakter;
	}
	
	public void proc() throws FileNotFoundException {
		Beolvas beolvas = new Beolvas();
		
		try { File file = new File("D:\\Szandra\\szoveg.txt");
        Scanner scan = new Scanner(file);
        scan.useDelimiter("\\Z");
        beolvas.setSzoveg(scan.next());
        scan.close();
		} catch (IOException e) {
		}
	
		for(char c: beolvas.getSzoveg().toCharArray()) {
			karakter.add(c);
		}
		}
	}
