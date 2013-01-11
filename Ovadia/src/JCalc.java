import java.util.Hashtable;
import java.io.*;
import java.util.*;

public class JCalc {
    public static void main(String[] args) {

    	Hashtable<String, Double> VariableTable =new Hashtable();
    	Scanner myscan = new Scanner(System.in);
    	System.out.print("> ");
	
    	String line = myscan.nextLine();
    	//System.out.println(line);
    	
    
    
    

    	while(!line.equals("exit"))
    	{
    		Tokenizer myToken = new Tokenizer(line);
    		String Toke1 =myToken.getToken();
    		//String Toke2 =myToken.peak();
		
		
		
				if(Toke1==(null)  /* || Toke2==(null) */ )
				{
					System.out.println("");
			
				}
				else if(Toke1.equalsIgnoreCase("printTable"))
				{
					if (VariableTable.isEmpty()==false)
					
						System.out.println(VariableTable);
					else 
						System.out.println("Table is Empty");
	
		
				}
				else if(Toke1.equalsIgnoreCase("print"))
				{

					if(myToken.done() || myToken.containsAfter("="))
					{
					System.out.println("Error");
			
				
					}
					else{
						IntoPost ITP = new IntoPost(myToken);
						
						TheQueue<String> The = ITP.translate();
						if(The.equals(null)||The.isEmpty())
						{
							System.out.println("error");
						}	
						else{
							Evaluate Eval = new Evaluate(The);
						
							double x=Eval.evaluate(VariableTable);
							System.out.println(x);

						}}}

				else {
			
					if(myToken.done()==true)
					{
						System.out.println(" error");

					}
			
					else 
						{String Toke2=myToken.getToken();
							if(Toke2==null)
								{
								System.out.println(" error");
								}
		
							else if (Toke2.equals("="))

									{

									if((Toke1.charAt(0)>=48 && Toke1.charAt(0)<=57 )|| myToken.containsAfter("="))	
										{
											System.out.println(" error");
											}
				
									else {IntoPost ITP = new IntoPost(myToken);
											if(myToken.done()==true)
														{
														System.out.println("ERROR");

														}
											else{
													TheQueue<String> theQ=ITP.translate();
													Evaluate Eval = new Evaluate(theQ);
													double x=Eval.evaluate(VariableTable);
													System.out.println();
													VariableTable.put(Toke1, x);
													//System.out.println(VariableTable);
													//System.out.println(x);
											}}}
		else
		{
			System.out.println("Please enter a print statement followed by an equation, number, or variable, or initialize a variable using syntax examples below x=2 print x print x*2 print 2");
			
		}}}
			
					
			
			
			
		
		System.out.print("> ");
	     line = myscan.nextLine();
    }
    
    

    }}



			


				
	
			
    

		

