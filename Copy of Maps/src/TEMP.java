import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;


public class TEMP {

	public static City[] Cities;
	public static void main(String[] args) throws FileNotFoundException {
	
	File myFileMap =new File("src/MapData.txt");
	Scanner input=new Scanner(myFileMap);	
	int TotCit=input.nextInt();
	Cities=new City[TotCit];
	for(int x=0; x<TotCit; x++)
	{
		String CityName=input.next();
		double Longitude=input.nextDouble();
		double Latitude=input.nextDouble();
		Cities[x]=new City(CityName, Longitude, Latitude);

	}
	String From =args[0];
	String To =args[1];
	LinkedList map[] = new LinkedList[TotCit];
	
		for(int x=0; x<TotCit; x++)
		{
			map[x]=new LinkedList();
			
			
			String fromCityName=input.next();
			if(!Cities[x].getName().equalsIgnoreCase(fromCityName))
				{System.out.println("ERROR");
				System.exit(00);
				}
			int FromNum=FindCity(fromCityName);
			int NumConnections=input.nextInt();
			for(int y=0; y<NumConnections; y++)
			{
			String ConnCity=input.next();
			int CityNum=FindCity(ConnCity);
			int ConnDist=input.nextInt();
			String ConnHW=input.next();
			System.out.println(Cities[CityNum]);

			System.out.println(Cities[CityNum]);
			map[x].add(new Connection(Cities[CityNum], ConnHW, ConnDist));
			
			}}
			
			if(FindCity(From)==-1 || FindCity(To)==-1)
		{
			System.out.println("City Does Not Exist");
				System.exit(0);
		}
		System.out.println("Cities");

			for (int c=0;  c<Cities.length; c++)
			{

				System.out.println(Cities[c]);
				System.out.println();
				
			}
				
			for(int m=0; m<map.length; m++ )
			{System.out.println(Cities[m].getName());
			System.out.println(map[m]);
			
			}
			
			
		int fromNum=FindCity(From);
		int toNum=FindCity(To);
		PriorityQueue myPQ=new PriorityQueue();
		Connection FirstCityCon =new Connection(Cities[fromNum], " ", 0);
		Path myPath=new Path(FirstCityCon, Cities[toNum]);
		myPQ.add(myPath);
		
		while(myPQ.isEmpty()==false)
			
		
			{
			System.out.println("PQ=" +myPQ);
			Path Guess=myPQ.removeMin();

			if(Guess.last().getCity().getName().equals(Cities[toNum].getName()))
				{System.out.println(Guess);
				break;}
			else
			{
				int lastAddedCity=FindCity(Guess.last().getCity().getName());
				for(int x=0; x<map[lastAddedCity].size(); x++ )
				{
					//System.out.println("adding map" + x);
					Connection theC= (Connection) map[lastAddedCity].get(x);
					Path NewGuess = Guess.Extend(theC);
					System.out.println(NewGuess);
					myPQ.add(NewGuess);
				
				
				}
			}
			
		}
			
		
	
		
		}

		
	


			

			
	
	public static int FindCity(String myCity)
	{
		for(int x=0; x<Cities.length; x++)
		{
			if(Cities[x].getName().equals(myCity))
				return x;
			
		}
		return -1;
		
		
	}
	}
	
	


