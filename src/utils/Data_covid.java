package utils;

public class Data_covid {
	
    private String date;
    private String state;
    private String city;
    private String place_type;
    private Integer confirmed;
    private Integer deaths;
    private String order_for_place;
    private String is_last;
    private String estimated_population_2019;
    private String estimed_population;
    private String city_ibge_code;
    private String confirmed_per_100k_inhabitants;
    private String death_rate;
    
	public Data_covid(String date, String state, String city, String place_type, Integer confirmed, Integer deaths,
			String order_for_place, String is_last, String estimated_population_2019, String estimed_population,
			String city_ibge_code, String confirmed_per_100k_inhabitants, String death_rate) {
		this.date = date;
		this.state = state;
		this.city = city;
		this.place_type = place_type;
		this.confirmed = confirmed;
		this.deaths = deaths;
		this.order_for_place = order_for_place;
		this.is_last = is_last;
		this.estimated_population_2019 = estimated_population_2019;
		this.estimed_population = estimed_population;
		this.city_ibge_code = city_ibge_code;
		this.confirmed_per_100k_inhabitants = confirmed_per_100k_inhabitants;
		this.death_rate = death_rate;
	}

	public String getDate() {
		return date;
	}

	public String getState() {
		return state;
	}

	public String getCity() {
		return city;
	}

	public String getPlace_type() {
		return place_type;
	}

	public Integer getConfirmed() {
		return confirmed;
	}

	public Integer getDeaths() {
		return deaths;
	}

	public String getOrder_for_place() {
		return order_for_place;
	}

	public String getIs_last() {
		return is_last;
	}

	public String getEstimated_population_2019() {
		return estimated_population_2019;
	}

	public String getEstimed_population() {
		return estimed_population;
	}

	public String getCity_ibge_code() {
		return city_ibge_code;
	}

	public String getConfirmed_per_100k_inhabitants() {
		return confirmed_per_100k_inhabitants;
	}

	public String getDeath_rate() {
		return death_rate;
	}

	
    
	
    

}
