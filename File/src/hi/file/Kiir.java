package hi.file;

// Feladat: 1. tetszőleges szöveg bekérése és kiírása saját gépre

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Kiir {
	 private String szoveg;

	public String getSzoveg() {
		return szoveg;
	}
	public void setSzoveg(String szoveg) {
		this.szoveg = szoveg;
	}
	
	 public void proc() throws IOException {
		 Kiir kiir = new Kiir();
		 
		 System.out.println("Kérem a szöveget:");
		 Scanner scanner = new Scanner(System.in);
		 kiir.setSzoveg(scanner.next());
		 scanner.close();
		 
		 try { FileWriter fileWriter = new FileWriter("D:\\Szandra\\szoveg.txt");
		 fileWriter.write(kiir.getSzoveg());
	        fileWriter.close();
	 } catch (IOException ex) {
	 }
	 }
}