package edu.ucsb.cs56.W11.aarondodson.InAndOutBurger;
import java.util.ArrayList;

public class InAndOut
{
	public static void main(String[] argv)
	{
		InAndOutBurgerDirectory directory = new InAndOutBurgerDirectory("file:///Users/Aaron/Desktop/test.html");
		ArrayList<InAndOutBurgerLocation> locations = directory.allLocations();
		
		for (int i = 0; i < locations.size(); i++)
		{
			System.out.println(locations.get(i).toString());
			System.out.println("");
		}
	}
}
