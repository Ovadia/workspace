import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;


public class TEMP {

	public static City[] Cities;
	public static void main(String[] args) throws FileNotFoundException {
	String fileName=args[2];
	File myFileMap =new File(fileName);
	Scanner input=new Scanner(myFileMap);	
	int TotCit=input.nextInt();
	Cities=new City[TotCit];
	
	//Assign Cities
	System.out.println(TotCit);
	for(int x=0; x<TotCit; x++)
	{
		String CityName=input.next();
		double Latitude=input.nextDouble();
		double Longitude=input.nextDouble();

		Cities[x]=new City(CityName, Latitude, Longitude);
		System.out.println(Cities[x]);
		System.out.println();
		

	}
	
	String From =args[0];//From
	String To =args[1];//To
	
	//Holds Cities and there Connections in a Linkedlist
	LinkedList map[] = new LinkedList[TotCit];

		for(int x=0; x<TotCit; x++)
		{
			map[x]=new LinkedList();	
			String fromCityName=input.next();
			if(!Cities[x].getName().equalsIgnoreCase(fromCityName))
				{System.out.println("Error" +args[2]);
				System.exit(000);
				}

			int FromNum=FindCity(fromCityName);
	
			int NumConnections=input.nextInt();
			System.out.println(Cities[x].getName() +"  " +NumConnections);

				for(int y=0; y<NumConnections; y++)
			{
					String ConnCity=input.next();
				
					int CityNum=FindCity(ConnCity);
					int ConnDist=input.nextInt();
					String ConnHW=input.next();
					map[x].add(new Connection(Cities[CityNum], ConnHW, ConnDist));
					System.out.println(map[x].get(y));
			}
				System.out.println("");

				}
		
			
			if(FindCity(From)==-1 || FindCity(To)==-1)
		{
			System.out.println("City Does Not Exist");
				System.exit(0);
		}
		System.out.println("");

			
				
		//for(int m=0; m<map.length; m++ )
		//	{System.out.println(Cities[m].getName());
			//	for(int z=0; z<map[m].size(); z++){
			//System.out.println(map[m].get(z));}
				//System.out.println("");
			
			//}
			
			
		int fromNum=FindCity(From);
		int toNum=FindCity(To);
		
		NEWPQ myPQ=new NEWPQ();
		Connection FirstCityCon =new Connection(Cities[fromNum], " ", 0);
		Path myPath=new Path(FirstCityCon, Cities[toNum]);
		myPQ.enqueue(myPath);
		
		while(myPQ.isEmpty()==false)
			
		
			{
			//System.out.println("PQ=" +myPQ);
			Path Guess=myPQ.dequeue();

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
							myPQ.enqueue(NewGuess);
				
				
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
	
	


