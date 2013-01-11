
public class Path implements Comparable{
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
		int myDistance=myConnection.getDistance();
		
		newPath.cost+=myDistance;
		newPath.estimate=SphericalLawofCosines(myCity.getLongitude(), myCity.getLatitude(), destLong, destLati);
		newPath.currentConnection=this.currentConnection+1;
		//System.out.println(this + " extended with " + NewConnection.getCity().getName() + " to " + newPath);
		return newPath;
		 
		
	
		
		
	}
	public static double SphericalLawofCosines(double lat1, double lon1,  double lat2, double lon2)
	{
		


		int R=6371;
		double d;
		lon1=Math.toRadians(lon1);
		lon2=Math.toRadians(lon2);
		lat1=Math.toRadians(lat1);
		lat2=Math.toRadians(lat2);

	
		d=Math.acos((Math.sin(lat1)*Math.sin(lat2)) +(Math.cos(lat1)*Math.cos(lat2)*Math.cos(lon2-lon1)));
		d=d*R;
		return d;
	}
	
	
	public int getCost(){
	return (int)(estimate+cost);
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
		for(int x=1; x<currentConnection; x++)
		{
			myS+=Stops[x-1].getCity().getName() ;
			myS+="  ";
			myS+=Stops[x].getCity().getName();
			myS+="  ";
			myS+=Stops[x].getRoad();
			myS+="\n";

		}
		return  "Route: " +this.getCost()+"\n" +myS;
	}
	public static void main(String[] args)
	{
		System.out.println(SphericalLawofCosines(42.75, 73.8, 42.68 ,93.37));
	}
	
	
	public int compareTo(Path CompareTo) {
		if(this.getCost()>CompareTo.getCost())
		return -1;
		if(this.getCost()<CompareTo.getCost())
			return 1;
		else //EQUAL
			return 0;
		
		
		
	}
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
		
	
	
}
		
	

