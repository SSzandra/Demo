package hu.lotto;

// Feladat: a 3 leggyakrabban előforduló szám kiválasztása

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Kivalaszt {
	private String n;
	private String url;
	private String user;
	private String password;
	private List<Integer> eredmeny = new ArrayList<>();
	
	public String getN() {
		return n;
	}
	public void setN(String n) {
		this.n = n;
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
	public List<Integer> getEredmeny() {
		return eredmeny;
	}
	public void setEredmeny(List<Integer> eredmeny) {
		this.eredmeny = eredmeny;
	}
	public void proc() {
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			String gyakorisag = "SELECT SZAM, " +
					"COUNT(SZAM) AS count_szam " +
					"FROM lotto " +
					"GROUP BY SZAM " +
					"ORDER BY count_szam DESC " +
					"LIMIT " + n;		
			PreparedStatement preparedStatement = connection.prepareStatement(gyakorisag);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int szam = resultSet.getInt(1);
				eredmeny.add(szam);
			}
			preparedStatement.close();
			connection.close();
			System.out.println("A gyakoriság vizsgálata megtörtént");
		} catch (SQLException e) {
			System.out.println("Csatlakozás nem megfelelő");
		}
	}
}
