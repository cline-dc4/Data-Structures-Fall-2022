
public class Main {

	public static void main(String[] args) 
	{
		try 
		{
			//invalid name 
			//Event SportLocation = new SportsEvent("", 1000, 'o', 200, "Soccer");
			
			//Invalid location
			//Event sportLocation = new SportsEvent("Soccer Opener", 1000, 'u', 200, "Soccer");
			
			//invalid cost
			//Event SportCost = new SportsEvent("Soccer Opener", -1000, 'o', 200, "Soccer");
			
			//invalid sport
			//Event SportSport = new SportsEvent("Soccer Opener", 1000, 'o', 200, "");
			
			//invalid spectators
			//Event SportSpectators = new SportsEvent("Soccer Opener", 1000, 'o', -200, "Soccer");
			
			//invalid name
			//Event TheaterName = new TheaterEvent("", 2000, 'i', true, 90);
			
			//invalid location
			//Event TheaterLocation = new TheaterEvent("Winter Concert", 2000, 'u', true, 90);
			
			//invalid cost
			//Event TheaterCost = new TheaterEvent("Winter Concert", -2000, 'i', true, 90);
			
			//invalid length
			Event TheaterLength = new TheaterEvent("Winter Concert", 2000, 'i', true, -90);
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		try
		{
			//with 1500 for sport and 150 for theater, sport will be bigger...
			
			Event Sports = new SportsEvent("Kickoff", 1500, 'i', 200, "Soccer");
			Event Theater = new TheaterEvent("Kickoff", 150, 'i', true, 90);
			
			System.out.println(Sports);
			System.out.println(Theater);
			
			if (Sports.compareTo(Theater) > 0)
				System.out.println("Sports Event is larger.");
			else if (Sports.compareTo(Theater) < 01)
				System.out.println("Theater event is bigger");
			else 
				System.out.println("Theater event and sports event are equal");
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

}
