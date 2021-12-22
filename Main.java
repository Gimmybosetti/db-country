package countries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/db-nations";
	private static final String DB_USER = "root";
	private static final String DB_PW = "Roottazz0!";

	public static void main(String[] args) {
		
		try(Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PW)){
			
			Country country = selectCountryById(con, 107);
			if(country != null) {
				System.out.println("Dati della riga prima dell'update:");
				System.out.print(country.getId() + "\t");
				System.out.print(country.getName() + "\t");
				System.out.print(country.getArea() + "\t");
				System.out.print(country.getNational_day() + "\t");
				System.out.print(country.getCountry_code2() + "\t");
				System.out.print(country.getCountry_code3() + "\t");
				System.out.println(country.getRegion_id() + "\t");
			}
			updateCountry(con, country);
			country = selectCountryById(con, 107);
			if(country != null) {
				System.out.println("Dati della riga dopo l'update:");
				System.out.print(country.getId() + "\t");
				System.out.print(country.getName() + "\t");
				System.out.print(country.getArea() + "\t");
				System.out.print(country.getNational_day() + "\t");
				System.out.print(country.getCountry_code2() + "\t");
				System.out.print(country.getCountry_code3() + "\t");
				System.out.println(country.getRegion_id() + "\t");
			}

		}catch(SQLException e) {
			System.out.println("OOOPS an error occurred");
			System.out.println(e.getMessage());
		}
	}
	
	private static Country selectCountryById(Connection con, int id) throws SQLException{
		Country country = null;
		String query = "select * from countries c where c.country_id = ?;";
		
		try (PreparedStatement psCountry = con.prepareStatement(query)){
			psCountry.setInt(1, id);
			
			try(ResultSet rsCountry = psCountry.executeQuery()){
				if(rsCountry.next()) {
					country = new Country(rsCountry.getInt(1), rsCountry.getString(2), rsCountry.getDouble(3),
							rsCountry.getDate(4), rsCountry.getString(5), rsCountry.getString(6), rsCountry.getInt(7));
				}
			}
		}
		return country;
	}
	
	private static void updateCountry (Connection con, Country country) throws SQLException{
		String update = "UPDATE countries SET country_id=?, name=?, area=?, national_day=?, country_code2=?,"
				+ "country_code3=?, region_id=? WHERE country_id=?;";
		try(PreparedStatement psUpdate = con.prepareStatement(update)){
			psUpdate.setInt(1, country.getId());
			psUpdate.setString(2, country.getName());
			psUpdate.setDouble(3, country.getArea());
			psUpdate.setDate(4, country.getNational_day());
			psUpdate.setString(5, country.getCountry_code2());
			psUpdate.setString(6, country.getCountry_code3());
			psUpdate.setInt(7, country.getRegion_id());
			psUpdate.setInt(8, country.getId());
			int result = psUpdate.executeUpdate();
			if(result == 0) {
				System.out.println("Country not found");
			}
			
			Country countryTest = selectCountryById(con, 107);
			if(countryTest.getNational_day() == null) {
				java.sql.Date dataNationalDay = java.sql.Date.valueOf(LocalDate.of(1861, 03, 17));
				countryTest.setNational_day(dataNationalDay);
				updateCountry(con, countryTest);
			}
			
		}
	}

}











