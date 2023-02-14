package history.object;


public class Event {
	private String suKien;
	private String nam;
	public String getSuKien() {
		return suKien;
	}
	public void setSuKien(String suKien) {
		this.suKien = suKien;
	}
	public String getNam() {
		return nam;
	}
	public void setNam(String nam) {
		this.nam = nam;
	}
	public Event() {
		super();
	}
	@Override
	public String toString() {
		return "Sự kiện: " + suKien + "\nNăm: " + nam;
	}
}	

