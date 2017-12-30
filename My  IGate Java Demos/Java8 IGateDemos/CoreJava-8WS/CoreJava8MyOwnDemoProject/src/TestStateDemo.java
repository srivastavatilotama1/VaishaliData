import java.util.function.Consumer;


public class TestStateDemo {

	public static void main(String[] args) 
	{
		
		
		StateOwner sow=new StateOwner();
		sow.addStateListener(
				(oState,nState)->System.out.println("Hello...")				
				);
	
	}

}
