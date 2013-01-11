

import java.util.LinkedList;

import java.util.Queue;
import java.util.Stack;
public class IntoPost {

    private TheQueue<String> theQ; //this is the queue of the translated postfix expression
    private Tokenizer theT; //this is the tokenizer where the infix expression resides
    private TheQueue<String> Empty= new TheQueue<String>(); 

    public IntoPost(Tokenizer in) {
    //The initiatlizes the instance variable theT=in;
	theT=in;
	theQ = new TheQueue<String>();

    }
    	
    public TheQueue<String> translate()
    {	
    	Stack<String> theOperands		 = new Stack<String>();

	while(theT.done()==false)
	    {
		String s;
		s=theT.getToken();
		if(s==null){
			return Empty;
		}
		String top;
		if(s.equals("("))
		    {
			
			theOperands.push("(");
			    
			
			
		    }
		else if(s.equals(")"))
		    {
			if(theOperands.contains("(")){
			while(!theOperands.peek().equals("("))
			    {
				theQ.enqueue(theOperands.pop());
				
			    }
			theOperands.pop();
			}
			else{
				System.out.println("Error");
				return Empty;
			}
			
			      
		    }
		else if(s.equals("*"))
		    {
			
			if(theOperands.empty()==true)
			    {theOperands.push(s);}
			
			else if(theOperands.peek().equals("*"))
			    {
				theQ.enqueue(s);}
			else if(theOperands.peek().equals("/"))
			    {
				theQ.enqueue(theOperands.pop());
				theOperands.push(s);}
			
			
			else
			    {theOperands.push(s);}
			
		    }
		
		
		
		

		
		

		else if(s.equals("/"))
		    {
			
			if(theOperands.empty()==true)
			    {theOperands.push(s);}

			else if(theOperands.peek().equals("/"))
				{
				    theQ.enqueue(s);}
			else if(theOperands.peek().equals("*"))
			    {
				theQ.enqueue(theOperands.pop());
				theOperands.push(s);}
				
			
			else
			    {theOperands.push(s);}
			
			
		    		
			    
			       
			    
			
		    }
		else if(s.equals("+"))
		    {
			
			if(theOperands.empty()==true)
			    {theOperands.push(s);}

			else if(theOperands.peek().equals("/"))
			      {
				theQ.enqueue(theOperands.pop());
				theOperands.push(s);}
			
			else if(theOperands.peek().equals("*"))
			    {
				theQ.enqueue(theOperands.pop());
				theOperands.push(s);}
			else if(theOperands.peek().equals("+"))
			    { 	theQ.enqueue(s);}

			else if(theOperands.peek().equals("-"))
			    {
				theQ.enqueue(theOperands.pop());
				theOperands.push(s);  
			    }
			else if(theOperands.peek().equals("("))
		    {theOperands.push(s);}


			
			
			
			
		    }
		else if(s.equals("-"))
		    {
			
			if(theOperands.empty()==true)
			    {theOperands.push(s);}

			else if(theOperands.peek().equals("/"))
			      {
				theQ.enqueue(theOperands.pop());
				theOperands.push(s);}
			
			else if(theOperands.peek().equals("*"))
			    {
				theQ.enqueue(theOperands.pop());
				theOperands.push(s);}
			else if(theOperands.peek().equals("-"))
			    {theQ.enqueue(s);}

			else if(theOperands.peek().equals("+"))
			    {
				theQ.enqueue(theOperands.pop());
				theOperands.push(s);}
			else if(theOperands.peek().equals("("))
		    {theOperands.push(s);}}
			
			

		else
				theQ.enqueue(s);}
    
			
		    
		
		
	
	while(theOperands.empty()==false)
	{
		if(theOperands.peek().equalsIgnoreCase("("))
		{
			System.out.println("Syntax Error");
			return Empty;
		}
		theQ.enqueue(theOperands.pop());
	}
	return theQ;


		
		
    }
  
    public static void  main(String[] args) {

   	 
		String s="print (5*2";

		
		Tokenizer myToken = new Tokenizer(s);
			myToken.getToken();
		IntoPost ITP = new IntoPost(myToken);
		System.out.print(ITP.translate());

		
     
		
		
    }}
    
    
    //
    
    
