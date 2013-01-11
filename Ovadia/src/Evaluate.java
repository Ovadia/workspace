import java.util.*;

public class Evaluate {
    private TheQueue<String> inputQ; //This holds the postfix expression to be evaluated
    public Evaluate(TheQueue<String> in) 
    {
	
	inputQ=in;


	
    }
    public double evaluate(Hashtable<String, Double> ST)
    {
	Stack<Double> NumberStack = new Stack<Double>();
	while((inputQ.size()>0)){
	String s=inputQ.dequeue();
	if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
	    {
		if(NumberStack.isEmpty()==true)
		{
			System.out.println("Error");
			return 0;
		}
		//number last added
		double s1=NumberStack.pop();
		//number added before s1
		if(NumberStack.isEmpty()==true)
		{
			System.out.println("Error");
			return 0;
		}
		double s2=NumberStack.pop();
		
		
		double total=0;
		if(s.equals("+"))
		     total=s2+s1;
		else if(s.equals("-"))
			total=s2-s1;
		else if(s.equals("*"))
		     total=s2*s1;
		else if(s.equals("/"))
		     total=s2/s1;
		
		NumberStack.push(total);
		   
		
	    }
	    
	  
	else if((s.charAt(0)>=48 && s.charAt(0)<=57) || (s.charAt(0)==46))
	    {
		
		double T = Double.parseDouble(s);
		NumberStack.push(T);
				
		

	    }
	else if((s.charAt(0)>=65 && s.charAt(0)<=90) || (s.charAt(0)>=97 && s.charAt(0)<=122))
	    {
	    if(!ST.containsKey(s))
		{	System.out.println(s +" not found initialize the variable and try again! Ignore result below!!!");
	    	return 0;
		
		
		}
	    double T=ST.get(s);
		    
		NumberStack.push(T);
	    
	    
	    }
	
	
	
	
    }
    return NumberStack.pop();

    }
    
    
    
    public static void  main(String[] args) {

      	 
		String s="5*Toke*10";

		Hashtable<String, Double> Ov =new Hashtable();
		Ov.put("Toke", 10.0);

		Tokenizer myToken = new Tokenizer(s);
		IntoPost ITP = new IntoPost(myToken);
		TheQueue<String> The=ITP.translate();
		Evaluate Eval = new Evaluate(The);
		double x=Eval.evaluate(Ov);
		System.out.println(x);
		
		


		
     
		
		
    }}
   
