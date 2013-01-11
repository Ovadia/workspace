import java.util.Scanner;


public class Calc {

	public static void main(String[] args)
	{
		Scanner input=new Scanner( System.in);
		System.out.println("Enter Class 1");
		String Class1=input.nextLine();
		System.out.println("Enter Grade  for "+Class1);

		String Grade1=input.nextLine();
		double Grade1num=ConvertGrade(Grade1);
		
		System.out.println("Enter Class 2");

		String Class2=input.nextLine();
		System.out.println("Enter Grade  for "+Class2);

		String Grade2=input.nextLine();
		double Grade2num=ConvertGrade(Grade2);
		
		System.out.println("Enter Class 3");

		String Class3=input.nextLine();
		System.out.println("Enter Grade  for "+Class3);

		String Grade3=input.nextLine();
		
		double Grade3num=ConvertGrade(Grade3);
		System.out.println("Enter Class 4");

					String Class4=input.nextLine();
		System.out.println("Enter Grade  for "+Class4);

		String Grade4=input.nextLine();
		double Grade4num=ConvertGrade(Grade4);
		System.out.println("Report Card");
		System.out.println();
		System.out.println(Class1  + "    "  +Grade1num);
		System.out.println(Class2  + "    "  +Grade2num);
		System.out.println(Class3  + "    "  +Grade3num);
		System.out.println(Class4  + "    "  +Grade4num);
		System.out.println();
		System.out.println("GPA: " +((Grade1num+Grade2num+Grade3num/*Grade4num*/)/3));


		

		


		
	}
	public static double ConvertGrade(String X)
	{
		if(X.equalsIgnoreCase("a"))
		return 4.0;	
		else if(X.equalsIgnoreCase("a-"))
			return 3.7;
		else if(X.equalsIgnoreCase("b+"))
			return 3.3;
		else  if(X.equalsIgnoreCase("b"))
			return 3.0;
		else if(X.equalsIgnoreCase("b-"))
			return 2.7;
		else if(X.equalsIgnoreCase("C+"))
			return 2.3;
		else if(X.equalsIgnoreCase("C"))
			return 2.0;
		else if(X.equalsIgnoreCase("C-"))
			return 1.7;
		else  if(X.equalsIgnoreCase("D+"))
			return 1.3;
		else if(X.equalsIgnoreCase("D"))
			return 1.0;
		else return 0;
		
		
				





		
	}
}
