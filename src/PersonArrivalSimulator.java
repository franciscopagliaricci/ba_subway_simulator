import java.util.Map;

public class PersonArrivalSimulator implements SimulatorObject {
	
	private Long seed;
	private Station station;
	// Map of the style: destiny -> tickets
	private Map<Station, Integer> distribution;
	
	public PersonArrivalSimulator(Long seed, Station station, Map<Station, Integer> distribution){
		if(seed <= 1)
			throw new RuntimeException("Seed has to be greater than 1");
		this.seed = seed;
		this.station = station;
		this.distribution = distribution;
	}
	
	private Long getTotalTickets(){
		Long ans = 0L;
		for(Integer d: distribution.values())
			ans += d;
		return ans;
	}
	
	private Station getRandomDestiny() throws Exception{
		double ticketNumber = Math.random() * getTotalTickets();
		for(Station key : distribution.keySet()){
			if(0 < ticketNumber && ticketNumber < distribution.get(key)){
				return key;
			}else {
				ticketNumber -= distribution.get(key);
			}
		}
		throw new Exception("Random destiny failed :(");
	}
	
	public void start(Long timestamp) throws Exception{
		Long next = timestamp + (long) (seed * Math.random()) + 1;
		SimulatorScheduler.getInstance().registerEvent(next, new SchedulerRegistrator(this, "person arriving to -> " + station.getName()));
	}
	
	@Override
	public void event(Long timestamp) throws Exception {
		Long next = timestamp + (long)(seed * Math.random()) + 1;
		SimulatorScheduler.getInstance().registerEvent(next, new SchedulerRegistrator(this, "person arriving to -> " + station.getName()));
		station.personArrival(new Person(getRandomDestiny()));
	}
	
	@Override
	public String toString(){
		return station + " person arrival";
	}

}