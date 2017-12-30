import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.igate.bean.Vehicle;
import com.igate.bean.VehicleService;

public class Client 
{	
	public static void main(String[] args)
	{
		Vehicle vehicle1=VehicleService.getVehicle(2);
		System.out.println(vehicle1.drive());
		
		
		Vehicle vehicle2=VehicleService.getVehicle(6);
		System.out.println(vehicle2.drive());
		
		
		
	
	}
	

}
