package edu.ucsb.cs56.W11.aarondodson.InAndOutBurger;

import java.net.*;
import java.io.*;
import java.util.*;

public class InAndOutBurgerDirectory 
{	
	
	/**
	 * InAndOutBurgerDirectory allows one to look up the locations of In And Out Burger franchises.
	 *
	 * @see <a href="https://foo.cs.ucsb.edu/56mantis/view.php?id=3">
	 *      56mantis issue 0000003</a> 
	 *
	 * @author Aaron Dodson
	 */
	
	ArrayList<InAndOutBurgerLocation> locations;
	
	/**
    	Constructs a directory based on the information in the given URL
    	@param url A file or web URL to a directory of In And Out Burger locations
	 */
	public InAndOutBurgerDirectory(String url)
	{
		locations = new ArrayList<InAndOutBurgerLocation>();
		URL location = null;
		try {
			location = new URL(url);
		}
		catch (MalformedURLException exception) {
			System.out.println("URL is malformed.");
		}
		
		String contents = fetchURLContents(location);
		parseSource(contents);
	}
	
	/**
    	Fetches a list of every In And Out Burger location
    	@return An ArrayList of every In And Out Burger location
	 */
	public ArrayList<InAndOutBurgerLocation> allLocations()
	{
		return locations;
	}
	
	/**
    	Fetches a list of In And Out Burger locations in a given city
    	@param city The city to search for locations in
    	@return An ArrayList of matching InAndOutBurgerLocation objects
	 */
	public ArrayList<InAndOutBurgerLocation> get(String city)
	{
		ArrayList<InAndOutBurgerLocation> cityLocations = new ArrayList<InAndOutBurgerLocation>();
		
		for (int i = 0; i < locations.size(); i++)
		{
			if (locations.get(i).getCity().equals(city))
				cityLocations.add(locations.get(i));
		}
		
		return cityLocations;
	}
	
	/**
		Fetches the number of In And Out Burger locations in a given city
		@param city The city to search for locations in
		@return An int equal to the number of locations in the city
	 */
	public int count(String city)
	{
		return get(city).size();
	}

	private String fetchURLContents(URL location)
	{
		String contents = "";
		BufferedReader bufferedReader = null;
		try
		{
			URLConnection connection = (URLConnection)location.openConnection();

			InputStream stream = new BufferedInputStream(connection.getInputStream());
			InputStreamReader reader = new InputStreamReader(stream);
			bufferedReader = new BufferedReader(reader);
		}
		catch (MalformedURLException exception) {
			System.out.println("The URL is malformed.");
		}
		catch (IOException exception) {
			System.out.println("Could not get input stream.");
		}

		boolean done = false;
		while (!done)
		{
			try
			{
				String nextLine = bufferedReader.readLine();

				if (nextLine != null)
					contents = contents + nextLine;
				else
					done = true;
			}
			catch (IOException exception) {
				System.out.println("Call to readLine() failed.");
			}
		}

		return contents;
	}
	
	private void parseSource(String source)
	{
		String[] items = source.split("<tr bgcolor=\"#");
		
		for (int i = 2; i < items.length; i++)
		{
			String currentItem = items[i];
			currentItem = currentItem.replaceAll("ffffff\">", "");
			currentItem = currentItem.replaceAll("eeeeee\">", "");
			currentItem = currentItem.replaceAll("<[^<>]+>", "");
			
			String[] subitems = currentItem.split("\t");
			
			String city = subitems[16];
			String address = subitems[24];
			address = address.replaceAll("\\*", "");
			int zip = Integer.parseInt(subitems[32].replaceAll(" ", ""));
			String county = subitems[40];
			
			InAndOutBurgerLocation newLoc = new InAndOutBurgerLocation(city, address, county, zip);
			locations.add(newLoc);
		}
	}
}
