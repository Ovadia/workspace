
public class Path {
	private double cost;
	private double estimate;
	private City Destination;
	Connection[] Stops;
	private int currentConnection;
	private double destLong;
	private double destLati;
	
	public  Path(Connection First, City Dest) {

		Stops=new Connection[100];	
		
		double Long=Dest.getLongitude();
		double Lati=Dest.getLatitude();
		String Name=Dest.getName();
		Destination=new City(Name, Long, Lati);
		currentConnection=1;
		cost=0;
		destLong=Long;
		destLati=Lati;			
		Stops[0]=First;
		estimate=SphericalLawofCosines(First.getCity().getLongitude(), First.getCity().getLatitude(), destLong, destLati);

		
		
	}
	public Path Extend(Connection NewConnection)
	{
		Path newPath= new Path(Stops[0],  Destination);
		
		for(int i=1; i<currentConnection; i++)
		{
			newPath.Stops[i]=this.Stops[i];
		
		}
		newPath.cost=this.cost;
		Connection myConnection=NewConnection;
		newPath.Stops[currentConnection]=NewConnection;
		City myCity = myConnection.getCity();
		double myDistance=myConnection.getDistance();
		
		newPath.cost+=myDistance;
		newPath.estimate=SphericalLawofCosines(myCity.getLongitude(), myCity.getLatitude(), destLong, destLati);
		newPath.currentConnection=this.currentConnection+1;
		System.out.println(this + " extended with " + NewConnection.getCity().getName() + " to " + newPath);
		return newPath;
		 
		
	
		
		
	}
	public double SphericalLawofCosines(double lon1, double lat1,  double lon2, double lat2)
	{
	int R = 6371; // km
	double distance = Math.acos(Math.sin(lat1)*Math.sin(lat2) + 
           Math.cos(lat1)*Math.cos(lat2) *
           Math.cos(lon2-lon1)) * R;
	return distance;
	}
	
	
	public double getCost(){
	return (estimate+cost);
	}

	public double getEstimate(){
	return estimate;
	}
	public Connection last()
	{
		return Stops[currentConnection-1];
	}
	public String toString()
	{
		String myS="";
		for(int x=0; x<currentConnection; x++)
		{
			myS+=Stops[x];
		}
		return myS;
	}
	
		
}
		
	

