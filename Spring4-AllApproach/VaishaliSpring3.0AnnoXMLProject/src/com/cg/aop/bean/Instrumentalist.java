package com.cg.aop.bean;

public class Instrumentalist  implements Performer
{
	private String song;
	private Instrument instrument;

	public Instrumentalist(String song, Instrument instrument) {
		super();
		this.song = song;
		this.instrument = instrument;
	}

	public Instrumentalist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	@Override
	public void perform() 
	{
		try
		{
			System.out.print("Playing " + song + " : ");
			instrument.play();
			//throw new NullPointerException();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
}
