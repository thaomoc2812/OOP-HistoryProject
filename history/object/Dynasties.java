package history.object;


public class Dynasties {
	private int id;
	private String name;
	private String yearStart;
	private String yearEnd;
	private String description;
	private String countryName;
	
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYearStart() {
		return yearStart;
	}
	public void setYearStart(String yearStart) {
		this.yearStart = yearStart;
	}
	public String getYearEnd() {
		return yearEnd;
	}
	public void setYearEnd(String yearEnd) {
		this.yearEnd = yearEnd;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Dynasties() {
		super();
	}
	@Override
	public String toString() {
		return "ID: " + id + "\nTriều đại: " + name + "\nNăm bắt đầu: " + yearStart + "\nNăm kết thúc: " + yearEnd
				+ "\nMiêu tả: " + description + "\nTên nước: " + countryName;
	}
}

