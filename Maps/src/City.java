
public class City {

	private String theName;
	private double theLongitude;
	private double theLatitude;
	public City(String Name, double Longitude, double Latitude)
	
	{
		 theName=Name;
		 theLongitude=Longitude;
		 theLatitude=Latitude;
		
	}
	
	public  String getName() 
	{	return theName;}
	public  double getLongitude() 
	{	return theLongitude;}
	public  double getLatitude() 
	{	return theLatitude;}
	
	public String toString()
	{
		int spaces=((40)-getName().length());
		
		return(this.getName()  +"  " +this.getLongitude() +"  "+this.getLatitude() );
	}
	
	
	

}
