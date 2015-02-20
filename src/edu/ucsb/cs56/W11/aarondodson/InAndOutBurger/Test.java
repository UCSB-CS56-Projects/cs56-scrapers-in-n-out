package edu.ucsb.cs56.W11.aarondodson.InAndOutBurger;

import java.util.ArrayList;

public class Test
{
	public static void main(String[] argv)
	{
		InAndOutBurgerLocation loc = new InAndOutBurgerLocation();
		if (loc == null)
			System.out.println("No args constructor FAILED");
		else
			System.out.println("No args constructor PASSED");
		
		System.out.println("*****Running accessors tests on no-args object******");
		
		if (loc.getAddress().equals("4865 Calle Real"))
			System.out.println("Address accessors test 1 PASSED");
		else
			System.out.println("Address accessors test 1 FAILED");
		
		loc.setAddress("1222 Copper Penny Court");
		if (loc.getAddress().equals("1222 Copper Penny Court"))
			System.out.println("Address accessors test 2 PASSED");
		else
			System.out.println("Address accessors test 2 FAILED");
		
		if (loc.getCity().equals("Goleta"))
			System.out.println("City accessors test 1 PASSED");
		else
			System.out.println("City accessors test 1 FAILED");
		
		loc.setCity("Charleston");
		if (loc.getCity().equals("Charleston"))
			System.out.println("City accessors test 2 PASSED");
		else
			System.out.println("City accessors test 2 FAILED");
		
		if (loc.getCounty().equals("Santa Barbara"))
			System.out.println("County accessors test 1 PASSED");
		else
			System.out.println("County accessors test 1 FAILED");
		
		loc.setCounty("Dorchester");
		if (loc.getCounty().equals("Dorchester"))
			System.out.println("County accessors test 2 PASSED");
		else
			System.out.println("County accessors test 2 FAILED");
		
		if (loc.getZip() == 93111)
			System.out.println("Zip accessors test 1 PASSED");
		else
			System.out.println("Zip accessors test 1 FAILED");
		
		loc.setZip(12345);
		if (loc.getZip() == 12345)
			System.out.println("Zip accessors test 2 PASSED");
		else
			System.out.println("Zip accessors test 2 FAILED");
		
		loc = new InAndOutBurgerLocation("Awendaw", "4561 Angel Oak Way", "Berkeley", 28486);
		if (loc == null)
			System.out.println("Args constructor FAILED");
		else
			System.out.println("Args constructor PASSED");
		
		System.out.println("*****Running accessors tests on args object******");
		
		if (loc.getAddress().equals("4561 Angel Oak Way"))
			System.out.println("Address accessors test 1 PASSED");
		else
			System.out.println("Address accessors test 1 FAILED");
		
		loc.setAddress("1222 Copper Penny Court");
		if (loc.getAddress().equals("1222 Copper Penny Court"))
			System.out.println("Address accessors test 2 PASSED");
		else
			System.out.println("Address accessors test 2 FAILED");
		
		if (loc.getCity().equals("Awendaw"))
			System.out.println("City accessors test 1 PASSED");
		else
			System.out.println("City accessors test 1 FAILED");
		
		loc.setCity("Charleston");
		if (loc.getCity().equals("Charleston"))
			System.out.println("City accessors test 2 PASSED");
		else
			System.out.println("City accessors test 2 FAILED");
		
		if (loc.getCounty().equals("Berkeley"))
			System.out.println("County accessors test 1 PASSED");
		else
			System.out.println("County accessors test 1 FAILED");
		
		loc.setCounty("Dorchester");
		if (loc.getCounty().equals("Dorchester"))
			System.out.println("County accessors test 2 PASSED");
		else
			System.out.println("County accessors test 2 FAILED");
		
		if (loc.getZip() == 28486)
			System.out.println("Zip accessors test 1 PASSED");
		else
			System.out.println("Zip accessors test 1 FAILED");
		
		loc.setZip(12345);
		if (loc.getZip() == 12345)
			System.out.println("Zip accessors test 2 PASSED");
		else
			System.out.println("Zip accessors test 2 FAILED");
		
		System.out.println("*****Running tests on web directory******");
		
		InAndOutBurgerDirectory directory = new InAndOutBurgerDirectory("http://www.in-n-out.com/alllocations.asp");
		
		if (directory.count("Fresno") == 4)
			System.out.println("count() test 1 PASSED");
		else
			System.out.println("count() test 1 FAILED");
		
		if (directory.count("Chandler") == 3)
			System.out.println("count() test 2 PASSED");
		else
			System.out.println("count() test 2 FAILED");
		
		if (directory.count("Atlanta") == 0)
			System.out.println("count() test 3 PASSED");
		else
			System.out.println("count() test 3 FAILED");
		
		ArrayList<InAndOutBurgerLocation> locations = directory.get("Fresno");
		boolean failed = false;
		for (int i = 0; i < locations.size(); i++)
		{
			if (!locations.get(i).getCity().equals("Fresno"))
			{
				System.out.println("get() test 1 FAILED");
				failed = true;
			}
		}
		
		if (!failed)
			System.out.println("get() test 1 PASSED");
		
		locations = directory.get("Atlanta");
		if (locations.size() == 0)
			System.out.println("get() test 2 PASSED");
		else
			System.out.println("get() test 2 FAILED");
	}
}
