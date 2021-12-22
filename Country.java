package countries;

public class Country {
	
	//attributes
	private int id;
	private String name;
	private double area;
	private java.sql.Date national_day;
	private String country_code2; 
	private String country_code3;
	private int region_id;
	
	//constructor
	public Country(int id, String name, double area, java.sql.Date national_day, String country_code2, String country_code3, int region_id) {
		this.id = id;
		this.name = name;
		this.area = area;
		this.national_day = national_day;
		this.country_code2 = country_code2;
		this.country_code3 = country_code3;
		this.region_id = region_id;
	}
	
	//getter e setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public java.sql.Date getNational_day() {
		return national_day;
	}
	public void setNational_day(java.sql.Date national_day) {
		this.national_day = national_day;
	}
	public String getCountry_code2() {
		return country_code2;
	}
	public void setCountry_code2(String country_code2) {
		this.country_code2 = country_code2;
	}
	public String getCountry_code3() {
		return country_code3;
	}
	public void setCountry_code3(String country_code3) {
		this.country_code3 = country_code3;
	}
	public int getRegion_id() {
		return region_id;
	}
	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}
	
	
	
}
