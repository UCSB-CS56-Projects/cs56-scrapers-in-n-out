package edu.ucsb.cs56.W11.aarondodson.InAndOutBurger;

public class InAndOutBurgerLocation
{
	/**
	 * InAndOutBurgerLocation represents the locations of an In And Out Burger.
	 *
	 * @see <a href="https://foo.cs.ucsb.edu/56mantis/view.php?id=3">
	 *      56mantis issue 0000003</a> 
	 *
	 * @author Aaron Dodson
	 */
	
	String city, address, county;
	int zip;
	
	/**
		Constructs an InAndOutBurgerLocation initialized to the Goleta location
	 */
	public InAndOutBurgerLocation()
	{
		city = "Goleta";
		address = "4865 Calle Real";
		county = "Santa Barbara";
		zip = 93111;
	}
	
	/**
		Constructs an InAndOutBurgerLocation initialized to a specified location
		@param newCity The city the In And Out Burger is located in
		@param newAddress The street address of the In And Out Burger
		@param newCounty The county the In And Out Burger is located in
		@param newZip The zip code of the In And Out Burger location
	 */
	public InAndOutBurgerLocation(String newCity, String newAddress, String newCounty, int newZip)
	{
		city = newCity;
		address = newAddress;
		county = newCounty;
		zip = newZip;
	}
	
	/**
		Sets the city for this location
		@param newCity The city the In And Out Burger is located in
	 */
	public void setCity(String newCity)
	{
		city = newCity;
	}
	
	/**
		Gets the city for this location
		@return The city the In And Out Burger is located in
	 */	
	public String getCity()
	{
		return city;
	}
	
	/**
		Sets the address for this location
		@param newAddress The address the In And Out Burger is located at
	 */	
	public void setAddress(String newAddress)
	{
		address = newAddress;
	}
	
	/**
		Gets the address for this location
		@return The address the In And Out Burger is located at
	 */	
	public String getAddress()
	{
		return address;
	}
	
	/**
		Sets the county for this location
		@param newCounty The county the In And Out Burger is located in
	 */	
	public void setCounty(String newCounty)
	{
		county = newCounty;
	}
	
	/**
		Gets the county for this location
		@return The county the In And Out Burger is located in
	 */	
	public String getCounty()
	{
		return county;
	}
	
	/**
		Sets the zip for this location
		@param newZip The zip code the In And Out Burger is located in
	 */	
	public void setZip(int newZip)
	{
		zip = newZip;
	}
	
	/**
		Gets the zip code for this location
		@return The zip code the In And Out Burger is located in
	 */	
	public int getZip()
	{
		return zip;
	}
	
	/**
		Prints a nicely formatted description of the location
		@return The full address of the location
	 */	
	public String toString()
	{
		String description = address + "\n" + city + " " + zip + "\n" + county + " County";
		
		return description;
	}
}
