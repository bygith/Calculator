
/**
 * This class implements Math.java and performs basic
 * mathematical operations.
 * 
 * @author Bee
 *
 */
public class BasicMath implements Math{

	
	
	public double add(double lhs, double rhs){
		
		return lhs+rhs;
	}
	
	public double subtract(double lhs, double rhs){
		
		return lhs-rhs;
	}
	
	public double multiply(double lhs, double rhs){
		
		return lhs*rhs;
	}
	
	public double divide(double lhs, double rhs){
		
		return lhs/rhs;
	}
	
	public double factorial(double num) {
		
		double counter=num;
		double factorial=1;
		
		if(num<0){
			throw new ArithmeticException();
		}
		
		for (int i=1; counter>=i; counter--)
		{
			factorial=factorial*counter;
		}
		
		return factorial;
	}
	
	public double pow(double lhs, double rhs){
		
		double counter=rhs;
		double answer=1;
		
		if(rhs==0){
			return 1;
		}
		
		for ( ;counter>=1; counter--)
		{
			answer=answer*lhs;
		}
		for (;counter<0; counter++)
		{
			answer=(answer*lhs);
			if(counter==-1){
				answer=1/answer;
			}
		}
		
		return answer;
	}
	
}
