package history.object;


public class King {
	private String paperURL;
	private String mieuHieu;
	private String thuyHieu;
	private String nienHieu;
	private String tenHuy;
	private String theThu;
	private String namTriVi;
	private String ten;
	public String getPaperURL() {
		return paperURL;
	}
	public void setPaperURL(String paperURL) {
		this.paperURL = paperURL;
	}
	public String getMieuHieu() {
		return mieuHieu;
	}
	public void setMieuHieu(String mieuHieu) {
		this.mieuHieu = mieuHieu;
	}
	public String getThuyHieu() {
		return thuyHieu;
	}
	public void setThuyHieu(String thuyHieu) {
		this.thuyHieu = thuyHieu;
	}
	public String getNienHieu() {
		return nienHieu;
	}
	public void setNienHieu(String nienHieu) {
		this.nienHieu = nienHieu;
	}
	public String getTenHuy() {
		return tenHuy;
	}
	public void setTenHuy(String tenHuy) {
		this.tenHuy = tenHuy;
	}
	public String getTheThu() {
		return theThu;
	}
	public void setTheThu(String theThu) {
		this.theThu = theThu;
	}
	public String getNamTriVi() {
		return namTriVi;
	}
	public void setNamTriVi(String namTriVi) {
		this.namTriVi = namTriVi;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	
	public King() {
		super();
	}
	@Override
	public String toString() {
		return "Paper URL: " + paperURL + "\nTên: " + ten+ "\nMiếu hiệu: " + mieuHieu + "\nThụy Hiệu: " + thuyHieu + "\nNiên hiệu: "
				+ nienHieu + "\nTên húy: " + tenHuy + "\nThế thứ: " + theThu + "\nNăm trị vì: " + namTriVi ;
	}
}

