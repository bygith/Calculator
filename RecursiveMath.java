
/**
 * This class implements Math.java and uses recursion.
 * 
 * @author Bee
 * 
 */
public class RecursiveMath implements Math{
	
	
	public double add(double lhs, double rhs){
		
		if (rhs==0)
		{
			return lhs;
		}
		if (lhs==0)
		{
			return rhs;
		}
		
		double answer=add(lhs, rhs-1)+1;
		
		return answer;
	}
	
	public double subtract(double lhs, double rhs){
		
		
		if (lhs==rhs)
		{
			double zero=0;
			return zero;
		}
		
		if (lhs>rhs)
		{
			double answer=subtract(lhs-1, rhs)+1;
			return answer;
		}
		
		else
		{
			double answer=subtract(lhs+1, rhs)-1;
			return answer;
		}
	}
	
	public double multiply(double lhs, double rhs){
		
		if(lhs==0||rhs==0)
		{
			return 0;
		}
		
		double answer=multiply(lhs, rhs-1)+lhs;
		return answer;
	}
	
	public double divide(double lhs, double rhs){
		if (rhs==0){
			throw new ArithmeticException();
		}
		if (lhs>=rhs){
			double answer;
			answer=divide(lhs-rhs, rhs)+1;
			return answer;
		}
		else
		{
			return 0;
		}
		
	}
	
	
	public double factorial(double num){
		
		if(num<0){
			throw new ArithmeticException();
		}
		
		if((num==1)||(num==0))
		{
			return 1;
		}
		
		double answer=factorial(num-1)*num;
		return answer;
	}
	
	public double pow(double lhs, double rhs){
		
		if(rhs==1)
		{
			return lhs;
		}
		
		double answer=pow(lhs, rhs-1)*lhs;
		return answer;
		
	}
	
}
