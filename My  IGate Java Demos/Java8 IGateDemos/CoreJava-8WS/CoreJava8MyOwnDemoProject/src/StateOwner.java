public class StateOwner
{

    public void addStateListener(StateChangeListener listener) {

    	State oldState=new State("Pune");
		State newState=new State("Chennai");
		
		listener.onStateChange(oldState, newState);
		
    	
    System.out.println("In owner.....");}

}
