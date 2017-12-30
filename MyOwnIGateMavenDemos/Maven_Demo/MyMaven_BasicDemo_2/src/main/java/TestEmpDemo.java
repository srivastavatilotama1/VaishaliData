
import static java.lang.Math.pow;
import com.igate.vai.Date;
import com.igate.vai.Employee;
public class TestEmpDemo
{
	public static void main(String[] args)
	{
		Date paruDOJ=new Date(13,11,2004);
		Employee paruE=new Employee(111,"Parvati",30000.0F,'F',paruDOJ);
				
		System.out.println(" Total Sal Of Emp :"+paruE.calcEmpGrossSal());
		System.out.println(" Emp Info : "+paruE.dispEmpInfo());	  
		System.out.println(" 4 Raise to 5 is :"+pow(Integer.parseInt(args[0]), 5));
		
		
	}

}
