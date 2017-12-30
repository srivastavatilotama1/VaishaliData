
public class State {
	String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "State [city=" + city + "]";
	}

	public State(String city) {
		super();
		this.city = city;
	}
	
}
