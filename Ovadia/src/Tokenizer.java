//Tokenizer.java


public class Tokenizer {

    private String theinput; //This references the input line.
    private int x; //This points to the next character
                           //to be inspected when getToken()is called.
    private boolean done; //This is false initially, and set to true
                          // when lineIndex>=theLine.length();
    private boolean contains;


    public Tokenizer(String input)
    // this initializes the instance variables of the class.
    {
	theinput=input;//.replaceAll("\\s", "");	
	x=0;
	done=false;
	contains=false;
    theinput=theinput.trim();}
    	
    

    public String getToken(){
	
	final int START=0;
	final int DECIMALNUMS=1;
	final int NUMBER=2;
	final int TEXT=3;
	int state=START;
	String OUT="";

    //This implements the finite state machine to collect and return
    //the next token in the line starting from the position lineIndex
	//set state

	if(theinput.length()==0)
	return null;
	
	while(theinput.charAt(x)==' ' && x<theinput.length()){
	    x++;}
	
	while(x<theinput.length()){
	    
	    switch(state) {
		
	    case START:
		
		if((theinput.charAt(x)>=40 && theinput.charAt(x)<=47 && theinput.charAt(x)!=46 ) || theinput.charAt(x)==61 )
		    {
			OUT+=theinput.charAt(x);
			//System.out.println("NEW c added (Start.op)" +OUT);
			x++;
			return OUT;
		    }
		
		else if(theinput.charAt(x)==46)
		    {
			OUT+=theinput.charAt(x);
			//System.out.println("NEW c added (Start.DecimalNUMS" +OUT);
			
			state=DECIMALNUMS;
			
		    }
		
		else if(theinput.charAt(x)>=48 && theinput.charAt(x)<=57 )
		    {
			OUT+=theinput.charAt(x);
			//System.out.println("NEW c added (start.NUMBER)" +OUT);
			
			state=NUMBER;
			//System.out.println("NUM");
			
		    }
		
		else if((theinput.charAt(x)>=65 && theinput.charAt(x)<=90) || (theinput.charAt(x)>=97 && theinput.charAt(x)<=122))
		    {
			
			OUT+=theinput.charAt(x);
			//System.out.println("NEW c added (Start.TEXT)" +OUT);

			state=TEXT;
			
		    }
		
		else {
		    System.out.print("Invalid syntax (Unable to tokenize)");
		    //System.exit(0);
		    x=theinput.length();
		    return null;

		}
				

		break;
		
	    case DECIMALNUMS:
		if(theinput.charAt(x)>=48 && theinput.charAt(x)<=57 )
		    {
			state=DECIMALNUMS;
			
			OUT+=theinput.charAt(x);
			//	System.out.println("NEW c added DecimalNUMS " +OUT);


			
		    
			
		    }
		else if(theinput.charAt(x)==46)
		{  System.out.print("Invalid syntax (Unable to tokenize)");
		return null;
		}
		else {
		    
		    state=START;
		    return OUT;
		}
		
		break;
		
		
	    case NUMBER:
		
		    
		    if(theinput.charAt(x)>=48 && theinput.charAt(x)<=57 )
			{
			    state=NUMBER;
			    OUT+=theinput.charAt(x);
			    // System.out.println("NEW c added NUMBER" +OUT);
						
			    //System.out.println("NUM");


			}
		    else if(theinput.charAt(x)==46)
			{
			    
			    state=DECIMALNUMS;
			    OUT+=theinput.charAt(x);
			    // System.out.println("NEW c added DECIMAL.NUMBER" +OUT);


			}
		    else
			{
			    
			    state=START;
			    return OUT;
			
		    }
		    break;
		
		
	    case TEXT:
		
		    
		if((theinput.charAt(x)>=65 && theinput.charAt(x)<=90) || (theinput.charAt(x)>=97 && theinput.charAt(x)<=122) || ( theinput.charAt(x)>=48 && theinput.charAt(x)<=57))
		    {	state=TEXT;
			OUT+=theinput.charAt(x);
		//	System.out.println("NEW c added TEXT" +OUT);

		    }
		else{
			state=START;
			return OUT;

		     }
		
			
			
		break;

			
	    }
	    //System.out.println(currentLoc);
	    x++;
	    //while(theinput.charAt(x)==' ' && x<theinput.length()){
		 //  x++;}
		    
	    //end of switch
	    

	}
	return OUT;
	
	
    }
        


	    
	
		

	    


    


 	
     public static void  main(String[] args) {

	 
		String s="";

		
		Tokenizer myToken = new Tokenizer(s);
		
		String TempS;
		TempS=myToken.getToken();
		 //String  Temp1=myToken.peak();
		    System.out.println(TempS);
		   // System.out.println(Temp1);



		while(myToken.done()==false){
		   String Temp2;
			Temp2=myToken.getToken();

		    System.out.println(Temp2);
		   
		    
		}
		}
     
		
		
	    
    

    
	

	
	public boolean done() {
	    if(x>=theinput.length())
		done=true;
	    
	    return done;
	}
	public boolean containsAfter(String searchc) {
	    if(this.theinput.substring(x).contains(searchc))
		contains=true;
	    
	    return contains;
	}




	public String peak() {
	String Peaking= this.getToken();
	this.x--;
	return Peaking;
}


}

	    

      
	
                          


      
	
                          
