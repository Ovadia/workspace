
public class Connection {
	private City theCity;
	private String theRoad;
	private int theDistance;
	// public City theFromCity;
	 
	 
	 public Connection(/*City FromCity,*/ City C, String roadName, int distance)
	
	{
		theCity=C;
		//theFromCity=FromCity;
		theRoad=roadName;
		theDistance=distance;
			
	}
	 	public  City getCity() 
		{	return theCity;}
		public  String getRoad() 
		{	return theRoad;}
		public  int getDistance() 
		{	return theDistance;}
	 	//public  City getFromCity() 
	//	{	return theFromCity;}
		
		public  String toString() 
		{	return (/*"From " +this.getFromCity().getName() +   " To " +*/ this.getCity().getName() +" " +this.getDistance() +"   " +this.getRoad()  );   }
		
		

	 
	 
}
