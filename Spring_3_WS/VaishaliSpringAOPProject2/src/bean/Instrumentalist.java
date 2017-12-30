package bean;

public class Instrumentalist  implements Performer
{
	private Audience audience;
	private Instrument instrument;
	private String song;

	public Instrumentalist() {}

	public void perform() throws PerformanceException
	{
		
		try
		{
			System.out.print("Playing " + song + " : ");
			instrument.play();
			
		}
		catch(Throwable e)
		{
			audience.demandRefund();
		}
	}
	
	public void testMe(){System.out.println(" In side testMe");}

	public void setSong(String song)
	{
		this.song = song;
	}

	public void setInstrument(Instrument instrument) 
	{
		this.instrument = instrument;
	}
	public void setAudience(Audience audience) 
	{
		this.audience = audience;
	}
}
