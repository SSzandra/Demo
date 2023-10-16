package hu.lotto;

// Feladat: 1. 100 lottósorsolás szimulálása, az eredmény adatbázisban tárolása

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.sql.*;

public class Sorsol {
	private int maxElem;
	private int huzas;
	private String url;
	private String user;
	private String password;
	
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void proc() {
		Random random = new Random();
		List<Integer> szamok = new ArrayList<>();
		
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			String feltolt = "insert into lotto " +
					"(SZAM) " +
					"values (?)";
			PreparedStatement preparedStatement = connection.prepareStatement(feltolt);
			
			for(int i= 0; i<=maxElem; i++) {
				szamok.clear();
					for(int j=0; j<=huzas;j++) {
						int szam=random.nextInt(90);
							while (szamok.contains(szam)) {
								szam=random.nextInt(90);
						}
					szamok.add(szam);
					preparedStatement.setInt(1, szam);
					preparedStatement.executeUpdate();
				}
			}
			preparedStatement.close();
			connection.close();
			System.out.println("A sorsolások sikeresen megtörténtek");
		} catch (SQLException e) {
			System.out.println("Csatlakozás nem megfelelő");
		}
	}
}
