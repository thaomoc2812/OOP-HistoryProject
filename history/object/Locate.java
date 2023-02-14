package history.object;


public class Locate {
	private String tt;
	private String Locate;
	private String name;
	private String description;
	public String getTt() {
		return tt;
	}
	public void setTt(String tt) {
		this.tt = tt;
	}
	public String getLocate() {
		return Locate;
	}
	public void setLocate(String locate) {
		Locate = locate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Locate() {
		super();
	}
	@Override
	public String toString() {
		return "TT: " + tt + "\nVị trí: " + Locate + "\nTên di tích: " + name + "\nMiêu tả: " + description;
	}
	
	
}

