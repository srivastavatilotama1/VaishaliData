public class FactorialImpl implements IFactorial
{
	int number;	
	public int getNumber() 
	{
		return number;
	}
	public void setNumber(int number) 
	{
		this.number = number;
	}
	@Override
	public int calcFact1(int number) 
	{
		int fact=1;
		while(number!=1)
		{
			fact=fact*number;
			number--;
		}
		return fact;
	}
	public int calcFact2() 
	{
		int fact=1;
		while(number!=1)
		{
			fact=fact*number;
			number--;
		}
		return fact;
	}
	
	public FactorialImpl(){};
	
	public FactorialImpl(int number){this.number=number;}
	
	public  static FactorialImpl  createFactorialImpl(int number)
	{
		return new FactorialImpl(number);
	}

}
